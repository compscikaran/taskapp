package com.domain.pack;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.data.pack.DataLayer;
import com.data.pack.Task;
import com.data.pack.TaskEnum;

/**
 * Servlet implementation class UpServ
 */
@WebServlet("/UpServ")
public class UpServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("tname") != null && request.getParameter("tdesc")!= null) {
			int tid = Integer.valueOf(request.getParameter("tid"));
			String name = request.getParameter("tname");
			String desc = request.getParameter("tdesc");
			String priority = request.getParameter("tpriority");
			Task t = new Task();
			t.setTid(tid);
			t.setName(name);
			t.setDescription(desc);
			t.setPriority(TaskEnum.valueOf(priority));
			DataLayer dl = new DataLayer();
			dl.updateTask(t);
			response.sendRedirect("home.jsp");
		} else {
			response.sendRedirect("add.jsp");
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
