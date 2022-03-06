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

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import it.catalogolibri.model.Categoria;
import it.catalogolibri.service.CategoriaService;

@RestController
@SecurityRequirement(name="bearerAuth")
@RequestMapping("/api")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaservice;
	
	@GetMapping(path = "/categoria/listaCategorie")
	public ResponseEntity<List<Categoria>> findAll() {
		List<Categoria> findAll = categoriaservice.findAll();

		if (!findAll.isEmpty()) {
			return new ResponseEntity<>(findAll, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

	}
	
	@GetMapping(path = "/categoria/categoriaById/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable(required = true) Long id) {
		Optional<Categoria> find = categoriaservice.findById(id);

		if (find.isPresent()) {
			return new ResponseEntity<>(find.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

	}
	
	
	@PostMapping(path = "/categoria/aggiungiCategoria")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Categoria> save(@RequestBody Categoria categoria) {
		Categoria save = categoriaservice.save(categoria);
		return new ResponseEntity<>(save, HttpStatus.OK);

	}

	@PutMapping(path = "/categoria/aggiornaCategoria/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Categoria> update(@PathVariable Long id, @RequestBody Categoria categoria) {
		Categoria save = categoriaservice.update(id, categoria);
		return new ResponseEntity<>(save, HttpStatus.OK);

	}

	@DeleteMapping(path = "/categoria/eliminaCategoria/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		categoriaservice.delete(id);
		return new ResponseEntity<>("Categoria eliminata!", HttpStatus.OK);

	}

}
