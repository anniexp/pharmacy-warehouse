package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import util.DBUtil;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PharmacyController {
    @FXML
    private TextField pharmacyId;
    @FXML
    private TextField address;

    public void getAllPharmacies(ActionEvent event) throws IOException {
        try {
            ResultSet studForCourse = DBUtil.getInstance().getAllPharmacies();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/TableDialog.fxml"));
            Parent tableParent = fxmlLoader.load();

            //get controller and transfer data!
            TableController tblcontroller = fxmlLoader.getController();
            try {
                tblcontroller.setTableResultset(studForCourse);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Students list");
            stage.setScene(new Scene(tableParent));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createPharmacy(ActionEvent actionEvent) throws IOException {
        try {
            int inputNum = Integer.parseInt(pharmacyId.getText());
            DBUtil.getInstance().createPharmacy(inputNum, address.getText());
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/InfoDialog.fxml"));
            Parent infoParent = fxmlLoader.load();

            InfoDialogController infoController = fxmlLoader.getController();
            System.out.println(infoController);
            infoController.setInfoLabel("Pharmacy was created successfully!");
            System.out.println(infoController);

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Pharmacy was created successfully!");
            stage.setScene(new Scene(infoParent));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (NumberFormatException ex) {
            String message = pharmacyId.getText();
            System.out.println("Input is not valid! " + message);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/InfoDialog.fxml"));
            Parent infoParent = fxmlLoader.load();

            //get controller and transfer data!
            InfoDialogController infoController = fxmlLoader.getController();
            System.out.println(infoController);
            infoController.setInfoLabel("Invalid input " + message);
            System.out.println(infoController);

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Error page");
            stage.setScene(new Scene(infoParent));
            stage.show();
        }
    }

    public void deletePharmacy(ActionEvent actionEvent) throws IOException {
        try {
            int inputNum = Integer.parseInt(pharmacyId.getText());
            System.out.println(inputNum);
            DBUtil.getInstance().deletePharmacy(inputNum);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/InfoDialog.fxml"));
            Parent infoParent = fxmlLoader.load();

            InfoDialogController infoController = fxmlLoader.getController();
            System.out.println(infoController);
            infoController.setInfoLabel("Pharmacy " + inputNum +  " was deleted successfully!");
            System.out.println(infoController);

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Pharmacy deleted!");
            stage.setScene(new Scene(infoParent));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (NumberFormatException ex) {
            String message = pharmacyId.getText();
            System.out.println("Input is not valid! " + message);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/InfoDialog.fxml"));
            Parent infoParent = fxmlLoader.load();

            //get controller and transfer data!
            InfoDialogController infoController = fxmlLoader.getController();
            System.out.println(infoController);
            infoController.setInfoLabel("Invalid input " + message);
            System.out.println(infoController);

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Error page");
            stage.setScene(new Scene(infoParent));
            stage.show();
        }
    }

    private void showError(String message){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Text is: " + pharmacyId.getText());
        alert.showAndWait();
    }

    public void getPharmacyById(ActionEvent actionEvent) throws IOException {
        try {
            int inputNum = Integer.parseInt(pharmacyId.getText());
            ResultSet studForCourse = DBUtil.getInstance().getPharmacyById(inputNum);
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
            stage.setTitle("Product by id");
            stage.setScene(new Scene(tableParent));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (NumberFormatException ex) {
            String message = pharmacyId.getText();
            System.out.println("Input is not valid! " + message);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/InfoDialog.fxml"));
            Parent infoParent = fxmlLoader.load();
            InfoDialogController infoController = fxmlLoader.getController();
            System.out.println(infoController);
            infoController.setInfoLabel("Invalid input " + message);
            System.out.println(infoController);

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Error page");
            stage.setScene(new Scene(infoParent));
            stage.show();
        }
    }
}
