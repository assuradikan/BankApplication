package main.java.models;

import main.java.Observable;
import main.java.Observer;

import java.util.*;

public class Bank implements Observable {
    private List<Observer> observers;
    private HashMap<Integer, Client> clients;
    private HashMap<Integer, Company> companies;
    private HashMap<Integer, Account> accounts;
    private HashSet<Transaction> transactions;
    private ArrayList<History> histories;


    public Bank(){
        this.observers = new LinkedList<>();
        this.clients = new HashMap<>();
        this.companies = new HashMap<>();
        this.accounts = new HashMap<>();
        this.transactions = new HashSet<>();
        this.histories = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void notifyObservers(int code, String message) {
        System.out.println(message);
        for (Observer o: this.observers) o.notification(code, message);
    }
}
