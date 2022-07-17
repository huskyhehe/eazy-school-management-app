package com.huskyhehe.eazyschool.service;

import com.huskyhehe.eazyschool.constants.EazySchoolConstants;
import com.huskyhehe.eazyschool.model.Person;
import com.huskyhehe.eazyschool.model.Role;
import com.huskyhehe.eazyschool.repository.PersonRepository;
import com.huskyhehe.eazyschool.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RoleRepository roleRepository;

    public boolean createNewPerson(Person person){
        boolean isSaved = false;
        Role role = roleRepository.getByRoleName(EazySchoolConstants.STUDENT_ROLE);
        person.setRoles(role);
        person = personRepository.save(person);
        if (null != person && person.getPersonId() > 0) {
            isSaved = true;
        }
        return isSaved;
    }
}
