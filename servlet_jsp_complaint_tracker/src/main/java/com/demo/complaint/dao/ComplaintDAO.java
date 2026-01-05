package com.demo.complaint.dao;
import java.util.*;
import com.demo.complaint.model.Complaint;

public interface ComplaintDAO {
	
	boolean addComplaint(Complaint complaint);
	
	List<Complaint> getComplaintByUser(int userId);
	
	
	// NEW (Admin)
	
	List<Complaint> getAllComplaints();
	
	boolean updateStatus(int complaintId, String status);
	
	
}
