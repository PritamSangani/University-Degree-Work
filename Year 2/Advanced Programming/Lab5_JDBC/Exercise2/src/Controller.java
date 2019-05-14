import java.sql.*;

/**
 * Created by Pritam Sangani on 24/10/2017.
 */
public class Controller {
    public static void main(String[] args) {
        try {
            ShowAllCustomers();
            ShowAllOrders();
            ShowOrdersForCustomer(2);
            ShowProductOrdersList();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static Connection getDBConnection() {
        Connection dbConnection = null;

        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            String dbURL = "jdbc:sqlite:shopdb.sqlite";
            dbConnection = DriverManager.getConnection(dbURL);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return dbConnection;
    }

    private static void ShowAllCustomers() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String query = "SELECT * FROM customers";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();
            System.out.println(query);
            //execute SQL Query
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println(resultSet.getString("CustomerID") + " " +
                        resultSet.getString("CustomerName") + " " +
                        resultSet.getString("CustomerEmail"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }

    private static void ShowAllOrders() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String query = "SELECT * FROM orders";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();
            System.out.println(query);
            //execute SQL Query
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println(resultSet.getString("OrderID") + " " +
                        resultSet.getString("ProductID") + " " +
                        resultSet.getString("CustomerID") + " " +
                        resultSet.getString("OrderDate"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }

    private static void ShowOrdersForCustomer(int i) throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String query = "SELECT * FROM orders WHERE CUSTOMERID = " + i;

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();
            System.out.println(query);
            //execute SQL Query
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println(resultSet.getString("OrderID") + " " +
                        resultSet.getString("ProductID") + " " +
                        resultSet.getString("CustomerID") + " " +
                        resultSet.getString("OrderDate"));

                
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }

    private static void ShowProductOrdersList() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String query = "SELECT ProductID, CustomerID.CustomerName, OrderDate FROM orders ORDER BY ProductID";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();
            System.out.println(query);
            //execute SQL Query
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println(resultSet.getString("ProductID") + " " +
                        resultSet.getString("CustomerID.CustomerName") + " " +
                        resultSet.getString("OrderDate"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }
}
