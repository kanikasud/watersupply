package in.redexp.watersupply.dao.impl;

import java.util.ArrayList;

import in.redexp.watersupply.model.SubDivision;
import in.redexp.watersupply.util.hibernate.HibernateUtil;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

public class SubDivisionDaoImpl {
	public SubDivisionDaoImpl() {
		super();
		sf = HibernateUtil.getSessionFactory();
	}

	SessionFactory sf;
	
	public ArrayList<SubDivision> getSubDivisionByDivID(String divID)
	{
		ArrayList<SubDivision> subDivisionList = null;
		try
		{
			Session sess = sf.openSession();
			Criteria crit = sess.createCriteria(SubDivision.class);
			crit.add(Restrictions.eq("divisionalID",divID));
			subDivisionList = (ArrayList<SubDivision>) crit.list();
			sess.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return subDivisionList;
	}
	
	public SubDivision getSubDivisionById(String subDivisionID)
	{
		SubDivision subDivision = null;
		try
		{
			Session sess = sf.openSession();
			Criteria crit = sess.createCriteria(SubDivision.class);
			crit.add(Restrictions.eq("subDivisionalID",subDivisionID));
			subDivision = (SubDivision) crit.uniqueResult();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return subDivision;
		
	}
	
}
