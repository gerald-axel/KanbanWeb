<%@ page language="java" contentType="text/html"%>
  <%@ page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<script>
window.alert("Inicia tu super codigo");
</script>
<body>
	<script>
	function validate(){
		var title=document.forms["task_form"]["title"].value;
		var description=document.forms["task_form"]["description"].value;
		var owner=document.forms["task_form"]["owner"].value;
		var duedate=document.forms["task_form"]["duedate"].value;
		var category=document.forms["task_form"]["category"].value;
		var priority=document.forms["task_form"]["priority"].value;

		if(!title||!description||!owner||!duedate||!category||!priority){
			alert("Something is missing");
			return false;
		}
		return true;		
	}
	</script>

<form name="task_form" method="POST" action="AddTask" onsubmit="return validate()">
	<table>
		<tr>
			<td>Title:</td>
			<td><input type="text" name="title"/></td>			
	</tr>
	
	<tr>
	        <td>Description:</td>
			<td><input type="text" name="description"/></td>			
	</tr>
	
	<tr>
	        <td>Category:</td>
			<td><input type="text" name="category"/></td>
	</tr>
	
	<tr>
	        <td>Owner:</td>
			<td><input type="text" name="owner"/></td>
	</tr>
	
	<tr>
	        <td>Priority:</td>
			<td><input type="text" name="priority"/></td>
	</tr>
	
	<tr>
	        <td>State:</td>
			<td><select name="state">
				<option value="BACKLOG"selected>BackloG</option>
				<option value="TO_DO">To do</option>
				<option value="IN_PROGRESS">In progress</option>
				<option value="DONE">done</option>
				</select>
				</td>
	</tr>
	
	<tr>
	        <td>Due date:</td>
			<td><input type="text" name="duedate"/></td>
	</tr>
	
	<tr>
				<td colspan="2">
				<input type="submit" value="Add"/>
				</td>
				</tr>
	
	</table>
</form>
</body>
</html>