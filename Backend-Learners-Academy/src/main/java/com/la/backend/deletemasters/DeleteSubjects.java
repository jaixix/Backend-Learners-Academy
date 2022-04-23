package com.la.backend.deletemasters;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteSubjects")
public class DeleteSubjects extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection connection;
	private PreparedStatement ps;
	
	public void init(ServletConfig sc) {
		ServletContext context = sc.getServletContext();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(context.getInitParameter("dbUrl"), 
					context.getInitParameter("dbUser"), 
					context.getInitParameter("dbPassword"));
			ps = connection.prepareStatement("delete from bla.subjects");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside Get Method");
		try {
			Statement statement = connection.createStatement();
			PrintWriter out = response.getWriter();
//			statement.executeUpdate("delete c from class c join subjects s on c.sub_id = s.id where c.sub_id>=0");
			
			int result = ps.executeUpdate();
			response.setContentType("text/html");
			if(result>0) {
				out.println("<h2>Success! Table : Subjects as been emptied.</h2><br><br>");
				out.println("<h4>To Return to Homepage, <a href=\"index.jsp\">Click Here</a></h4>");
			}
				else {
				out.println("<h2>Failure! Table : Subjects could not be emptied.<br>Please try again.</h2>");
				out.println("<h4>To Return to Homepage, <a href=\"index.jsp\">Click Here</a></h4>");
				}
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
