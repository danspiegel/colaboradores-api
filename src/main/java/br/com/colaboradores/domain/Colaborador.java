package br.com.colaboradores.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

/**
 * Entidade de colaborador que representa a tabela de colaborador no banco de dados
 * @author danie
 *
 */
@Entity
public class Colaborador implements Serializable {

	private static final long serialVersionUID = -1997034623850891780L;
	
	//--> Atributos
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="colaborador_sequence")
	@SequenceGenerator(name="colaborador_sequence", sequenceName="seq_colaborador")
	private Long id;
	
	@NotEmpty(message="CPF é obrigatório")
	@Length(min=11, max=11, message="O CPF deve conter 11 dígitos")
	@Column(unique=true)
	private String cpf;
	
	@NotEmpty(message="Nome é obrigatório")
	@Length(min=2, max=80, message="O tamanho deve ser entre 2 e 80 caracteres.")
	private String nome;
	
	@NotNull(message="Idade é obrigatória") // Foi colocada como obrigatória, pois era necessária para o cálculo dos 20% menores que 18 e maiores que 65
	private Integer idade;
	
	@NotEmpty(message="Telefone é obrigatório")
	@Length(min=8, max=9, message="O telefone deve conter 8 ou 9 dígitos.")
	private String telefone;
	
	@NotEmpty(message="E-mail é obrigatório")
	@Email(message="Favor informar um e-mail válido.")
	private String email;
	
	@ManyToOne
	private Setor setor;

	//--> Getters e Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((idade == null) ? 0 : idade.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((setor == null) ? 0 : setor.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Colaborador other = (Colaborador) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idade == null) {
			if (other.idade != null)
				return false;
		} else if (!idade.equals(other.idade))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (setor == null) {
			if (other.setor != null)
				return false;
		} else if (!setor.equals(other.setor))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}
	
}
