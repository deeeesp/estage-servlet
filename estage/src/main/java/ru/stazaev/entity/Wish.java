package ru.stazaev.entity;

public class Wish {
    private long id;
    private long id_client;
    private int meters;
    private int rooms;
    private int cost;

    public Wish() {
    }

    public Wish(long id, long id_client, int meters, int rooms, int cost) {
        this.id = id;
        this.id_client = id_client;
        this.meters = meters;
        this.rooms = rooms;
        this.cost = cost;
    }

    public Wish(long id_client, int meters, int rooms, int cost) {
        this.id_client = id_client;
        this.meters = meters;
        this.rooms = rooms;
        this.cost = cost;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_client() {
        return id_client;
    }

    public void setId_client(long id_client) {
        this.id_client = id_client;
    }

    public int getMeters() {
        return meters;
    }

    public void setMeters(int meters) {
        this.meters = meters;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Wish{" +
                "id=" + id +
                ", id_client=" + id_client +
                ", meters=" + meters +
                ", flat=" + rooms +
                ", cost=" + cost +
                '}';
    }
}
