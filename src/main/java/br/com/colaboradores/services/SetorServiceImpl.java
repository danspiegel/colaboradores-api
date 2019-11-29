package br.com.colaboradores.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.colaboradores.domain.Colaborador;
import br.com.colaboradores.domain.Setor;
import br.com.colaboradores.dto.ColaboradorDTO;
import br.com.colaboradores.dto.ColaboradorPorSetorDTO;
import br.com.colaboradores.dto.SetorDTO;
import br.com.colaboradores.exceptions.ObjectNotFoundException;
import br.com.colaboradores.repositories.SetorResource;

/**
 * Classe de serviço de setores
 *
 */
@Service
public class SetorServiceImpl implements SetorService {

	@Autowired
	private SetorResource setorRepository;
	
	/**
	 * {@inheritDoc}
	 */
	public List<Setor> listarSetores() {
		return this.setorRepository.findAll();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public List<SetorDTO> listarColaboradoresPorSetor() {
		return this.converteListaColaboradoresPorSetor(this.listarSetores());
	}
	
	/**
	 * Método responsável por converter a lista de colaboradores por setor que vem em um objeto de entidade do banco para o objeto que será serializado.
	 * @param Lista de colaboradores por setor na forma de entidade do banco
	 * @return Lista de colaboradores por setor que será serializada
	 */
	public List<SetorDTO> converteListaColaboradoresPorSetor(List<Setor> setores) {
		List<SetorDTO> listaSetores = new ArrayList<SetorDTO>();
		
		setores.forEach(s -> {
			List<ColaboradorPorSetorDTO> listaColaboradores = new ArrayList<ColaboradorPorSetorDTO>();
			SetorDTO setor = new SetorDTO(s);
			
			s.getColaboradores().forEach(c -> {
				listaColaboradores.add(new ColaboradorPorSetorDTO(c));
			});
			
			setor.setColaboradores(listaColaboradores);
			listaSetores.add(setor);
		});
		
		return listaSetores;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Setor buscarPorId(String id) {
		Optional<Setor> setor = this.setorRepository.findById(Long.valueOf(id));
		return setor.orElseThrow(() -> new ObjectNotFoundException("Setor não encontrado."));
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Setor inserirSetor(Setor setor) {
		return this.setorRepository.save(setor);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void removerSetor(String id) {
		Setor setor = this.buscarPorId(id);
		this.setorRepository.delete(setor);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public SetorDTO converteSetor(Setor setor) {
		SetorDTO dto = new SetorDTO(setor);	
		return dto;
	}	
	
}
