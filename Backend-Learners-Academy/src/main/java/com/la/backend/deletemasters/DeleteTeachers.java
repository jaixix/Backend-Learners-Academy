package com.la.backend.deletemasters;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteTeachers")
public class DeleteTeachers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection connection;
	private PreparedStatement ps;

	private PrintWriter out;
	
	public void init(ServletConfig sc) {
		ServletContext context = sc.getServletContext();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(context.getInitParameter("dbUrl"), 
					context.getInitParameter("dbUser"), 
					context.getInitParameter("dbPassword"));
			ps = connection.prepareStatement("delete from bla.teachers");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside Get Method");
		response.setContentType("text/html");
		out = response.getWriter();
		out = response.getWriter();
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
		try {
			int result = ps.executeUpdate();
			response.setContentType("text/html");
			if(result>0) {
				out.println("<h2>Success! Table : Teachers as been emptied.</h2>");
				out.println("<h4>To Return to Homepage, <a href=\"index.jsp\">Click Here</a></h4>");
			}
			else {
				out.println("<h2>Failure! Table : Teachers could not be emptied.<br>Please try again.</h2>");
				out.println("<h4>To Return to Homepage, <a href=\"index.jsp\">Click Here</a></h4>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		out.println("</body>\r\n"
				+ "</html>");
	}
	
	public void destroy() {
		try {
			if (connection != null) {
				connection.close();
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
