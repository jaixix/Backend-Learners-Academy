package com.la.backend.assignrelations;

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

@WebServlet("/assignTeacherToClass")
public class AssignTeacherToClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection connection;
	private PreparedStatement ps;
	private PreparedStatement ps1;

//	private Statement statement1;
	
	public void init(ServletConfig sc) {
		ServletContext context = sc.getServletContext();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(context.getInitParameter("dbUrl"), 
					context.getInitParameter("dbUser"), 
					context.getInitParameter("dbPassword"));
			ps = connection.prepareStatement("update teachers set teachers.class_id=? where bla.teachers.id=?");
			ps1 =connection.prepareStatement("insert into teachers values(?, ?, ?, ?, ?, ?)");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside Post Method!");
		int teacherId = Integer.parseInt(request.getParameter("teacherId"));
		int classId = Integer.parseInt(request.getParameter("classId"));
		int subjectId = Integer.parseInt(request.getParameter("subjectId"));
		
		try {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			System.out.println(teacherId+" "+classId+" "+subjectId+" ");
			Statement statement1 = connection.createStatement();
			ResultSet rs = statement1.executeQuery("select * from teachers where teachers.id="+teacherId);

			while(rs.next()) {
				if(rs.getInt(2)==0) {
					ps.setInt(1, classId);
					ps.setInt(2, teacherId);
					int result = ps.executeUpdate();
					out.println("<h2>Teacher - ID : " + teacherId + " has been assigned to Class - ID : " + classId + "</h2>");
				}
				else if(rs.getInt(2)!=0 && rs.getInt(2)!=classId){
					ps1.setInt(1, teacherId);
					ps1.setInt(2, classId);
					ps1.setInt(3, subjectId);
					ps1.setString(4,rs.getString(4));
					ps1.setString(5,rs.getString(5));
					ps1.setString(6,rs.getString(6));
					
					int result = ps1.executeUpdate();
					out.println("<h2>Teacher - ID : " + teacherId + " has been assigned to Class - ID : " + classId + " (Created) </h2>");
//					out.println("<br><br>Want to assign more/other subjects? <a href='assignSubjectToTeacherForm.jsp'>Click Here</a>");
//					out.println("<br><br>Want to return to the Homepage? <a href='index.jsp'>Click Here</a>");
					out.close();
				}
			}
			
			request.setAttribute("subjectId", subjectId);
			request.setAttribute("classId", classId);
			
			RequestDispatcher rd = request.getRequestDispatcher("/assignSubjectToClassForm.jsp");		
			rd.include(request, response);
			
			out.println("<br><br>Want to assign more/other teachers? <a href='assignSubjectToTeacherForm.jsp'>Click Here</a>");
			out.println("<br><br>Want to return to the Homepage? <a href='index.jsp'>Click Here</a>");
			
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
