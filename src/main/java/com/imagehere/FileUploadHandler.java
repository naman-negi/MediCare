package com.imagehere;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

 
/**
 * A Java servlet that handles file upload from client.
 *
 * @author www.codejava.net
 */
public class FileUploadHandler extends HttpServlet {
    private static final long serialVersionUID = 1L;
     
    // location to store file uploaded
    private static final String UPLOAD_DIRECTORY ="";
 
    // upload settings
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 300;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 400; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 500; // 50MB
 
    /*
     * Upon receiving file upload submission, parses the request to read
     * upload data and saves the file on disk.
     */
    protected void service (HttpServletRequest request,
    HttpServletResponse response) throws ServletException, IOException {
    	
    	HttpSession s=request.getSession(false);

    	
        if (!ServletFileUpload.isMultipartContent(request)) {
            
            PrintWriter writer = response.getWriter();
            writer.println("Error: Form must has enctype=multipart/form-data.");
            writer.flush();
            return;
        }
 
     
        DiskFileItemFactory factory = new DiskFileItemFactory();
       
        factory.setSizeThreshold(MEMORY_THRESHOLD);
   
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
    
        
        ServletFileUpload upload = new ServletFileUpload(factory);
         
   
        upload.setFileSizeMax(MAX_FILE_SIZE);
         

        upload.setSizeMax(MAX_REQUEST_SIZE);
 
     
        String uploadPath = getServletContext().getRealPath("")
                + File.separator + UPLOAD_DIRECTORY;
         
  
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
 	 
        try {
    
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);
 
              
                for (FileItem item : formItems) {
             
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        String filePath = uploadPath + File.separator + fileName;
                        
                        File storeFile = new File(filePath);
               		   

                 
                        item.write(storeFile);
                        new ReturnName(fileName,(String)(s.getAttribute("productid6")));
                    }
                }
    
       
   		 
        } catch (Exception ex) {
            request.setAttribute("message",
                    "There was an error: " + ex.getMessage());
        }   
        
       
      response.sendRedirect(request.getContextPath() + "/AdminDatabase.jsp");  
    }
}