package it.catalogolibri.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import it.catalogolibri.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {

	Page<Libro> findByTitolo(String titolo, Pageable pageable);

	List<Libro> findByAutori_IdIn(List<Long> id);

	List<Libro> findByCategorie_IdIn(List<Long> id);

}
