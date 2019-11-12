package br.com.colaboradores.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.colaboradores.dto.SetorColaboradorDTO;
import br.com.colaboradores.service.SetorService;

/**
 * Classe de controller que representa os serviços de setores.
 *
 */
@RestController
@RequestMapping("/setor")
public class SetorController {

	@Autowired
	private SetorService setorService;
	
	@GetMapping("/listarColaboradoresPorSetor")
	public ResponseEntity<List<SetorColaboradorDTO>> listarColaboradoresPorSetor() {
		List<SetorColaboradorDTO> setores = this.setorService.listarColaboradoresPorSetor();
		return ResponseEntity.ok().body(setores);
	}
	
}
