package com.demo.complaint.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

import java.io.IOException;

import com.demo.complaint.dao.UserDAO;
import com.demo.complaint.dao.UserDAOImpl;
import com.demo.complaint.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	private UserDAO userDAO = new UserDAOImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		// Temporary Logic
//		if("admin@gmail.com".equals(email) && "admin".equals(password)) {
//			response.sendRedirect("dashboard.jsp");
//		}else {
//			response.sendRedirect("login.jsp");
//		}
		
		User user = userDAO.login(email, password);
		
		if(user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loggedUser", user);
			response.sendRedirect("dashboard.jsp");
		}else {
			response.sendRedirect("login.jsp");
		}
	}
}