
package com.inrik.dao.hibernate;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import com.inrik.auth.model.User;
import com.inrik.dao.ItemDao;
import com.inrik.domain.ItemInfo;
import com.inrik.service.UserService;

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
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService) context.getBean("userService");
		//Check Publisher if not redirect to login page
		User user = userService.getUserInfo(userId);
		String hql = "select item from ItemInfo item  where userid="+ user.getId().shortValue() + " order by creationDate desc";    
		return   (List<ItemInfo>) getHibernateTemplate().find(hql);
	}

	@Override
	public ItemInfo getItem(String userId, String itemId) {
		//return (ItemInfo) getHibernateTemplate().load(ItemInfo.class, itemId);
		String hql = "select item from ItemInfo item where iteminfoid="+ itemId; 
		return   ((List<ItemInfo>) getHibernateTemplate().find(hql)).get(0);
		
	}
	

	@Override
	public void deleteItem(String itemId) {
		ItemInfo myItem = (ItemInfo) getHibernateTemplate().load(ItemInfo.class,  Long.parseLong(itemId));
		 getHibernateTemplate().delete(myItem);
	}


	@Override
	public void setItem(ItemInfo itemInfo) {
		// TODO Auto-generated method stub
		
	}
}
