package main.java.models;

public class Service {
    private int id;

    public Service(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id + "\n";
    }
}
