package main.java.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import main.java.Observer;
import main.java.models.Bank;

public class ContentController implements Observer {

    protected Bank bank;
    public boolean signin;

    @FXML private AnchorPane p1_2;
    @FXML private Label l1_2;
    @FXML private AnchorPane p2_2;

    public void setBank(Bank bank) {
        bank.registerObserver(this);
        this.bank = bank;
    }

    public Bank getBank() {
        return bank;
    }

    @Override
    public void notification(int code, String message) {
        if (code == 100) {
            l1_2.setText(bank.getCurrent_client().getName());
            p1_2.toFront();
            this.signin = true;
        }
        if (code == 101) {
            p2_2.toFront();
            this.signin = false;
        }
    }

    public void sign_in(ActionEvent event){
        bank.sign_in();
        bank.notifyObservers(100, "sign in");
    }

    public void sign_out(ActionEvent event){
        bank.sign_out();
        bank.notifyObservers(101, "sign out");
    }
}
