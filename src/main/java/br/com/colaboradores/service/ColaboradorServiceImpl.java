package br.com.colaboradores.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.colaboradores.dto.ColaboradorDTO;
import br.com.colaboradores.exceptions.BusinessException;
import br.com.colaboradores.exceptions.ObjectNotFoundException;
import br.com.colaboradores.models.Colaborador;
import br.com.colaboradores.models.Setor;
import br.com.colaboradores.repositories.ColaboradorRepository;
import br.com.colaboradores.utils.Utils;

/**
 * Classe de serviço de colaboradores
 *
 */
@Service
public class ColaboradorServiceImpl implements ColaboradorService {

	@Autowired
	private ColaboradorRepository colaboradorRepository;
	
	@Autowired
	private SetorService setorService;
	
	/**
	 * {@inheritDoc}
	 */
	public Colaborador buscarPorId(String id) {
		Optional<Colaborador> colaborador = this.colaboradorRepository.findById(Long.valueOf(id));
		return colaborador.orElseThrow(() -> new ObjectNotFoundException("Colaborador não encontrado."));
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void removerColaborador(String id) {
		Colaborador colaborador = this.buscarPorId(id);
		colaboradorRepository.delete(colaborador);
	}
	
	/**
	 * Método responsável por realizar a validação no colaborador e ver se está atendendo as regras para ser inserido.
	 * @param Colaborador a ser validado
	 * @return Colaborador validado e inserido.
	 */
	public Colaborador validarColaborador(Colaborador colaborador) {
		
		if (this.cpfCadastrado(colaborador.getCpf())) {
			throw new BusinessException("CPF já cadastrado.");
		}
		
		if (null == colaborador.getSetor() || null == colaborador.getSetor().getId()) {
			// Coloquei o setor como obrigatório, pois o colaborador precisa ter um setor.
			throw new BusinessException("O setor é obrigatório."); 
		}
		
		Setor setor = this.setorService.buscarSetorPorId(colaborador.getSetor().getId());
		List<Setor> setores = this.setorService.listarSetores();
		
		if (colaborador.getIdade() < 18) {
			Long totalColaboradoresSetor = Long.valueOf(setor.getColaboradores().size());
			Long quantidadeColaboradoresMenores18 = setor.getColaboradores().stream().filter(c -> c.getIdade() < 18).count();
			BigDecimal percentColaboradoresMenores18 = BigDecimal.ZERO;
			
			if (quantidadeColaboradoresMenores18 != 0L) {
				percentColaboradoresMenores18 = Utils.calcularPercentualPeloValor(BigDecimal.valueOf(totalColaboradoresSetor), BigDecimal.valueOf(quantidadeColaboradoresMenores18));
			}
			
			if (percentColaboradoresMenores18.compareTo(new BigDecimal(20)) == 0 || percentColaboradoresMenores18.compareTo(new BigDecimal(20)) == 1) {
				throw new BusinessException("Colaborador não pode ser inserido, pois o setor já possui 20% de colaboradores menores de 18 anos.");
			}
		} else if (colaborador.getIdade() > 65) {
			Long totalColaboradoresEmpresa = setores.stream().mapToLong(s -> s.getColaboradores().size()).sum();
			Long quantidadeColaboradoresMaiores65 = setores.stream().mapToLong(s -> s.getColaboradores().stream().filter(c -> c.getIdade() > 65).count()).sum();
			BigDecimal percentColaboradoresMaiores65 = BigDecimal.ZERO;
				
			if (quantidadeColaboradoresMaiores65 != 0) {
				percentColaboradoresMaiores65 = Utils.calcularPercentualPeloValor(BigDecimal.valueOf(totalColaboradoresEmpresa), BigDecimal.valueOf(quantidadeColaboradoresMaiores65));
			}
			
			if (percentColaboradoresMaiores65.compareTo(new BigDecimal(20)) == 0 || percentColaboradoresMaiores65.compareTo(new BigDecimal(20)) == 1) {
				throw new BusinessException("Colaborador não pode ser inserido, pois a empresa já possui 20% de colaboradores maiores de 65 anos.");
			}
			
		}

		return colaborador;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Colaborador inserirColaborador(Colaborador colaborador) {
		return this.colaboradorRepository.save(this.validarColaborador(colaborador));
	}
	
	/**
	 * Método responsável por verificar se o CPF que está sendo inserido já foi cadastrado antes. 
	 * @param CPF que será inserido
	 * @return Verdadeiro se o CPF já está cadastrado e falso caso não esteja
	 */
	public boolean cpfCadastrado(String cpf) {
		Optional<Colaborador> colaborador = this.colaboradorRepository.findByCpf(cpf.replaceAll("[./-]", "").trim());
		
		if (colaborador.isPresent()) {
			return true;
		} 
		
		return false;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public ColaboradorDTO converteColaborador(Colaborador colaborador) {
		ColaboradorDTO dto = new ColaboradorDTO(colaborador);	
		return dto;
	}
	
}
