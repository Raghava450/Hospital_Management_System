package com.company.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public MsgServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long phone=Long.valueOf(request.getParameter("phone"));
		PrintWriter pw=response.getWriter();
		pw.println("<a href='sms:+91"+phone+"?body=Hello%20world!'><button id='connectBtn'>Connect</button></a>");

	}

}
