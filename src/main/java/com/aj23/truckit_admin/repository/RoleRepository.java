package com.aj23.truckit_admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aj23.truckit_admin.model.Role;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Integer> {
        Optional<Role> findByName(String name);
}
