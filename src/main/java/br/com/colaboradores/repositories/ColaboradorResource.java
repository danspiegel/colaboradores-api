package br.com.colaboradores.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.colaboradores.domain.Colaborador;

/**
 * Interface de repository de colaboradores
 *
 */
public interface ColaboradorResource extends JpaRepository<Colaborador, Long> {

	/**
	 * Método responsável por buscar o colaborador por CPF.
	 * @param CPF do colaborador
	 * @return Colaborador com o CPF buscado.
	 */
	public Optional<Colaborador> findByCpf(String cpf);
	
}
