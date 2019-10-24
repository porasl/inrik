package com.inrik.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inrik.dao.ItemDao;
import com.inrik.domain.ItemInfo;

@Service
public class ItemServiceImpl implements ItemService
{
	private ItemDao itemDao;

	@Override
	public ItemInfo createOrUpdate(ItemInfo itemInfo) {
		return itemDao.createOrUpdate(itemInfo);
	}

	@Override
	public List<ItemInfo> getItems(String userId) {
		return itemDao.getItems(userId);
	}

	@Override
	public ItemInfo getItem(String userId, String itemId) {
		return itemDao.getItem(userId, itemId);
	}

	@Override
	public void deleteItem(String itemInfoId) {
		itemDao.deleteItem(itemInfoId);
	}

	public void setItemDao(ItemDao itemDao){
		this.itemDao = itemDao;
	}

	public ItemDao getItemDao(){
		return itemDao;
	}
}
