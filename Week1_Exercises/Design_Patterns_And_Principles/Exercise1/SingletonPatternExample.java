package Exercise1;

public class SingletonPatternExample {

    public static class DatabaseConnection {
        private static DatabaseConnection instance;

        private DatabaseConnection() {
        }

        public static synchronized DatabaseConnection getInstance() {
            if (instance == null) {
                instance = new DatabaseConnection();
            }
            return instance;
        }

        public void connect(String databaseUrl) {
            System.out.println("Connecting to database: " + databaseUrl);
        }
    }

    public static void main(String[] args) {
        DatabaseConnection connection1 = DatabaseConnection.getInstance();
        DatabaseConnection connection2 = DatabaseConnection.getInstance();

        connection1.connect("jdbc:mysql://localhost:3306/mydatabase");
        connection2.connect("jdbc:mysql://localhost:3306/mydatabase");

        if (connection1 == connection2) {
            System.out.println("connection1 and connection2 are the same instance.");
        } else {
            System.out.println("connection1 and connection2 are different instances.");
        }
    }
}
