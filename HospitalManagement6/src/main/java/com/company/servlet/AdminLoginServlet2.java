package com.company.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.dao.UserDaoImpl;


public class AdminLoginServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserDaoImpl userDao = new UserDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		if (userDao.isValidAdmin(name, password)) {
           // HttpSession session = request.getSession();
          //  session.setAttribute("name", name);
            request.setAttribute("name", name);
		     RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AppointmentServlet");
		     requestDispatcher.forward(request, response);
           // response.sendRedirect("AdminProfile.jsp");
            //System.out.println("Hi - "+username);
        } else {
            response.sendRedirect("AdminLogin.jsp?error=1");
        	System.out.println("Error A gya");
        }
	}

}
