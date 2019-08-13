package com.inrik.resource;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import com.inrik.domain.ItemInfo;
import com.inrik.service.ItemService;
import com.inrik.service.UserService;
import com.inrik.utils.Converter;

@MultipartConfig
@WebServlet("/items")
public class ItemCollectionResource extends HttpServlet {
	
	@Autowired
    private ItemService itemService;
	
	@Autowired
    private UserService userService;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		itemService = (ItemService) context.getBean("itemService");
		ItemInfo[] itemInfos = new ItemInfo[1];
		if(itemService != null) {
			List<ItemInfo> items = itemService.getItems("${pageContext.request.userPrincipal.name}");
			itemInfos = items.toArray(new ItemInfo[items.size()]);
		}
		response.setContentType("application/json");  // Set content type of the response so that jQuery knows what it can expect.
	    response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
	    response.getWriter().write(Converter.itemToString(itemInfos).toJSONString()); 
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "*");
	}
	 
	 public void setItemService(ItemService itemService) {
			this.itemService = itemService;
		}
		
		public void setUserService(UserService userService) {
			this.userService = userService;
		} 
}
      

