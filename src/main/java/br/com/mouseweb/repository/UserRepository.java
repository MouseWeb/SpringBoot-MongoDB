package br.com.mouseweb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.mouseweb.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
	
	
}
