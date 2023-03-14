package util;

import java.sql.*;
import java.time.Instant;

public class DBUtil {
    //region Select Statements
    private static final String GET_ALL_PHARMACIES = "SELECT * FROM PHARMACY";
    private static final String GET_ROOM_QUERY = "SELECT * FROM ROOM WHERE \"room_id\"= ?";
    private static final String GET_PRODUCT_QUERY = "SELECT * FROM PRODUCT WHERE product_id= ?";
    private static final String GET_PRODUCT_WITH_SPECIALIZATION_ATTRIBUTES_QUERY = "SELECT p.product_id, p.quantity, p.name_bg, p.name_eng, p.room, p.\"batch\", p.act_ingr, m.\"has_prescription\", m.\"group\", s.\"quantity\", s.\"num\"\n" +
            "  FROM PRODUCT p\n" +
            "  FULL OUTER JOIN MEDIC m\n" +
            "  ON p.product_id = m.\"product\"\n" +
            "  FULL OUTER JOIN SUPPLEMENT s\n" +
            "  ON p.product_id = s.\"product\"";
    private static final String GET_PHARMACY_QUERY = "SELECT * FROM PHARMACY WHERE \"ph_id\"= ?";
    private static final String GET_ALL_ROOMS = "SELECT * FROM ROOM";
    private static final String SELECT_ORDER_PRODUCT_INFO_2 = "SELECT op.\"order\", op.\"product\", op.\"quantity\", op.\"price_piece\", p.NAME_BG, p.NAME_ENG, p.\"batch\", p.ACT_INGR, ai.\"name_eng\", ai.\"name_bg\" FROM ORDER_PRODUCT op LEFT JOIN PRODUCT p ON  op.\"product\" =  p.product_id LEFT JOIN ACTIVE_INGR ai  ON ai.\"ingr_id\" = p.ACT_INGR WHERE op.\"order\" = ?";
    private static final String GET_ALL_PRODUCTS = "SELECT * FROM PRODUCT";
    private static final String GET_ALL_ORDERS = "SELECT * FROM ORDERS";
    private static final String GET_ALL_DISTRIBUTORS = "SELECT * FROM DISTRIBUTOR";
    private static final String GET_ALL_ACTIVE_INGR = "SELECT * FROM ACTIVE_INGR";
    private static final String GET_ALL_E_NUMS = "SELECT * FROM E_NUM";
    private static final String GET_ALL_BATCHES = "SELECT * FROM BATCHES";
    private static final String GET_BATCH_QUERY = "SELECT * FROM BATCHES WHERE \"batch_id\"= ?";
    private static final String GET_ORDER_QUERY = "SELECT * FROM ORDERS WHERE \"order_id\"= ?";
    private static final String GET_ORDERS_IN = "SELECT * FROM ORDER_IN";
    private static final String GET_ORDERS_OUT = "SELECT * FROM ORDER_OUT";
    //endregion

    //region Insert Statements
    private static final String CREATE_PRODUCT = "INSERT INTO PRODUCT VALUES(?,?,?,?,?,?,?)";
    private static final String CREATE_MEDICINE = "INSERT INTO MEDIC VALUES(?,?,?)";
    private static final String CREATE_SUPPLEMENT = "INSERT INTO SUPPLEMENT VALUES(?,?,?)";

    private static final String CREATE_PHARMACY = "INSERT INTO PHARMACY VALUES(?,?)";
    private static final String CREATE_DISTRIBUTOR = "INSERT INTO DISTRIBUTOR VALUES(?,?,?)";
    private static final String CREATE_ROOM = "INSERT INTO ROOM VALUES(?)";

    private static final String CREATE_E_NUM = "INSERT INTO E_NUM VALUES(?,?,?,?)";
    private static final String CREATE_ACTIVE_INGR = "INSERT INTO ACTIVE_INGR VALUES(?,?,?)";
    private static final String CREATE_ACT_INGR_PRODUCT = "INSERT INTO ACT_INGR_PRODUCT VALUES(?)";

    private static final String CREATE_ORDER = "INSERT INTO ORDERS VALUES(?)";
    private static final String CREATE_ORDER_IN = "INSERT INTO ORDER_IN VALUES(?,?,?)";
    private static final String CREATE_ORDER_OUT = "INSERT INTO ORDER_OUT VALUES(?,?,?)";
    private static final String CREATE_ORDER_PRODUCT = "INSERT INTO ORDER_PRODUCT VALUES(?,?,?,?)";
    private static final String CREATE_BATCH = "INSERT INTO BATCHES VALUES(?,?,?)";
    //endregion

    //region Delete Statements
    private static final String DELETE_PRODUCT = "DELETE FROM PRODUCT WHERE \"product_id\" = ?";
    private static final String DELETE_MEDICINE = "DELETE FROM MEDIC WHERE \"product\" = ?";
    private static final String DELETE_SUPPLEMENT = "DELETE FROM SUPPLEMENT WHERE \"product\" = ?";

    private static final String DELETE_PHARMACY = "DELETE FROM PHARMACY WHERE \"ph_id\" = ?";
    private static final String DELETE_DISTRIBUTOR = "DELETE FROM DISTRIBUTOR WHERE \"dis_id\" = ?";
    private static final String DELETE_ROOM = "DELETE FROM ROOM WHERE \"room_id\" = ?";

    private static final String DELETE_E_NUM = "DELETE FROM E_NUM WHERE \"e_num_id\" = ?";
    private static final String DELETE_ACTIVE_INGR = "DELETE FROM ACTIVE_INGR WHERE \"ingr_id\" = ?";
    private static final String DELETE_ACT_INGR_PRODUCT = "DELETE FROM ACT_INGR_PRODUCT WHERE \"act_ingrs_ingr_id\" = ?";

    private static final String DELETE_ORDER = "DELETE FROM ORDERS WHERE \"order_id\" = ?";
    private static final String DELETE_ORDER_IN = "DELETE FROM ORDER_IN WHERE \"order\" = ?";
    private static final String DELETE_ORDER_OUT = "DELETE FROM ORDER_OUT WHERE \"order\" = ?";
    private static final String DELETE_ORDER_PRODUCT = "DELETE FROM ORDER_PRODUCT WHERE \"order\" = ?";
    private static final String DELETE_BATCH = "DELETE FROM BATCHES WHERE \"batch_id\" = ?";

    //endregion

    private Connection cachedConnection = null;
    private static final DBUtil instance = new DBUtil();

    //region PreparedStatements
    private final PreparedStatement preparedStatementGetAllPharmacies = null;
    private final PreparedStatement preparedStatementGetPharmacyById = null;
    private final PreparedStatement preparedStatementGetDeletePharmacyById = null;
    private final PreparedStatement preparedStatementAddPharmacy = null;
    private final PreparedStatement preparedStatementAddBatch = null;
    private final PreparedStatement prepareStatementGetOrderProductInfo = null;
    private final PreparedStatement prepareStatementGetAllOrdersOut = null;
    private final PreparedStatement prepareStatementGetAllRooms = null;
    private final PreparedStatement prepareStatementFetProductById = null;
    private final PreparedStatement prepareStatementAddRoom = null;
    private final PreparedStatement prepareStatementAddOrderIn = null;
    private final PreparedStatement prepareStatementAddOrder = null;
    private final PreparedStatement prepareStatementAddOrderOut = null;
    private final PreparedStatement prepareStatementDeleteRoom = null;
    private final PreparedStatement prepareStatementGetAllPharmacies = null;
    private final PreparedStatement prepareStatementGetAllPeoducts = null;
    private final PreparedStatement prepareStatementGetAllProductsWithSpecialisation = null;
    private final PreparedStatement prepareStatementGetAllOrders = null;
    private final PreparedStatement prepareStatementGetAllDistributors = null;
    private final PreparedStatement prepareStatementGetAllActIngr = null;
    private final PreparedStatement prepareStatementGetAllENums = null;
    private final PreparedStatement prepareStatementGetRoomById = null;
    private final PreparedStatement prepareStatementAddProduct = null;
    private final PreparedStatement prepareStatementAddMedicine = null;
    private final PreparedStatement prepareStatementAddSupplement = null;
    private final PreparedStatement prepareStatementDeleteBatch = null;
    private final PreparedStatement prepareStatementGetAllBatches = null;
    private final PreparedStatement prepareStatementGetBatchById = null;
    private final PreparedStatement prepareStatementGetOrderById = null;
    private final PreparedStatement prepareStatementGetAllOrdersIn = null;
    //endregion


    private DBUtil() {
    }

    public static DBUtil getInstance() {
        return instance;
    }

    private Connection getConnection() {
        try {
            if (cachedConnection == null ||
                    cachedConnection.isClosed() ||
                    !cachedConnection.isValid(10)) {
                System.out.println("Attempting to get a new connection to DB!");
                DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
                cachedConnection = DriverManager.getConnection(
                        "jdbc:oracle:thin:@172.16.251.135:1521:orcl", "c##ex2_ani", "123456");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.cachedConnection;
    }

    private PreparedStatement getStatement(String statement, PreparedStatement preparedStatement) {
        if (preparedStatement == null) {
            try {
                preparedStatement = getConnection().prepareStatement(statement);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return preparedStatement;
    }

    public ResultSet getProductById(int id) {
        ResultSet result = null;
        try {
            PreparedStatement stmt = getStatement(GET_PRODUCT_QUERY, prepareStatementFetProductById);
            stmt.setInt(1, id);
            result = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public ResultSet getAllRooms() {
        ResultSet result = null;
        try {

            PreparedStatement stmt = getStatement(GET_ALL_ROOMS, prepareStatementGetAllRooms);
            result = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public void createRoom(int roomId) {
        ResultSet result = null;
        try {
            PreparedStatement stmt = getStatement(CREATE_ROOM, prepareStatementAddRoom);
            stmt.setInt(1, roomId);
            int row = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createOrderIn(int orderId, int distributor) {
        ResultSet result = null;
        try {
            PreparedStatement stmt2 = getStatement(CREATE_ORDER_IN, prepareStatementAddOrderIn);
            stmt2.setTimestamp(1, Timestamp.from(Instant.now()));
            stmt2.setInt(2, orderId);
            stmt2.setInt(3, distributor);
            stmt2.executeUpdate();

            //int row = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createOrderInStart(int orderId, int distributor) {
        createOrder(orderId, distributor);
        createOrderIn(orderId, distributor);
    }

    public void createOrder(int orderId, int distributor) {
        ResultSet result = null;
        try {
            PreparedStatement stmt = getStatement(CREATE_ORDER, prepareStatementAddOrder);
            stmt.setInt(1, orderId);
            int row = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void createOrderOut(int orderId, int pharmacy) {
        ResultSet result = null;
        try {
            PreparedStatement stmt2 = getStatement(CREATE_ORDER_OUT, prepareStatementAddOrderOut);
            stmt2.setTimestamp(1, Timestamp.from(Instant.now()));
            stmt2.setInt(2, orderId);
            stmt2.setInt(3, pharmacy);
            stmt2.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteRoom(int roomId) {
        try {
            PreparedStatement stmt = getStatement(DELETE_ROOM, prepareStatementDeleteRoom);
            stmt.setInt(1, roomId);
            int row = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePharmacy(int pharmacyId) {
        try {
            PreparedStatement stmt = getStatement(DELETE_PHARMACY, preparedStatementGetDeletePharmacyById);
            stmt.setInt(1, pharmacyId);
            int row = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getOrderProductInfo(int orderId) {
        ResultSet result = null;
        try {
            PreparedStatement stmt = getStatement(SELECT_ORDER_PRODUCT_INFO_2, prepareStatementGetOrderProductInfo);
            stmt.setInt(1, orderId);
            result = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public ResultSet getAllPharmacies() {
        ResultSet result = null;
        try {
            PreparedStatement stmt = getStatement(GET_ALL_PHARMACIES, prepareStatementGetAllPharmacies);
            result = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public ResultSet getAllProducts() {
        ResultSet result = null;
        try {
            PreparedStatement stmt = getStatement(GET_ALL_PRODUCTS, prepareStatementGetAllPeoducts);
            result = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public ResultSet getAllProductsWithSpecialisation() {
        ResultSet result = null;
        try {
            PreparedStatement stmt = getStatement(GET_PRODUCT_WITH_SPECIALIZATION_ATTRIBUTES_QUERY, prepareStatementGetAllProductsWithSpecialisation);
            result = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public ResultSet getAllOrders() {
        ResultSet result = null;
        try {
            PreparedStatement stmt = getStatement(GET_ALL_ORDERS, prepareStatementGetAllOrders);
            result = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public ResultSet getAllDistributors() {
        ResultSet result = null;
        try {
            PreparedStatement stmt = getStatement(GET_ALL_DISTRIBUTORS, prepareStatementGetAllDistributors);
            result = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public ResultSet getAllActiveIngredients() {
        ResultSet result = null;
        try {
            PreparedStatement stmt = getStatement(GET_ALL_ACTIVE_INGR, prepareStatementGetAllActIngr);
            result = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public ResultSet getAllENums() {
        ResultSet result = null;
        try {
            PreparedStatement stmt = getStatement(GET_ALL_E_NUMS, prepareStatementGetAllENums);
            result = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public ResultSet getRoomById(int inputNum) {
        ResultSet result = null;
        try {
            PreparedStatement stmt = getStatement(GET_ROOM_QUERY, prepareStatementGetRoomById);
            stmt.setInt(1, inputNum);
            result = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public void createProduct(int productId, int quantity, String name_bg, String name_eng, int room, int batch, int actIngr) {
        try {
            PreparedStatement stmt = getStatement(CREATE_PRODUCT, prepareStatementAddProduct);
            stmt.setInt(1, productId);
            stmt.setInt(2, quantity);
            stmt.setString(3, name_bg);
            stmt.setString(4, name_eng);
            stmt.setInt(5, room);
            stmt.setInt(6, batch);
            stmt.setInt(7, actIngr);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createMedicine(int productId, int has_prescription, int group) {
        try {
            PreparedStatement stmt = getStatement(CREATE_MEDICINE, prepareStatementAddMedicine);
            stmt.setInt(1, has_prescription);
            stmt.setInt(2, group);
            stmt.setInt(3, productId);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createMedicineStart(int productId, int quantity, String name_bg, String name_eng, int room, int batch, int actIngr, int has_prescription, int group) {
        createProduct(productId, quantity, name_bg, name_eng, room, batch, actIngr);
        createMedicine(productId, has_prescription, group);
    }

    public void createSupplement(int productId, int quantity, int eNum) {
        try {
            PreparedStatement stmt = getStatement(CREATE_SUPPLEMENT, prepareStatementAddSupplement);
            stmt.setInt(1, quantity);
            stmt.setInt(2, eNum);
            stmt.setInt(3, productId);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createPharmacy(int inputNum, String address) {
        ResultSet result = null;
        try {
            PreparedStatement stmt = getStatement(CREATE_PHARMACY, preparedStatementAddPharmacy);
            stmt.setInt(1, inputNum);
            stmt.setString(2, address);

            int row = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getPharmacyById(int inputNum) {
        ResultSet result = null;
        try {
            PreparedStatement stmt = getStatement(GET_PHARMACY_QUERY, preparedStatementGetPharmacyById);
            stmt.setInt(1, inputNum);
            result = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public void createBatch(int inputNum, Double price, Timestamp shelfLife) {
        ResultSet result = null;
        try {
            PreparedStatement stmt = getStatement(CREATE_BATCH, preparedStatementAddBatch);
            stmt.setInt(1, inputNum);
            stmt.setDouble(2, price);
            stmt.setTimestamp(3, shelfLife);

            int row = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBatch(int inputNum) {
        try {
            PreparedStatement stmt = getStatement(DELETE_BATCH, prepareStatementDeleteBatch);
            stmt.setInt(1, inputNum);
            int row = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getAllBatches() {
        ResultSet result = null;
        try {
            PreparedStatement stmt = getStatement(GET_ALL_BATCHES, prepareStatementGetAllBatches);
            result = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public ResultSet getBatchById(int inputNum) {
        ResultSet result = null;
        try {
            PreparedStatement stmt = getStatement(GET_BATCH_QUERY, prepareStatementGetBatchById);
            stmt.setInt(1, inputNum);
            result = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public ResultSet getOrderById(int inputNum) {
        ResultSet result = null;
        try {
            PreparedStatement stmt = getStatement(GET_ORDER_QUERY, prepareStatementGetOrderById);
            stmt.setInt(1, inputNum);
            result = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public void createOrderOutsStart(int order, int pharm) {
        createOrder(order, pharm);
        createOrderOut(order, pharm);
    }

    public ResultSet getAllOrdersIn() {
        ResultSet result = null;
        try {
            PreparedStatement stmt = getStatement(GET_ORDERS_IN, prepareStatementGetAllOrdersIn);
            result = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public ResultSet getAllOrdersOut() {
        ResultSet result = null;
        try {
            PreparedStatement stmt = getStatement(GET_ORDERS_OUT, prepareStatementGetAllOrdersOut);
            result = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public void createSupplementStart(int productId, int quantity, String name_bg, String name_eng, int room, int batch, int actIngr, int eNum) {
        createProduct(productId, quantity, name_bg, name_eng, room, batch, actIngr);
        createSupplement(productId, quantity, eNum);
    }
}