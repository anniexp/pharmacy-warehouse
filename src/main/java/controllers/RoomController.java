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

public class RoomController {
    @FXML
    private TextField roomId;

    public void getAllRooms(ActionEvent event) throws IOException {
        try {
            int inputNum = Integer.parseInt(roomId.getText());
            System.out.println(inputNum);
            ResultSet studForCourse = DBUtil.getInstance().getAllRooms();
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
        catch (NumberFormatException ex) {
            String message = roomId.getText();
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

    public void createRoom(ActionEvent actionEvent) throws IOException {
        try {
            int inputNum = Integer.parseInt(roomId.getText());
            System.out.println(inputNum);
            DBUtil.getInstance().createRoom(inputNum);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/InfoDialog.fxml"));
            Parent infoParent = fxmlLoader.load();

            InfoDialogController infoController = fxmlLoader.getController();
            System.out.println(infoController);
            infoController.setInfoLabel("Room was created successfully!");
            System.out.println(infoController);

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Room was created successfully!");
            stage.setScene(new Scene(infoParent));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (NumberFormatException ex) {
            String message = roomId.getText();
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

    public void deleteRoom(ActionEvent actionEvent) throws IOException {
        try {
            int inputNum = Integer.parseInt(roomId.getText());
            System.out.println(inputNum);
            DBUtil.getInstance().deleteRoom(inputNum);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/InfoDialog.fxml"));
            Parent infoParent = fxmlLoader.load();

            InfoDialogController infoController = fxmlLoader.getController();
            System.out.println(infoController);
            infoController.setInfoLabel("Room " + inputNum +  " was deleted successfully!");
            System.out.println(infoController);

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Room deleted!");
            stage.setScene(new Scene(infoParent));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (NumberFormatException ex) {
            String message = roomId.getText();
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
        alert.setContentText("Text is: " + roomId.getText());
        alert.showAndWait();
    }

    public void getRoomById(ActionEvent actionEvent) throws IOException {
        try {
            int inputNum = Integer.parseInt(roomId.getText());
            ResultSet studForCourse = DBUtil.getInstance().getRoomById(inputNum);
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
            String message = roomId.getText();
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

