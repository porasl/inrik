package com.inrik.resource;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.inrik.auth.model.User;

public class UserInfoFactory {
	
	public User getUserInfo(String jsonString) throws JSONException{
	User publisherInfo = new User();
	JSONObject obj = new JSONObject(jsonString);
	/*
	item.setMadeYear(obj.getString("madeYear"));
	item.setMake(obj.getString("make"));
	item.setMileage(obj.getString("mileage"));
	item.setModel(obj.getString("model"));
	item.setNumberOfDoors(obj.getString("numberOfDoors"));
	item.setTransmission(obj.getString("transmission"));
	item.setVersion(obj.getString("version"));
	item.setType(obj.getString("type"));
	item.setCity(obj.getString("city"));
	item.setCountry(obj.getString("country"));
	item.setState(obj.getString("state"));
	item.setExpireDate(new Date());
	item.setStartDate(new Date());
	item.setPaid(Boolean.valueOf(obj.getString("paid")));
	item.setApproved(Integer.parseInt(obj.getString("approved")));
	item.setDetails(obj.getString("details"));
	item.setDeleteCode("1234");
	item.setPrice(obj.getString("price"));
	item.setZipCode(obj.getString("zipcode"));
	item.setCurrencySymbol(obj.getString("currencySymbol"));
	
	item.setExpireDate(new Date());
	item.setStartDate(new Date());
	item.setPaid(Boolean.valueOf(obj.getString("paid")));
	
	String imagePaths = obj.getString("advertisementImageInfo");
	JSONObject imagePathsObj = new JSONObject(imagePaths);
	
	AdvertisementImageInfo advertisementImageInfo = new AdvertisementImageInfo();
	advertisementImageInfo.setImage1(imagePathsObj.getString("image1"));
	
	car.setAdvertisementImageInfo(advertisementImageInfo);
	
	String principalStr = obj.getString("adPrincipalInfo");
	JSONObject principalObj = new JSONObject(principalStr);
	
	AddressInfo adPrincipalInfo = new AddressInfo();
	adPrincipalInfo.setContactName(principalObj.getString("contactName"));

	item.setAdPrincipalInfo(adPrincipalInfo);
	*/
	return publisherInfo;
	}
}
