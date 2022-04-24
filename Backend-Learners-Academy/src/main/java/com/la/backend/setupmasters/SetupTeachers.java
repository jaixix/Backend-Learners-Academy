package com.la.backend.setupmasters;

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

@WebServlet("/setupTeachers")

public class SetupTeachers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection connection;
	private PreparedStatement ps;

	private PrintWriter out;
	
	public void init(ServletConfig sc) {
		System.out.println("Initializing addProductServlet...");
		ServletContext context = sc.getServletContext();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(context.getInitParameter("dbUrl"), 
					context.getInitParameter("dbUser"), 
					context.getInitParameter("dbPassword"));
			ps = connection.prepareStatement("insert into teachers values(?, 0, 0, ?, ?, ?)");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside Post Method!");
		
		int id = Integer.parseInt(request.getParameter("id"));
		String teacherFirstName = request.getParameter("teacherFirstName");
		String teacherLastName = request.getParameter("teacherLastName");
		String emailId = request.getParameter("emailId");
		
		response.setContentType("text/html");
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
			ps.setInt(1, id);
			ps.setString(2, teacherFirstName);
			ps.setString(3, teacherLastName);
			ps.setString(4, emailId);
			
			int result = ps.executeUpdate();
//			out.println("<h1>Values Added Successfully!</h1>");
			out.println("<h2>Teacher has been Setup Successfully.</h2><br><br>");
			out.println("Want to add more Teachers? <a href='setupTeachersForm.jsp'>Click Here</a>");
			out.println("<br><br>Want to return to the Homepage? <a href='index.jsp'>Click Here</a>");
			out.close();
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
