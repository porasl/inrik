package com.inrik.utils;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.json.simple.JSONArray;

import com.inrik.domain.ItemInfo;

 public class  Converter {

	public static JSONArray itemToString(ItemInfo[] itemInfos){
		
		JSONArray jsonArray = new JSONArray();
	  for(int i=0;i<itemInfos.length;i++){
		JSONObject obj = new JSONObject();
		ItemInfo itemInfo = itemInfos[i];
		try {
			obj.put("itemInfoId", itemInfo.getIteminfoid());
			obj.put("version", itemInfo.getVersion());
			obj.put("locale",itemInfo.getLocale());
			obj.put("name", itemInfo.getName());
			obj.put("type", itemInfo.getType());
			obj.put("accessType", itemInfo.getAccesstype());
			obj.put("notified",itemInfo.getNotified());
			obj.put("deleted", itemInfo.getDeleted());
			obj.put("deleteCode",itemInfo.getDeletecode());
			obj.put("state",itemInfo.getState());
			obj.put("description",itemInfo.getDescription());
			obj.put("format",itemInfo.getFormat());
			obj.put("audioPath",itemInfo.getAudiopath());
			obj.put("imagePath",itemInfo.getImagepath());
			obj.put("videoPath",itemInfo.getVideopath());
			obj.put("audioMainName",itemInfo.getAudiomainname());
			obj.put("imageMainName",itemInfo.getImagemainname());
			obj.put("videoMainName",itemInfo.getVideomainname());	
			obj.put("price",itemInfo.getPrice());
			obj.put("paidAmount",itemInfo.getPaidamount());
			obj.put("selectedTemplate",itemInfo.getSelectedtemplate());
			obj.put("creationDate",itemInfo.getCreationdate());
			obj.put("modificationDate",itemInfo.getModificationdate());
			obj.put("expirationDate",itemInfo.getExpirationdate());
			obj.put("deletionDate",itemInfo.getDeletiondate());
			obj.put("userId",itemInfo.getUserid());
			jsonArray.add(obj);
		
		} catch (JSONException e) {
	            e.printStackTrace();
	        }
	  }
		return jsonArray;
	}
}
