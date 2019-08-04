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
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inrik.domain.ItemInfo;
import com.inrik.auth.model.User;
import com.inrik.service.ItemService;
import com.inrik.service.UserService;
import com.inrik.utils.Converter;
import com.inrik.utils.State;


@MultipartConfig
@WebServlet("/item")
public class ItemResource extends HttpServlet {
	
	private static final double VERSION = 1.0;
    
	@Autowired
	private ItemService itemService;
    
	@Autowired
    private UserService userService;
    
    private final Logger logger = LoggerFactory.getLogger(ItemResource.class);

	// This can be used to test the integration with the browser
    @GetMapping("/item/{id}")
    @ResponseBody
	public Response getHTML(@PathVariable String id) {
		logger.info(" Get item id {0} ", id);
		//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//itemService = (ItemService) context.getBean("itemService");
		ItemInfo item = itemService.getItem("${pageContext.request.userPrincipal.name}", id);
		ItemInfo[] ItemInfos = new ItemInfo[1];
		ItemInfos[0] = item;
		return Response.status(200).entity(Converter.itemToString(ItemInfos).toJSONString()).header("Access-Control-Allow-Origin", "*")
		.header("Access-Control-Allow-Methods", "*").build();
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
        response.getWriter().append(Converter.itemToString(itemInfos).toJSONString());
	
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
      

