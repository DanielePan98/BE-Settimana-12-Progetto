package it.catalogolibri.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import it.catalogolibri.model.Autore;


public interface AutoreRepository extends JpaRepository<Autore, Long>{
	
	Page<Autore> findByNome(String nome, Pageable pageable);
	

}
