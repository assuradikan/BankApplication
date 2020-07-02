package main.java.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import main.java.models.Company;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class PaymentsController extends ContentController implements Initializable {
    @FXML private GridPane gridpane;
    @FXML private Label l1;

    @FXML private Pane p1, p2;
    @FXML private JFXButton back_btn;
    @FXML private JFXTextField f1;
    @FXML private JFXTextField f2;
    @FXML private JFXComboBox<?> f3;
    @FXML private JFXToggleButton tbtn;
    @FXML private Label l2;
    @FXML private Label l3;



    @Override
    public void initialize(URL location, ResourceBundle resources) {


        /*int i = 0;
        for (int row = 0; row < 10; row++){
            for (int column = 0; column < 3; column++){
                gridpane.add(get_element(), column, row);
            }
        }*/
    }

    private AnchorPane get_element(String i){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/resources/fxml/paymentcard.fxml"));
        AnchorPane pane;
        try {
            pane = loader.load();
            ((PaymentCardController)loader.getController()).set_name(i, this);
            return pane;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new AnchorPane();
    }

    public void back(){
        p1.toFront();
    }

    public void open_payment(String s){
        p2.toFront();
        l1.setText(s);
    }

    public void test1() {
        System.out.println("Hello");
    }

    public void test2() {
        System.out.println("Bye");
    }

    @FXML
    public void pay(ActionEvent event) {

    }

    @Override
    public void notification(int code, String message) {
        super.notification(code, message);
        if (code == 201) {
            int col = 0;
            int row = 0;
            for (Map.Entry<Integer, Company> entry: bank.getCompanies().entrySet()) {
                if (col < 3) gridpane.add(get_element(entry.getValue().getName()), col++, row);
                else {
                    col = 0;
                    row++;
                }
            }
        }
    }
}
