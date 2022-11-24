package com.example.configserver.repositories;

import com.example.configserver.models.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Integer> {
    Optional<Service> findByName(String name);
}
