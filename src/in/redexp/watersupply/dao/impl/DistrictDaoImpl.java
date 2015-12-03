package in.redexp.watersupply.dao.impl;

import java.util.ArrayList;

import in.redexp.watersupply.model.District;
import in.redexp.watersupply.model.Scheme;
import in.redexp.watersupply.model.Village;
import in.redexp.watersupply.util.hibernate.HibernateUtil;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

public class DistrictDaoImpl {
	SessionFactory sf;
	public DistrictDaoImpl()
	{
		sf = HibernateUtil.getSessionFactory();
	}
	
	public ArrayList<District> getAllDistricts()
	{
		ArrayList<District> districtList = new ArrayList<District>();
		try
		{
		Session session = sf.openSession();
		Criteria crit = session.createCriteria(District.class);
		districtList = (ArrayList<District>) crit.list();
		session.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return districtList;
		
	}
	
	public ArrayList<District> getAllDistrictsBySchemeId(String schemeID)
	{
		ArrayList<District> districtList = new ArrayList<District>();
		try
		{
		Session session = sf.openSession();
		Criteria crit = session.createCriteria(District.class);
		Scheme scheme = session.get(Scheme.class, schemeID);
		crit.add(Restrictions.eq("schemeID", schemeID));
		districtList = (ArrayList<District>) crit.list();
		session.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return districtList;
		
	}
	
	public District getDistrictByID(String id)
	{
		District dist = null;
		try
		{
		Session session = sf.openSession();
		Criteria crit = session.createCriteria(District.class);
		crit.add(Restrictions.eq("districtID", id));
		dist = (District) crit.uniqueResult();
		session.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return dist;
	}
	
	
}
