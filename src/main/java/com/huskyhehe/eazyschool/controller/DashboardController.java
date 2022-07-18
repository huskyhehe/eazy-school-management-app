package com.huskyhehe.eazyschool.controller;

import com.huskyhehe.eazyschool.model.Person;
import com.huskyhehe.eazyschool.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class DashboardController {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/dashboard")
    public String displayDashboard(Model model,Authentication authentication, HttpSession session) {
        Person person = personRepository.readByEmail(authentication.getName());
        model.addAttribute("username", authentication.getName());
        model.addAttribute("roles", authentication.getAuthorities().toString());
        session.setAttribute("loggedInPerson", person);

        return "dashboard.html";
    }
}
