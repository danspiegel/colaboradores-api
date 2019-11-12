package br.com.colaboradores.exceptions;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que herda o status de erro das requisições e contém a lista de campos
 * e seus respectivos erros.
 *
 */
public class ValidacaoErros extends DadosErro {

	private static final long serialVersionUID = -8330186726644284503L;
	
	private List<ErroCampos> erros = new ArrayList<ErroCampos>();
	
	public ValidacaoErros(Integer status, String mensagem, Long timeStamp) {
		super(status, mensagem, timeStamp);
	}
	
	public void adicionarErros(String campo, String mensagem) {
		erros.add(new ErroCampos(campo, mensagem));
	}
	
	//--> Getters e Setters

	public List<ErroCampos> getErros() {
		return erros;
	}

	public void setErros(List<ErroCampos> erros) {
		this.erros = erros;
	}

}
