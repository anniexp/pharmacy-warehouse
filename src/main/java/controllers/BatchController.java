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
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class BatchController {

    @FXML
    private TextField batchId;
    @FXML
    private TextField shelf_life;
    @FXML
    private TextField priceByBatch;

    public void getAllBatches(ActionEvent event) throws IOException {
        try {
            ResultSet studForCourse = DBUtil.getInstance().getAllBatches();
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
            stage.setScene(new Scene(tableParent));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createBatch(ActionEvent actionEvent) throws IOException {
        try {
            int inputNum = Integer.parseInt(batchId.getText());
            String pattern = "dd/MM/yyyy";
            String timestampAsString = shelf_life.getText();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            LocalDate localDate = LocalDate.from(formatter.parse(timestampAsString));
            Timestamp timestamp = Timestamp.valueOf(localDate.atTime(LocalTime.MIDNIGHT));

            DBUtil.getInstance().createBatch(inputNum, Double.parseDouble(priceByBatch.getText()), timestamp);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/InfoDialog.fxml"));
            Parent infoParent = fxmlLoader.load();

            InfoDialogController infoController = fxmlLoader.getController();
            System.out.println(infoController);
            infoController.setInfoLabel("Batch was created successfully!");
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
            String message = batchId.getText();
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

    public void deleteBatch(ActionEvent actionEvent) throws IOException {
        try {
            int inputNum = Integer.parseInt(batchId.getText());
            System.out.println(inputNum);
            DBUtil.getInstance().deleteBatch(inputNum);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/InfoDialog.fxml"));
            Parent infoParent = fxmlLoader.load();

            InfoDialogController infoController = fxmlLoader.getController();
            System.out.println(infoController);
            infoController.setInfoLabel("Batch " + inputNum +  " was deleted successfully!");
            System.out.println(infoController);

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Batch deleted!");
            stage.setScene(new Scene(infoParent));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (NumberFormatException ex) {
            String message = batchId.getText();
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
        alert.setContentText("Text is: " + batchId.getText());
        alert.showAndWait();
    }

    public void getBatchById(ActionEvent actionEvent) throws IOException {
        try {
            int inputNum = Integer.parseInt(batchId.getText());
            ResultSet studForCourse = DBUtil.getInstance().getBatchById(inputNum);
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
            stage.setTitle("Order by id");
            stage.setScene(new Scene(tableParent));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException ex) {
            String message = batchId.getText();
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
