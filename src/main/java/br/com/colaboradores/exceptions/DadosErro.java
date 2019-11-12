package br.com.colaboradores.exceptions;

import java.io.Serializable;

/**
 * Classe contendo o status de erro da requisição.
 *
 */
public class DadosErro implements Serializable {

	private static final long serialVersionUID = 1608812318310390899L;
	
	//--> Atributos
	
	private Integer status;
	private String mensagem;
	private Long timeStamp;
	
	public DadosErro(Integer status, String mensagem, Long timeStamp) {
		super();
		this.status = status;
		this.mensagem = mensagem;
		this.timeStamp = timeStamp;
	}
	
	//--> Getters e Setters
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public Long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}

}
