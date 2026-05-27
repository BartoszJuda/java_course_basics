package day03.simple_database_app;

import java.sql.*;

public class DataBaseApp {

    private static final String DB_URL = "jdbc:h2:./testdb";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    static void main(String[] args) {
        try(Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            //utworzenie tabeli
            //createTable(connection);

            //dodanie użytkownika
            //insertUser(connection, "Bartosz", "Juda");
            //insertUser(connection, "Jan", "Kowalski");
            //insertUser(connection, "Adam", "Nowak");

            //wyświetlenie użytkownika
            System.out.println("Wyświetlenie użytkowników");
            readUsers(connection);

            //usunięcie użytkownika
            System.out.println("Wyświetlenie użytkowniów po usunięciu");
            deleteUser(connection, 1);
            readUsers(connection);

            //update użytkownika
            updateUser(connection,9, "Mateusz", "Judaaaaa");
            System.out.println("Wyswietlenie użytkowników po update");
            readUsers(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //utworzenie tabeli w bazie
    private static void createTable(Connection connection) throws SQLException {
        String sql = """
                CREATE TABLE IF NOT EXISTS users (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    first_name VARCHAR(100),
                    last_name VARCHAR(100)
                )
                """;

        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    // dodanie użytkownika do bazy
    private static void insertUser(Connection connection, String firstName, String lastName) throws SQLException {
        String sql = "INSERT INTO users (first_name, last_name) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.executeUpdate();
        }
    }

    // usunięcie użytkownika
    private static void deleteUser(Connection connection, int id) throws SQLException {
        String sql = "DELETE FROm users WHERE id = ?";

        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            System.out.println("Usunięto: " + rowsDeleted + " wierszy");
        }
    }

    // update
    private static void updateUser(Connection connection,
                                   int id,
                                   String newFirstName,
                                   String newLastName) throws SQLException {


        String sql = """
                UPDATE users
                SET first_name = ?, last_name = ?
                WHERE id = ?
                """;
        try(PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, newFirstName);
            statement.setString(2, newLastName);
            statement.setInt(3, id);

            int rowsUpdated = statement.executeUpdate();

            System.out.println("Updated rows: " + rowsUpdated);
        }
    }

    // pobranie
    private static void readUsers(Connection connection) throws SQLException {
        String sql = "SELECT id, first_name, last_name FROM users";

        try(Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                System.out.println(
                        resultSet.getInt("id") + " : " +
                                resultSet.getString("first_name") + " " +
                                resultSet.getString("last_name")
                );
            }
        }
    }
}
