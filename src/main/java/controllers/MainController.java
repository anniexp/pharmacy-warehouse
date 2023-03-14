package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import util.DBUtil;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainController {
    public void navigateToCreateRoom(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = null;
            Parent tableParent = null;
            fxmlLoader = new FXMLLoader(getClass().getResource("/views/createRoom.fxml"));
            tableParent = fxmlLoader.load();

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Create Room");
            stage.setScene(new Scene(tableParent));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void navigateToDeleteRoom(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = null;
            Parent tableParent = null;
            fxmlLoader = new FXMLLoader(getClass().getResource("/views/deleteRoom.fxml"));
            tableParent = fxmlLoader.load();

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Delete Room By Id");
            stage.setScene(new Scene(tableParent));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void navigateToGetAllRooms(ActionEvent event) {
        try {
            ResultSet studForCourse = DBUtil.getInstance().getAllRooms();
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
            stage.setTitle("All Rooms");
            stage.setScene(new Scene(tableParent));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void navigateToGetAllProductsByOrder(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = null;
            Parent tableParent = null;
            fxmlLoader = new FXMLLoader(getClass().getResource("/views/showProductsInOrder.fxml"));
            tableParent = fxmlLoader.load();

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Get Product Info for order");
            stage.setScene(new Scene(tableParent));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void navigateToGetRoomById(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = null;
            Parent tableParent = null;
            fxmlLoader = new FXMLLoader(getClass().getResource("/views/getRoomById.fxml"));
            tableParent = fxmlLoader.load();

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Get Room by Id");
            stage.setScene(new Scene(tableParent));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void navigateToGetOrderById(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = null;
            Parent tableParent = null;
            fxmlLoader = new FXMLLoader(getClass().getResource("/views/getOrderById.fxml"));
            tableParent = fxmlLoader.load();

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Get order");
            stage.setScene(new Scene(tableParent));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void navigateToGetAllOrders(ActionEvent actionEvent) throws IOException {
            ResultSet studForCourse = DBUtil.getInstance().getAllOrders();
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
            stage.setTitle("All Rooms");
            stage.setScene(new Scene(tableParent));
            stage.show();
    }

    public void navigateToCreateSupplement(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = null;
            Parent tableParent = null;
            fxmlLoader = new FXMLLoader(getClass().getResource("/views/createSupplement.fxml"));
            tableParent = fxmlLoader.load();

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Create Supplement");
            stage.setScene(new Scene(tableParent));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void navigateToCreateMedication(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader;
            Parent tableParent;
            fxmlLoader = new FXMLLoader(getClass().getResource("/views/createMedication.fxml"));
            tableParent = fxmlLoader.load();

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Create Medication");
            stage.setScene(new Scene(tableParent));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void navigateToCreateOrderIn(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = null;
            Parent tableParent = null;
            fxmlLoader = new FXMLLoader(getClass().getResource("/views/createOrderIn.fxml"));
            tableParent = fxmlLoader.load();

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Create Order from distributor to pharmacy warehouse");
            stage.setScene(new Scene(tableParent));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void navigateToCreateOrderOut(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = null;
            Parent tableParent = null;
            fxmlLoader = new FXMLLoader(getClass().getResource("/views/createOrderOut.fxml"));
            tableParent = fxmlLoader.load();

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Create Order from warehouse to pharmacy");
            stage.setScene(new Scene(tableParent));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void navigateToGetProductById(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = null;
            Parent tableParent = null;
            fxmlLoader = new FXMLLoader(getClass().getResource("/views/getProductById.fxml"));
            tableParent = fxmlLoader.load();

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Get Product By Id");
            stage.setScene(new Scene(tableParent));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void navigateToGetAllProducts(ActionEvent actionEvent) throws IOException {
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
        stage.setTitle("All Products");
        stage.setScene(new Scene(tableParent));
        stage.show();
    }

    public void navigateToGetAllPharmacies(ActionEvent actionEvent) throws IOException {
        ResultSet studForCourse = DBUtil.getInstance().getAllPharmacies();
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
        stage.setTitle("All Pharmacies");
        stage.setScene(new Scene(tableParent));
        stage.show();
    }

    public void navigateToGetAllDistributors(ActionEvent actionEvent) throws IOException {
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
        stage.setTitle("All Distributors");
        stage.setScene(new Scene(tableParent));
        stage.show();
    }

    public void navigateToGetAllActiveIngredients(ActionEvent actionEvent) throws IOException {
        ResultSet studForCourse = DBUtil.getInstance().getAllActiveIngredients();
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
        stage.setTitle("All Pharmacies");
        stage.setScene(new Scene(tableParent));
        stage.show();
    }

    public void navigateToGetAllENums(ActionEvent actionEvent) throws IOException {
        ResultSet studForCourse = DBUtil.getInstance().getAllENums();
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
        stage.setTitle("All Pharmacies");
        stage.setScene(new Scene(tableParent));
        stage.show();
    }

    public void navigateToDeletePharmacy(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = null;
            Parent tableParent = null;
            fxmlLoader = new FXMLLoader(getClass().getResource("/views/deletePharmacy.fxml"));
            tableParent = fxmlLoader.load();

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Delete pharmacy");
            stage.setScene(new Scene(tableParent));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void navigateToAddPharmacy(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = null;
            Parent tableParent = null;
            fxmlLoader = new FXMLLoader(getClass().getResource("/views/createPharmacy.fxml"));
            tableParent = fxmlLoader.load();

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Create Pharmacy");
            stage.setScene(new Scene(tableParent));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void navigateToGetPharmacyById(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = null;
            Parent tableParent = null;
            fxmlLoader = new FXMLLoader(getClass().getResource("/views/getPharmacyById.fxml"));
            tableParent = fxmlLoader.load();

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Get pharmacy");
            stage.setScene(new Scene(tableParent));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void navigateToGetAllBatches(ActionEvent actionEvent) throws IOException {
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
        stage.setTitle("All Batches");
        stage.setScene(new Scene(tableParent));
        stage.show();
    }

    public void navigateToGetBatchById(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = null;
            Parent tableParent = null;
            fxmlLoader = new FXMLLoader(getClass().getResource("/views/getBatchById.fxml"));
            tableParent = fxmlLoader.load();

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Get pharmacy");
            stage.setScene(new Scene(tableParent));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void navigateToCreateBatch(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = null;
            Parent tableParent = null;
            fxmlLoader = new FXMLLoader(getClass().getResource("/views/createBatch.fxml"));
            tableParent = fxmlLoader.load();

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Create Batch");
            stage.setScene(new Scene(tableParent));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void navigateToGetDeleteBatch(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = null;
            Parent tableParent = null;
            fxmlLoader = new FXMLLoader(getClass().getResource("/views/deleteBatch.fxml"));
            tableParent = fxmlLoader.load();

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Create Pharmacy");
            stage.setScene(new Scene(tableParent));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void navigateToGetAllOrdersIn(ActionEvent actionEvent) throws IOException {
        ResultSet studForCourse = DBUtil.getInstance().getAllOrdersIn();
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
        stage.setTitle("All Orders from distributor for warehouse");
        stage.setScene(new Scene(tableParent));
        stage.show();
    }

    public void navigateToGetAllOrdersOut(ActionEvent actionEvent) throws IOException {
        ResultSet studForCourse = DBUtil.getInstance().getAllOrdersOut();
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
        stage.setTitle("All Orders from warehouse for pharmacy");
        stage.setScene(new Scene(tableParent));
        stage.show();
    }
}
