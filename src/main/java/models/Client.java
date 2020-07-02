package main.java.models;

public class Client implements Customer{
    private int client_id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private boolean has_card;

    public Client(int client_id, String name, String surname, String email, String phone) {
        this.client_id = client_id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
    }

    public Client(int client_id, String name, String surname, String email, String phone, boolean has_card) {
        this.client_id = client_id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.has_card = has_card;
    }

    public int getId() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isHas_card() {
        return has_card;
    }

    public void setHas_card(boolean has_card) {
        this.has_card = has_card;
    }

    @Override
    public String toString() {
        return client_id + "\n" +
                name + "\n" +
                surname + "\n" +
                email + "\n" +
                phone + "\n" +
                has_card + "\n" +
                "" ;
    }

    public static void main(String[] args) {
        Client client = new Client(1421, "Baltabay", "Beisen", "gmail.com", "87087499116");
        System.out.println(client);
    }
}
