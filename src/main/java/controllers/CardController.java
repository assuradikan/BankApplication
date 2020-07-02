package main.java.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class CardController implements Initializable {

    @FXML private Label l1, l2, l3;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void set_labels(String s1, String s2, String s3){
        l1.setText(s1);
        l2.setText(s2);
        l3.setText(s3);
    }
}
