package com.supelpawel.zoo.animal.model;

public class AnimalFactory {

  public Animal createAnimal(String species) {
    Animal animal = null;

    switch (species) {
      case "ELEPHANT" -> animal = new Elephant();
      case "LION" -> animal = new Lion();
      case "RABBIT" -> animal = new Rabbit();
    }
    return animal;
  }
}