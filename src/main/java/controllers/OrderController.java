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

public class OrderController {
    @FXML
    private TextField orderId;
    @FXML
    private TextField distributor;
    @FXML
    private TextField pharmacy;

    private void showError(String message){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Text is: " + orderId.getText());
        alert.showAndWait();
    }

    /**
     * Shows information about products in order - uses left joins with tables with products and active ingredients
     * @param actionEvent - button click
     * @throws IOException
     */
    public void showProductsByOrder(ActionEvent actionEvent) throws IOException {
        try {
            //showError("ERROR!"); //TODO: Check for the input and show error!
            //TODO: Show the same error in a self-built dialog!
            int inputNum = Integer.parseInt(orderId.getText());
            System.out.println(inputNum);
            ResultSet studForCourse = DBUtil.getInstance().getOrderProductInfo(inputNum);
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
            stage.setTitle("Order Products list");
            stage.setScene(new Scene(tableParent));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (NumberFormatException ex) {
            String message = orderId.getText();
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

    /**
     * Create order from distributor for pharmacy warehouse
     * @param actionEvent - click of button
     */
    public void createOrderIn(ActionEvent actionEvent) throws IOException {
        try {
            int order = Integer.parseInt(orderId.getText());
            int distr = Integer.parseInt(distributor.getText());

            DBUtil.getInstance().createOrderInStart(order, distr);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/InfoDialog.fxml"));
            Parent infoParent = fxmlLoader.load();

            InfoDialogController infoController = fxmlLoader.getController();
            infoController.setInfoLabel("Order for pharmacy warehouse was created successfully!");

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Create order");
            stage.setScene(new Scene(infoParent));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (NumberFormatException ex) {
            String message = orderId.getText();
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
    /**
     * Create order from pharmacy warehouse for pharmacy
     * @param actionEvent - click of button
     */
    public void createOrderOut(ActionEvent actionEvent) throws IOException {
        try {
            int order = Integer.parseInt(orderId.getText());
            int pharm = Integer.parseInt(pharmacy.getText());

            DBUtil.getInstance().createOrderOutsStart(order, pharm);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/InfoDialog.fxml"));
            Parent infoParent = fxmlLoader.load();

            InfoDialogController infoController = fxmlLoader.getController();
            infoController.setInfoLabel("Order from pharmacy warehouse for pharmacy was created successfully!");

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Create order");
            stage.setScene(new Scene(infoParent));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (NumberFormatException ex) {
            String message = orderId.getText();
            System.out.println("Input is not valid! " + message);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/InfoDialog.fxml"));
            Parent infoParent = fxmlLoader.load();
            InfoDialogController infoController = fxmlLoader.getController();
            infoController.setInfoLabel("Invalid input " + message);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Error page");
            stage.setScene(new Scene(infoParent));
            stage.show();
        }
    }

    public void getAllOrders(ActionEvent event) throws IOException {
        try {
            ResultSet studForCourse = DBUtil.getInstance().getAllOrders();
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

    public void showOrderById(ActionEvent actionEvent) throws IOException {
        try {
            int inputNum = Integer.parseInt(orderId.getText());
            ResultSet studForCourse = DBUtil.getInstance().getOrderById(inputNum);
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
            String message = orderId.getText();
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

    public void getAllOrdersIn(ActionEvent event) throws IOException {
        try {
            ResultSet studForCourse = DBUtil.getInstance().getAllOrdersIn();
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
            stage.setTitle("Orders In list");
            stage.setScene(new Scene(tableParent));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getAllOrdersOut(ActionEvent event) throws IOException {
        try {
            ResultSet studForCourse = DBUtil.getInstance().getAllOrdersOut();
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
            stage.setTitle("Orders Out list");
            stage.setScene(new Scene(tableParent));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
