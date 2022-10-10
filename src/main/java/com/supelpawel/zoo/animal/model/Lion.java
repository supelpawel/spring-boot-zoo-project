package com.supelpawel.zoo.animal.model;

import javax.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Lion extends Animal {

  public Lion() {
    this.setFoodPortionsPerDay(11);
  }
}