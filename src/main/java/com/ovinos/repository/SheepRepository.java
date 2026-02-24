package com.ovinos.repository;

import com.ovinos.entity.Sheep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SheepRepository extends JpaRepository<Sheep, Long> {
}
