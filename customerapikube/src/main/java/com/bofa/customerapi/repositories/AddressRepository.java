package com.bofa.customerapi.repositories;

import com.bofa.customerapi.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
