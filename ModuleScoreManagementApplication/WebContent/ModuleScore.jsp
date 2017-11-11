<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	
		<style>
			tr,td{
			border:1px solid black;
			}
		</style>
	</head>
	
<link href = "main.css" rel = "stylesheet"/>
	
	<body>
	
		<%
		int traineeId = Integer.parseInt(session.getAttribute("traineeId").toString());
		String moduleName = session.getAttribute("moduleName").toString();
		int total = Integer.parseInt(session.getAttribute("total").toString());
		int grade = Integer.parseInt(session.getAttribute("grade").toString());
		%>
	
		<table align = "center">
			<tr>
				<td colspan = "2"><h3 align = "center"><u>Module Result:</u></h3></td>
			</tr>
			<tr>
				<td>Trainee Id: </td><td><%=traineeId %></td>
			</tr>
			<tr>
				<td>Module name: </td><td><%=moduleName %></td>
			</tr>
			<tr>
				<td>Total Score: </td><td><%=total %></td>
			</tr>
			<tr>
				<td>Grade: </td><td><%=grade %></td>
			</tr>
		</table>
		
		
		<h3><a href = "add.obj">Add Assessment Details</a></h3>
		
	</body>
	
</html>