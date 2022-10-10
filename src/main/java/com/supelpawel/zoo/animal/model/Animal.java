package com.supelpawel.zoo.animal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.supelpawel.zoo.zone.model.Zone;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "animals")
@Data
public class Animal implements AnimalSpecies {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String species;
  @Size(min = 3)
  private String name;
  @ManyToOne
  @JsonIgnore
  private Zone zone;
  private int foodPortionsPerDay;
}