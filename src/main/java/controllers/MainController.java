package main.java.controllers;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.java.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController extends MainView implements Initializable {

    @FXML private JFXButton btn1, btn2, btn3, btn4;
    @FXML private JFXButton hide_btn, close_btn;
    @FXML private AnchorPane header_pane;

    private AnchorPane p1, p2, p3, p4;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Controller.addDraggableNode(header_pane);
        try {
            p1 = get_content("mybank.fxml");
            p2 = get_content("payments.fxml");
            p3 = get_content("transfer.fxml");
            p4 = get_content("message.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        bank.load();
        bank.notifyObservers(201, "Loaded");
        content_pane.getChildren().addAll(p1);
    }

    @FXML public void close(ActionEvent event) {
        Stage stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML public void hide(ActionEvent event) {
        Stage stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        stage.hide();
    }

    public AnchorPane get_content(String file) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/resources/fxml/" + file));
        AnchorPane pane = loader.load();
        ContentController controller = loader.getController();
        controller.setBank(bank);
        return pane;
    }

    @FXML public void change_content(ActionEvent event) throws IOException {
        content_pane.getChildren().clear();
        if (event.getSource() == btn1) content_pane.getChildren().addAll(p1);
        else if (event.getSource() == btn2) content_pane.getChildren().addAll(p2);
        else if (event.getSource() == btn3) content_pane.getChildren().addAll(p3);
        else if (event.getSource() == btn4) content_pane.getChildren().addAll(p4);
    }


}
