package com.rappel.repository;

import org.springframework.data.repository.CrudRepository;

import com.rappel.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
