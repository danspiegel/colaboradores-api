package br.com.colaboradores.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Classe de negócio do setor que será retornado
 *
 */
public class SetorColaboradorDTO implements Serializable {

	private static final long serialVersionUID = 8156726362091472448L;

	//--> Atributos
	
	private Long id;
	private String descricao;
	private List<ColaboradorPorSetorDTO> colaboradores;
	
	//--> Getters e Setters
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<ColaboradorPorSetorDTO> getColaboradores() {
		return colaboradores;
	}
	public void setColaboradores(List<ColaboradorPorSetorDTO> colaboradores) {
		this.colaboradores = colaboradores;
	}
	
}
