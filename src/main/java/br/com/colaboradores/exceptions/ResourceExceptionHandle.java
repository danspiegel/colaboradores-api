package br.com.colaboradores.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Classe global controladora de exceções.
 *
 */
@ControllerAdvice
public class ResourceExceptionHandle {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<DadosErro> objectNotFound(ObjectNotFoundException e) {
		DadosErro erro = new DadosErro(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<DadosErro> methodArgumentNotValid(MethodArgumentNotValidException e) {
		ValidacaoErros erro = new ValidacaoErros(HttpStatus.BAD_REQUEST.value(), "Erro durante a validação", System.currentTimeMillis());
		
		for (FieldError err: e.getBindingResult().getFieldErrors()) {
			erro.adicionarErros(err.getField(), err.getDefaultMessage());
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(erro);
	}
	
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<DadosErro> business(BusinessException e) {
		DadosErro erro = new DadosErro(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
	
}
