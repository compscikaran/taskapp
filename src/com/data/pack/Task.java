package com.data.pack;

public class Task {
	private int tid;
	private String name;
	private String description;
	private TaskEnum priority;
	
	public int getTid() {
		return tid;
	}
	
	public void setTid(int tid) {
		this.tid = tid;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public TaskEnum getPriority() {
		return priority;
	}
	
	public void setPriority(TaskEnum priority) {
		this.priority = priority;
	}
		
}
