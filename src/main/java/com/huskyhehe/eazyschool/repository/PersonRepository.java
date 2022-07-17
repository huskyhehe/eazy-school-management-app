package com.huskyhehe.eazyschool.repository;

import com.huskyhehe.eazyschool.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    Person readByEmail(String email);
}
