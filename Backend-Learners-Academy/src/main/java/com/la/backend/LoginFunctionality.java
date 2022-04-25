package com.la.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/loginFunctionality")
public class LoginFunctionality extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection connection;
	private PrintWriter out;
	private Statement statement;
	
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
		
		String emailId = request.getParameter("emailId");
		String password = request.getParameter("password");
		
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
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from admin where email='"+emailId+"' and password='"+password+"'");
			
			if(rs.next()) {
					//successful login
					out.println("<p>Login Successfull</p>");
//					request.setAttribute("emailId", emailId);
//					request.setAttribute("adminName", rs.getString(4));
					
					Cookie myCookie = new Cookie("emailId", emailId);
					myCookie.setMaxAge(60*60);
					response.addCookie(myCookie);
					
					RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
					rd.forward(request, response);
				}
			else {
					// unsuccessful login - incorrect email or incorrect password
					out.println("<h3>Login failed</h3>");
					out.println("<h3>Email/Password Incorrect</h3><br><br>");
					RequestDispatcher rd = request.getRequestDispatcher("/LoginForm.jsp");
					rd.include(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			out.println("</body>\r\n"
					+ "</html>");
		}
}