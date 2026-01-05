package com.demo.complaint.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.demo.complaint.dao.ComplaintDAO;
import com.demo.complaint.dao.ComplaintDAOImpl;
import com.demo.complaint.model.Complaint;
import com.demo.complaint.model.User;

/**
 * Servlet implementation class AddComplaintServlet
 */
@WebServlet("/addComplaint")
public class AddComplaintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddComplaintServlet() {
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
	
	private ComplaintDAO complaintDAO = new ComplaintDAOImpl();  
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("loggedUser");
		
		Complaint c = new Complaint();
		c.setUserId(user.getUserId());
		c.setTitle(request.getParameter("title"));
		c.setDescription(request.getParameter("description"));
		
		
		complaintDAO.addComplaint(c);
		response.sendRedirect("viewComplaints");
		
		
	}
}
