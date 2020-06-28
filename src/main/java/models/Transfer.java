package main.java.models;

import java.time.LocalDateTime;

public class Transfer implements Transaction{
    private Account<Client> from;
    private Account<Client> to;
    private LocalDateTime date;
    private int status;
    private String message;
    private boolean completed;
    private double amount;

    public Transfer(Account<Client> from, Account<Client> to) {
        this.from = from;
        this.to = to;
        this.completed = false;
        this.message = "Processing";
        this.status = 101;
    }

    @Override
    public void process(double amount) {
        assert from.getBalance() > amount;
        from.setBalance(from.getBalance()-amount);
        to.setBalance(to.getBalance()+amount);

        this.amount = amount;
        this.status = 111;
        this.message = "Completed successfully";
        this.completed = true;
        this.date = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return  from.getId() + "\n" +
                to.getId() + "\n" +
                status + "\n" +
                message + "\n" +
                completed + "\n" +
                amount + "\n";
    }
}
