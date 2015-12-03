package in.redexp.watersupply.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import in.redexp.watersupply.model.Division;
import in.redexp.watersupply.util.hibernate.HibernateUtil;

public class DivisionDaoImpl {
	SessionFactory sf;
	public DivisionDaoImpl() {
		super();
		sf = HibernateUtil.getSessionFactory();
	}
	
	public Division getDivisionByID(String divID)
	{
		Division division = null;
		try
		{
			Session session = sf.openSession();
			Criteria crit = session.createCriteria(Division.class);
			crit.add(Restrictions.eq("divID", divID));
			division = (Division)crit.uniqueResult();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return division;
		
	}

}
