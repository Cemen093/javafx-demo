package org.itstep;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AppController {
    @FXML
    private Label label;

    @FXML
    public void buttonClicked(ActionEvent actionEvent){
        label.setText("Pushed");
    }
}
