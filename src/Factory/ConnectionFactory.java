package Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {
  private static final String banco = "#";
  private static final String usuario = "root";
  private static final String senha = "#";

  public static Connection getConnect() {
    try {
      return DriverManager.getConnection();
    } catch (SQLException ex) {
      Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }
}