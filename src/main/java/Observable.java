package main.java;

public interface Observable {
    void registerObserver(Observer o);
    void notifyObservers(int code, String message);
}
