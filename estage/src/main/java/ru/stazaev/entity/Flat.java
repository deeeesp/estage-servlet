package ru.stazaev.entity;

public class Flat {
    private long id;

    private long worker_id;

    private int meters;

    private int floor;

    private int rooms;

    public Flat() {
    }

    public Flat(long worker_id, int meters, int floor, int rooms) {
        this.worker_id = worker_id;
        this.meters = meters;
        this.floor = floor;
        this.rooms = rooms;
    }

    public Flat(long id, long worker_id, int meters, int floor, int rooms) {
        this.id = id;
        this.worker_id = worker_id;
        this.meters = meters;
        this.floor = floor;
        this.rooms = rooms;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getWorker_id() {
        return worker_id;
    }

    public void setWorker_id(long worker_id) {
        this.worker_id = worker_id;
    }

    public int getMeters() {
        return meters;
    }

    public void setMeters(int meters) {
        this.meters = meters;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "Flat{" +
                "id=" + id +
                ", worker_id=" + worker_id +
                ", meters=" + meters +
                ", flat=" + floor +
                ", rooms=" + rooms +
                '}';
    }
}
