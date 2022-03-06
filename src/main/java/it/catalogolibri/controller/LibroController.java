package it.catalogolibri.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import it.catalogolibri.model.Libro;
import it.catalogolibri.service.LibroService;


@RestController
@RequestMapping("/api")
@SecurityRequirement(name="bearerAuth")
public class LibroController {

	@Autowired
	private LibroService libroservice;

	@GetMapping(path = "/libro/listaLibri")
	public ResponseEntity<List<Libro>> findAll() {
		List<Libro> findAll = libroservice.findAll();

		if (!findAll.isEmpty()) {
			return new ResponseEntity<>(findAll, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

	}
	
	@GetMapping(path = "/libro/LibroById/{id}")
	public ResponseEntity<Libro> findById(@PathVariable(required = true) Long id) {
		Optional<Libro> find = libroservice.findById(id);

		if (find.isPresent()) {
			return new ResponseEntity<>(find.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

	}
	
	@PostMapping(path="/libro/listaLibriPerAutori")
	@Operation(summary = "Ho usato una Post per far passare la lista di Id con un RequestBody ma il metodo restituisce solo e non salva niente in db")
	public ResponseEntity<List<Libro>> findByAutore_IdIn(@RequestBody List<Long> id) {
		List<Libro> find = libroservice.findByAutori_IdIn(id);
		if (!find.isEmpty()) {
			return new ResponseEntity<>(find, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping(path="/libro/listaLibriPerCategorie")
	@Operation(summary = "Ho usato una Post per far passare la lista di Id con un RequestBody ma il metodo restituisce solo e non salva niente in db")
	public ResponseEntity<List<Libro>> findByCategorie_IdIn(@RequestBody List<Long> id) {
		List<Libro> find = libroservice.findByCategorie_IdIn(id);
		if (!find.isEmpty()) {
			return new ResponseEntity<>(find, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PostMapping(path = "/libro/aggiungiLibro")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Operation(summary = "Per evitare che sovrascriva i dati usare Id non presenti in memoria,id utente deve essere diverso da 0 e gli id di Categoria e Autore devono essere diversi tra loro")
	public ResponseEntity<Libro> save(@RequestBody Libro libro) {
		Libro save = libroservice.save(libro);
		return new ResponseEntity<>(save, HttpStatus.OK);

	}

	@PutMapping(path = "/libro/aggiornalibro/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Operation
	public ResponseEntity<Libro> update(@PathVariable Long id, @RequestBody Libro libro) {
		Libro save = libroservice.update(id, libro);
		return new ResponseEntity<>(save, HttpStatus.OK);

	}

	@DeleteMapping(path = "/libro/eliminalibro/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		libroservice.delete(id);
		return new ResponseEntity<>("Libro eliminato!", HttpStatus.OK);

	}
}
