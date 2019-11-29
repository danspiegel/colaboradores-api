package br.com.colaboradores.services;

import br.com.colaboradores.domain.Colaborador;
import br.com.colaboradores.dto.ColaboradorDTO;

/**
 * Interface de serviço de colaboradores
 *
 */
public interface ColaboradorService {

	/**
	 * Método responsável por buscar o colaborador pelo id.
	 * @param Id do colaborador
	 * @return Colaborador.
	 */
	public Colaborador buscarPorId(String id);
	
	/**
	 * Método responsável por remover um colaborador pelo CPF.
	 * @param CPF do colaborador que será removido.
	 */
	public void removerColaborador(String id);
	
	/**
	 * Método responsável por inserir um colaborador.
	 * @param Colaborador a ser inserido.
	 */
	public Colaborador inserirColaborador(Colaborador colaborador);
	
	/**
	 * Método para converter a entidade Colaborador para DTO Colaborador.
	 * @param Colaborador entidade.
	 * @return Colaborador DTO.
	 */
	public ColaboradorDTO converteColaborador(Colaborador colaborador);
	
}
