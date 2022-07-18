package com.huskyhehe.eazyschool.service;

import com.huskyhehe.eazyschool.constants.EazySchoolConstants;
import com.huskyhehe.eazyschool.model.Person;
import com.huskyhehe.eazyschool.model.Role;
import com.huskyhehe.eazyschool.repository.PersonRepository;
import com.huskyhehe.eazyschool.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean createNewPerson(Person person){
        boolean isSaved = false;
        Role role = roleRepository.getByRoleName(EazySchoolConstants.STUDENT_ROLE);
        person.setRoles(role);
        person.setPwd(passwordEncoder.encode(person.getPwd()));
        person = personRepository.save(person);

        if (person != null && person.getPersonId() > 0) {
            isSaved = true;
        }
        return isSaved;
    }
}
