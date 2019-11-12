package br.com.colaboradores.exceptions;

/**
 * Classe de exceção de negócio.
 *
 */
public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 4833231768588164842L;

	public BusinessException(String mensagem) {
		super(mensagem);
	}
	
}
