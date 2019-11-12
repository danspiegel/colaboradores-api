package br.com.colaboradores.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.colaboradores.models.Setor;

/**
 * Interface de repository de setores
 *
 */
public interface SetorRepository extends JpaRepository<Setor, Long> {

}
