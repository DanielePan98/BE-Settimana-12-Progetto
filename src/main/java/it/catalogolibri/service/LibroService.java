package it.catalogolibri.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.catalogolibri.exception.CatalogoException;
import it.catalogolibri.model.Libro;
import it.catalogolibri.repository.LibroRepository;


@Service
public class LibroService {
	
	@Autowired
	private LibroRepository librorepository;
	
	public List<Libro> findByAutori_IdIn(List<Long> id) {
		return librorepository.findByAutori_IdIn(id);
	}
	
	public List<Libro> findByCategorie_IdIn(List<Long> id) {
		return librorepository.findByCategorie_IdIn(id);
	}
	
	public Page<Libro> findByTitolo(String titolo,Pageable pageable) {
		return librorepository.findByTitolo(titolo, pageable);
	}
	
	public Optional<Libro> findById( Long id) {
		return librorepository.findById(id);
	}
	
	public List<Libro> findAll() {
		return librorepository.findAll();
	}
	
	public Libro save(Libro libro) {
		return librorepository.save(libro);
	}
	
	public Libro update(Long id,Libro libro) {
		Optional<Libro> libroResult = librorepository.findById(id);
		if(libroResult.isPresent()) {
			Libro libroUpdate=libroResult.get();
			libroUpdate.setTitolo(libro.getTitolo());
			libroUpdate.setAnnoPubblicazione(libro.getAnnoPubblicazione());
			libroUpdate.setPrezzo(libro.getPrezzo());
			libroUpdate.setAutori(libro.getAutori());
			libroUpdate.setCategorie(libro.getCategorie());
			librorepository.save(libroUpdate);
			return libroUpdate;
		}else {
			throw new CatalogoException("Libro non aggiornato!");
		}	
	}
	
	public void delete(Long id) {
		librorepository.deleteById(id);
	}

}
