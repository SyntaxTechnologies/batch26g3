package utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DBUtils {

    private static Connection conn;
    private static Statement statement;
    private static ResultSet resultSet;

    /**
     * Establishes a connection to the MySQL database using credentials from configuration.properties
     */
    public static void establishConnection() {
        try {
            // Read connection details from your config file
            String url = ConfigReader.read("dbUrl");
            String username = ConfigReader.read("dbUsername");
            String password = ConfigReader.read("dbPassword");

            // Open connection
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to establish database connection!");
        }
    }

    /**
     * Executes a SELECT query and returns the results as a List of Maps.
     * Each Map represents one row, where Key = Column Name, and Value = Cell Value.
     */
    public static List<Map<String, String>> fetchDataFromDb(String query) {
        List<Map<String, String>> dataList = new ArrayList<>();
        try {
            // 1. Establish connection and create statement
            establishConnection();
            statement = conn.createStatement();

            // 2. Execute query
            resultSet = statement.executeQuery(query);

            // 3. Get structural info about the table columns (metadata)
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            // 4. Loop through each row of the query result
            while (resultSet.next()) {
                Map<String, String> rowMap = new LinkedHashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    String columnValue = resultSet.getString(i);
                    rowMap.put(columnName, columnValue);
                }
                dataList.add(rowMap);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Always close resources to prevent memory leaks
            closeConnection();
        }
        return dataList;
    }

    /**
     * Closes the database connection safely.
     */
    public static void closeConnection() {
        try {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}