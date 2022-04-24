package com.la.backend.assignrelations;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

@WebServlet("/assignSubjectToClass")
public class AssignSubjectToClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	private PreparedStatement ps;
	private PreparedStatement ps1;
	private Statement statement;
	private PrintWriter out;
	
	public void init(ServletConfig sc) {
		ServletContext context = sc.getServletContext();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(context.getInitParameter("dbUrl"), 
					context.getInitParameter("dbUser"), 
					context.getInitParameter("dbPassword"));
			ps = connection.prepareStatement("update class set sub_id=? where bla.class.id=?");
			ps1 =connection.prepareStatement("insert into class values(?, ?, ?, ?)");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside Post Method!");
		int subjectId = Integer.parseInt(request.getParameter("subjectId"));
		int classId = Integer.parseInt(request.getParameter("classId"));
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
				+ "            margin-top:70px !important;\r\n"
				+ "        }\r\n"
				+ "</style>\r\n"
				+ "</head>");
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from class where class.id="+classId);
			
			while(rs.next()) {
				if(rs.getInt(2)==0) {
					ps.setInt(1, subjectId);
					ps.setInt(2, classId);
					int result = ps.executeUpdate();
					out.println("<h2>Subject - ID : " + subjectId + " has been assigned to Class - ID : " + classId + "</h2>");
					out.println("<br><br>Want to assign more/other subjects? <a href='assignSubjectToTeacherForm.jsp'>Click Here</a>");
					out.println("<br><br>Want to return to the Homepage? <a href='index.jsp'>Click Here</a>");
					out.close();
				}
				else if(rs.getInt(2)!=0 && rs.getInt(2)!=subjectId){
					ps1.setInt(1, classId);
					ps1.setInt(2, subjectId);
					ps1.setString(3,rs.getString(3));
					ps1.setString(4,rs.getString(4));
					int result = ps1.executeUpdate();
					out.println("<h2>Subject - ID : " + subjectId + " has been assigned to Class - ID : " + classId + " (Created) </h2>");
					out.println("<br><br>Want to assign more/other subjects? <a href='assignSubjectToTeacherForm.jsp'>Click Here</a>");
					out.println("<br><br>Want to return to the Homepage? <a href='index.jsp'>Click Here</a>");
					out.close();
				}
				else if(rs.getInt(2)!=0 && rs.getInt(2)==subjectId) {
					out.println("<h1>Subject already assigned to class!</h2>");
					out.println("<br><br>Want to return to the Homepage? <a href='index.jsp'>Click Here</a>");
				}
			}
		} catch (SQLException | NullPointerException e) {
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
