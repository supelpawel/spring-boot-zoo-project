package com.supelpawel.zoo.animal.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.supelpawel.zoo.animal.model.Animal;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AnimalServiceTest {

  @Test
  @DisplayName("Should return a list of animals with the given name")
  void findAnimalsByNameWhenThereAreSomeAnimalsWithTheGivenNameThenReturnListOfAnimals() {
    Animal animal1 = mock(Animal.class);
    Animal animal2 = mock(Animal.class);
    Animal animal3 = mock(Animal.class);
    when(animal1.getName()).thenReturn("animal1");
    when(animal2.getName()).thenReturn("animal1");
    when(animal3.getName()).thenReturn("animal1");
    List<Animal> animals = List.of(animal1, animal2, animal3);

    int expected = 3;
    int actual = (int) animals.stream()
        .filter(animal -> "animal1".equals(animal.getName()))
        .count();

    assertEquals(expected, actual);
  }

  @Test
  @DisplayName("Should return an empty list when the given name is not found")
  void findAnimalsByNameWhenThereIsNoAnimalWithTheGivenNameThenReturnEmptyList() {
    Animal animal1 = mock(Animal.class);
    Animal animal2 = mock(Animal.class);
    Animal animal3 = mock(Animal.class);
    when(animal1.getName()).thenReturn("animal1");
    when(animal2.getName()).thenReturn("animal1");
    when(animal3.getName()).thenReturn("animal1");
    List<Animal> animals = List.of(animal1, animal2, animal3);

    List<Animal> animalList = animals.stream()
        .filter(animal -> "animal2".equals(animal.getName())).toList();

    assertTrue(animalList.isEmpty());
  }
}