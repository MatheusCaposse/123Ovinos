package com.ovinos.repository;

import com.ovinos.entity.auxiliarData.Pregnancy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PregnancyRepository extends JpaRepository<Pregnancy, Long> {
}
