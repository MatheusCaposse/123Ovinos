package com.ovinos.repository;

import com.ovinos.entity.Female;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FemaleRepository extends JpaRepository<Female, String> {
}
