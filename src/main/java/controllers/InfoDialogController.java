package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class InfoDialogController {
    @FXML
    Label infoLabel;

    public void setInfoLabel(String info) {
        infoLabel.setText(info);
    }

    @Override
    public String toString() {
        return "InfoDialogController{" +
                "infoLabel=" + infoLabel +
                '}';
    }
}
