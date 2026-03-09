package com.ovinos.repository;

import com.ovinos.DTO.ActivityDTO;
import com.ovinos.entity.auxiliarData.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcitivityRepository extends JpaRepository<Activity, Long> {
}
