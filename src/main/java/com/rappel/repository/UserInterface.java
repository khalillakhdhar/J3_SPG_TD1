package com.rappel.repository;

import org.springframework.data.repository.CrudRepository;

import com.rappel.model.User;

public interface UserInterface extends CrudRepository<User, Long> {

}
