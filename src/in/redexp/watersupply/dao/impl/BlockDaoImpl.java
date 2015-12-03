package in.redexp.watersupply.dao.impl;

import in.redexp.watersupply.util.hibernate.HibernateUtil;

import org.hibernate.SessionFactory;

public class BlockDaoImpl {
	SessionFactory sf;
	
	public BlockDaoImpl()
	{
		sf = HibernateUtil.getSessionFactory();
	}
}
