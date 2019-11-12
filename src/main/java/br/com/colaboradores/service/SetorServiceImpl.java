package br.com.colaboradores.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.colaboradores.dto.ColaboradorPorSetorDTO;
import br.com.colaboradores.dto.SetorColaboradorDTO;
import br.com.colaboradores.exceptions.ObjectNotFoundException;
import br.com.colaboradores.models.Setor;
import br.com.colaboradores.repositories.SetorRepository;

/**
 * Classe de serviço de setores
 *
 */
@Service
public class SetorServiceImpl implements SetorService {

	@Autowired
	private SetorRepository setorRepository;
	
	/**
	 * {@inheritDoc}
	 */
	public List<Setor> listarSetores() {
		return this.setorRepository.findAll();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public List<SetorColaboradorDTO> listarColaboradoresPorSetor() {
		return this.converteListaColaboradoresPorSetor(this.listarSetores());
	}
	
	/**
	 * Método responsável por converter a lista de colaboradores por setor que vem em um objeto de entidade do banco para o objeto que será serializado.
	 * @param Lista de colaboradores por setor na forma de entidade do banco
	 * @return Lista de colaboradores por setor que será serializada
	 */
	public List<SetorColaboradorDTO> converteListaColaboradoresPorSetor(List<Setor> setores) {
		List<SetorColaboradorDTO> listaSetores = new ArrayList<SetorColaboradorDTO>();
		
		setores.forEach(s -> {
			List<ColaboradorPorSetorDTO> listaColaboradores = new ArrayList<ColaboradorPorSetorDTO>();
			SetorColaboradorDTO setorColaborador = new SetorColaboradorDTO();
			setorColaborador.setId(s.getId());
			setorColaborador.setDescricao(s.getDescricao());
			
			s.getColaboradores().forEach(c -> {
				ColaboradorPorSetorDTO colaboradoresPorSetor = new ColaboradorPorSetorDTO();
				colaboradoresPorSetor.setNome(c.getNome());
				colaboradoresPorSetor.setEmail(c.getEmail());
				listaColaboradores.add(colaboradoresPorSetor);
			});
			
			setorColaborador.setColaboradores(listaColaboradores);
			listaSetores.add(setorColaborador);
		});
		
		return listaSetores;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Setor buscarSetorPorId(Long id) {
		Optional<Setor> setor = this.setorRepository.findById(id);
		return setor.orElseThrow(() -> new ObjectNotFoundException("Setor não encontrado."));
	}
	
}
