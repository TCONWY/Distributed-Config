package com.example.configserver.services;

import com.example.configserver.models.Config;
import com.example.configserver.repositories.ConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ConfigService {
    private final ConfigRepository configRepository;
    private final ServiceService serviceService;

    @Autowired
    public ConfigService(ConfigRepository configRepository, ServiceService serviceService) {
        this.configRepository = configRepository;
        this.serviceService = serviceService;
    }

    public List<Config> findAll(){
        return configRepository.findAll();
    }


    public Config findByService(String service){
        return configRepository.findByService(service).orElse(null);
    }

    public Config findByServiceAndActive(String service) {
        return configRepository.findByServiceAndActive(service, true).orElse(null);
    }

    public List<Config> findAllByService (String service) {
        return configRepository.findAllByService(service);
    }

    public Config findByServiceAndConfigVersion(String service, int version){
        return configRepository.findByServiceAndConfigVersion(service, version).orElse(null);
    }

    @Transactional
    public void save(Config config) {
        com.example.configserver.models.Service service = serviceService.findByName(config.getService()).orElse(null);
        List<Config> lstConfigs = service.getConfigs();
        config.setServiceOwner(service);
        lstConfigs.add(config);
        service.setConfigs(lstConfigs);
        serviceService.save(service);
        configRepository.save(config);
    }

    @Transactional
    public void update(int id, Config updateConfig) {
        updateConfig.setId(id);
        configRepository.save(updateConfig);
    }

    @Transactional
    public void delete(int id) {
        configRepository.deleteById(id);
    }
}
