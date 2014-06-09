<%@ page language="java" contentType="text/html"%>
    <%@ page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%--Comentario desde JSP --%>
<!-- comentario desde html -->
<%@include file="cuco.jsp" %>

<%
String[] values={"test","test1","test2"};
String[] cocas={"coca","coca1","coca2"};

for(String value:values)
	out.println("<div>"+value+"</div>");

for(String coca:cocas){
	%>
	<div><%=coca %></div>
	<%
}

    out.println("Hola mundo "+new Date().toString());
%>

</body>
</html>