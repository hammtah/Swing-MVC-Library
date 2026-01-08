package ma.ilisi2.library.utility;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
    public static String connectionString = "jdbc:sqlite:identifier.sqlite";

    public static java.sql.Connection getConnection() throws SQLException {
        return DriverManager.getConnection(connectionString);
    }
}
