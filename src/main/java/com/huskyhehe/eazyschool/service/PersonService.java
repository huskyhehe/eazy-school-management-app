package com.huskyhehe.eazyschool.service;

import com.huskyhehe.eazyschool.model.Person;
import com.huskyhehe.eazyschool.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public boolean createNewPerson(Person person){
        boolean isSaved = false;

        person = personRepository.save(person);
        if (person != null && person.getPersonId() > 0) {
            isSaved = true;
        }
        return isSaved;
    }
}
