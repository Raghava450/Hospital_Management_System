package com.company.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dao.User;
import com.company.dao.UserDaoImpl;

/**
 * Servlet implementation class RegisterServlet
 */
public class registerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserDaoImpl userDao =new UserDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
			 public registerservlet() {
	       
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String name = request.getParameter("name");
	        String phone = request.getParameter("phone");
	        String email = request.getParameter("email");
	        String area = request.getParameter("area");
	        String city = request.getParameter("city");
	        String state = request.getParameter("state");
	        String date = request.getParameter("date");
	        String time = request.getParameter("time");
	        String post_code = request.getParameter("post-code");
	        PrintWriter pw=response.getWriter();
	      

	        User user = new User();
	        user.setName(name);
	        user.setEmail(email);
	        user.setPhone(phone);
	        user.setArea(area);
	        user.setCity(city);
	        user.setState(state);
	        user.setDate(date);
	        user.setTime(time);
	        user.setPost_code(post_code);

	        if(userDao.isValidDate(date, time)) {
			pw.println("In the Date And Time You Mentioned,Another Appointment Is Already Registered.");
			pw.println("Kindly,Try Again With Another Date Or Time.");
	        }
	        else {
	        	//UserDao userDao = new UserDaoImpl();
		        if (userDao.addUser(user)) {
		            response.sendRedirect("login.jsp?registration=success");
		        } else {
		            response.sendRedirect("appointment.jsp?error=1");
		        }
	        }
	}

}
