/**
 * If you really care for the license, look for the LICENSE.txt at the project root. Frankly, I 
 * really don't care.
 **/
package com.example.starter.dao.impl;

import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.starter.dao.UserDao;
import com.example.starter.entity.Role;
import com.example.starter.entity.User;

/**
 * This class implements the UserDao interface.
 * 
 * @author Roshan Amadoru
 **/
@Repository("userDao")
public class UserDaoImpl implements UserDao {
	
	/**
     * The logger instance
     **/
    private static Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	
	/**
     * The instance of SessionFactory injected with Spring
     **/
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
     * Returns the user object matched by the passed username. Returns null if the user is not 
     * found in the database.
     * @param username username of the user which needs to query for
     * @return an instance of User if the user is found, null otherwise
     **/
	@Transactional(readOnly=true)
	public User findUserByUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		User user = (User)session.createQuery("from User user where user.username=?")
				.setParameter(0, username)
				.uniqueResult();
		
		if (logger.isDebugEnabled()) {
			if (user==null) {
				logger.trace("User not found: " + username);
			} else {
				logger.trace("User found: " + username);
				Iterator<Role> roleIterator = user.getRoles().iterator();
				while(roleIterator.hasNext()) {
					Role role = roleIterator.next();
					logger.trace("\tUser role: " + role.getRoleName());
				}
			}
		}
		return user;
	}
}
