<%@page import="org.jboss.logging.MDC"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="com.RetrieveHere.*"%>
<%@page import="java.util.List"%>
<%@page import="com.controller.*"%>
<%@page import="com.u.*"%>

<html>

<head>

<meta charset="utf-8">
<title>Trial Database</title>


<link href="CSS2/bootstrap-table.min0.css" rel="stylesheet" />
<link href="CSS3/CreateNew.css" rel="stylesheet" />
<link href="CSS2/AdminDatabase.css" rel="stylesheet" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>

<link href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" rel="stylesheet" />
<link href="CSS2/bootstrap-table.min.css" rel="stylesheet" />

</head>
<body>


	<%HttpSession s3 = request.getSession(false);%>
	
	<% if(((String)s3.getAttribute("username"))!= null) {%>

   	<%s3.setAttribute("Logout", (Object)"Logout");%>
		
		
		
	<div class="NewContainer">
		<div class="box">



			
	
	<div class="divtable">

		<table style="margin: auto; width: 100%; height: 100%">
			<tbody>
			
			<tr>

				<td align="left">
				
				
					<font class="FontEdit2">Admin Database</font>
				
		
						</td>
			   
               
				 <td style="width: 800px;">
				 
			     
				
					</td>
					
					
					
			    	<td align="right">
			    	
			    	
				  	
				  	
				  	
				  
				  	<form action="Logouthere" method="post">
				    <button class="button" type="submit">
			     	<font class="FontEdit2"><%=(String)s3.getAttribute("Logout")%></font>
			     	</button>
			     	</form>
				  				  	
							  	
				  	
				  	
				</td>
				</tr>
			</tbody>
		</table>
	</div>








			<div class="container mt-2 mb-2">


				<table data-toggle="table" data-pagination="true" data-search="true">


					<thead>
						<tr>

							<th data-field="productid" data-sortable="true">ProductID</th>
							<th data-field="company" data-sortable="true">Company</th>
							<th data-field="medicine_name" data-sortable="true">Medicine_name
							</th>
							<th data-field="expiry_date" data-sortable="false">Expiry_date
							</th>
							<th data-field="category" data-sortable="true">Category</th>
							
							<th data-field="description" data-sortable="false" style="width:109px; height:160px;">
							Description
							</th>
							
							<th data-field="quantity" data-sortable="true">Quantity</th>
							<th data-field="prices" data-sortable="false">Price</th>
							<th data-field="update" data-sortable="false">Update</th>
							<th data-field="delete" data-sortable="false">Delete</th>
						</tr>
					</thead>
					<tbody>

						<%
  Retrieve add_retrieve = new  Retrieve ();
  List<Medicinal> list = add_retrieve.retrievedata(); 
               for (int i=0;i<list.size();i++) { %>

						<tr>

							<td><%=list.get(i).getProductid()%></td>
							<td><%=list.get(i).getCompany()%></td>
							<td><%=list.get(i).getMedicine_name()%> <br /> 
							
							<img src=<%=list.get(i).getImgurl()%> height="60px" width="60px" />
							<form action="Uploadimage.jsp" method="post" id="insert_form">
						    
						    <button name="productid6" value=<%=list.get(i).getProductid()%>
										type="submit" >Update</button>
						    
						    
						    </form> 
							</td>
							
							<td><%=list.get(i).getExpiry_date()%></td>
							<td><%=list.get(i).getCategory()%></td>
							<td ><font style="font-size:10px;"><%=list.get(i).getDescription()%></font></td>
							<td><%=list.get(i).getQuantity()%></td>
							<td><%=list.get(i).getPrice()%></td>
							<td>

								<form action="Updateinfoadmin.jsp" method="post">

									<button name="productid2" value=<%=list.get(i).getProductid()%>
										type="submit" class="button0">Update</button>

								</form>

							</td>

							<td>
								<form action="Del" method="post">
									<button name="product1" value=<%=list.get(i).getProductid()%>
										type="submit" class="button0">

										<img src="bin.png" height="40px" width="40px" />

									</button>


								</form>

							</td>

						</tr>
						<%}%>
					</tbody>
				</table>

			</div>
			</div>
		</div>

		<div class="box overlay">
			<button class="button " type="submit" name="submit"
				data-toggle="modal" data-target="#add_data_Modal">
				<font class="FontEdit">ADD Data</font>
			</button>

		</div>


	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<script src="bootstrap-table.min.js"></script>



	<div id="add_data_Modal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<div class="modal-body">

					<form action="Addinghere" method="post" id="insert_form">
						<br />
						<br /> <label>ProductID</label> <input name="productid"
							type="text" class="form-control"
							value=<%=request.getParameter("productid") %> /> <br /> <label>Company</label>
						<input name="company" class="form-control"
							value=<%= request.getParameter("company")  %> /> <br /> <label>Medicine_name</label>
						<input name="medicine_name" class="form-control"
							value=<%=request.getParameter("medicine_name") %> /> <br /> <label>Expiry_date</label>
						<input type="text" name="expiry_date" class="form-control"
							value=<%= request.getParameter("expiry_date") %> /> <br /> <label>Category</label>
						<input type="text" name="category" class="form-control"
							value=<%= request.getParameter("category")%> /> <br /> <label>Description</label>
						<input type="text" name="description" class="form-control"
							value=<%= request.getParameter("description")%> /> <br /> <label>Quantity</label>
						<input type="text" name="quantity" class="form-control"
							value=<%= request.getParameter("quantity")%> /> <br /> <label>Price</label>
						<input type="text" name="price" class="form-control"
							value=<%=request.getParameter("price") %> /> <br /> <input
							name="submithere" type="submit" value=" Register "> <br />
						<br />

					</form>





				</div>
			</div>
		</div>
	</div>

<% } else {%>

		<%response.sendRedirect(request.getContextPath()+"/LoginAdmin.jsp");%>

	<%} %>

</body>


</html>


