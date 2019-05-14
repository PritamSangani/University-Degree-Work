import java.sql.*;

/**
 * Created by Pritam Sangani on 23/10/2017.
 */
public class Controller {
    public static void main(String[] args) {
        try {
            ShowAllRecords();
            insertRecordIntoCollectionTable();
            ShowAllRecords();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
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
            String dbURL = "jdbc:sqlite:dvd.sqlite";
            dbConnection = DriverManager.getConnection(dbURL);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return dbConnection;
    }

    private static void ShowAllRecords() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String query = "SELECT * FROM collection";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();
            System.out.println(query);
            //execute SQL Query
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println(resultSet.getString("ID") + " " +
                resultSet.getString("Title") + " " +
                resultSet.getString("Genre") + " " +
                resultSet.getString("Year"));
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

    private static void insertRecordIntoCollectionTable() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String query = "INSERT INTO collection (ID, Title, Genre, Year) VALUES (5,'Divergent','Sci Fi',2014);";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();
            System.out.println(query);
            //execute SQL Query
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println(resultSet.getString("ID") + " " +
                        resultSet.getString("Title") + " " +
                        resultSet.getString("Genre") + " " +
                        resultSet.getString("Year"));
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
