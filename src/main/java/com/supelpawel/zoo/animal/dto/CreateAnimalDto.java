package com.supelpawel.zoo.animal.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAnimalDto {

  private String name;
  @Enumerated(EnumType.STRING)
  private AnimalSpecies species;
  private String zoneName;
}
