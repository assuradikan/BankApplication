package main.java.models;

import java.time.LocalDate;

public class Deposit extends Account{
    private static int duration_month = 12;
    private String contract_number;
    private static int effective_rate;
    private String currency;

    public Deposit(int id, Client client, String type, double balance, LocalDate opening_date, String contract_number, String currency) {
        super(id, client, type, balance, opening_date);
        this.contract_number = contract_number;
        this.currency = currency;
        setExpiration_date(opening_date.plusMonths(duration_month));
    }

    public static int getDuration_month() {
        return duration_month;
    }

    public static void setDuration_month(int duration_month) {
        Deposit.duration_month = duration_month;
    }

    public String getContract_number() {
        return contract_number;
    }

    public void setContract_number(String contract_number) {
        this.contract_number = contract_number;
    }

    public static int getEffective_rate() {
        return effective_rate;
    }

    public static void setEffective_rate(int effective_rate) {
        Deposit.effective_rate = effective_rate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return super.toString() +
                contract_number + "\n" +
                currency + "\n";
    }
}
