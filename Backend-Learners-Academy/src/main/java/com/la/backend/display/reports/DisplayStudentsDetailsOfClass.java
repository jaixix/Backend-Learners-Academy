package com.la.backend.display.reports;

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
@WebServlet("/DisplayStudentsDetailsOfClass")
public class DisplayStudentsDetailsOfClass extends HttpServlet {
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
			rs = statement.executeQuery("select distinct s.firstName, s.lastName, s.roll_no, c.name, c.section from students s join class c on s.class_id=c.id");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside Get Method!");
		try {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("<table border='1' align='center'>");
			out.println("<tr>");
			out.println("<th>First Name</th>");
			out.println("<th>Last Name</th>");
			out.println("<th>Roll No.</th>");
			out.println("<th>Class Name</th>");
			out.println("<th>Section</th>");
			out.println("</tr>");
			while (rs.next()) {
				out.println("<tr>");
				out.println("<td>"+rs.getString(1)+"</td>");
				out.println("<td>"+rs.getString(2)+"</td>");
				out.println("<td>"+rs.getInt(3)+"</td>");
				out.println("<td>"+rs.getString(4)+"</td>");
				out.println("<td>"+rs.getString(5)+"</td>");
				out.println("</tr>");
//				out.println(""+rs.getString(2) + ", " + rs.getString(3) + ": Balance=" + rs.getInt(4));
			}
			out.println("</table>");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
