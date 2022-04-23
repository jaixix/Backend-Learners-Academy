package com.la.backend.assignrelations;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/assignSubjectToTeacher")
public class AssignSubjectToTeacher extends HttpServlet {
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
			ps = connection.prepareStatement("update teachers set teachers.sub_id=? where bla.teachers.id=?");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside Post Method!");
		int teacherId = Integer.parseInt(request.getParameter("teacherId"));
		int subjectId = Integer.parseInt(request.getParameter("subjectId"));
		
		
		try {
			ps.setInt(1, subjectId);
			ps.setInt(2, teacherId);
			int result = ps.executeUpdate();
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("<h2>Subject - ID : " + subjectId + " has been assigned to Teacher - ID : " + teacherId + "</h2>");
			
			request.setAttribute("teacherId", teacherId);
			request.setAttribute("subjectId", subjectId);
			
			RequestDispatcher rd = request.getRequestDispatcher("/assignTeacherToClassForm.jsp");		
			rd.include(request, response);
			
			out.println("<br><br>Want to assign more/other subjects? <a href='assignSubjectToTeacherForm.jsp'>Click Here</a>");
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
