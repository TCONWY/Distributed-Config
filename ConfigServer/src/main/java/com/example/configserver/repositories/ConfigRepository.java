package com.example.configserver.repositories;

import com.example.configserver.models.Config;
import com.example.configserver.models.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConfigRepository extends JpaRepository<Config, Integer> {
    List<Config> findAllByService (String service);
    Optional<Config> findConfigByActive(boolean active);
    Optional<Config> findByServiceAndConfigVersion(String service, int version);
    Optional<Config> findByService(String service);
    Optional<Config> findByServiceAndActive(String Service, Boolean active);
}
