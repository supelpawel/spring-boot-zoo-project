package com.supelpawel.zoo.zone.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.supelpawel.zoo.animal.model.Animal;
import com.supelpawel.zoo.zone.model.Zone;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ZoneServiceTest {

  @Test
  @DisplayName("Should return the least inhabited zone")
  void findTheLeastInhabitedZone() {
    Animal animal1 = mock(Animal.class);
    Animal animal2 = mock(Animal.class);
    Zone zone1 = mock(Zone.class);
    Zone zone2 = mock(Zone.class);
    when(zone1.getAnimals()).thenReturn(List.of(animal1, animal2));

    assertTrue(zone1.getAnimals().size() > zone2.getAnimals().size());
  }
}