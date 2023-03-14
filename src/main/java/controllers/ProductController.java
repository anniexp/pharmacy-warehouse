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

public class ProductController {
    @FXML
    public TextField nameBg;
    @FXML
    public TextField nameEng;
    @FXML
    public TextField quantity;
    @FXML
    public TextField room;
    @FXML
    public TextField batch;
    @FXML
    public TextField act_ingr;
    @FXML
    public TextField eNum;
    @FXML
    public TextField has_prescription;
    @FXML
    public TextField group;
    @FXML
    private TextField productId;

    public void showProductsById(ActionEvent actionEvent) throws IOException {
        try {
            int inputNum = Integer.parseInt(productId.getText());
            ResultSet studForCourse = DBUtil.getInstance().getProductById(inputNum);
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
        } catch (NumberFormatException ex) {
            String message = productId.getText();
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

    public void getAllProducts(ActionEvent event) throws IOException {
        ResultSet studForCourse = DBUtil.getInstance().getAllProducts();
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
        stage.setTitle("Students list");
        stage.setScene(new Scene(tableParent));
        stage.show();
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Text is: " + productId.getText());
        alert.showAndWait();
    }

    public void createMedication(ActionEvent actionEvent) throws IOException {
        try {
            int inputId = Integer.parseInt(productId.getText());
            int quant = Integer.parseInt(quantity.getText());
            String name1 = nameBg.getText();
            String name2 = nameEng.getText();
            int r = Integer.parseInt(room.getText());
            int b = Integer.parseInt(batch.getText());
            int actIng = Integer.parseInt(act_ingr.getText());
            int hasPr = Integer.parseInt(has_prescription.getText());
            int gr = Integer.parseInt(group.getText());

            if (hasPr != 0 && hasPr != 1) {
                throw new NumberFormatException();
            }

            DBUtil.getInstance().createMedicineStart(inputId, quant, name1, name2, r, b, actIng, hasPr, gr);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/InfoDialog.fxml"));
            Parent infoParent = fxmlLoader.load();

            InfoDialogController infoController = fxmlLoader.getController();
            System.out.println(infoController);
            infoController.setInfoLabel("Medication created successfully!");
            System.out.println(infoController);

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Medication was created successfully!");
            stage.setScene(new Scene(infoParent));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException ex) {
            String message = productId.getText();
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

    public void createSupplement(ActionEvent actionEvent) throws IOException {
        try {
            int inputId = Integer.parseInt(productId.getText());
            int quant = Integer.parseInt(quantity.getText());
            String name1 = nameBg.getText();
            String name2 = nameEng.getText();
            int r = Integer.parseInt(room.getText());
            int b = Integer.parseInt(batch.getText());
            int actIng = Integer.parseInt(act_ingr.getText());
            int eN = Integer.parseInt(eNum.getText());

            DBUtil.getInstance().createSupplementStart(inputId, quant, name1, name2, r, b, actIng, eN);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/InfoDialog.fxml"));
            Parent infoParent = fxmlLoader.load();

            InfoDialogController infoController = fxmlLoader.getController();
            System.out.println(infoController);
            infoController.setInfoLabel("Supplement was created successfully!");
            System.out.println(infoController);

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Supplement was created successfully!");
            stage.setScene(new Scene(infoParent));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException ex) {
            String message = productId.getText();
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
}
