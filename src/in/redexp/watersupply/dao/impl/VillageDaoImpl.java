package in.redexp.watersupply.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import in.redexp.watersupply.model.District;
import in.redexp.watersupply.model.Village;
import in.redexp.watersupply.model.VillagePopulation;
import in.redexp.watersupply.util.hibernate.HibernateUtil;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class VillageDaoImpl {
	SessionFactory sf;
	public VillageDaoImpl()
	{
		sf = HibernateUtil.getSessionFactory();
	}
	
	public ArrayList<Village> getAllVillages()
	{
		ArrayList<Village> villageList = new ArrayList<Village>();
		try {
			Session session = sf.openSession();
			Criteria crit  = session.createCriteria(Village.class);
			villageList = (ArrayList<Village>) crit.list();
			session.close();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return villageList;
	}

	public ArrayList<Village> getAllVillagesForDistrict(District district) {
		ArrayList<Village> villageList = null;
		try {
			Session session = sf.openSession();
			district = session.get(District.class, district.getDistrictID());
			Criteria crit  = session.createCriteria(Village.class);
			crit.add(Restrictions.eq("districtID", district.getDistrictID()));
			villageList = (ArrayList<Village>) crit.list();
			session.close();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return villageList;
	}

	public Village getVillageByID(String villageID) {
		Village village = null;
		try
		{
		Session session = sf.openSession();
		village = session.get(Village.class, villageID); 
		session.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return village;
	}
	
	public VillagePopulation getLatestPopulationForVillage(String villageID)
	{
		VillagePopulation villagePopulation = null;
		try
		{
		Session session = sf.openSession();
		
		
		Criteria crit = session.createCriteria(VillagePopulation.class);
		crit.addOrder(Order.desc("asOnDate"));
		crit.add(Restrictions.eq("villageID", villageID));
		crit.setMaxResults(1);
		
		 System.out.println("getLatestPopulationForVillage: " + crit.uniqueResult());
		 villagePopulation = (VillagePopulation) crit.uniqueResult();
		 System.out.println(villagePopulation.getVillageID() + " :: " + villagePopulation.getAsOnDate() + " :: " + villagePopulation.getPopulationYear() + ":: " + villagePopulation.getTotalPopulation());
		session.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return villagePopulation;
	}
	
}
