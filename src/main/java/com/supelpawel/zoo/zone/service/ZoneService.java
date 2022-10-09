package com.supelpawel.zoo.zone.service;

import com.supelpawel.zoo.zone.dto.ZoneDto;
import com.supelpawel.zoo.zone.model.Zone;
import com.supelpawel.zoo.zone.repository.ZoneRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Service
@AllArgsConstructor
public class ZoneService {

  private final ZoneRepository zoneRepository;

  public String showAddZoneForm(Model model) {
    Zone zone = new Zone();

    model.addAttribute("zone", zone);
    return "zone/add";
  }

  @Transactional
  public String processAddZoneForm(Zone zone, BindingResult result) {
    if (result.hasErrors()) {
      return "zone/add";
    }

    if (zoneRepository.findByName(zone.getName()) != null) {
      return "zone/warning";
    }
    zoneRepository.save(zone);
    return "redirect:/";
  }

  public List<String> findAllZoneNames() {
    return zoneRepository.findAll().stream()
        .map(Zone::getName)
        .collect(Collectors.toList());
  }

  public void save(Zone zone) {
    zoneRepository.save(zone);
  }

  public Zone findByName(String name) {
    return zoneRepository.findByName(name);
  }

  public Optional<ZoneDto> findTheMostFoodDemandingZone() {
    return zoneRepository.findTheMostFoodDemandingZones().stream()
        .map(ZoneDto::from)
        .findFirst();
  }

  public ZoneDto findTheLeastInhabitedZone() {
    Zone theLeastInhabitedZone = zoneRepository.findTheLeastInhabitedZone();

    return ZoneDto.from(theLeastInhabitedZone);
  }
}