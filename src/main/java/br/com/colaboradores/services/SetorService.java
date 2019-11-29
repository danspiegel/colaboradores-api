package br.com.colaboradores.services;

import java.util.List;

import br.com.colaboradores.domain.Setor;
import br.com.colaboradores.dto.SetorDTO;

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
	public List<SetorDTO> listarColaboradoresPorSetor();
	
	/**
	 * Método responsável por buscar o setor pelo Id.
	 * @param Id do setor
	 * @return Setor
	 */
	public Setor buscarPorId(String id);
	
	/**
	 * Método responsável por inserir os setores.
	 * @param Setor que será inserido
	 * @return Setor inserio na base
	 */
	public Setor inserirSetor(Setor setor);
	
	/**
	 * Método responsável por remover os setores.
	 * @param Id do setor que será removido
	 */
	public void removerSetor(String id);
	
	/**
	 * Método responsável por converter a entidade de setor para um DTO.
	 * @param Entidade setor
	 * @return DTO de Setor
	 */
	public SetorDTO converteSetor(Setor setor);
	
}
