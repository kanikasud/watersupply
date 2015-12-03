package in.redexp.watersupply.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;

import in.redexp.watersupply.model.District;
import in.redexp.watersupply.model.Scheme;
import in.redexp.watersupply.util.hibernate.HibernateUtil;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

public class SchemeDaoImpl {
	SessionFactory sf;
	public SchemeDaoImpl()
	{
		sf = HibernateUtil.getSessionFactory();
	}
	
	public ArrayList<Scheme> getAllSchemes()
	{
		ArrayList<Scheme> schemeList = new ArrayList<Scheme>();
		try
		{
			System.out.println("in.redexp.watersupply.dao.impl.SchemeDaoImpl.getAllSchemes()");
			Session session = sf.openSession();
			Scheme scheme = session.get(Scheme.class, String.valueOf(Scheme.serialVersionUID));
			Criteria crit = session.createCriteria(Scheme.class);
			Criterion rest1 = (Restrictions.eq("schemeSource", "TUBEWELL"));
			Criterion rest2 = (Restrictions.eq("schemeSource", "CANAL"));
			crit.add(Restrictions.or(rest1, rest2));
			schemeList = (ArrayList<Scheme>) crit.list();
			Iterator<Scheme> schemeListIterator = schemeList.iterator();
			
			session.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return schemeList;
		
	}

	public Scheme getSchemeByID(String schemeID) {
		Scheme scheme = null;
		try
		{
		Session session = sf.openSession();
		Criteria crit = session.createCriteria(Scheme.class);
		crit.add(Restrictions.eq("schemeID", schemeID));
		scheme = (Scheme) crit.uniqueResult();
		System.out.println("in.redexp.watersupply.dao.impl.SchemeDaoImpl.getSchemeByID(String)");
		System.out.println("scheme Name: " + scheme.getSchemeName());
		System.out.println("scheme ID: " + scheme.getSchemeID());
		System.out.println("scheme District: " + scheme.getDistrictID());
		session.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return scheme;
	}

	public ArrayList<Scheme> getSchemeByName(String schemeName) {
		ArrayList<Scheme> schemeList = null;
		try
		{
		Session session = sf.openSession();
		Criteria crit = session.createCriteria(Scheme.class);
		crit.add(Restrictions.eq("schemeName", schemeName));
		
		Criterion rest1 = (Restrictions.eq("schemeSource", "TUBEWELL"));
		Criterion rest2 = (Restrictions.eq("schemeSource", "CANAL"));
		crit.add(Restrictions.or(rest1, rest2));
		schemeList =  (ArrayList<Scheme>)crit.list();
		System.out.println("in.redexp.watersupply.dao.impl.SchemeDaoImpl.getSchemeByName(String)");
		session.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return schemeList;
	}

	
}
