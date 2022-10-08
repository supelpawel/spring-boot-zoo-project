package com.supelpawel.zoo.animal.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.supelpawel.zoo.animal.model.Animal;
import com.supelpawel.zoo.zone.model.Zone;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnimalDto {

  private String species;
  private String name;
  @OneToOne
  @JsonIgnore
  private Zone zone;
  private int foodPortionsPerDay;

  public static AnimalDto from(Animal animal) {
    AnimalDto animalDto = new AnimalDto();

    animalDto.setSpecies(animal.getSpecies());
    animalDto.setName(animal.getName());
    animalDto.setZone(animal.getZone());
    animalDto.setFoodPortionsPerDay(animal.getFoodPortionsPerDay());
    return animalDto;
  }
}
