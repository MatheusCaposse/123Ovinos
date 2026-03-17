package com.ovinos.repository;

import com.ovinos.entity.auxiliarData.Kinship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KinshipRepository extends JpaRepository<Kinship, Long> {
}
