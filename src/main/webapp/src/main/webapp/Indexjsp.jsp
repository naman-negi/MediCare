<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Hello from HTML</h1>
<%="<h1>Hello from JSP</h1>"%>
<%int x=10; %>
<input type="button" value=<%=x%>>
</br>

</br>
<%@include file="footer.html"%>
<%=new Date()%>
</br>
<form action="">
<input type="text" name="fname">
<input type="submit" name="click" value="click me">
</form>
<div align="right">
<button type="button" name="age" id="age" data-toggle="modal" data-target="#add_data_Modal" class="btn btn-warning">Add</button>
</div>
</body>

<div id="add_data_Modal">
<form method="post">
<% 
out.println("Hello:");
%>
<br />
<input type="submit" name="insert" value="Insert"/>
</form>
</div>

</html>
<!-- if (request.getParameter("click")!=null){ -->
<!--  +request.getParameter("fname") -->


 <%
for (int i=0; i<10; i++){
	out.print("</br>i="+(i+1));
}
%> 