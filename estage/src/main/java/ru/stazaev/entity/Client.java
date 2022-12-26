package ru.stazaev.entity;

public class Client {
    private long id;
    private String name;
    private int telephone;

    public Client(String name, int telephone) {
        this.name = name;
        this.telephone = telephone;
    }

    public Client(long id, String name, int telephone) {
        this.id = id;
        this.name = name;
        this.telephone = telephone;
    }

    public Client() {
    }

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

    @Override
    public String toString() {
        return "Clients{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
