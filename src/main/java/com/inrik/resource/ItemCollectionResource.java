package com.inrik.resource;

import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

  
	// @GetMapping("/items")
	// @ResponseBody
	public Response doGet() {
		//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//itemService = (ItemService) context.getBean("itemService");
		List<ItemInfo> items = itemService.getItems("${pageContext.request.userPrincipal.name}");
		ItemInfo[] itemInfos = new ItemInfo[items.size()];
		itemInfos = items.toArray(itemInfos);
		 return Response.status(201).entity(Converter.itemToString(itemInfos).toJSONString()).header("Access-Control-Allow-Origin", "*")
		    		.header("Access-Control-Allow-Methods", "*").build();
	}
	 
	 public void setItemService(ItemService itemService) {
			this.itemService = itemService;
		}
		
		public void setUserService(UserService userService) {
			this.userService = userService;
		} 
}
      

