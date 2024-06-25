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

public class EditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public EditServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException
	 {
		 PrintWriter pw=res.getWriter();
		 res.setContentType("text/html"); 
		  String query="update appo set name=?,email=?,phone=?,area=?,city=?,state=?,date=?,time=?,post_code=? where name=? ";
		  String id=req.getParameter("id");
		  String name=req.getParameter("name");
		  String email=req.getParameter("email");
		  String phone=req.getParameter("phone");
		  String area=req.getParameter("area");
		  String city=req.getParameter("city");
		  String state=req.getParameter("state");
		  String date=req.getParameter("date");
		  String time=req.getParameter("time");
		  String post_code=req.getParameter("post-code");
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
			   ps.setString(1, name);
			   ps.setString(2, email);
			   ps.setString(3, phone);
			   ps.setString(4, area);
			   ps.setString(5, city);
			   ps.setString(6, state);
			   ps.setString(7, date);
			   ps.setString(8, time);
			   ps.setString(9, post_code);
			   ps.setString(10, id);
			   int count=ps.executeUpdate();
			   if(count==1)
			   {
				   pw.println("<h2> Record is Edited Successfully </h2>");
			   }
			   else
			   {
				   pw.println("<h2> Record is not Edited Successfully </h2>");
				      
			   }
			   
			   
			   
		 }catch(Exception e) {
			 pw.println("<h1>"+e.getMessage()+"</h1>");
		 }
		 
		 pw.println("<a href='Index.html'> Home </a>");
//		 pw.println("<br>");		 
//		 pw.println("<a href='booklist'> BookList </a>");
//		 
		 
	 }




}
