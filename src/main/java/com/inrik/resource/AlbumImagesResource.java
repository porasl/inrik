package com.inrik.resource;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.inrik.auth.model.User;
import com.inrik.domain.ItemInfo;
import com.inrik.service.ItemService;
import com.inrik.service.UserService;
import com.inrik.utils.Converter;
import com.inrik.utils.State;


@MultipartConfig
@WebServlet("/item_")
public class AlbumImagesResource extends HttpServlet {
	
	private static final double VERSION = 1.0;
    
	@Autowired
	private ItemService itemService;
    
	@Autowired
    private UserService userService;
    
    private final Logger logger = LoggerFactory.getLogger(AlbumImagesResource.class);

	// This can be used to test the integration with the browser
    @Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//logger.info(" Get item id {0} ", re);
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		itemService = (ItemService) context.getBean("itemService");
		String id = request.getParameter("id");
		String itemInfoId = request.getParameter("itemInfoId");
		String temp = request.getParameter("templ");
		String description = request.getParameter("des");
		String imagePath = request.getParameter("imagePath");
		
		//????  make sure user n context is asking for listing
		//if(itemService.validate("${pageContext.request.userPrincipal.name}", id)) {
			// list the files in the folder "image/imagePath"  O
		//}
		
		// find if user is owner of the Album/imagePath
		//Get page Content list as a JSON List
		
		//1. read the files in the image folder
		
		ItemInfo[] ItemInfos = new ItemInfo[1];
		//ItemInfos[0] = item;
		response.setContentType("application/json");  // Set content type of the response so that jQuery knows what it can expect.
	    response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
	    response.getWriter().write(Converter.itemToString(ItemInfos, "").toJSONString());
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "*");
	}
	
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   	    //logger.info(" POST create album {0} ", album);
    	String body = request.getReader().lines()
    		    .reduce("", (accumulator, actual) -> accumulator + actual);
    	
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		itemService = (ItemService) context.getBean("itemService");
		String[] params = body.split("&");
		ItemInfo itemInfo = new ItemInfo();
		itemInfo.setAccesstype(Boolean.valueOf(getParamValue(params[1])));
		try{
			itemInfo.setName(URLDecoder.decode(getParamValue(params[0]), "UTF-8"));
			itemInfo.setDescription(URLDecoder.decode(getParamValue(params[2]), "UTF-8"));
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}
		itemInfo.setSelectedtemplate(getParamValue(params[3]));
		itemInfo.setImagepath(getParamValue(params[5]));
		itemInfo.setCreationdate(new Date());
		itemInfo.setNotified(false);
		itemInfo.setState(State.PENDING);
		itemInfo.setDeletecode(0);
		itemInfo.setLocale("en");
		itemInfo.setType("ALBUM");
		itemInfo.setFormat("ALBUM");
		itemInfo.setVersion(VERSION);
		
		
		//String username = "${pageContext.request.userPrincipal.name}";
		userService = (UserService) context.getBean("userService");
		//Check Publisher if not redirect to login page
		User user = userService.getUserInfo(getParamValue(params[4]));
		
		itemInfo.setUserid(user.getId());
		ItemInfo newAlbumInfo = itemService.createOrUpdate(itemInfo);
		ItemInfo[]  itemInfos = new ItemInfo[1];
		itemInfos[0] = newAlbumInfo;
		
		response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS");
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");    
        //response.getWriter().write(newAlbumInfo.tmpSubFolderName+"/"+filename);
		//response.status(200).entity(Converter.itemToString(itemInfos).toJSONString()).build();
        response.getWriter().append(Converter.itemToString(itemInfos, "").toJSONString());
	
    }
	
	public String getParamValue(String paramStr){
		if(paramStr!=null){
			return paramStr.substring(paramStr.indexOf("=")+1, paramStr.length());
		}
		
		return "";
	}
	
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
      

