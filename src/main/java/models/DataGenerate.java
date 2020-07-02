package main.java.models;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class DataGenerate {
    public static void main(String[] args) throws IOException {
        /*File directory0 = new File("./src/main/resources/data/company.txt");
        Scanner sc0 = new Scanner(directory0);
        ArrayList<Company> companies = new ArrayList<>();

        while (sc0.hasNext()){
            int id  = sc0.nextInt();
            String name = sc0.next();
            String bin = sc0.next();
            sc0.nextLine();
            String des = sc0.nextLine();
            Company company = new Company(id, name, bin, des);
            companies.add(company);
        }

        sc0.close();
        File directory1 = new File("./src/main/resources/data/accounts.txt");
        PrintWriter pw1 = new PrintWriter(new FileWriter(directory1, false));

        for (Company c: companies) {
            Account<Company> account = new Account<Company>(get_id(), c, "Business", 0, LocalDate.now(), LocalDate.now().plusMonths(24));
            pw1.print(account);
            pw1.println();
        }

        pw1.close();*/


        /*File directory0 = new File("./src/main/resources/data/clients.txt");
        Scanner sc0 = new Scanner(directory0);
        ArrayList<Client> clients = new ArrayList<>();

        while (sc0.hasNext()){
            int id  = sc0.nextInt();
            String name = sc0.next();
            String surname = sc0.next();
            String email = sc0.next();
            String phone = sc0.next();
            boolean has_card = sc0.nextBoolean();
            Client client = new Client(id, name, surname, email, phone, has_card);
            clients.add(client);
        }

        sc0.close();
        File directory1 = new File("./src/main/resources/data/deposits.txt");
        PrintWriter pw1 = new PrintWriter(new FileWriter(directory1, false));

        for (Client client: clients) {
            String card_number = get_id() + "" + get_id() + "" + get_id() + "" + get_id();
//            Card card = new Card(get_id(), client, "Personal", 0, LocalDate.now(), card_number, get_cvv(), true);
            Deposit deposit = new Deposit(get_id(), client, "Personal", 0, LocalDate.now(), get_id()+""+get_id(), "kzt");
            pw1.print(deposit);
            pw1.println();
        }

        pw1.close();*/

        File directory0 = new File("./src/main/resources/data/accounts.txt");
        Scanner sc0 = new Scanner(directory0);
        while (sc0.hasNext()){
            int id  = sc0.nextInt();
            int owner_id  = sc0.nextInt();
            String type = sc0.next();
            double balance = sc0.nextDouble();
            String sd = sc0.next();
            String ed = sc0.next();
        }


    }

    public static int get_id(){
        Random rn = new Random();
        return rn.nextInt(10) + rn.nextInt(10)*10 + rn.nextInt(10)*100 + rn.nextInt(10)*1000;
    }

    public static int get_cvv(){
        Random rn = new Random();
        return rn.nextInt(10) + rn.nextInt(10)*10 + rn.nextInt(10)*100;
    }
}
