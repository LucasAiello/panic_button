package com.panicButton.panicButton;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api/panico")
public class PanicButtonController {
	@GetMapping("/acionar")
	 public String acionarPanico() {

		LocalDateTime agora = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String dataHoraAcionamento = agora.format(formatter);

		System.out.println("!!! BOTÃO DE PÂNICO ACIONADO EM: " + dataHoraAcionamento + " !!!");

		// Em um cenário real, você poderia:
		// - Enviar um e-mail para uma lista de contatos (usando Spring Mail)
		// - Enviar um SMS (usando Twilio ou similar)
		// - Inserir um registro em um banco de dados
		// - Disparar uma mensagem para uma fila (Kafka, RabbitMQ)
		// - Chamar outro serviço (webhook)

		return "Botão de pânico acionado com sucesso em " + dataHoraAcionamento + "!";
	}
}