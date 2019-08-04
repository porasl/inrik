package com.inrik.resource;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.inrik.helper.RandomGenerator;
import com.inrik.utils.PropertiesUtil;

@MultipartConfig
@WebServlet("/uploadServlet")
public class UploadResource extends HttpServlet {
	
	RandomGenerator randomGenerator;
    String imageTempdir;
    String tmpSubFolderName;
    
    static Logger logger = Logger.getLogger(UploadResource.class.getName());
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 FileHandler fh;  
    	 try {   
    	     	fh = new FileHandler(PropertiesUtil.getServerLogAddress());  
    	        logger.addHandler(fh);
    	        SimpleFormatter formatter = new SimpleFormatter();  
    	        fh.setFormatter(formatter);   
    	     } catch (SecurityException e) {  
    	        e.printStackTrace();  
    	    } 
    	
			imageTempdir = PropertiesUtil.getImageTempdir();
			logger.info("Image dir is set to: " + imageTempdir);
				
			
    		
    	Part filePart = request.getPart("file");
    	if(tmpSubFolderName == null){
    		tmpSubFolderName = request.getParameter("tmpSubFolderName");
    		if((tmpSubFolderName == null) || tmpSubFolderName.equals("undefined")){
    			randomGenerator = new RandomGenerator();
    			tmpSubFolderName = randomGenerator.nextRandom();
    		}
    	}
        String filename = getFilename(filePart);
        InputStream filecontent = filePart.getInputStream(); 
        Path imagePath = Paths.get(imageTempdir+ "/"+ tmpSubFolderName);
        
        Files.createDirectories(imagePath);
        
        String fileName = imageTempdir+"/"+tmpSubFolderName+"/"+filename;
        logger.info("Filename: " + fileName);
		OutputStream os = new FileOutputStream(fileName);
        
        byte[] buffer = new byte[1024];
        int bytesRead = 0;
        while((bytesRead = filecontent.read(buffer)) !=-1){
            os.write(buffer, 0, bytesRead);
        }
        filecontent.close();
        os.flush();
        os.close();

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS");
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");    
        response.getWriter().write(tmpSubFolderName+"/"+filename);
    }

    private static String getFilename(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
            }
        }
        return null;
    }
}