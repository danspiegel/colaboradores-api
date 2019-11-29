package br.com.colaboradores.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.colaboradores.domain.Setor;
import br.com.colaboradores.dto.SetorDTO;
import br.com.colaboradores.services.SetorService;

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
	public ResponseEntity<List<SetorDTO>> listarColaboradoresPorSetor() {
		List<SetorDTO> setores = this.setorService.listarColaboradoresPorSetor();
		return ResponseEntity.ok().body(setores);
	}
	
	@GetMapping("/buscarSetorPorId/{id}")
	public ResponseEntity<SetorDTO> buscarSetorPorId(@PathVariable String id) {
		SetorDTO setor = this.setorService.converteSetor(this.setorService.buscarPorId(id));
		return ResponseEntity.ok().body(setor);
	}
	
	@PostMapping("/inserirSetor")
	public ResponseEntity<String> inserirSetor(@Valid @RequestBody Setor setor) {
		this.setorService.inserirSetor(setor);
		return ResponseEntity.status(HttpStatus.CREATED).body("Setor inserido com sucesso.");
	}
	
	@DeleteMapping("/removerSetor/{id}")
	public ResponseEntity<String> removerSetor(@PathVariable String id) {
		this.setorService.removerSetor(id);
		return ResponseEntity.ok().body("Setor removido com sucesso.");
	}
	
}
