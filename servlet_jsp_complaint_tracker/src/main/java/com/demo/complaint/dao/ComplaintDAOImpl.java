package com.demo.complaint.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import com.demo.complaint.model.Complaint;
import com.demo.complaint.util.DBConnectionUtil;

public class ComplaintDAOImpl implements ComplaintDAO{

	private static final String INSERT_SQL =
	        "INSERT INTO complaints (user_id, title, description, status) VALUES (?, ?, ?, ?)";

	private static final String SELECT_BY_USER =
	        "SELECT * FROM complaints WHERE user_id = ? ORDER BY created_at DESC";

	private static final String SELECT_ALL = "SELECT * FROM complaints ORDER BY created_at DESC";
	
	private static final String UPDATE_STATUS = "UPDATE complaints SET status = ? WHERE complaint_id = ?";
	
	@Override
	public boolean addComplaint(Complaint complaint) {
		try (Connection con = DBConnectionUtil.getConnection();
	             PreparedStatement ps = con.prepareStatement(INSERT_SQL)) {
			
			ps.setInt(1, complaint.getUserId());
			ps.setString(2, complaint.getTitle());
			ps.setString(3, complaint.getDescription());
			ps.setString(4, "OPEN");
			
			return ps.executeUpdate() > 0;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Complaint> getComplaintByUser(int userId) {
		// TODO Auto-generated method stub
		
		List<Complaint> list = new ArrayList<>();
		try (Connection con = DBConnectionUtil.getConnection();
	             PreparedStatement ps = con.prepareStatement(SELECT_BY_USER)) {
			
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Complaint c = new Complaint();
				c.setComplaintId(rs.getInt("complaint_id"));
				c.setUserId(rs.getInt("user_id"));
                c.setTitle(rs.getString("title"));
                c.setDescription(rs.getString("description"));
                c.setStatus(rs.getString("status"));
                c.setCreatedAt(rs.getTimestamp("created_at"));
                
                list.add(c);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		return list;
	}

	@Override
	public List<Complaint> getAllComplaints() {
		// TODO Auto-generated method stub
		List<Complaint> list = new ArrayList();
		
		 try (Connection con = DBConnectionUtil.getConnection();
	             PreparedStatement ps = con.prepareStatement(SELECT_ALL); 
				 ) {
			 ResultSet rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 Complaint c = new Complaint();
				 c.setComplaintId(rs.getInt("complaint_id"));
			        c.setUserId(rs.getInt("user_id"));
			        c.setTitle(rs.getString("title"));
			        c.setDescription(rs.getString("description"));
			        c.setStatus(rs.getString("status"));
			        c.setCreatedAt(rs.getTimestamp("created_at"));
			        list.add(c);
			 }
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		return list;
	}

	@Override
	public boolean updateStatus(int complaintId, String status) {
		// TODO Auto-generated method stub
		try (Connection con = DBConnectionUtil.getConnection();
	             PreparedStatement ps = con.prepareStatement(UPDATE_STATUS)) {
			ps.setString(1, status);
			ps.setInt(2, complaintId);
			
			return ps.executeUpdate() > 0;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}