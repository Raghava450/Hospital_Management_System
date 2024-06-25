package com.company.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public EditServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException
	 {
		 PrintWriter pw=res.getWriter();
		 res.setContentType("text/html"); 
		  String query="select * from appo where name=? ";
		  String id=req.getParameter("id");
		 try
		 {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 //pw.println("Driver loaded");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","Raghava@1234");
			 //pw.print("sql connection set");
			   PreparedStatement ps=con.prepareStatement(query);
			   ps.setString(1, id);
			  
			   
			   ResultSet rs=ps.executeQuery();
			   pw.println("<html><head><style>");
			   pw.println(":root{--maincolor:blue;    --secondcolor:#f8a803;  --thirdcolor:#f4ab01;  --textcolor:#000000;}");
	          pw.println(" * {   margin: 0;   padding: 0;    box-sizing: border-box; }");
	          pw.println(" body {   font-family: \"Inter\", Arial, Helvetica, sans-serif; background-image: url(\"backgroung-pattern-1.png\"); background-size: cover; }");
	          pw.println(" .mainform {  display: flex;  align-items: center; justify-content: center; padding: 48px; margin-left:20%; }");
	          pw.println(".subform {  align-items: center; justify-content: center;  margin: 0 auto; max-width: 550px;  width: 100%;  background: white;}");
	          pw.println("input{ width: 100%;  padding: 12px 24px; border-radius: 6px;  border: 1px solid #e0e0e0; background: white; font-weight: 500; font-size: 16px; color: black;  outline: none; resize: none; }");
	          pw.println("input:hover{ background-color: var(--secondcolor); color: #6a64f1; }");
	          pw.println("a{margin-left=50%}");
	           pw.println("</style></head><body>");
			   rs.next();
			   pw.println("<form action='EditServlet2?id=" +id+" ' method='post'>");
			   pw.println("<div class='mainform'>");
			   pw.println("<div class='subform'>");
			   pw.println("<table");
			   pw.println("<tr>");
			   pw.println("<td> Name </td>");
			   pw.println("<td><input type='text' name='name' value='"+rs.getString(1)+"'></td>");
			   pw.println("</tr>");
			   pw.println("<tr>");
			   pw.println("<td> Email </td>");
			   pw.println("<td><input type='email' name='email' value='"+rs.getString(2)+"'></td>");
			   pw.println("</tr>");
			   pw.println("<tr>");
			   pw.println("<td> phone </td>");
			   pw.println("<td><input type='text' name='phone' value='"+rs.getString(3)+"'></td>");
			   pw.println("</tr>");
			   pw.println("<tr>");
			   pw.println("<td> area </td>");
			   pw.println("<td><input type='text' name='area' value='"+rs.getString(4)+"'></td>");
			   pw.println("</tr>");
			   pw.println("<tr>");
			   pw.println("<td> city </td>");
			   pw.println("<td><input type='text' name='city' value='"+rs.getString(5)+"'></td>");
			   pw.println("</tr>");
			   pw.println("<tr>");
			   pw.println("<td> state </td>");
			   pw.println("<td><input type='text' name='state' value='"+rs.getString(6)+"'></td>");
			   pw.println("</tr>");
			   pw.println("<tr>");
			   pw.println("<td> date </td>");
			   pw.println("<td><input type='text' name='date' value='"+rs.getString(7)+"'></td>");
			   pw.println("</tr>");
			   pw.println("<tr>");
			   pw.println("<td> time </td>");
			   pw.println("<td><input type='text' name='time' value='"+rs.getString(8)+"'></td>");
			   pw.println("</tr>");
			   pw.println("<tr>");
			   pw.println("<td> post_code </td>");
			   pw.println("<td><input type='text' name='post-code' value='"+rs.getString(9)+"'></td>");
			   pw.println("</tr>");
			   pw.println("<tr>");
			   pw.println("<td><input type='submit' value='Edit'></td>");
			   pw.println("<td><input type='reset' value='Cancel'></td>");
			   
			   pw.println("</tr>");
			   
			   pw.print("</table>");
		       pw.println("</form>");
		       pw.println("</div>");
		       pw.println("</div>");
		      
		 }catch(Exception e) {
			 pw.println("<h1>"+e.getMessage()+"</h1>");
		 }
		 
		 pw.println("<a href='Index.html'> Home </a>");
		 
	 }


}
