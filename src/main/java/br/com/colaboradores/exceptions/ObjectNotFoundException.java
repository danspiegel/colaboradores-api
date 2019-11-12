package br.com.colaboradores.exceptions;

/**
 * Classe de exceção de recurso não encontrado.
 *
 */
public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 3329209544695578207L;
	
	public ObjectNotFoundException(String mensagem) {
		super(mensagem);
	}
	
	public ObjectNotFoundException(String mensagem, Throwable cause) {
		super(mensagem, cause);
	}

}
