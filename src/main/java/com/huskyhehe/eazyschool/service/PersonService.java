package com.huskyhehe.eazyschool.service;

import com.huskyhehe.eazyschool.constants.EazySchoolConstants;
import com.huskyhehe.eazyschool.model.Person;
import com.huskyhehe.eazyschool.model.Roles;
import com.huskyhehe.eazyschool.repository.PersonRepository;
import com.huskyhehe.eazyschool.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RolesRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean createNewPerson(Person person){
        boolean isSaved = false;
        Roles role = roleRepository.getByRoleName(EazySchoolConstants.STUDENT_ROLE);
        person.setRoles(role);
        person.setPwd(passwordEncoder.encode(person.getPwd()));
        person = personRepository.save(person);

        if (person != null && person.getPersonId() > 0) {
            isSaved = true;
        }
        return isSaved;
    }
}
