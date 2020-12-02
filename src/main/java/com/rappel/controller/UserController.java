package com.rappel.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rappel.exception.ResourceNotFoundException;
import com.rappel.model.User;
import com.rappel.repository.UserRepository;

@RestController
public class UserController {
@Autowired
UserRepository userRepository;
@GetMapping("user")
public List<User> afficheUsers()
{
	
return 	(List<User>) userRepository.findAll();

}
@PostMapping("user")
public User adduser(@Valid @RequestBody User user)
{
	return userRepository.save(user);

}

//Get a Single Utilisateur
@GetMapping("/user/{id}")
public User getUtilisateurById(@PathVariable(value = "id") Long id) {
 return userRepository.findById(id)
         .orElseThrow(() -> new ResourceNotFoundException("Utilisateur", "id", id));
}

@DeleteMapping("/user/{id}")
public ResponseEntity<?> deleteUtilisateur(@PathVariable(value = "id") Long id) {
    User user = userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Utilisateur", "id", id));

    userRepository.delete(user);

    return ResponseEntity.ok().build();
}



}
