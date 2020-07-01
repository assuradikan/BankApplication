package main.java.controllers;

import main.java.Observer;
import main.java.models.Bank;

public class ContentController implements Observer {
    private Bank bank;

    public void setBank(Bank bank) {
        bank.registerObserver(this);
        this.bank = bank;
    }

    public Bank getBank() {
        return bank;
    }

    @Override
    public void notification(int code, String message) {

    }
}
