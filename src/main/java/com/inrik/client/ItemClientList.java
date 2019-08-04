package com.inrik.client;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="itemClients")
public class ItemClientList {
	private int count;
	private List<ItemClient> itemClients;

	public ItemClientList() {}
	
	public ItemClientList(List<ItemClient> itemClients) {
		this.itemClients = itemClients;
		this.count = itemClients.size();
	}

	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	@XmlElement(name="itemClients")
	public List<ItemClient> getItemClients() {
		return itemClients;
	}
	
	public void setItemClients(List<ItemClient> itemClients) {
		this.itemClients = itemClients;
	}
}
