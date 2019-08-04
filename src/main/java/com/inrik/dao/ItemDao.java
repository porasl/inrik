
package com.inrik.dao;

import java.util.List;

import com.inrik.domain.ItemInfo;

public interface ItemDao
{
	public ItemInfo createOrUpdate(ItemInfo itemInfo);
	public List<ItemInfo> getItems(String userId);
	public ItemInfo getItem(String userId, String itemId);
	public void setItem(ItemInfo itemInfo);
	public void delete(int itemId);
}
