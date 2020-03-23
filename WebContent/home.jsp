<%@page import="com.data.pack.BacklogEnum"%>
<%@page import="com.data.pack.DataLayer"%>
<%@page import="com.data.pack.Task"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<jsp:include page="header.html"></jsp:include>
</div>
<br><br><br>
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<h3 style="text-align:center;">All Tasks</h3>
		</div>
	</div>
	<br><br><br>
		
		<% 
		DataLayer dl = new DataLayer();
		ArrayList<Task>  tlist = dl.returnTasks();
		for(Task t: tlist) {
			out.println("<div class=\"row\"");
			if(t.getStatus().name().equalsIgnoreCase(BacklogEnum.Todo.name()))
			{
			out.println("<div class=\"col-md-4 taskbox\">");
			if(t.getPriority().name().equals("Low")) {
				out.println("<div class=\"card\"><div class=\"card-header low\">");	
			} else if(t.getPriority().name().equals("Medium")) {
				out.println("<div class=\"card\"><div class=\"card-header medium\">");
			} else {
				out.println("<div class=\"card\"><div class=\"card-header high\">");
			}
			out.println(t.getPriority().name());
			out.println("</div><div class=\"card-body\"><h5 class=\"card-title\">");
			out.println(t.getName());
			out.println("</h5><p class=\"card-text\">");
			out.println(t.getDescription());
			out.println("<form action=\"DelServ\" method=\"POST\">");
			out.println("<input type=\"hidden\" name=\"tid\" value=\"" + t.getTid() + "\"/>");
			out.println("<input type=\"submit\" class=\"btn btn-primary\" value=\"Delete\"/>");
			out.println("</form><br>");
			out.println("<form action=\"update.jsp\" method=\"POST\">");
			out.println("<input type=\"hidden\" name=\"tid\" value=\"" + t.getTid() + "\"/>");
			out.println("<input type=\"submit\" class=\"btn btn-primary\" value=\"Update\"/>");
			out.println("</form>");
			out.println("</p></div></div></div>");
			}
			out.println("</div>");
		}
		
		%>
		
</div>
</body>
</html>