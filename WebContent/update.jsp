<%@page import="com.data.pack.DataLayer"%>
<%@page import="com.data.pack.Task"%>
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
			<h3 style="text-align:center;">Update Task</h3>
		</div>
	</div>
	<br><br>
	<%
		int tid = Integer.valueOf(request.getParameter("tid"));
		DataLayer dl = new DataLayer();
		Task t = dl.fetchTask(tid);
	%>
	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-6">
		<form name="f1" method="POST" action="UpServ">
			<% 
			out.println("<label for=\"tname\">Name</label><br>");
			out.println("<input type=\"hidden\" name=\"tid\" value=\"" + t.getTid() + "\"/><br><br>");
			out.println("<input type=\"text\" name=\"tname\" value=\"" + t.getName() + "\"/><br><br>");
			out.println("<label for=\"tdesc\">Description</label><br>");
			out.println("<input type=\"text\" name=\"tdesc\" value=\"" + t.getDescription() + "\"/><br><br>");
			out.println("<label for=\"tpriority\">Priority</label><br>");
			out.println("<select name=\"tpriority\">" + 
				"<option value=\"Low\">Low</option>" + 
				"<option value=\"Medium\">Medium</option>" + 
				"<option value=\"High\">High</option>" + 
			"</select><br><br>");
			%>
			<input type="submit" class="btn btn-primary" value="Update Task"/>
		</form>
		</div>
		<div class="col-md-3"></div>
	</div>
</div>
</body>
</html>