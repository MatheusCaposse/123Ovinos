package com.ovinos.repository;

import com.ovinos.entity.auxiliarData.Characteristics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacteristicsRepository extends JpaRepository<Characteristics, Long> {
}
