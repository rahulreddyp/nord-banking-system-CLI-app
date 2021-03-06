package com.nord.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

/**
 * Create and close connection to the database . This class creates a static
 * connections so that a single connection is used throughout the lifecycle
 * of the application
 *
 * @author Abdul Mueed Qadri
 */
public class DbConnection {

  public static Connection connection;
  private String DB_URL;
  private String DB_USERNAME;
  private String DB_PASSWORD;
  private String DATABASE_DRIVER;

  public DbConnection() {
    setVariables();
    try {
      Class.forName(DATABASE_DRIVER);
      connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    } catch (SQLException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  private void setVariables() {
    Map<String, String> envMap = System.getenv();
    for (Map.Entry<String, String> entry : envMap.entrySet()) {
      if (entry.getKey().equals("DATABASE_USERNAME")) {
        this.DB_USERNAME = entry.getValue();
      }
      if (entry.getKey().equals("DATABASE_PASSWORD")) {
        this.DB_PASSWORD = entry.getValue();
      }
      if (entry.getKey().equals("DATABASE_URL")) {
        this.DB_URL = entry.getValue();
      }
      if (entry.getKey().equals("DATABASE_DRIVER")) {
        this.DATABASE_DRIVER = entry.getValue();
      }
    }
  }

  public static Connection getConnection() {
    if (connection == null) {
      new DbConnection();
    }
    return connection;
  }

  public static void closeDbConnection() {
    try {
      if (connection != null && !connection.isClosed()) {
        connection.close();
        connection = null;
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }
}
