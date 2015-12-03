package in.redexp.watersupply.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import in.redexp.watersupply.model.User;
import in.redexp.watersupply.model.UserLocation;
import in.redexp.watersupply.util.hibernate.HibernateUtil;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

public class UserLocationDaoImpl {
	SessionFactory sf;
	public UserLocationDaoImpl() {
		super();
		this.sf = HibernateUtil.getSessionFactory();
	}
	
	public ArrayList<String> getUserLocationID(User user) {
		ArrayList<String> locationIDList = new ArrayList<String>();
		try
		{
		Session session = sf.openSession();
		System.out.println("in.redexp.watersupply.dao.impl.UserLocationDaoImpl.getUserLocationID(User)");
		System.out.println("userID : " + user.getUserID());
		session.beginTransaction();
		//UserLocation loc = session.get(UserLocation.class, String.valueOf(UserLocation.serialVersionUID));
		UserLocation loc = null;
		/*Criteria criteria = session.createCriteria(UserLocation.class);
		criteria.add(Restrictions.eq("userID", userName));
		loc = (UserLocation) criteria.uniqueResult();
		System.out.println(loc);*/
		Query query =  session.createQuery("from UserLocation where userID=:userName");
        query.setString("userName", user.getUserID());
        List<UserLocation> locList = (List<UserLocation>) query.list();
        System.out.println("Location DB: " + locList.size());
        if(locList!=null)
        {
        	Iterator<UserLocation> locIt = locList.iterator();
        	while(locIt.hasNext())
        	{
        		UserLocation location = locIt.next();
        		if(location!=null)
        		{
        			locationIDList.add(location.getLocationID());
        		}
        	}
        	
        }
        session.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		// TODO Auto-generated method stub
		return locationIDList;
	}
	
	
	

}
