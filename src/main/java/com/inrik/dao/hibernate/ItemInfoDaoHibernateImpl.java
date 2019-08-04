
package com.inrik.dao.hibernate;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import com.inrik.dao.ItemDao;
import com.inrik.domain.ItemInfo;

@Component
public class ItemInfoDaoHibernateImpl extends HibernateDaoSupport implements ItemDao
{
	
    public ItemInfo createOrUpdate(ItemInfo itemInfo)
    {
    	getHibernateTemplate().saveOrUpdate(itemInfo);
        return itemInfo;
    }


	@SuppressWarnings("unchecked")
	@Override
	public List<ItemInfo> getItems(String userId) {
		String hql = "select item from ItemInfo item order by creationDate desc";    
		return   (List<ItemInfo>) getHibernateTemplate().find(hql);
	}

	@Override
	public ItemInfo getItem(String userId, String itemId) {
		//return (ItemInfo) getHibernateTemplate().load(ItemInfo.class, itemId);
		String hql = "select item from ItemInfo item where iteminfoid="+ itemId; 
		return   ((List<ItemInfo>) getHibernateTemplate().find(hql)).get(0);
		
	}
	

	@Override
	public void delete(int itemId) {
		ItemInfo myItem = (ItemInfo) getHibernateTemplate().load(ItemInfo.class, itemId);
		 getHibernateTemplate().delete(myItem);
	}


	@Override
	public void setItem(ItemInfo itemInfo) {
		// TODO Auto-generated method stub
		
	}
}
