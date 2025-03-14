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

@WebServlet("/update")
public class UpdateTodoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        int id = Integer.parseInt(request.getParameter("id"));
        String rollno= request.getParameter("rollno");
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        Date lastDate =Date.valueOf(request.getParameter("last_date")) ;
        String status = request.getParameter("status");

        // Get database connection
        Connection conn = DbUtil.getConnection();
        TodoDao dao = new TodoDao(conn);

        try {
            // Update the To-Do item in the database
            dao.updateTodo(id, rollno, title, description, lastDate, status);
            response.sendRedirect("list"); // Redirect to the To-Do list page
        } catch (Exception e) {
            e.printStackTrace();
            //response.sendRedirect("error.jsp"); // Redirect to an error page if something goes wrong
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle GET requests (if needed)
        response.sendRedirect("index.jsp"); // Redirect to the main page
    }
}