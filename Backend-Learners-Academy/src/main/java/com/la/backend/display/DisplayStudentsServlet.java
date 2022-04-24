package com.la.backend.display;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DisplayStudentsServlet")
public class DisplayStudentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private RequestDispatcher requestDispatcher;
	
	public void init(ServletConfig sc) {
		ServletContext context = sc.getServletContext();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(context.getInitParameter("dbUrl"), 
					context.getInitParameter("dbUser"), 
					context.getInitParameter("dbPassword"));
			Statement statement = connection.createStatement();
			rs = statement.executeQuery("select firstName, lastName, roll_no from bla.students;");	
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("<!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ "<head>\r\n"
					+ "<meta charset=\"ISO-8859-1\">\r\n"
					+ "<title>Setup Classes Form</title>\r\n"
					+ "<style>\r\n"
					+ "      body{\r\n"
					+ "            font-family:'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;\r\n"
					+ "            text-align:center;\r\n"
					+ "            margin-top:100px !important;\r\n"
					+ "        }\r\n"
					+ "</style>\r\n"
					+ "</head>");
			out.println("<h3>Students Table</h3><br>");
			out.println("<table border='1' align='center'>");
			out.println("<tr>");
			out.println("<th>First Name</th>");
			out.println("<th>Last Name</th>");
			out.println("<th>Roll Number</th>");
			out.println("</tr>");
			while (rs.next()) {
				out.println("<tr>");
				out.println("<td>"+rs.getString(1)+"</td>");
				out.println("<td>"+rs.getString(2)+"</td>");
				out.println("<td>"+rs.getInt(3)+"</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("<br><br><a href='setupStudentsForm.jsp' align='middle'>Go back?</a>");
			out.println("</body>\r\n"
					+ "</html>");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
