package br.com.colaboradores.exceptions;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que herda o status de erro das requisições e contém a lista de campos
 * e seus respectivos erros.
 *
 */
public class ValidationError extends StandardError {

	private static final long serialVersionUID = -8330186726644284503L;
	
	private List<FieldMessage> erros = new ArrayList<FieldMessage>();
	
	public ValidationError(Integer status, String mensagem, Long timeStamp) {
		super(status, mensagem, timeStamp);
	}
	
	public void adicionarErros(String campo, String mensagem) {
		erros.add(new FieldMessage(campo, mensagem));
	}
	
	//--> Getters e Setters

	public List<FieldMessage> getErros() {
		return erros;
	}

	public void setErros(List<FieldMessage> erros) {
		this.erros = erros;
	}

}
