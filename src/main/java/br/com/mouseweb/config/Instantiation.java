package br.com.mouseweb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.mouseweb.domain.Post;
import br.com.mouseweb.domain.User;
import br.com.mouseweb.dto.AuthorDTO;
import br.com.mouseweb.repository.PostRepository;
import br.com.mouseweb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");

		userRepository.deleteAll();
		postRepository.deleteAll();

		User dog = new User(null, "Douglas Coelho", "douglas@gmail.com");
		User let = new User(null, "Leticia Martins", "let@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(dog, let, bob));
		
		Post p1 = new Post(null, sdf.parse("28/07/2018"), "Partiu Praia", "Irei viaja", new AuthorDTO(dog));
		Post p2 = new Post(null, sdf.parse("28/07/2018"), "Boa Noite", "Cheguei", new AuthorDTO(let));

		postRepository.saveAll(Arrays.asList(p1, p2));
		
		dog.getPosts().addAll(Arrays.asList(p1,p2));
		userRepository.save(dog);
		
	}

}
