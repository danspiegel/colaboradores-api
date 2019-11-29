package br.com.colaboradores.dto;

import java.io.Serializable;

import br.com.colaboradores.domain.Colaborador;

/**
 * Classe de negócio de colaborador contendo somente os campos para serem retornados junto ao setor
 *
 */
public class ColaboradorPorSetorDTO implements Serializable {

	private static final long serialVersionUID = -4275124881066162603L;
	
	//--> Atributos
	
	private String nome;
	private String email;
	
	public ColaboradorPorSetorDTO() {
		
	}
	
	public ColaboradorPorSetorDTO(Colaborador colaborador) {
		this.nome = colaborador.getNome();
		this.email = colaborador.getEmail();
	}
	
	//--> Getters e Setters
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
