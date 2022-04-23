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

import com.la.backend.display.DisplayClassesServlet;
@WebServlet("/setupClasses")
public class SetupClasses extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private Connection connection;
	private PreparedStatement ps;
	
	public void init(ServletConfig sc) {
		System.out.println("Initializing addProductServlet...");
		ServletContext context = sc.getServletContext();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(context.getInitParameter("dbUrl"), 
					context.getInitParameter("dbUser"), 
					context.getInitParameter("dbPassword"));
			ps = connection.prepareStatement("insert into class values(?, 0, ?, ?)");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside Post Method!");
		
		int id = Integer.parseInt(request.getParameter("id"));
		String className = request.getParameter("className");
		String sectionName = request.getParameter("sectionName");
		
		try {
			ps.setInt(1, id);
			ps.setString(2, className);
			ps.setString(3, sectionName);
			int result = ps.executeUpdate();
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<h1>Values Added Successfully!</h1>");
			out.println("Want to add more Classes? <a href='setupClassesForm.jsp'>Click Here</a>");
			out.println("<br><br>Want to return to the Homepage? <a href='index.jsp'>Click Here</a>");
			out.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
