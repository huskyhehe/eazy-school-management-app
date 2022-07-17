package com.huskyhehe.eazyschool.repository;

import com.huskyhehe.eazyschool.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role getByRoleName(String roleName);
}
