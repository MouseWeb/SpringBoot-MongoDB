package br.com.mouseweb.domain.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.mouseweb.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		User douglas = new User("1", "Douglas Coelho", "douglas@mouseweb.com.br");
		User leticia = new User("2", "Leticia", "Leticia@mouseweb.com.br");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(douglas, leticia));
		return ResponseEntity.ok().body(list);
	}

}
