package com.supelpawel.zoo.zone.controller;

import com.supelpawel.zoo.zone.dto.ZoneDto;
import com.supelpawel.zoo.zone.model.Zone;
import com.supelpawel.zoo.zone.service.ZoneService;
import java.util.Optional;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@AllArgsConstructor
public class ZoneController {

  private final ZoneService zoneService;

  @GetMapping("/zone/add")
  String showAddZoneForm(Model model) {
    return zoneService.showAddZoneForm(model);
  }

  @PostMapping("/zone/add")
  String processAddZoneForm(@Valid Zone zone, BindingResult result) {
    return zoneService.processAddZoneForm(zone, result);
  }

  @GetMapping(value = "/zone/find-the-most-food-demanding", produces = "application/json")
  @ResponseBody
  Optional<ZoneDto> findTheMostFoodDemandingZone() {
    return zoneService.findTheMostFoodDemandingZone();
  }

  @GetMapping(value = "/zone/find-the-least-inhabited", produces = "application/json")
  @ResponseBody
  ZoneDto findTheLeastInhabitedZone() {
    return zoneService.findTheLeastInhabitedZone();
  }
}
