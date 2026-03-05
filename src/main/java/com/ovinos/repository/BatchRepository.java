package com.ovinos.repository;

import com.ovinos.entity.Batch;
import com.ovinos.entity.Female;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatchRepository extends JpaRepository<Batch, String> {
}
