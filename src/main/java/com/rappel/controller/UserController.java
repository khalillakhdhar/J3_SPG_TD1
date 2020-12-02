package com.rappel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
