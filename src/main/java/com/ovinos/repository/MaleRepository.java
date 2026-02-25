package com.ovinos.repository;

import com.ovinos.entity.Female;
import com.ovinos.entity.Male;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaleRepository extends JpaRepository<Male, Long> {
}
