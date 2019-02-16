package sda;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class JdbcBookStoreManager implements BookStoreManager {
    public void add(String title, String author) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/bookstore?user=root&password=root");
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO book (title, author) VALUES(?, ?)");
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, author);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Collection<Book> findAll() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/bookstore?user=root&password=root");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM book");
            Collection<Book> books = new ArrayList<>();

            if (resultSet.next()) {

                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                Book book = new Book(id, title, author);
                books.add(book);
            }
            return books;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}