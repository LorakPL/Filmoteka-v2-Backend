package com.filmoteka.v2.backend.repository;

import com.filmoteka.v2.backend.model.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    ApplicationUser findUserByUsername(String username);
}
