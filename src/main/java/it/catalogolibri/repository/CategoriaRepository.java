package it.catalogolibri.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import it.catalogolibri.model.Categoria;


public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
	Page<Categoria> findByNome(String nome, Pageable pageable);

}
