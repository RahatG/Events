import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties; // Add this import statement

public class Connect {

    static Properties properties = Utils.getProperties();

    static Connection con;

    public Connect() {
        connect();
    }

    // attempt to connect to MySQL database
    public void connect() {
        Connect connector = new Connect();
        connector.connect();
        try {
            String driver = properties.getProperty("db.driver");
            String ip = properties.getProperty("db.ip");
            String port = properties.getProperty("db.port");
            String db = properties.getProperty("db.db");
            String user = properties.getProperty("db.user");
            String pass = properties.getProperty("db.pass");

            Class.forName(driver);
            System.out.println("Driver Loaded Successfully");
            con = DriverManager.getConnection("jdbc:mysql://"+ip+":"+port+"/"+db, user,
                    pass);
            System.out.println("Successful Connection");
        } catch (ClassNotFoundException cnfe) {
            System.err.println(cnfe);
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }
}
