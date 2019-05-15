package com.uplife.api.repository;

import com.uplife.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAll();

    User findById(long Id);

    User findByNom(String nom);

    User findByPrenom (String prenom);

    User findByUsername(String username);
}
