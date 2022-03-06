package it.catalogolibri.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.catalogolibri.exception.CatalogoException;
import it.catalogolibri.model.Autore;
import it.catalogolibri.repository.AutoreRepository;

@Service
public class AutoreService {
	
	@Autowired
	private AutoreRepository autorerepository;
	
	public Page<Autore> findByNome(String nome,Pageable pageable) {
		return autorerepository.findByNome(nome, pageable);
	}
	public Optional<Autore> findById( Long id) {
		return autorerepository.findById(id);
	}
	
	public List<Autore> findAll() {
		return autorerepository.findAll();
	}
	
	public Autore save(Autore autore) {
		return autorerepository.save(autore);
	}
	
	public Autore update(Long id,Autore autore) {
		Optional<Autore> autoreResult = autorerepository.findById(id);
		if(autoreResult.isPresent()) {
			Autore autoreUpdate=autoreResult.get();
			autoreUpdate.setNome(autore.getNome());
			autoreUpdate.setCognome(autore.getCognome());
			autorerepository.save(autoreUpdate);
			return autoreUpdate;
		}else {
			throw new CatalogoException("Autore non aggiornato!");
		}	
	}
	
	public void delete(Long id) {
		autorerepository.deleteById(id);
	}
}
