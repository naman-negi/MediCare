<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form id="GFG" action="Generalhome.jsp" method="post">

		Payment is made Successfully<br /> <br /> <a href="#"
			onclick="myFunction()">Continue Shopping</a>

	</form>

	<script>
	
		function myFunction() {
			document.getElementById("GFG").submit();
		}
		
	</script>

</body>
</html>