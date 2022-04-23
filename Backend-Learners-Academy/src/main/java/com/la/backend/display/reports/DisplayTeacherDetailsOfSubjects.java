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

@WebServlet("/DisplayTeacherDetailsOfSubjects")
public class DisplayTeacherDetailsOfSubjects extends HttpServlet {
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
			rs = statement.executeQuery("select distinct t.firstName, t.lastName, t.emailId, c.name, c.section, s.name, s.grade_points from class c, teachers t, subjects s where c.id=t.class_id and t.sub_id=s.id order by c.section");
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
			out.println("<th>Teacher First Name</th>");
			out.println("<th>Teacher Last Name</th>");
			out.println("<th>Teacher Email ID</th>");
			out.println("<th>Class Name</th>");
			out.println("<th>Section</th>");
			out.println("<th>Subject Name</th>");
			out.println("<th>Grade Points</th>");
			out.println("</tr>");
			while (rs.next()) {
				out.println("<tr>");
				out.println("<td>"+rs.getString(1)+"</td>");
				out.println("<td>"+rs.getString(2)+"</td>");
				out.println("<td>"+rs.getString(3)+"</td>");
				out.println("<td>"+rs.getString(4)+"</td>");
				out.println("<td>"+rs.getString(5)+"</td>");
				out.println("<td>"+rs.getString(6)+"</td>");
				out.println("<td>"+rs.getInt(7)+"</td>");
				out.println("</tr>");
//				out.println(""+rs.getString(2) + ", " + rs.getString(3) + ": Balance=" + rs.getInt(4));
			}
			out.println("</table>");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
