package myservlet_pack;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DbUtil;
import dao.TodoDao;

@WebServlet("/delete")
public class DeleteTodoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Connection conn = DbUtil.getConnection();
        TodoDao dao = new TodoDao(conn);
        try {
            dao.deleteTodo(id);
            response.sendRedirect("list");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}