package main.java.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import main.java.Observer;
import main.java.models.Bank;

public class MainView implements Observer {
    @FXML public AnchorPane content_pane;

    public Bank bank = new Bank();

    public MainView() {
        bank.registerObserver(this);
    }

    @Override
    public void notification(int code, String message) {

    }

}
