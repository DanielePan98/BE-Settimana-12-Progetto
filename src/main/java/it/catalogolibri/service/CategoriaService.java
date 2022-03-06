package it.catalogolibri.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.catalogolibri.exception.CatalogoException;
import it.catalogolibri.model.Categoria;
import it.catalogolibri.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriarepository;

	public Page<Categoria> findByNome(String nome, Pageable pageable) {
		return categoriarepository.findByNome(nome, pageable);
	}

	public Optional<Categoria> findById(Long id) {
		return categoriarepository.findById(id);
	}

	public List<Categoria> findAll() {
		return categoriarepository.findAll();
	}

	public Categoria save(Categoria categoria) {
		return categoriarepository.save(categoria);
	}

	public Categoria update(Long id, Categoria categoria) {
		Optional<Categoria> categoriaResult = categoriarepository.findById(id);
		if (categoriaResult.isPresent()) {
			Categoria categoriaUpdate = categoriaResult.get();
			categoriaUpdate.setNome(categoria.getNome());
			categoriarepository.save(categoriaUpdate);
			return categoriaUpdate;
		} else {
			throw new CatalogoException("Categoria non aggiornata!");
		}
	}

	public void delete(Long id) {
		categoriarepository.deleteById(id);
	}

}
