<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="com.RetrieveHere.*"%>
<%@page import="java.util.List"%>
<%@page import="com.controller.*"%>
<%@page import="com.u.*"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<meta charset="utf-8">

<meta name="viewport" content="width=device-width, initial-scale=1">


<link href="CSS3/CartpageNew2.css" rel=stylesheet>

<link href="CSS3/CartpageNew.css" rel=stylesheet>

<link href="CSS2/bootstrap-table.min0.css" rel="stylesheet" />
<link href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
	rel="stylesheet" />
<link href="CSS2/bootstrap-table.min.css" rel="stylesheet" />

<title>User Cart Page</title>


</head>
<body>
	<%
	HttpSession s3 = request.getSession(false);
	User u = (User) s3.getAttribute("user");
	%>
	<%
	if (u.getCart() != null) {
	%>
	<%
	String[] arr3 = u.getCart().split(" ");
	int k = 0;
	for (int i = 1; i <= (arr3.length - 1);) {
		k = k + Integer.parseInt(arr3[i]);
		i = i + 2;
	}
	s3.setAttribute("cart", (Object) Integer.toString(k));
	s3.setAttribute("Login", (Object) u.getUsername());
	s3.setAttribute("Signup", (Object) "Logout");
	%>



	<!--Table 1-->

	<div class="divtable">

		<table style="margin: auto; width: 100%; height: 100%">
			<tbody>
				<tr>
					<td><a href="Generalhome.jsp"><font class="FontEdit1">Home</font></a>




					</td>

					<td><input class="form-control" id="myInput" type="text"
						placeholder="Search.." />

						<button type="submit" hidden>My</button></td>

					<td align="right">
						<%
						if (u != null) {
						%>

						<form action="Userlogout" method="post">
							<button class="button" type="submit">
								<font class="FontEdit2"><%=(String) s3.getAttribute("Signup")%></font>
							</button>
						</form> <%
 }
 %> <%
 if (u != null) {
 %> <font class="FontEdit2"><%=(String) s3.getAttribute("Login")%></font>

						<%
						}
						%> <font class="FontEdit2">InCart:<%=(String) s3.getAttribute("cart")%></font>

					</td>

				</tr>
			</tbody>
		</table>
	</div>

	<%
	String[] arr = u.getCart().split(" ");
	%>










	<div class="paydiv">

		<button class="button0" type="submit" name="submit"
			data-toggle="modal" data-target="#add_data_Modal">
			<font style="font-size: 20px;">Add Details and Pay</font>
		</button>

	</div>















	<div class="container">
		<div class="divtable2">
			<table class="bigtable3">

				<tbody>
					<%
					String[] str = new String[100];
					int m = 0;
					%>
					<%
					for (int i = 0; i < arr.length;) {
						Productretrieve pd = new Productretrieve();
						Medicinal md1 = pd.productretrieve(arr[i]);
					%>
					<tr>
						<td style="width: 200px; height: 200px;"><img
							style="width: 200px; height: 200px;" alt="ImageHere"
							src=<%=md1.getImgurl()%>></td>
						<td style="width: 750px;">Name:<%=md1.getMedicine_name()%> <br />
							Company:<%=md1.getCompany()%> <br /> Price:<%=md1.getPrice()%> <br />
							Quantity:
							<form action="Cartupdate" method="post">
								<select name="quantity" id="myselect"
									onchange="this.form.submit()">

									<%
									str[m] = arr[i];
									%>

									<%
									if (i < (arr.length - 1)) {

										i = i + 1;

									}
									%>

									<option><%=arr[i]%></option>

									<option value="<%=str[m]%> 1">1</option>
									<option value="<%=str[m]%> 2">2</option>
									<option value="<%=str[m]%> 3">3</option>
									<option value="<%=str[m]%> 4">4</option>
									<option value="<%=str[m]%> 5">5</option>
									<option value="<%=str[m]%> 6">6</option>
									<option value="<%=str[m]%> 7">7</option>
									<option value="<%=str[m]%> 8">8</option>
									<option value="<%=str[m]%> 9">9</option>
									<option value="<%=str[m]%> 10">10</option>


								</select>
							</form>

							<form action="Cartdelete" method="post">

								<button class="button" type="submit"
									value="<%=md1.getProductid()%>" name="delete">
									<font class="FontEdit2">Delete</font>
								</button>

							</form>
						</td>

					</tr>
					<tr>
						<td colspan="2" height="50px"><%=md1.getDescription()%></td>
					</tr>
					<%
					i = i + 1;
					%>
					<%
					m = m + 1;
					%>
					<%
					}
					%>
				</tbody>
			</table>


		</div>
		<div class="box overlay">

			<table class="bigtable">

				<tbody>

					<tr>
						<%
						m = 0;
						%>
						<td rowspan="4" style="width: 250px;">
							<%
							for (int i = 0; i < arr.length;) {
								Productretrieve pd = new Productretrieve();
								Medicinal md1 = pd.productretrieve(arr[i]);%> <%=md1.getMedicine_name()%><br />
							<%String[] arr2 = md1.getPrice().split(" ");%> Total Price:<%=(Integer.parseInt(arr2[0]) * Integer.parseInt(arr[i + 1]))%><br />
							<br /> <%m = m + (Integer.parseInt(arr2[0]) * Integer.parseInt(arr[i + 1]));%>
							<br /> <br /> <%i = i + 2;%> <%}%> Grand Total:<%=m%> <%request.setAttribute("m", (Object) m);%>

						</td>

					</tr>
					<tr>

					</tr>
					<tr>

					</tr>
					<tr>

					</tr>

				</tbody>

			</table>

		</div>

	</div>






















	<div id="add_data_Modal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<div class="modal-body">

					<form action="Validateandpay" method="post" id="insert_form">
						<br /> <label>Add Card Number</label><br /> <input
							name="cardnumber" type="text" class="form-control" /><br /> <label>Add
							Address</label><br /> <input name="address" class="form-control" /><br />
						<button class="button1" type="submit" name="submit">
							<font style="font-size: 20px;">Pay</font>
						</button>
					</form>
				</div>
			</div>
		</div>
	</div>



	<%
	} else {
	%>

	<%
	response.sendRedirect(request.getContextPath() + "/Generalhome.jsp");
	%>

	<%
	}
	%>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>