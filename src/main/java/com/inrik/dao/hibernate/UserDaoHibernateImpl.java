
package com.inrik.dao.hibernate;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import com.inrik.auth.model.User;
import com.inrik.dao.UserDao;

@Component
public class UserDaoHibernateImpl extends HibernateDaoSupport implements UserDao
{

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		String hql = "select userInfo from UserInfo";    
		return (List<User>) getHibernateTemplate().find(hql);
	}

	@Override
	public User getUser(String username) {
		String hql ="";
		try {
			hql = "from User user where user.username='"+ URLDecoder.decode(username, "UTF-8") +"'";
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}; 
		return (User) getHibernateTemplate().find(hql).get(0);
	}

	@Override
	public void delete(int userId) {
		User userInfo = (User) getHibernateTemplate().load(User.class, userId);
		 getHibernateTemplate().delete(userInfo);
	}

	@Override
	public void setUser(User user) {
		// TODO Auto-generated method stub
		
	}
}
