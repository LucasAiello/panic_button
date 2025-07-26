package com.panicButton.panicButton.api;
import org.springframework.beans.factory.annotation.Autowired;
import com.panicButton.panicButton.domain.Usuario;
import com.panicButton.panicButton.domain.Alerta;
import com.panicButton.panicButton.dto.AlertaDTO;
import com.panicButton.panicButton.dto.UsuarioDTO;
import com.panicButton.panicButton.proxy.Proxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/panico")
public class PanicButtonFacadeController {

	private static final Logger LOG = LoggerFactory.getLogger(PanicButtonFacadeController.class);

	private Proxy proxy;

	@Autowired
	public PanicButtonFacadeController(Proxy proxy) {
		this.proxy = proxy;
	}

	@PostMapping("/create-usuario")
	public ResponseEntity<?> add(@RequestBody UsuarioDTO usuarioDTO) {
		try {
			Usuario novoUsuario = proxy.createUsuario(usuarioDTO);
			UsuarioDTO dto = UsuarioDTO.fromUsuario(novoUsuario);
			return new ResponseEntity<>(dto, HttpStatus.CREATED);
		} catch (IllegalArgumentException ex) {
			return new ResponseEntity<>("Parâmetros inválidos: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			LOG.error("[POST] /api/panico/create-usuario - Erro: ", e);
			return new ResponseEntity<>("Erro interno ao criar usuário.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/get-usuario")
	public ResponseEntity<?> get(@RequestParam String matricula) {
		try {
			Optional<Usuario> novoUsuario = proxy.getUsuario(matricula);
			if (novoUsuario.isPresent()) {
				UsuarioDTO dto = UsuarioDTO.fromUsuario(novoUsuario.get());
				return ResponseEntity.ok(dto);
			} else {
				return ResponseEntity.badRequest().body("Usuário não encontrado");
			}
		} catch (IllegalArgumentException ex) {
			return ResponseEntity.badRequest().body("Parâmetros inválidos: " + ex.getMessage());
		} catch (Exception e) {
			LOG.error("[GET] /get-usuario - Erro: ", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Erro interno ao buscar usuário.");
		}
	}

	@PutMapping("/update-usuario")
	public ResponseEntity<?> update(@RequestBody UsuarioDTO usuarioDTO) {
		try {
			Usuario novoUsuario = proxy.updateUsuario(usuarioDTO);
			UsuarioDTO dto = UsuarioDTO.fromUsuario(novoUsuario);
			return ResponseEntity.ok(dto);
		} catch (IllegalArgumentException ex) {
			return ResponseEntity.badRequest().body("Parâmetros inválidos: " + ex.getMessage());
		} catch (Exception e) {
			LOG.error("[PUT] /api/panico/update-usuarios - Erro: ", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Erro interno ao atualizar usuário.");
		}
	}
	@DeleteMapping("/delete-usuario")
	public ResponseEntity<?> delete(@RequestParam UsuarioDTO usuarioDTO) {
		try {
			Optional<Usuario> deletado = proxy.removeUsuario(usuarioDTO.getMatricula());
			if (deletado.isPresent()) {
				UsuarioDTO dto = UsuarioDTO.fromUsuario(deletado.get());
				return ResponseEntity.ok(dto);
			} else {
				return ResponseEntity.badRequest().body("Usuário não encontrado");
			}
		} catch (IllegalArgumentException ex) {
			return ResponseEntity.badRequest().body("Parâmetros inválidos: " + ex.getMessage());
		} catch (Exception e) {
			LOG.error("[GET] /delete-usuario - Erro: ", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Erro interno ao deletar usuário.");
		}
	}

	@PostMapping("/create-alerta")
	public ResponseEntity<?> add(@RequestBody AlertaDTO alertaDTO) {
		try {
			System.out.println(alertaDTO);
			System.out.println(proxy);
			Alerta novoAlerta = proxy.createAlerta(alertaDTO);
			AlertaDTO dto = AlertaDTO.fromAlerta(novoAlerta);
			return new ResponseEntity<>(dto, HttpStatus.CREATED);
		} catch (IllegalArgumentException ex) {
			return ResponseEntity.badRequest().body("Parâmetros inválidos: " + ex.getMessage());
		} catch (Exception e) {
			LOG.error("[POST] /api/panico/create-alerta - Erro: ", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Erro interno ao criar alerta.");
		}
	}

	@GetMapping("/get-alerta")
	public ResponseEntity<?> get(@RequestParam Long id) {
		try {
			Optional<Alerta> alerta = proxy.getAlerta(id);
			if (alerta.isPresent()) {
				AlertaDTO dto = AlertaDTO.fromAlerta(alerta.get());
				return ResponseEntity.ok(dto);
			} else {
				return ResponseEntity.badRequest().body("Alerta não encontrado");
			}
		} catch (IllegalArgumentException ex) {
			return ResponseEntity.badRequest().body("Parâmetros inválidos: " + ex.getMessage());
		} catch (Exception e) {
			LOG.error("[GET] /get-alerta - Erro: ", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Erro interno ao buscar alerta.");
		}
	}

	@PutMapping("/update-alerta")
	public ResponseEntity<?> update(@RequestBody AlertaDTO alertaDTO) {
		try {
			Alerta alertaAtualizado = proxy.updateAlerta(alertaDTO);
			AlertaDTO dto = AlertaDTO.fromAlerta(alertaAtualizado);
			return ResponseEntity.ok(dto);
		} catch (IllegalArgumentException ex) {
			return ResponseEntity.badRequest().body("Parâmetros inválidos: " + ex.getMessage());
		} catch (Exception e) {
			LOG.error("[PUT] /api/panico/update-alerta - Erro: ", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Erro interno ao atualizar alerta.");
		}
	}

	@DeleteMapping("/delete-alerta")
	public ResponseEntity<?> delete(@RequestParam AlertaDTO alertaDTO) {
		try {
			Optional<Alerta> deletado = proxy.removeAlerta(alertaDTO.getId());
			if (deletado.isPresent()) {
				AlertaDTO dto = AlertaDTO.fromAlerta(deletado.get());
				return ResponseEntity.ok(dto);
			} else {
				return ResponseEntity.badRequest().body("Alerta não encontrado");
			}
		} catch (IllegalArgumentException ex) {
			return ResponseEntity.badRequest().body("Parâmetros inválidos: " + ex.getMessage());
		} catch (Exception e) {
			LOG.error("[DELETE] /delete-alerta - Erro: ", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Erro interno ao deletar alerta.");
		}
	}

}
