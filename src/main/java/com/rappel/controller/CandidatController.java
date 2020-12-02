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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rappel.exception.ResourceNotFoundException;
import com.rappel.model.Candidat;
import com.rappel.model.Candidat;
import com.rappel.repository.CandidatRepository;

@RestController
@RequestMapping("candidat")
public class CandidatController {
@Autowired
CandidatRepository candidatRepository;
@GetMapping
public List<Candidat> getallcandidats()
{
	return (List<Candidat>) candidatRepository.findAll();
}
@PostMapping
public Candidat addcandidat(@Valid @RequestBody Candidat candidat)
{
	return candidatRepository.save(candidat);

}

//Get a Single Utilisateur
@GetMapping("/{id}")
public Candidat getUtilisateurById(@PathVariable(value = "id") Long id) {
 return candidatRepository.findById(id)
         .orElseThrow(() -> new ResourceNotFoundException("Utilisateur", "id", id));
}

@DeleteMapping("/{id}")
public ResponseEntity<?> deleteUtilisateur(@PathVariable(value = "id") Long id) {
    Candidat candidat = candidatRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Utilisateur", "id", id));

    candidatRepository.delete(candidat);

    return ResponseEntity.ok().build();
}

}
