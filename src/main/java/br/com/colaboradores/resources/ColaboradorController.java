package br.com.colaboradores.resources;

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

import br.com.colaboradores.domain.Colaborador;
import br.com.colaboradores.dto.ColaboradorDTO;
import br.com.colaboradores.services.ColaboradorService;

/**
 * Classe de controller que representa os serviços de colaboradores.
 * @author danie
 *
 */
@RestController
@RequestMapping("/colaborador")
public class ColaboradorController {
	
	@Autowired
	private ColaboradorService colaboradorService;
	
	@GetMapping("/buscarColaboradorPorId/{id}")
	public ResponseEntity<ColaboradorDTO> buscarColaboradorPorId(@PathVariable String id) {
		ColaboradorDTO colaborador = this.colaboradorService.converteColaborador(this.colaboradorService.buscarPorId(id));
		return ResponseEntity.ok().body(colaborador);
	}
	
	@PostMapping("/inserirColaborador")
	public ResponseEntity<String> inserirColaborador(@Valid @RequestBody Colaborador colaborador) {
		this.colaboradorService.inserirColaborador(colaborador);
		return ResponseEntity.status(HttpStatus.CREATED).body("Colaborador inserido com sucesso.");
	}
	
	@DeleteMapping("/removerColaborador/{id}")
	public ResponseEntity<String> removerColaborador(@PathVariable String id) {
		colaboradorService.removerColaborador(id);
		return ResponseEntity.ok().body("Colaborador removido com sucesso.");
	}
	
}
