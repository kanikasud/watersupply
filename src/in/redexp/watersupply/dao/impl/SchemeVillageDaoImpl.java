package in.redexp.watersupply.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import in.redexp.watersupply.model.SchemeVillage;
import in.redexp.watersupply.model.Village;
import in.redexp.watersupply.util.hibernate.HibernateUtil;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

public class SchemeVillageDaoImpl {
	SessionFactory sf;
	public SchemeVillageDaoImpl()
	{
		sf = HibernateUtil.getSessionFactory();
	}
	
	public ArrayList<SchemeVillage> getAllVillagesUnderSchemeID(String schemeID)
	{
		System.out.println("in.redexp.watersupply.dao.impl.SchemeVillageDaoImpl.getAllVillagesUnderSchemeID(String)");
		ArrayList<SchemeVillage> schemeVillageList = new ArrayList<SchemeVillage>();
		try
		{
			Session session = sf.openSession();
			SQLQuery query = session.createSQLQuery("SELECT * FROM prwss_main.mst_scheme_village WHERE scheme_id like :schemeID");
			query.addEntity(SchemeVillage.class);
			query.setParameter("schemeID", schemeID);
			schemeVillageList = (ArrayList<SchemeVillage>) query.list();
			
			session.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return schemeVillageList;
		
	}
	
	
	public SchemeVillage getSchemePrepDetailsBySchemeID(String schemeID)
	{
		SchemeVillage schemeVillage = null;
		
		try
		{
			Session session = sf.openSession();
			Criteria crit = session.createCriteria(SchemeVillage.class);
			crit.add(Restrictions.eq("schemeID", schemeID));
			ArrayList<SchemeVillage> schemeVillageList = getAllVillagesUnderSchemeID(schemeID);
			schemeVillage = schemeVillageList.get(0);
			
			
		}catch(Exception ex)
		{
			
		}
		return schemeVillage;
	}
	
	
}
