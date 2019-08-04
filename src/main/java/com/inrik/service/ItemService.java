package com.inrik.service;

import java.util.List;

import com.inrik.domain.ItemInfo;

public interface ItemService
{
   public ItemInfo createOrUpdate(ItemInfo itemInfo);

   public List<ItemInfo> getItems(String userId);
 
   public ItemInfo getItem(String string, String itemId); 
  
   public void delete(int itemId);
}
