package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import util.DBUtil;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DistributorController {

    @FXML
    private TextField distributorId;
//DONT KNOW HOW TO SHOW THE XML DATA
    public void getAllDistributors(ActionEvent event) throws IOException {
        try {
            ResultSet studForCourse = DBUtil.getInstance().getAllDistributors();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/TableDialog.fxml"));
            Parent tableParent = fxmlLoader.load();
            TableController tblcontroller = fxmlLoader.getController();
            try {
                tblcontroller.setTableResultset(studForCourse);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Distributor list");
            stage.setScene(new Scene(tableParent));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
