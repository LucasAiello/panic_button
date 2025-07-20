package com.panicButton.panicButton.api;

import com.panicButton.panicButton.domain.Usuario;
import com.panicButton.panicButton.service.Sistema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

}
