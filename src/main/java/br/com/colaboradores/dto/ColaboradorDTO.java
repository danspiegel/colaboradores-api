package br.com.colaboradores.dto;

import java.io.Serializable;

import br.com.colaboradores.domain.Colaborador;
import br.com.colaboradores.utils.Utils;

/**
 * Classe de negócio do colaborador
 *
 */
public class ColaboradorDTO implements Serializable {

	private static final long serialVersionUID = -6943444863217541803L;
	
	//--> Atributos
	
	private Long id;
	private String cpf;
	private String nome;
	private Integer idade;
	private String telefone;
	private String email;
	
	public ColaboradorDTO() {
		
	}
	
	public ColaboradorDTO(Colaborador colaborador) {
		this.id = colaborador.getId();
		this.cpf = Utils.formatarCpf(colaborador.getCpf());
		this.nome = colaborador.getNome();
		this.idade = colaborador.getIdade();
		this.telefone = colaborador.getTelefone();
		this.email = colaborador.getEmail();
	}
	
	//--> Getters e Setters
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
