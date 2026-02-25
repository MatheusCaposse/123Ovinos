package com.ovinos.repository;

import com.ovinos.entity.Female;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FemaleRepository extends JpaRepository<Female, Long> {
}
