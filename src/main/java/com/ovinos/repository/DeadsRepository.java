package com.ovinos.repository;

import com.ovinos.entity.Deads;
import jakarta.annotation.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

@Resource
public interface DeadsRepository extends JpaRepository<Deads, String> {
}
