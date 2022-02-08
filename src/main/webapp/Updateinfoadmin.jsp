<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.RetrieveHere.*"%>
<%@page import="com.controller.*"%>
<%@page import="com.adding.*"%>
<%@page import="com.deletion.*"%>
<%@page import="javax.servlet.http.HttpSession"%>




<!DOCTYPE html>

<html>

<head>






<title>Update Information</title>

<link href="CSS3/CreateNew.css" rel="stylesheet" />
<link href="CSS2/bootstrap-table.min0.css" rel="stylesheet" />
<link href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
	rel="stylesheet" />
<link href="CSS2/bootstrap-table.min.css" rel="stylesheet" />

</head>

<body>


	<div id="add_data_Modal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<div class="modal-body">

					<form action="Updatinghere" method="post" id="insert_form">

						<%Retrieve dat=new Retrieve() ;
   Medicinal medicinal=dat.productretrieve1(request.getParameter("productid2"));
   String str=request.getParameter("productid2");
   %>

						<%HttpSession s1=request.getSession(false);
     s1.setAttribute("Check",(Object)(medicinal.getProductid())); %>

						<br /> <label>ProductID</label> <input name="productid2"
							type="text" class="form-control"
							value="<%=medicinal.getProductid()%>"> <br /> <label>Company</label>
						<input name="company2" type="text" class="form-control"
							value="<%=medicinal.getCompany()%>"> <br /> <label>Medicine_name</label>
						<input name="medicine_name2" type="text" class="form-control"
							value="<%=medicinal.getMedicine_name()%>"> <br /> <label>Expiry_date</label>
						<input type="text" name="expiry_date2" type="text"
							class="form-control" value="<%=medicinal.getExpiry_date()%>">

						<br /> <label>Category</label> <input type="text"
							name="category2" type="text" class="form-control"
							value="<%=medicinal.getCategory()%>"> <br /> <label>Description</label>
						<input type="text" name="description2" type="text"
							class="form-control" value="<%=medicinal.getDescription()%>">

						<br /> <label>Quantity</label> <input type="text"
							name="quantity2" type="text" class="form-control"
							value="<%=medicinal.getQuantity()%>"> <br /> <label>Price</label>
						<input type="text" name="price2" type="text" class="form-control"
							value="<%=medicinal.getPrice()%>"> <br /> <label>Imageurl</label>
						<input type="text" name="imgurl2" type="text" class="form-control"
							value="<%=medicinal.getImgurl()%>"> <br /> <input
							name="submithere" type="submit" value=" Register "> <br />
						<br />


					</form>

				</div>
			</div>
		</div>
	</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
		
		
<script type="text/javascript">


$(document) . ready (function(){

$('#add_data_Modal' ).modal('show');
});
</script>
</body>
</html>
