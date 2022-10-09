package com.supelpawel.zoo.animal.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAnimalDto {

  @Size(min = 3)
  private String name;
  @Enumerated(EnumType.STRING)
  private AnimalSpecies species;
  private String zoneName;
}