package ru.stazaev.entity;

import java.util.List;

public class Worker {
    private long id;

    private String name;

    private int telephone;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public Worker(String name, int telephone) {
        this.name = name;
        this.telephone = telephone;
    }

    public Worker(long id, String name, int telephone) {
        this.id = id;
        this.name = name;
        this.telephone = telephone;
    }

    public Worker() {
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
