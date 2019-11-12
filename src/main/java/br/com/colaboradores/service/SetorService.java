package br.com.colaboradores.service;

import java.util.List;

import br.com.colaboradores.dto.SetorColaboradorDTO;
import br.com.colaboradores.models.Setor;

/**
 * Interface de serviço de setores
 *
 */
public interface SetorService {

	/**
	 * Método responsável por listar os setores.
	 * @return Lista de setores.
	 */
	public List<Setor> listarSetores();
	
	/**
	 * Método responsável por retornar a lista de setores e os colaboradores de cada setor.
	 * @return Lista de setores e seus respectivos colaboradores.
	 */
	public List<SetorColaboradorDTO> listarColaboradoresPorSetor();
	
	/**
	 * Método responsável por buscar o setor pelo Id.
	 * @param Id do setor
	 * @return Setor
	 */
	public Setor buscarSetorPorId(Long id);
	
}
