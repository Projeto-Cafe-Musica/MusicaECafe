package br.com.musicaecafe.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.musicaecafe.model.Comentarios;
import br.com.musicaecafe.repository.ComentariosRepository;


@RestController
@RequestMapping("/comentarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ComentariosController {

	@Autowired
	private ComentariosRepository comentariosRepository;

	@GetMapping
	public ResponseEntity<List<Comentarios>> getAll() {
		return ResponseEntity.ok(comentariosRepository.findAll());

	}

	@GetMapping("/{id}")
	public ResponseEntity<Comentarios> getById(@PathVariable long id) {
		return comentariosRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());

	}

	
	@GetMapping("/avaliacao/{avaliacao}")
	public ResponseEntity<List<Comentarios>> getByAvaliacao(@PathVariable String avaliacao) {
		return ResponseEntity.ok(comentariosRepository.findAllByComenteContainingIgnoreCase(avaliacao));

	}

	@PostMapping
	public ResponseEntity<Comentarios> post(@Valid @RequestBody Comentarios comentarios) {
		return ResponseEntity.status(HttpStatus.CREATED).body(comentariosRepository.save(comentarios));
	}

	@PutMapping 
	public ResponseEntity<Comentarios> put(@Valid @RequestBody Comentarios comentarios) {
		return comentariosRepository.findById(comentarios.getId()).map(resposta -> {
			return ResponseEntity.ok().body(comentariosRepository.save(comentarios));
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteRepository(@PathVariable long id) {
		return comentariosRepository.findById(id).map(resposta -> {
			comentariosRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}).orElse(ResponseEntity.notFound().build());
	}
}