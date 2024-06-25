package com.company.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.util.DBUtil;

public class RetrieveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public RetrieveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//  
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw= response.getWriter();
		response.setContentType("text/html");
		pw.println("<h3 style="+"text-align:center;"+">Your Appointment Details</h3>");
		String name=request.getParameter("name");
		String query = "SELECT * FROM appo WHERE name = ?";
   	 try (Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {

           preparedStatement.setString(1, name);

           ResultSet rs = preparedStatement.executeQuery();
           pw.println("<html><head><style>");
           pw.println("table { border-collapse: collapse; width: 100%; }");
           pw.println("th, td { text-align: left; padding: 8px; }");
           pw.println("tr:nth-child(even) { background-color: #f2f2f2; }");
           pw.println("th { background-color: #4CAF50; color: white; }");
           pw.println("h3{color:#4CAF50;}");
           pw.println("</style></head><body>");
           pw.println("<table>");
	       pw.println("<tr>");
	       pw.println("<th> Name </th>");
	       pw.println("<th> Email </th>");
	       pw.println("<th> Phone No </th>");	
	       pw.println("<th> Area </th>");
	       pw.println("<th> City </th>");
	       pw.println("<th> State </th>");
	       pw.println("<th> Date </th>");
	       pw.println("<th> Time </th>");
	       pw.println("<th> Postal Code </th>");
	       pw.println("<th> Edit Appointment </th>");		 
	       pw.println("<th> Delete Appointment </th>");		 
	       
	       pw.println("</tr>");
	       while(rs.next())
	       {
	    	   pw.println("<tr>");
	    	   pw.println("<td>"+rs.getString(1)+"</td>");
	    	   pw.println("<td>"+rs.getString(2)+"</td>");
	    	   pw.println("<td>"+rs.getString(3)+"</td>");
	    	   pw.println("<td>"+rs.getString(4)+"</td>");
	    	   pw.println("<td>"+rs.getString(5)+"</td>");
	    	   pw.println("<td>"+rs.getString(6)+"</td>");
	    	   pw.println("<td>"+rs.getString(7)+"</td>");
	    	   pw.println("<td>"+rs.getString(8)+"</td>");
	    	   pw.println("<td>"+rs.getString(9)+"</td>");
	    	   pw.println("<td><a href='EditServlet1?id="+rs.getString(1)+"'>Edit Appointment</a></td>");
	    	   pw.println("<td><a href='DeleteServlet?name="+rs.getString(1)+"'>Cancel Appointment</a></td>");
	    	   
	    	   pw.println("</tr>");
	       }
	       pw.println("</table>");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
}
