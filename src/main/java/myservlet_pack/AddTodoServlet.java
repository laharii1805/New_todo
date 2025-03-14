package myservlet_pack;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DbUtil;
import dao.TodoDao;
import model.Todo;

@WebServlet("/add")
public class AddTodoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String rollno= request.getParameter("rollno");
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        Date last_date = java.sql.Date.valueOf(request.getParameter("last_date"));
        
        Todo todo = new Todo(0, rollno, title, description,last_date,"Pending");
        Connection conn = DbUtil.getConnection();
        TodoDao dao = new TodoDao(conn);
        try {
            dao.addTodo(todo);
            response.sendRedirect("list");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}