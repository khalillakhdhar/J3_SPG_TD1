package com.rappel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Formation {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
long id;
@NotBlank
String titre;
@Column(nullable = true,length = 100)
String description;

}
