<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link href = "main.css" rel = "stylesheet"/>

</head>

<body>

<form action="getDetails.obj">
<table align = "center" cellpadding="5" class = "insert">

	<tr>
	<td colspan = "2"><h1><u>Add Assessment Details</u></h1></td>
	</tr>

	<tr></tr>
	<tr></tr>
	
	<tr>
	<td>Trainee Id: </td>
	
	<td>
	
	
	<select id="traineeId"  name = "traineeId">
	
	<c:forEach items = "${sessionScope.idList}" var = "list">
		<option><c:out value="${list}"></c:out></option>
	</c:forEach>
			
	</select>
	</td>
	</tr>
	
	
	<tr>
	<td>Module Name: </td>
	
	<td>
	
	
	<select id="module"  name = "module">
			<option value="Module1">Module1 </option>
			<option value="Module2">Module2</option>
			<option value="Module3">Module3</option>
			<option value="Module4">Module4</option>
			<option value="Module5">Module5</option>
			
	</select>
	</td>
	</tr>
	
	<tr><td>MPT: </td><td><input type = "text" name = "mpt" pattern="[0-9]{1,}" required></td></tr>
	<tr><td>MTT: </td><td><input type = "text" name = "mtt" pattern="[0-9]{1,}" required></td></tr>
	<tr><td>Assignment: </td><td><input type = "text" name = "assignment" pattern="[0-9]{1,}" required></td></tr>
	
	<tr><td></td><td><input type = "submit" value = "submit"></td></tr>
</table>



</form>
</body>

</html>