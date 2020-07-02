package main.java.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MybankController extends ContentController implements Initializable {

    @FXML private HBox hbox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FXMLLoader loader1 = new FXMLLoader(getClass().getResource("/main/resources/fxml/card.fxml"));
        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/main/resources/fxml/card.fxml"));
        FXMLLoader loader3 = new FXMLLoader(getClass().getResource("/main/resources/fxml/card.fxml"));
        try {
            AnchorPane pane1 = loader1.load();
            ((CardController)loader1.getController()).set_labels("Card", "145784554", "5000");
            AnchorPane pane2 = loader2.load();
            ((CardController)loader2.getController()).set_labels("Card", "145784554", "5000");
            AnchorPane pane3 = loader3.load();
            ((CardController)loader3.getController()).set_labels("Card", "145784554", "5000");

            hbox.getChildren().add(pane1);
            hbox.getChildren().add(pane2);
            hbox.getChildren().add(pane3);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
