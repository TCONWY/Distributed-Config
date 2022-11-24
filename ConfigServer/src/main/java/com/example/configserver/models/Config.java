package com.example.configserver.models;


import com.vladmihalcea.hibernate.type.json.JsonType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Map;

@Entity
@Table(name = "configs")
@TypeDef(name = "json", typeClass = JsonType.class)
public class Config implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @Type(type = "json")
    @Column(name = "data", columnDefinition = "json")
    private Map<String, Object> data;

    @Column(name = "active")
    private boolean active;

    @Column(name = "service")
    private String service;

    @Column(name = "config_version")
    private int configVersion;

    @ManyToOne
    @JoinColumn(name = "service_id", referencedColumnName = "id")
    private Service serviceOwner;

    public Config() {

    }

    public Config(Map<String, Object> data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Service getServiceOwner() {
        return serviceOwner;
    }

    public void setServiceOwner(Service serviceOwner) {
        this.serviceOwner = serviceOwner;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public int getConfigVersion() {
        return configVersion;
    }

    public void setConfigVersion(int configVersion) {
        this.configVersion = configVersion;
    }

    @Override
    public String toString() {
        return "Config{" +
                "id=" + id +
                ", data=" + data +
                ", active=" + active +
                ", service='" + service + '\'' +
                ", configVersion=" + configVersion +
                ", serviceOwner=" + serviceOwner +
                '}';
    }
}
