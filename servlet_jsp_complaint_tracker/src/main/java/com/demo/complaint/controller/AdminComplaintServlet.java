package com.demo.complaint.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.demo.complaint.dao.ComplaintDAO;
import com.demo.complaint.dao.ComplaintDAOImpl;
import com.demo.complaint.model.Complaint;
import com.demo.complaint.model.User;

/**
 * Servlet implementation class AdminComplaintServlet
 */
@WebServlet("/admin/complaints")
public class AdminComplaintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminComplaintServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    private ComplaintDAO complaintDAO = new ComplaintDAOImpl();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session = request.getSession(false);
		User user = (User)session.getAttribute("loggedUser");
		
		if(user == null || !"ADMIN".equals(user.getRole())) {
			response.sendRedirect("../login.jsp");
			return;
		}
		
		List<Complaint> list = complaintDAO.getAllComplaints();
		request.setAttribute("complaints", list);
		
		try {
			request.getRequestDispatcher("/admin-complaints.jsp")
				.forward(request, response);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
