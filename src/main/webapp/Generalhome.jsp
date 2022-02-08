<%@page import="com.RetrieveHere.*"%>
<%@page import="java.util.List"%>
<%@page import="com.controller.*"%>
<%@page import="com.u.*"%>
<!DOCTYPE html>
<html lang="en">
<head>


<title>MediCare Home</title>



<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<link href="CSS2/New.css" rel=stylesheet>


</head>
<body>


	<%
	HttpSession s3 = request.getSession(false);
	User u = (User) s3.getAttribute("user");
	s3.removeAttribute("Done");
	
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
			for (int i = 1; i <=(arr.length-1);) {
		k = k + Integer.parseInt(arr[i]);
		i = i + 2;
			}
			s3.setAttribute("cart", (Object) Integer.toString(k));
			s3.setAttribute("Login", (Object) u.getUsername());
			s3.setAttribute("Signup", (Object) "Logout");

		}
	}
	%>
	
	
	
	
	
	
	
	
	
	
	<!--Table 1-->

	
	
	
	
	
	
	
	
	
	
	
	
	
	<div class="divtable">

		<table style="margin: auto; width: 100%; height: 100%">
			<tbody>
			
			<tr>

				<td>
				
				
				
				
		
						</td>
			   
               
				 <td style="width: 800px;">
				 
				 <form action="Searchfile.jsp">
				 
				 <input class="form-control" name="search" id="myInput" type="text" placeholder="Search..">
					
				 <button type="submit" hidden>My</button>
				 
				 </form>
				
					</td>
					
					
					
			    	<td align="right">
			    	
			    	<% if (u == null) {%>
			     	<form action="SignupUser.jsp" method="post">
				    <button class="button" type="submit">
			     	<font class="FontEdit2"><%=(String)s3.getAttribute("Signup")%></font>
			     	</button>
			     	</form>
				  	<%}%>
				  	
				  	
				  	
				  	<% if (u != null) {%>
				  	<form action="Userlogout" method="post">
				    <button class="button" type="submit">
			     	<font class="FontEdit2"><%=(String)s3.getAttribute("Signup")%></font>
			     	</button>
			     	</form>
				  	<%}%>
				  	
				  	
				    <% if (u == null) {%>
			     		
			     	
			     	<a href="LoginUser.jsp">
			     	
			     	<font class="FontEdit2">&nbsp<%=(String) s3.getAttribute("Login")%>
			     	
			     	</font>
			     	</a>
					
			     	
				  	<%}%>
				  	
				  	
				  	
				  	<% if (u != null) {%>
				  
					<font class="FontEdit2">&nbsp<%=(String) s3.getAttribute("Login")%></font>
			     	
				  	
				  	
				  	
				  	<form action="Cartpage.jsp" method="post">
				    <button class="button" type="submit">
					<font class="FontEdit2">&nbspInCart:<%=(String) s3.getAttribute("cart")%></font>
			     	</button>
			     	</form>
			     	<%}%>

				</td>
				</tr>
			</tbody>
		</table>
	</div>









	<!--Table 2-->











	<div class="divtable2">
		<table class="bigtable">

			<tbody>

				<tr>
					<td style="width: 250px; text-align: center;"></td>

					<td rowspan="4" width="940px;" align="right;"
						style="text-align: center"><img src="medicines.jpg"
						width="800px;"></td>

				</tr>
				<tr>
					<td style="width: 250px; text-align: center;"></td>

				</tr>
				<tr>
					<td style="width: 250px; text-align: center;"></td>

				</tr>
				<tr>
					<td style="width: 250px; text-align: center;"></td>

				</tr>
			</tbody>
		</table>


	</div>
	
	
	
	
	
	
	
	
	
	
	
	
	<!--Table 3-->












	<%
	Productretrieve add_retrieve = new Productretrieve();
	List<Medicinal> list = add_retrieve.retrievedata();
	
	%>



	<div class="divtable3">

		<table class="bigtable2">



			<tbody>
				<tr>

					<%
					int i = 0;
					%>
					<td style="text-align: center"><img
						src=<%=list.get(i).getImgurl()%> height="180px" width="160px" /></td>
					<td style="width: 115px;"><font style="font-size: 12px;">Price:<%=list.get(i).getPrice()%>,
							Medicine: <%=list.get(i).getMedicine_name()%>, Company:<%=list.get(i).getCompany()%>,
							ExpiryDate:<%=list.get(i).getExpiry_date()%>
					</font></td>

					<%
					i = i + 1;
					%>
					<td style="text-align: center"><img
						src=<%=list.get(i).getImgurl()%> height="180px" width="160px" /></td>
					<td style="width: 115px;"><font style="font-size: 12px;">Price:<%=list.get(i).getPrice()%>,
							Medicine: <%=list.get(i).getMedicine_name()%>, Company:<%=list.get(i).getCompany()%>,
							ExpiryDate:<%=list.get(i).getExpiry_date()%>
					</font></td>


					<%
					i = i + 1;
					%>
					<td style="text-align: center"><img
						src=<%=list.get(i).getImgurl()%> height="180px" width="160px" /></td>
					<td style="width: 115px;"><font style="font-size: 12px;">Price:<%=list.get(i).getPrice()%>,
							Medicine: <%=list.get(i).getMedicine_name()%>, Company:<%=list.get(i).getCompany()%>,
							ExpiryDate:<%=list.get(i).getExpiry_date()%>
					</font></td>
				</tr>



				<tr>
								
				
					<%int n= 0;
					
					%>
					<td colspan="2" style="height: 100px;"><font
						style="font-size: 13px;"><%=list.get(n).getDescription()%></font>
						<br /> <br />


						<form action="Cartupdate2" method="post">
						
							 <button  type="Submit" class="button"  name="productid5" value=<%=list.get(n).getProductid()%>>
							 <font style="color: white;">Add To Cart</font>	
						     </button>
								
						
						</form>
						
						</td>

					<%
					n = n + 1;
					
					%>
					<td colspan="2" style="height: 100px;"><font
						style="font-size: 13px;"><%=list.get(n).getDescription()%></font>
						<br /> <br />


						<form action="Cartupdate2" method="post">
						
							 <button  type="Submit" class="button"  name="productid5" value=<%=list.get(n).getProductid()%>>
							 <font style="color: white;">Add To Cart</font>	
						     </button>
								
						
						</form>
						
						</td>

					<%
					n = n + 1;
				
					%>
					<td colspan="2" style="height: 100px;"><font
						style="font-size: 13px;"><%=list.get(n).getDescription()%></font>
						<br /> <br />


						<form action="Cartupdate2" method="post">
						
							 <button  type="Submit" class="button"  name="productid5" value=<%=list.get(n).getProductid()%>>
							 <font style="color: white;">Add To Cart</font>	
						     </button>
								
						
						</form>
						
						</td>
					
				</tr>




			</tbody>
		</table>

	</div>

	

</body>
</html>