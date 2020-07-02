package main.java.controllers;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;

public class PaymentCardController {

    private PaymentsController paymentsController;
    @FXML private JFXButton btn;

    public void set_name(String text, PaymentsController paymentsController) {
        btn.setText(text);
        this.paymentsController = paymentsController;
    }

    public void click(){
        paymentsController.open_payment(btn.getText());
    }
}
