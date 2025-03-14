package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Todo;

public class TodoDao {
    private Connection conn;

    public TodoDao(Connection conn) {
        this.conn = conn;
    }

    public List<Todo> getAllTodos() throws SQLException {
        List<Todo> todos = new ArrayList<>();
        String sql = "SELECT * FROM todos";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                todos.add(new Todo(
                    rs.getInt("id"), 
                    rs.getString("rollno"),
                    rs.getString("title"), 
                    rs.getString("description"), 
                    rs.getDate("last_date"),  
                    rs.getString("status")
                ));
            }
        }
        return todos;
    }

    public void addTodo(Todo todo) throws SQLException {
        String sql = "INSERT INTO todos (rollno, title, description, last_date, status) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
        	ps.setString(1,todo.getRollno());
            ps.setString(2, todo.getTitle());
            ps.setString(3, todo.getDescription());
            ps.setDate(4, todo.getLast_date());
            ps.setString(5, todo.getStatus());
            ps.executeUpdate();
        }
    }

    public void deleteTodo(int id) throws SQLException {
        String sql = "DELETE FROM todos WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
    
    public void updateTodo(int id, String rollno, String title, String description, Date last_date, String status) throws SQLException {
      String sql = "UPDATE todos SET rollno = ?, title = ?, description = ?, last_date = ?, status = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
        	pstmt.setString(1, rollno);
            pstmt.setString(2, title);
            pstmt.setString(3, description);
            pstmt.setDate(4, last_date);
            pstmt.setString(5, status);
            pstmt.setInt(6, id);
            pstmt.executeUpdate();
        }
    }
  }