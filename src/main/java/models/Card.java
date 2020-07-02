package main.java.models;

import java.time.LocalDate;

public class Card extends Account {
    private static int duration_month = 24;
    private String card_number;
    private boolean available;
    private int CVV;

    public Card(int id, Client client, String type, double balance, LocalDate opening_date, String card_number, int CVV, boolean available) {
        super(id, client, type, balance, opening_date);
        this.card_number = card_number;
        this.CVV = CVV;
        this.available = available;
        setExpiration_date(opening_date.plusMonths(duration_month));
    }



    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public int getCVV() {
        return CVV;
    }

    public void setCVV(int CVV) {
        this.CVV = CVV;
    }

    public static int getDuration_month() {
        return duration_month;
    }

    public static void setDuration_month(int duration_month) {
        Card.duration_month = duration_month;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return super.toString() +
                card_number + "\n" +
                available + "\n" +
                CVV + "\n";
    }
}
