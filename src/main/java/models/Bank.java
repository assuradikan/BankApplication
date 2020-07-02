package main.java.models;

import main.java.Observable;
import main.java.Observer;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.*;

public class Bank implements Observable {
    private List<Observer> observers;
    private HashMap<Integer, Client> clients;
    private HashMap<Integer, Company> companies;
    private HashMap<Integer, Account<Company>> accounts;
    private HashMap<Integer, Card> cards;
    private HashMap<Integer, Deposit> deposits;
    private HashSet<Transaction> transactions;
    private ArrayList<History> histories;
    private Client current_client;


    public Bank(){
        this.observers = new LinkedList<>();
        this.clients = new HashMap<>();
        this.companies = new HashMap<>();
        this.cards = new HashMap<>();
        this.deposits = new HashMap<>();
        this.accounts = new HashMap<>();
        this.transactions = new HashSet<>();
        this.histories = new ArrayList<>();
    }

    public Client getCurrent_client() {
        return current_client;
    }

    public void sign_in(){
        File directory = new File("./src/main/resources/data/current_client.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(directory);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        if (sc.hasNext()) {
            int id = sc.nextInt();
            current_client = clients.get(id);
        }
    }

    public void sign_out() {
        current_client = null;
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

    public void load(){
        load_clients();
        load_companies();
        load_accounts();
        load_cards();
        load_deposit();
    }

    private void load_clients() {
        File directory = new File("./src/main/resources/data/clients.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(directory);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (sc.hasNext()){
            int id  = sc.nextInt();
            String name = sc.next();
            String surname = sc.next();
            String email = sc.next();
            String phone = sc.next();
            boolean has_card = sc.nextBoolean();
            Client client = new Client(id, name, surname, email, phone, has_card);
            clients.put(id, client);
        }

        System.out.println("Clients are loaded");
        sc.close();
    }

    private void load_companies() {
        File directory = new File("./src/main/resources/data/company.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(directory);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (sc.hasNext()){
            int id  = sc.nextInt();
            String name = sc.next();
            String bin = sc.next();
            sc.nextLine();
            String des = sc.nextLine();
            Company company = new Company(id, name, bin, des);
            companies.put(id, company);
        }

        System.out.println("Companies are loaded");
        sc.close();
    }

    private void load_accounts() {
        File directory = new File("./src/main/resources/data/accounts.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(directory).useLocale(Locale.US);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (sc.hasNext()){
            int id  = sc.nextInt();
            int owner_id  = sc.nextInt();
            String type = sc.next();
            double balance = sc.nextDouble();
            String sd = sc.next();
            String ed = sc.next();
            Account<Company> account = new Account<Company>(id, companies.get(owner_id), type, balance, LocalDate.parse(sd), LocalDate.parse(ed));
            accounts.put(id, account);
        }

        System.out.println("Accounts are loaded");
        sc.close();
    }

    private void load_cards() {
        File directory = new File("./src/main/resources/data/cards.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(directory).useLocale(Locale.US);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (sc.hasNext()){
            int id  = sc.nextInt();
            int owner_id  = sc.nextInt();
            String type = sc.next();
            double balance = sc.nextDouble();
            String sd = sc.next();
            String ed = sc.next();
            String card_number = sc.next();
            boolean available = sc.nextBoolean();
            int cvv = sc.nextInt();
            Card card = new Card(id, clients.get(owner_id), type, balance, LocalDate.parse(sd), card_number, cvv, available);
            cards.put(id, card);
        }


        System.out.println("Card are loaded");
        sc.close();
    }

    private void load_deposit() {
        File directory = new File("./src/main/resources/data/deposits.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(directory).useLocale(Locale.US);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (sc.hasNext()){
            int id  = sc.nextInt();
            int owner_id  = sc.nextInt();
            String type = sc.next();
            double balance = sc.nextDouble();
            String sd = sc.next();
            String ed = sc.next();
            String deposit_number = sc.next();
            String currency = sc.next();
            Deposit deposit = new Deposit(id, clients.get(owner_id), type, balance, LocalDate.parse(sd), deposit_number, currency);
            deposits.put(id, deposit);
        }

        System.out.println("Deposits are loaded");
        sc.close();
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public HashMap<Integer, Client> getClients() {
        return clients;
    }

    public HashMap<Integer, Company> getCompanies() {
        return companies;
    }

    public HashMap<Integer, Account<Company>> getAccounts() {
        return accounts;
    }

    public HashMap<Integer, Card> getCards() {
        return cards;
    }

    public HashMap<Integer, Deposit> getDeposits() {
        return deposits;
    }

    public HashSet<Transaction> getTransactions() {
        return transactions;
    }

    public ArrayList<History> getHistories() {
        return histories;
    }
}
