package main.java.models;

public class Company implements Customer{
    private int company_id;
    private String name;
    private String BIN;
    private String description;

    public Company(int company_id, String name, String BIN, String description) {
        this.company_id = company_id;
        this.name = name;
        this.BIN = BIN;
        this.description = description;
    }

    public int getId() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBIN() {
        return BIN;
    }

    public void setBIN(String BIN) {
        this.BIN = BIN;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return company_id + "\n" +
                name + "\n" +
                BIN + "\n" +
                description + "\n";
    }
}
