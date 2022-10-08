package com.supelpawel.zoo.zone.dto;

import com.supelpawel.zoo.animal.model.Animal;
import com.supelpawel.zoo.zone.model.Zone;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZoneDto {

  private String name;
  private List<Animal> animals = new ArrayList<>();

  public static ZoneDto from(Zone zone) {
    ZoneDto zoneDto = new ZoneDto();

    zoneDto.setName(zone.getName());
    zoneDto.setAnimals(zone.getAnimals());
    return zoneDto;
  }
}
