<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.RetrieveHere.*"%>
    <%@page import="com.controller.*"%>
    <%@page import="com.adding.*"%>
    <%@page import="com.deletion.*"%>  
    <%@page import="javax.servlet.http.HttpSession" %>
   
    
    

<!DOCTYPE html>

<html>

<head>
<title>Update Information</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>  
    <link href="CSS3/Uploadimage.css"  rel="stylesheet"/>
    <link href="CSS2/bootstrap-table.min0.css" rel="stylesheet"/>
    <link href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" rel="stylesheet"/>
    <link href="CSS2/bootstrap-table.min.css" rel="stylesheet"/>

</head>

<body>
 <%HttpSession s=request.getSession(false);%>
 <%s.setAttribute("productid6",(Object)request.getParameter("productid6"));%>
    
<div id="add_data_Modal" class="modal fade">
 <div class="modal-dialog">
  <div class="modal-content">
   <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal">&times;</button>
   </div>
  
   <div class="modal-body">
   
   
    
    
    
    <form action="FileUploadHandler" method="post" id="insert_form" enctype="multipart/form-data">
    
        
     <label>Image_URL</label><br />
     
     <input type="file" name="image_file" id="fileToUpload">  
     
     <br />
     <input name="Upload" type="submit" value=" Register ">
     

    </form>
     
 </div>
  </div>
 </div>
</div>



<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" ></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" ></script>
        <script type="text/javascript">
$(document) . ready (function(){

$('#add_data_Modal' ).modal('show');
});
</script>   
</body>
</html>
