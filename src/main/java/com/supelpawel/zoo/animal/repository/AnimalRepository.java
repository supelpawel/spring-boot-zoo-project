package com.supelpawel.zoo.animal.repository;

import com.supelpawel.zoo.animal.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

}
