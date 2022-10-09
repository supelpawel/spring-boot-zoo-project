package com.supelpawel.zoo.animal.service;

import com.supelpawel.zoo.animal.dto.AnimalDto;
import com.supelpawel.zoo.animal.dto.CreateAnimalDto;
import com.supelpawel.zoo.animal.model.Animal;
import com.supelpawel.zoo.animal.model.AnimalFactory;
import com.supelpawel.zoo.animal.repository.AnimalRepository;
import com.supelpawel.zoo.zone.model.Zone;
import com.supelpawel.zoo.zone.service.ZoneService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Service
@AllArgsConstructor
public class AnimalService {

  private final AnimalRepository animalRepository;
  private final ZoneService zoneService;

  public String showAddAnimalForm(Model model) {
    CreateAnimalDto createAnimalDto = new CreateAnimalDto();

    model.addAttribute("createAnimalDto", createAnimalDto);
    return "animal/add";
  }

  @Transactional
  public String processAddAnimalForm(CreateAnimalDto createAnimalDto, BindingResult result) {
    if (result.hasErrors()) {
      return "animal/add";
    }

    AnimalFactory animalFactory = new AnimalFactory();
    Animal animal = animalFactory.createAnimal(String.valueOf(createAnimalDto.getSpecies()));
    Zone zone = zoneService.findByName(createAnimalDto.getZoneName());

    animal.setName(createAnimalDto.getName());
    animal.setSpecies(String.valueOf(createAnimalDto.getSpecies()));
    animal.setZone(zone);
    animalRepository.save(animal);
    zone.getAnimals().add(animal);
    zoneService.save(zone);
    return "redirect:/";
  }

  public String showFindAnimalsByZoneForm() {
    return "animal/findByZone";
  }

  public List<AnimalDto> processFindAnimalsByZoneForm(String zoneName) {
    return zoneService.findByName(zoneName).getAnimals()
        .stream()
        .map(AnimalDto::from)
        .collect(Collectors.toList());
  }

  public String showFindAnimalsByNameForm() {
    return "animal/findByName";
  }

  public List<AnimalDto> processFindAnimalsByNameForm(String name) {
    return findAll().stream()
        .filter(animal -> name.equals(animal.getName()))
        .map(AnimalDto::from)
        .collect(Collectors.toList());
  }

  public List<Animal> findAll() {
    return animalRepository.findAll();
  }

  public List<String> getAnimalNames() {
    return findAll().stream()
        .map(Animal::getName)
        .distinct()
        .collect(Collectors.toList());
  }
}