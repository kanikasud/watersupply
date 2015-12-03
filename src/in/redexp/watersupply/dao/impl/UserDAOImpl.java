package in.redexp.watersupply.dao.impl;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;

import in.redexp.watersupply.dao.UserDAO;
import in.redexp.watersupply.model.*;
import in.redexp.watersupply.util.hibernate.HibernateUtil;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.RootEntityResultTransformer;

public class UserDAOImpl {
	private SessionFactory sf;
	private User user;
	private UserDAO userDao;

	public UserDAOImpl() {
		this.sf = HibernateUtil.getSessionFactory();
	}

	public User getUserByCredentials(String userName, String password) {
	        try
	        {
			
	        
	        Session session = sf.openSession();
	        
	        session.beginTransaction();
	      // SQLQuery query  = session.createSQLQuery("SELECT user_id, role_id, employee_id FROM login_ws WHERE user_name=:userName AND user_password=:pwd");
	       // List<User> result = (List<User>) session.createQuery("from " + User.class.).list();
	        
	        //session.save(userTemp);
	        //System.out.println("Return the persistent instance " + session.get(User.class, User.serialVersionUID));
	        User user = session.get(User.class, String.valueOf(User.serialVersionUID));
	        //System.out.println(user.getClass().getSimpleName());
	        Query query =  session.createQuery("from User where userID=:userName AND pwd=:password");
	        query.setString("userName", userName);
	        query.setString("password", password);
	        
	        User result = (User) query.uniqueResult();
			System.out.println("result: " + result);
	        session.close();
	        this.user = result;
	      
		
	        	/*Long userID = result.get(0).getUserID();
	        	user = new User();
	        	user.setRoleID(roleID);
	        	user.setEmpID(empID);
	        	user.setUserID(userID);*/
	        	

	        }catch(Exception ex)
	        {
	        	ex.printStackTrace();
	        }
	        return user;
	    }
}
