package com.bofa.customerapi.repositories;

import com.bofa.customerapi.models.Corporate;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CorporateRepository extends JpaRepository<Corporate,Long> {
}
