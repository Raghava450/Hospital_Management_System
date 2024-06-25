package com.company.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter pw=response.getWriter();
		 response.setContentType("text/html"); 
		  String query="delete from appo where name=? ";
		  String Name=request.getParameter("name");
		  pw.println("<html><head><style>");
          pw.println("h2{color:blue; text-align:center}");
          pw.println("a{margin-left:50%}");
          pw.println("</style></head><body>");
		 
		  
		 try
		 {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 //pw.println("Driver loaded");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","Raghava@1234");
			 //pw.print("sql connection set");
			   PreparedStatement ps=con.prepareStatement(query);
			   ps.setString(1, Name);
			 
			   int count=ps.executeUpdate();
			   if(count==1)
			   {
				   pw.println("<h2> Record is Deleted Successfully </h2>");
				    }
			   else
			   {
				   pw.println("<h2> Record is Not Deleted Successfully </h2>");
				      
			   }
			   
			   
			   
		 }catch(Exception e) {
			 pw.println("<h1>"+e.getMessage()+"</h1>");
		 }
		 
		 pw.println("<a href='Index.html'> Home </a>");
		 
	}

	

}
