package com.ovinos.repository;

import com.ovinos.entity.Batch;
import com.ovinos.entity.Female;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatchRepository extends JpaRepository<Batch, String> {
}
