package utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DBReader {

    public static List<Map<String,String>> fetch(String query) throws SQLException {
        String dbUrl="jdbc:mysql://148.72.132.33:3307/syntax_hrm";
        String username="syntax_std";
        String password="syntax_std@2026";

        List<Map<String, String>> data = new ArrayList<>();

      try(Connection con= DriverManager.getConnection(dbUrl,username,password)) {
          Statement stmt = con.createStatement();
          ResultSet rs = stmt.executeQuery(query);

          ResultSetMetaData rsmd = rs.getMetaData();



          while (rs.next()) { // for row by row
              Map<String, String> map = new LinkedHashMap<>();
              for (int i = 1; i <= rsmd.getColumnCount(); i++) { // for columns in row
                  String key = rsmd.getColumnName(i);
                  String value = rs.getString(i);
                  map.put(key, value);
              }
              data.add(map);
          }
          System.out.println(data);
          rs.close();
          stmt.close();
      }
      catch(SQLException e){
          e.printStackTrace();
      }
       return data;
    }
}
