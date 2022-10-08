package com.supelpawel.zoo.animal.model;

public class AnimalFactory implements AnimalCreator {

  @Override
  public Animal createAnimal(String species) {
    Animal animal;

    switch (species) {
      case "ELEPHANT" -> {
        animal = new Elephant();
        return animal;
      }
      case "LION" -> {
        animal = new Lion();
        return animal;
      }
      case "RABBIT" -> {
        animal = new Rabbit();
        return animal;
      }
    }
    return null;
  }
}
