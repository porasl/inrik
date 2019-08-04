package com.inrik.resource;

import java.util.Date;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.inrik.domain.ItemInfo;
import com.inrik.auth.model.User;
public class ItemFactory {
	
	public ItemInfo getItemInfo(String jsonString) throws JSONException{
	ItemInfo item = new ItemInfo();
	JSONObject obj = new JSONObject(jsonString);
	item.setLocale(obj.getString("locale"));
	item.setName(obj.getString("name"));
	item.setType(obj.getString("type"));
	item.setAccesstype(obj.getBoolean("accessType"));
	item.setDescription(obj.getString("description"));
	item.setFormat(obj.getString("format"));
	item.setAudiopath(obj.getString("audioPath"));
	item.setImagepath(obj.getString("imagePath"));
	item.setImagemainname(obj.getString("mainImageName"));
	item.setVideopath(obj.getString("videoPath"));
	item.setPrice(obj.getString("price"));
	item.setPaidamount(obj.getString("paidAmount"));
	item.setSelectedtemplate(obj.getString("selectedTemplate"));
	item.setDeletiondate(new Date(obj.getString("deletionDate")));
	item.setCreationdate(new Date(obj.getString("creationDate")));
	item.setModificationdate(new Date(obj.getString("modificationDate")));
	item.setExpirationdate(new Date(obj.getString("expirationDate")));
	
	/*
	JSONObject jsonObject = obj.getJSONObject("publisherInfo");
	UserInfo userInfo = new UserInfo();
	publisherInfo.setFirstName(jsonObject.getString("firstName"));
	publisherInfo.setLastName(jsonObject.getString("lastName"));
	publisherInfo.setPhoneNumber(jsonObject.getString("phoneNumber"));
	publisherInfo.setEmailAddress(jsonObject.getString("emailAddress"));
	publisherInfo.setAddress(jsonObject.getString("address"));
	publisherInfo.setZipcode(jsonObject.getString("zipcode"));
	publisherInfo.setCity(jsonObject.getString("city"));
	publisherInfo.setCountry(jsonObject.getString("country"));
	publisherInfo.setExpirationDate(new Date(jsonObject.getString("expirationDate")));
	publisherInfo.setCreationDate(new Date(jsonObject.getString("creationDate")));
	publisherInfo.setModificationDate(new Date(jsonObject.getString("modificationDate")));
	
	publisherInfo.setDeletionDate(new Date(jsonObject.getString("deletionDate")));
	item.setPublisherId(jsonObject.getInt("publisherId"));
	*/
	
	JSONObject jsonObject = obj.getJSONObject("userInfo");
	item.setUserid((long) jsonObject.getInt("id"));
	return item;
	}
}
