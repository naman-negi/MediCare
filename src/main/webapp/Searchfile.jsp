<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.RetrieveHere.*"%>
<%@page import="java.util.List"%>
<%@page import="com.controller.*"%>
<%@page import="com.u.*"%>
<%@page import="java.util.regex.Matcher"%>
<%@page import="java.util.regex.Pattern"%>
<!DOCTYPE html>
<html>
<head>
<title>MediCare Search</title>


<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="CSS2/Searchfile.css" rel=stylesheet>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<meta charset="ISO-8859-1">


</head>
<body>






	<%
	if(request.getParameter("search")!=null){

		HttpSession s3 = request.getSession(false);
		User u = (User) s3.getAttribute("user");
	if (u == null) {

		s3.setAttribute("cart", (Object) "0");
		s3.setAttribute("Login", (Object) "Login");
		s3.setAttribute("Signup", (Object) "Signup");

	} else {
		if (u.getCart() == null) {
			s3.setAttribute("cart", (Object) "0");
			s3.setAttribute("Login", (Object) u.getUsername());
			s3.setAttribute("Signup", (Object) "logout");
		} else {
			String[] arr = u.getCart().split(" ");
			int k = 0;
			for (int i = 1; i <= (arr.length - 1);) {
		k = k + Integer.parseInt(arr[i]);
		i = i + 2;
			}
			s3.setAttribute("cart", (Object) Integer.toString(k));
			s3.setAttribute("Login", (Object) u.getUsername());
			s3.setAttribute("Signup", (Object) "Logout");

		}
	}
	%>



	<!-- Table 1 -->








	<div class="divtable">

		<table style="margin: auto; width: 100%; height: 100%">
			<tbody>

				<tr>

					<td align="left"><a href="Generalhome.jsp"><font
							class="FontEdit1">Home</font></a></td>


					<td style="width: 800px;">






						<form action="Searchfile.jsp">

							<input class="form-control" name="search" id="myInput"
								type="text" placeholder="Search..">

							<button type="submit" hidden></button>

						</form>





					</td>



					<td align="right">
						<%
						if (u == null) {
						%>
						<form action="SignupUser.jsp" method="post">
							<button class="button" type="submit">
								<font class="FontEdit2"><%=(String) s3.getAttribute("Signup")%></font>
							</button>
						</form> <%
 }
 %> <%
 if (u != null) {
 %>
						<form action="Userlogout" method="post">
							<button class="button" type="submit">
								<font class="FontEdit2"><%=(String) s3.getAttribute("Signup")%></font>
							</button>
						</form> <%
 }
 %> <%
 if (u == null) {
 %> <a href="LoginUser.jsp"> <font class="FontEdit2"><%=(String) s3.getAttribute("Login")%>
						</font>
					</a> <%
 }
 %> <%
 if (u != null) {
 %> <font class="FontEdit2"><%=(String) s3.getAttribute("Login")%></font>




						<form action="Cartpage.jsp" method="post">
							<button class="button" type="submit">
								<font class="FontEdit2">InCart:<%=(String) s3.getAttribute("cart")%></font>
							</button>
						</form> <%
 }
 %>

					</td>
				</tr>
			</tbody>
		</table>
	</div>






	<!-- Table 2 -->

	<% Productretrieve add_retrieve = new  Productretrieve ();
	    List<Medicinal> list = add_retrieve.retrievedata();

	    int length=0;
	    for (int i=0;i<list.size();i++) {%>

	    <%Pattern p = Pattern.compile((request.getParameter("search")).toLowerCase());%>
	    	<%Matcher matcher1 = p.matcher((list.get(i).getCompany()).toLowerCase());
	    	Matcher matcher2 = p.matcher((list.get(i).getMedicine_name()).toLowerCase());
	    	Matcher matcher3 = p.matcher((list.get(i).getDescription()).toLowerCase());%>
	    	<%if((matcher1.find())||(matcher2.find())||(matcher3.find())){

	    	length=length+1;%>

	     <%s3.setAttribute("str"+Integer.toString(length),(Object)list.get(i).getProductid());%>


	    	<%}%>
	<%} %>
	<%int n; %>
	<%length=1; %>

	<%if((String)(s3.getAttribute("str"+Integer.toString(length)))!=null){ %>
	<div class="divtable0">
		<table class="bigtable">
			<tbody>


				<%while((String)(s3.getAttribute("str"+Integer.toString(length)))!=null){ %>
				<tr>
				<%int m=0; %>
					<%for(;m<3;m++){ %>

					<%Productretrieve pd=new Productretrieve();%>
					<%Medicinal md=pd.productretrieve1((String)(s3.getAttribute("str"+Integer.toString(length))));%>
				
					



					<td>
					<div class="imghere">
					<img style="height: 200px; width: 250px;"
						src=<%=md.getImgurl()%>></div>

						<div class="tdhere">
						<p style="line-height:10px;">
						<font style="font-size: 10px;">

						<%=md.getMedicine_name()%><br/>
						<%=md.getPrice()%><br/>
						<%=md.getDescription()%><br/>

					    </font>
					    </p>

						<form action="Cartupdate2" method="post">

							<button class="button1" type="submit" name="productid5"
								value=<%=md.getProductid()%>>
								 <p style="line-height:5px;">
								<font style="color: black; font-size: 20px;">Add To Cart</font>
								</p>
							</button>
						</form>

						</div>
						</td>
						<%s3.removeAttribute((String)("str"+Integer.toString(length))); %>

				    <%length=length+1;
				    if ((String)(s3.getAttribute("str"+Integer.toString(length)))==null){
				    	break;
				    }

				      %>

					<%} %>

				</tr>
				<%length=length+3; %>
				<%if ((String)(s3.getAttribute("str"+Integer.toString(length)))==null){
			    	break;
			    } %>
			<%} %>
			</tbody>
		</table>
	</div>
 <%}else{ %>

	<%response.sendRedirect(request.getContextPath()+"/Generalhome.jsp");%>

<%} %>

<%}else{ %>
<%response.sendRedirect(request.getContextPath()+"/Generalhome.jsp");%>
<%} %>
</body>
</html>
