package com.supelpawel.zoo.zone.repository;

import com.supelpawel.zoo.zone.model.Zone;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ZoneRepository extends JpaRepository<Zone, Long> {

  Zone findByName(String name);

  @Query(value = "SELECT z FROM Zone z WHERE z.animals.size=(SELECT MIN(z.animals.size) FROM z)")
  Zone findTheLeastInhabitedZone();

  @Query(value = "SELECT z, SUM(a.foodPortionsPerDay) FROM Zone z JOIN z.animals a GROUP BY z.id "
      + "ORDER BY SUM(a.foodPortionsPerDay) DESC")
  List<Zone> findTheMostFoodDemandingZones();
}
