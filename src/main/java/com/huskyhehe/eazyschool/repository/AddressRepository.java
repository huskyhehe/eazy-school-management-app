package com.huskyhehe.eazyschool.repository;

import com.huskyhehe.eazyschool.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
