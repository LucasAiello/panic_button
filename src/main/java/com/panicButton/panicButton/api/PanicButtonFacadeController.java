package com.panicButton.panicButton.api;

import com.panicButton.panicButton.domain.Usuario;
import com.panicButton.panicButton.service.Sistema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/panico")
public class PanicButtonFacadeController {

	private static final Logger LOG = LoggerFactory.getLogger(PanicButtonFacadeController.class);

	@Autowired
	private Sistema service;

	@PostMapping("/create-usuario")
	public ResponseEntity<?> add(@RequestBody Usuario usuario) {
		try {
			Usuario novoUsuario = service.createUsuario(usuario);
			return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
		} catch (IllegalArgumentException ex) {
			return new ResponseEntity<>("Parâmetros inválidos: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			LOG.error("[POST] /api/panico/create-usuario - Erro: ", e);
			return new ResponseEntity<>("Erro interno ao criar usuário.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/get-usuarios")
	public ResponseEntity<?> get(@RequestParam String matricula) {
		try {
			Optional<Usuario> novoUsuario = service.getUsuario(matricula);
			if (novoUsuario.isPresent()) {
				return ResponseEntity.ok(novoUsuario.get());
			} else {
				return ResponseEntity.badRequest().body("Parâmetros inválidos");
			}
		} catch (IllegalArgumentException ex) {
			return ResponseEntity.badRequest().body("Parâmetros inválidos: " + ex.getMessage());
		} catch (Exception e) {
			LOG.error("[GET] /get-usuario - Erro: ", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Erro interno ao buscar usuário.");
		}
	}

	@PutMapping("/update-usuarios")
	public ResponseEntity<?> update(@RequestParam String matricula, @RequestBody Usuario usuario) {
		try {
			Usuario novoUsuario = service.updateUsuario(matricula, usuario);
			return ResponseEntity.ok(novoUsuario);
		} catch (IllegalArgumentException ex) {
			return ResponseEntity.badRequest().body("Parâmetros inválidos: " + ex.getMessage());
		} catch (Exception e) {
			LOG.error("[PUT] /api/panico/update-usuarios - Erro: ", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Erro interno ao atualizar usuário.");
		}
	}

}
