package main.java.models;

import java.time.LocalDate;

public class Account<T extends Customer> extends Service {
    private T owner;
    private String type;
    private double balance;
    private LocalDate opening_date;
    private LocalDate expiration_date;
    private double bonus_balance;

    public Account(int id, T owner, String type, double balance, LocalDate opening_date) {
        super(id);
        this.balance = balance;
        this.type = type;
        this.owner = owner;
        this.opening_date = opening_date;
        this.bonus_balance = 0.0;
    }

    public Account(int id, T owner, String type, double balance, LocalDate opening_date, double bonus_balance) {
        super(id);
        this.balance = balance;
        this.type = type;
        this.owner = owner;
        this.opening_date = opening_date;
        this.bonus_balance = bonus_balance;
    }

    public T getOwner() {
        return owner;
    }

    public void setOwner(T owner) {
        this.owner = owner;
    }

    public double getBonus() {
        return bonus_balance;
    }

    public void setBonus(double bonus_balance) {
        this.bonus_balance = bonus_balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getOpening_date() {
        return opening_date;
    }

    public void setOpening_date(LocalDate opening_date) {
        this.opening_date = opening_date;
    }

    public LocalDate getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(LocalDate expiration_date) {
        this.expiration_date = expiration_date;
    }

    @Override
    public String toString() {
        return  super.toString() +
                owner.getId() + "\n" +
                type + "\n" +
                balance + "\n" +
                opening_date + "\n" +
                expiration_date + "\n";
    }

}
