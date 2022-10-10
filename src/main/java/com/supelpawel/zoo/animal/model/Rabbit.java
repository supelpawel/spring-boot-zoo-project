package com.supelpawel.zoo.animal.model;

import javax.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Rabbit extends Animal {

  public Rabbit() {
    this.setFoodPortionsPerDay(4);
  }
}