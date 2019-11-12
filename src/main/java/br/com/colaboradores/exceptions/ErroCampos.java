package br.com.colaboradores.exceptions;

import java.io.Serializable;

/**
 * Classe contendo informações dos erros de validação dos campos.
 *
 */
public class ErroCampos implements Serializable {

	private static final long serialVersionUID = -9108691767199807594L;
	
	//--> Atributos
	
	private String campo;
	private String mensagem;
	
	public ErroCampos() {
		
	}
	
	public ErroCampos(String campo, String mensagem) {
		super();
		this.campo = campo;
		this.mensagem = mensagem;
	}
	
	//--> Getters e Setters
	
	public String getCampo() {
		return campo;
	}
	public void setCampo(String campo) {
		this.campo = campo;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
