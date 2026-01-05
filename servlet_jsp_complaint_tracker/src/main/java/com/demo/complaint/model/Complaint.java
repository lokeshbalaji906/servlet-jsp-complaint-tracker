package com.demo.complaint.model;

import java.sql.Timestamp;

public class Complaint {
	
	private int complaintId;
	private int userId;
	private String title;
	private String description;
	private String status;
	private Timestamp createdAt;
	
	public Complaint() {
		
	}

	public Complaint(int complaintId, int userId, String title, String description, String status,
			Timestamp createdAt) {
		super();
		this.complaintId = complaintId;
		this.userId = userId;
		this.title = title;
		this.description = description;
		this.status = status;
		this.createdAt = createdAt;
	}

	public int getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Complaint [complaintId=" + complaintId + ", userId=" + userId + ", title=" + title + ", description="
				+ description + ", status=" + status + ", createdAt=" + createdAt + "]";
	}
}
