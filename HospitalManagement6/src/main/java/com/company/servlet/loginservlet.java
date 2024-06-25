package com.company.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.dao.UserDaoImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserDaoImpl userDao = new UserDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       String name = request.getParameter("name");
	        String email = request.getParameter("email");

	        if (userDao.isValidUser(name, email)) {
//	            HttpSession session = request.getSession();
//	            session.setAttribute("name", name);
//	            response.sendRedirect("Profile.jsp");
	            //System.out.println("Hi - "+username);
	        	 request.setAttribute("name", name);
			     RequestDispatcher requestDispatcher = request.getRequestDispatcher("/RetrieveServlet");
			     requestDispatcher.forward(request, response);
	        } else {
	            response.sendRedirect("login.jsp?error=1");
	        	System.out.println("Error A gya");
	        }
    }
}
