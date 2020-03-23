package com.data.pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;

public class DataLayer {
	
	private Connection conn = null;
	
	public DataLayer() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/taskdb", "karan", "karan184");
		} catch(SQLException | ClassNotFoundException e) {
			System.out.println("MySQL Connection did not work");
		}
	}
	
	public ArrayList<Task> returnTasks() {
		ArrayList<Task> tlist = new ArrayList<Task>();
		Statement st;
		try {
			st = conn.createStatement();
			String sql = "SELECT * FROM tasks";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				Task t = new Task();
				t.setTid(rs.getInt(1));
				t.setName(rs.getString(2));
				t.setDescription(rs.getString(3));
				t.setPriority(TaskEnum.valueOf(rs.getString(4)));
				t.setStatus(BacklogEnum.valueOf(rs.getString(5)));
				tlist.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tlist;
	}
	
	public void insertTask(Task t) {
		String sql = "INSERT INTO tasks(name,description,priority) VALUES(?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, t.getName());
			ps.setString(2, t.getDescription());
			ps.setObject(3, t.getPriority().name());
			ps.setObject(4, BacklogEnum.Todo.name());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateTask(Task t) {
		String sql = "UPDATE tasks SET name = ?, description= ?, priority = ? WHERE tid = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, t.getName());
			ps.setString(2, t.getDescription());
			ps.setString(3, t.getPriority().name());
			ps.setInt(4, t.getTid());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteTask(int tid) {
		String sql = "DELETE FROM tasks WHERE tid = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, tid);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Task fetchTask(int tid) {
		String sql = "SELECT * FROM tasks WHERE tid=" + tid;
		Task t = new Task();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			t.setTid(tid);
			while(rs.next()) {
				t.setName(rs.getString(2));
				t.setDescription(rs.getString(3));
				t.setPriority(TaskEnum.valueOf(rs.getString(4)));
				t.setStatus(BacklogEnum.valueOf(rs.getString(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t;
	}
	
	public void moveToDoing(int tid) {
		String sql = "UPDATE tasks set status = 'Doing' WHERE tid = ?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, tid);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void moveToDone(int tid) {
		String sql = "UPDATE tasks set status = 'Done' WHERE tid = ?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, tid);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void moveToTodo(int tid) {
		String sql = "UPDATE tasks set status = 'Todo' WHERE tid = ?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, tid);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}