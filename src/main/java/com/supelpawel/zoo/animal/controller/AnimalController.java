package com.supelpawel.zoo.animal.controller;

import com.supelpawel.zoo.animal.dto.AnimalDto;
import com.supelpawel.zoo.animal.dto.AnimalSpecies;
import com.supelpawel.zoo.animal.dto.CreateAnimalDto;
import com.supelpawel.zoo.animal.service.AnimalService;
import com.supelpawel.zoo.zone.service.ZoneService;
import java.util.List;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@AllArgsConstructor
public class AnimalController {

  private final AnimalService animalService;
  private final ZoneService zoneService;

  @ModelAttribute("animalSpecies")
  public AnimalSpecies[] getAnimalSpecies() {
    return AnimalSpecies.values();
  }

  @ModelAttribute("animalNames")
  public List<String> getAnimalNames() {
    return animalService.getAnimalNames();
  }

  @ModelAttribute("zones")
  public List<String> getAllZones() {
    return zoneService.findAllZoneNames();
  }

  @GetMapping("/animal/add")
  public String showAddAnimalForm(Model model) {
    return animalService.showAddAnimalForm(model);
  }

  @PostMapping("/animal/add")
  public String processAddAnimalForm(@Valid CreateAnimalDto createAnimalDto, BindingResult result) {
    return animalService.processAddAnimalForm(createAnimalDto, result);
  }

  @GetMapping("/animal/find-by-zone")
  public String showFindAnimalsByZoneForm() {
    return animalService.showFindAnimalsByZoneForm();
  }

  @PostMapping(value = "/animal/find-by-zone", produces = "application/json")
  @ResponseBody
  public List<AnimalDto> processFindAnimalsByZoneForm(@RequestParam String zoneName) {
    return animalService.processFindAnimalsByZoneForm(zoneName);
  }

  @GetMapping("/animal/find-by-name")
  public String showFindAnimalsByNameForm() {
    return animalService.showFindAnimalsByNameForm();
  }

  @PostMapping(value = "/animal/find-by-name", produces = "application/json")
  @ResponseBody
  public List<AnimalDto> processFindAnimalsByNameForm(@RequestParam String name) {
    return animalService.processFindAnimalsByNameForm(name);
  }
}