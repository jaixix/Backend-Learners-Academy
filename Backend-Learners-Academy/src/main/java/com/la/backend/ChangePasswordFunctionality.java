package com.la.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/changePasswordFunctionality")
public class ChangePasswordFunctionality extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection connection;
	private Statement statement;
	private PrintWriter out;
	
	public void init(ServletConfig sc) {
		ServletContext context = sc.getServletContext();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(context.getInitParameter("dbUrl"), 
					context.getInitParameter("dbUser"), 
					context.getInitParameter("dbPassword"));
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside Post Method!");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String newPassword= request.getParameter("newPassword");
		out = response.getWriter();
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
		try {
			ResultSet rs = statement.executeQuery("select * from admin where email='"+email+"' and password='"+password+"'");
			if(rs.next()) {
				int result = statement.executeUpdate("update admin set password='"+newPassword+"' where email='"+email+"'");
				if(result>0) {
					out.println("<h3>Password has been Updated!</h3>");
					out.close();
				}
				else {
					out.println("<h3>Password could not be changed!<br>Please try Again.</h3>");
				}
			}
			else {
				response.setContentType("text/html");
				out.println("<h2>Password could not be changed.</h2>");
				out.println("<h3>Please ensure you are entering the correct credentials!</h3>");
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		out.println("</body>\r\n"
				+ "</html>");
	}

//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("Inside Post Method!");
//		String email = request.getParameter("email");
//		String password = request.getParameter("password");
//		String newPassword= request.getParameter("newPassword");
//		out = response.getWriter();
//		try {
//			ResultSet rs = statement.executeQuery("select * from admin where email='"+email+"' and password='"+password+"'");
//			if(rs.next()) {
//				response.setContentType("text/html");	
//				int result = statement.executeUpdate("update admin set password='"+newPassword+"' where email='"+email+"'");
//				if(result>0) {
//					out.println("<h3>Password has been Updated!</h3>");
//				}
//				else {
//					out.println("<h3>Password could not be changed!<br>Please try Again.</h3>");
//				}
//			}
//			else {
//				out.println("<h2>Password could not be changed.</h2>");
//				out.println("<h3>Please ensure you are entering the correct credentials!</h3>");
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	
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
