package com.supelpawel.zoo.animal.model;

import javax.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Elephant extends Animal {

  public Elephant() {
    this.setFoodPortionsPerDay(20);
  }
}