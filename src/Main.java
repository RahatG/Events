import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class App {
    public static void main(String[] args) {
        // Load environment variables
        String dbHost = System.getenv("DATABASE_HOST");
        String dbUsername = System.getenv("DATABASE_USERNAME");
        String dbPassword = System.getenv("DATABASE_PASSWORD");
        String dbName = System.getenv("DATABASE");

        // JDBC connection properties
        Properties props = new Properties();
        props.setProperty("user", dbUsername);
        props.setProperty("password", dbPassword);
        props.setProperty("useSSL", "true"); // Enable SSL

        public class Solution {

            public static void main(String[] args) {
                /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
                Scanner scanner = new Scanner(System.in);
                int intValue = scanner.nextInt();
                scanner.nextLine();
                double doubleValue = scanner.nextDouble();
                scanner.nextLine();
                String stringValue = scanner.nextLine();
                scanner.close();

                System.out.println("String: " + string);
                System.out.println("Double: " + second);
                System.out.println("Int" + third);
            }
        }

        try {
            // Connect to the database
            String url = "jdbc:mysql://" + dbHost + "/" + dbName;
            Connection connection = DriverManager.getConnection(url, props);

            // Execute query
            Statement statement = connection.createStatement();
            String query = "SHOW TABLES";
            ResultSet resultSet = statement.executeQuery(query);

            // Display tables
            if (resultSet.next()) {
                System.out.println("Tables in the database:");
                do {
                    System.out.println("- " + resultSet.getString(1));
                } while (resultSet.next());
            } else {
                System.out.println("Connected successfully. No tables found in the database.");
            }

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}