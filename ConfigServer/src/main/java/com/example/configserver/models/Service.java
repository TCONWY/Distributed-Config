package com.example.configserver.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Services")
public class Service {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    private String name;

    @OneToMany(mappedBy = "serviceOwner")
    private List<Config> configs;

    public Service() {

    }

    public Service(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Config> getConfigs() {
        return configs;
    }

    public void setConfigs(List<Config> configs) {
        this.configs = configs;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", configs=" + configs +
                '}';
    }
}
