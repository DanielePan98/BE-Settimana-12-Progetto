package it.catalogolibri.config;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import it.catalogolibri.model.Autore;
import it.catalogolibri.model.Categoria;
import it.catalogolibri.model.Libro;
import it.catalogolibri.model.Role;
import it.catalogolibri.model.Roles;
import it.catalogolibri.model.User;
import it.catalogolibri.repository.AutoreRepository;
import it.catalogolibri.repository.CategoriaRepository;
import it.catalogolibri.repository.LibroRepository;
import it.catalogolibri.repository.RoleRepository;
import it.catalogolibri.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ApplicationStartupRunner implements CommandLineRunner {
	
	@Autowired
	private LibroRepository librorepository;
	@Autowired
	private AutoreRepository autorerepository;
	@Autowired
	private CategoriaRepository categoriarepository;
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	
	
	@Override
	public void run(String... args) throws Exception {
	
//	 initLibro();
//	 initAutore();
//	 initCategoria();
//	 
//	 BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
//		
//		Role role = new Role();
//	    Role role2 = new Role();
//	   
//	    role2.setRoleName(Roles.ROLE_USER);
//		role.setRoleName(Roles.ROLE_ADMIN);
//	
//		User user = new User();
//		User user2 = new User();
//		Set<Role> rolesAdmin = new HashSet<>(); 
//		Set<Role> rolesUser = new HashSet<>(); 
//		rolesAdmin.add(role);
//		rolesUser.add(role2);
//		
//		user2.setUserName("user");
//		user2.setPassword(bCrypt.encode("user"));
//		user2.setEmail("user@gmail.com");
//		user2.setRoles(rolesUser);
//		user2.setActive(true);
//		
//		user.setUserName("admin");
//		user.setPassword(bCrypt.encode("admin"));
//		user.setEmail("admin@domain.com");
//		user.setRoles(rolesAdmin);
//		user.setActive(true);
//		
//		
//		roleRepository.save(role2);
//		roleRepository.save(role);
//	
//		userRepository.save(user);
//		userRepository.save(user2);
		
	}

	private Categoria initCategoria() {
		Categoria categoria=new Categoria();
		categoria.setNome("Sci-Fi");
		categoriarepository.save(categoria);
		log.info("Categoria salvata: {}",categoria.getNome());
		return categoria;
	}
	
private Autore initAutore() {
	Autore autore=new Autore();
	autore.setNome("Marco");
	autore.setCognome("Rossi");
	autorerepository.save(autore);
	log.info("Autore salvato: {}",autore.getNome()+autore.getCognome());
	return autore;
}

	private Libro initLibro() {
		
		List<Categoria> categorie = new ArrayList<>();
		List<Autore> autori = new ArrayList<>();
		
		
		Autore autore1=new Autore();
		Autore autore2=new Autore();
		
		autore1.setCognome("Palladino");
		autore1.setNome("Mario");
		
		autore2.setCognome("Redente");
		autore2.setNome("Nicola");
		
		autori.add(autore2);
		autori.add(autore1);
		
		Categoria categoria1=new Categoria();
		Categoria categoria2=new Categoria();
		
		categoria1.setNome("Fantasy");
		categoria2.setNome("Avventura");
		
		categorie.add(categoria2);
		categorie.add(categoria1);
		
		Libro libro2 = new Libro();
		libro2.setAutori(autori);
		Libro libro = new Libro();
		libro.setTitolo("Harry Potter");
		libro.setAnnoPubblicazione(2022);
		libro.setPrezzo(9.50);
		libro.setAutori(autori);
		libro.setCategorie(categorie);
		librorepository.save(libro);
		log.info("Libro salvato: {}",libro.getTitolo());
		return libro;
	}

}
