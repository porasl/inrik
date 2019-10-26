package com.inrik.resource;

import com.inrik.client.ItemClient;
import com.inrik.domain.ItemInfo;

public class ItemConverter {
	public ItemClient convert(ItemInfo item){
		ItemClient itemClient = new ItemClient();
		
		itemClient.setSelectedTemplate(item.getSelectedtemplate());
		itemClient.setThumbnail(item.getThumbnail());
		item.setImagepath(item.getImagepath());
		itemClient.setPrice(item.getPrice());
		itemClient.setType(item.getType());
		itemClient.setVersion(item.getVersion());
		itemClient.setDescription(item.getDescription());
		itemClient.setExpirationDate(item.getExpirationdate());
		itemClient.setCreationDate(item.getCreationdate());
		itemClient.setItemInfoId(item.getIteminfoid());
		itemClient.setName(item.getName());
		itemClient.setFormat(item.getFormat());
		itemClient.setAudioPath(item.getAudiopath());
		itemClient.setImagePath(item.getImagepath());
		itemClient.setVideoPath(item.getVideopath());
		itemClient.setPaidAmount(item.getPaidamount());
		itemClient.setModificationDate(item.getModificationdate());
		
		
		itemClient.setpublisherId(item.getUserid());
		
		return itemClient;
		
	}
}
