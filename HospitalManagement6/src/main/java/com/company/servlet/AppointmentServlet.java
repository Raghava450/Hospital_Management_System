package com.company.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AppointmentServlet() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter pw=response.getWriter();
		 response.setContentType("text/html"); 
		  String query="select * from appo";
		 try
		 {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 //pw.println("Driver loaded");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","Raghava@1234");
			 //pw.print("sql connection set");
			   PreparedStatement ps=con.prepareStatement(query);
			   ResultSet rs = ps.executeQuery();
			   pw.println("<html><head><style>");
	           pw.println("table { border-collapse: collapse; width: 100%; }");
	           pw.println("th, td { text-align: left; padding: 8px; }");
	           pw.println("tr:nth-child(even) { background-color: #f2f2f2; }");
	           pw.println("th { background-color: #4CAF50; color: white; }");
	           pw.println("h3{color:#4CAF50;}");
	           pw.println("a{margin-left:50%}");
	           pw.println("</style></head><body>");
			   pw.println("<table border='1' align='center'>");
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
		       pw.println("<th> Delete </th>");		 
		       
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
		    	   
		    	   pw.println("<td><a href='DeleteServlet?name="+rs.getString(1)+"'>Cancel Appointment</a></td>");
		    	   
		    	   pw.println("</tr>");
		    	  
		       }
		       pw.println("</table>");
		       
		 }catch(Exception e) {
			 pw.println("<h1>"+e.getMessage()+"</h1>");
		 }
		 //pw.println("<form action='MsgSevlet' method='post'><input type=text name=phone></form>");
		 
		 pw.println("<a href='Index.html'> Home </a>");
		 
		 
	}

}
