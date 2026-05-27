package day03.messaging.dao;

import day03.messaging.db.Database;
import day03.messaging.exception.NoteNotFoundException;
import day03.messaging.model.Note;
import day03.messaging.repository.CrudRepository;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class NoteDao implements CrudRepository<Note, Integer> {

    public void createTable() throws SQLException {
        String sql = """
                CREATE TABLE IF NOT EXISTS notes (
                id INT AUTO_INCREMENT PRIMARY KEY,
                title VARCHAR(100) NOT NULL,
                content VARCHAR(1000) NOT NULL,
                created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
                )
                """;

        try(Connection connection = Database.getConnection();
            Statement statement = connection.createStatement()) {

            statement.execute(sql);
        }
    }


    @Override
    public void add(Note note) throws SQLException {
        String sql = """
                INSERT INTO notes (title, content)
                VALUES (?, ?)
                """;

        try(Connection connection = Database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, note.getTitle());
            preparedStatement.setString(2, note.getContent());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public List<Note> findAll() throws SQLException {
        List<Note> notes = new ArrayList<>();

        String sql = """
                SELECT id, title, content, created_at
                FROM notes
                ORDER BY created_at DESC
                """;

        try(Connection connection = Database.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                notes.add(mapRow(resultSet));
            }
        }
        return notes;
    }

    @Override
    public Note findById(Integer id) throws SQLException, NoteNotFoundException {
        String sql = """
                SELECT id, title, content, created_at
                FROM notes
                WHERE id = ?
                """;

        try(Connection connection = Database.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            try(ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return  mapRow(resultSet);
                }
            }

        }
        throw new NoteNotFoundException("Nie znaleziono notatki o id: " + id);
    }

    @Override
    public void update(Integer id, Note note) throws SQLException {

        String sql = """
                UPDATE notes
                SET title = ?, content = ?
                WHERE id = ?
                """;
        try(Connection connection = Database.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, note.getTitle());
            statement.setString(2, note.getContent());
            statement.setInt(3, note.getId());

            statement.executeUpdate();
        }

    }

    @Override
    public void delete(Integer id) throws SQLException {

        String sql = """
                DELETE FROM notes
                WHERE id = ?
                """;

        try(Connection connection = Database.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            statement.executeUpdate();
        }

    }

    private Note mapRow(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String title = resultSet.getString("title");
        String content = resultSet.getString("content");

        Timestamp timestamp = resultSet.getTimestamp("created_at");
        LocalDateTime createdAt = timestamp.toLocalDateTime();

        return new Note(id, title, content, createdAt);
    }
}
