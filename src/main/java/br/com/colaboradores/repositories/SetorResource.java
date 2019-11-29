package br.com.colaboradores.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.colaboradores.domain.Setor;

/**
 * Interface de repository de setores
 *
 */
public interface SetorResource extends JpaRepository<Setor, Long> {

}
