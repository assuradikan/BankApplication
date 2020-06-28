package main.java.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Payment implements Transaction {
    private Account<Client> from;
    private Account<Company> to;
    private String additional_information;
    private boolean use_bonus;
    private LocalDateTime date;
    private int status;
    private String message;
    private boolean completed;
    private double amount;

    public Payment(Account<Client> from, Account<Company> to, String additional_information, boolean use_bonus) {
        this.from = from;
        this.to = to;
        this.additional_information = additional_information;
        this.use_bonus = use_bonus;
    }

    @Override
    public void process(double amount) {
        if (use_bonus) {
            assert from.getBalance()+from.getBonus() > amount;
            double spent_bonus = spent_bonus(amount);
            double spent_balance = spent_balance(amount);
            from.setBonus(from.getBonus()-spent_bonus);
            from.setBalance(from.getBalance()-spent_balance);
            to.setBalance(to.getBalance()+amount);
        } else {
            from.setBalance(from.getBalance()-amount);
            to.setBalance(to.getBalance()+amount);
        }


        this.from.setBonus(this.from.getBonus() + amount*0.01);
        this.amount = amount;
        this.status = 111;
        this.message = "Completed successfully";
        this.date = LocalDateTime.now();
        this.completed = true;
    }

    public double spent_bonus(double amount) {
        if (!use_bonus) return 0;
        else {
            if (from.getBonus() < amount) return from.getBonus();
            else return amount;
        }
    }

    public double spent_balance(double amount) {
        if (!use_bonus) return amount;
        else {
            if (spent_bonus(amount) == amount) return 0;
            else return amount-spent_bonus(amount);
        }
    }

    public static void main(String[] args) {
        Client client1 = new Client(1424, "B", "B", "g", "8");
        Company company1 = new Company(1424, "Kcell", "142", "la");

        Account<Client> acc1 = new Account<>(4142, client1, "A", 1000, LocalDate.now());
        acc1.setBonus(150);
        Account<Company> acc2 = new Account<>(4142, company1, "A", 0, LocalDate.now());

        Payment payment = new Payment(acc1, acc2, "874", true);
        System.out.println(payment.spent_bonus(400));
        System.out.println(payment.spent_balance(400));
        payment.process(400);
        System.out.println(acc1.getBalance());
        System.out.println(acc1.getBonus());

        System.out.println();
        System.out.println(acc2.getBalance());
    }
}
