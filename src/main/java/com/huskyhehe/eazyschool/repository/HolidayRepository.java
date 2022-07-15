package com.huskyhehe.eazyschool.repository;

import com.huskyhehe.eazyschool.model.Holiday;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface HolidayRepository extends CrudRepository<Holiday, String> {
}