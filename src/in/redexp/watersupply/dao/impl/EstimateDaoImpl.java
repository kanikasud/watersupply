package in.redexp.watersupply.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import in.redexp.watersupply.controller.TWEstimateController;
import in.redexp.watersupply.model.EstimateDetailsCanal;
import in.redexp.watersupply.model.EstimateDetailsTubeWell;
import in.redexp.watersupply.model.EstimateInbox;
import in.redexp.watersupply.model.Workflow;
import in.redexp.watersupply.util.hibernate.HibernateUtil;

public class EstimateDaoImpl {

	private SessionFactory sf;

	public EstimateDaoImpl() {
		super();
		sf = HibernateUtil.getSessionFactory();
	}

	public Long saveTWEstimate(EstimateDetailsTubeWell tubewellEstimate) {
		Session session = null;
		Long id = null;
		try
		{
			System.out.println("in.redexp.watersupply.dao.impl.EstimateDaoImpl.save(EstimateDetailsTubeWell)");
			session = sf.openSession();
			session.createCriteria(EstimateDetailsTubeWell.class);
			 Transaction tx = session.beginTransaction();
			 tx.begin();
			id = (Long) session.save(tubewellEstimate);
			tx.commit();
			session.close();
			System.out.println(id);
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return id;
		
		
	}
	
	public Long saveToInbox(EstimateInbox inbox) {
		Long inboxID = null;
		try
		{
			Session session = sf.openSession();
			session.createCriteria(EstimateInbox.class);
			Transaction tx = session.beginTransaction();
			 tx.begin();
			 inboxID = (Long) session.save(inbox);
			 tx.commit();
			session.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		
		return inboxID;
		
		
	}


	public EstimateDetailsTubeWell getTWEstimateByID(Long id) {
		EstimateDetailsTubeWell tubewellEstimate = null;
		System.out.println("in.redexp.watersupply.dao.impl.EstimateDaoImpl.getEstimateByID(String)");
		try
		{
			Session session = sf.openSession();
			//session.get("EstimateDetailsTubeWell", id);
			Criteria crit = session.createCriteria(EstimateDetailsTubeWell.class);
			crit.add(Restrictions.eq("id", Long.valueOf(id)));
			tubewellEstimate  = (EstimateDetailsTubeWell) crit.uniqueResult();
			System.out.println(tubewellEstimate);
			session.close();
		}catch(Exception ex)
		{
			
		}
		return tubewellEstimate;
	}

	public EstimateDetailsCanal getCanalEstimateByID(Long id) {
		EstimateDetailsCanal canalEstimate = null;
		System.out.println("in.redexp.watersupply.dao.impl.EstimateDaoImpl.getCanalEstimateByID(Long)");
		try
		{
			Session session = sf.openSession();
			//session.get("EstimateDetailsTubeWell", id);
			Criteria crit = session.createCriteria(EstimateDetailsCanal.class);
			crit.add(Restrictions.eq("id", Long.valueOf(id)));
			canalEstimate  = (EstimateDetailsCanal) crit.uniqueResult();
			System.out.println(canalEstimate);
			session.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return canalEstimate;
	}
	
	public Long saveCanalEstimate(EstimateDetailsCanal canalEstimate) {
		Session session = null;
		Long id = null;
		try
		{
			System.out.println("in.redexp.watersupply.dao.impl.EstimateDaoImpl.saveCanalEstimate(EstimateDetailsCanal)");
			session = sf.openSession();
			 session.createCriteria(EstimateDetailsCanal.class);
			 Transaction tx = session.beginTransaction();
			 tx.begin();
			id = (Long) session.save(canalEstimate);
			tx.commit();
			session.close();
			System.out.println(id);
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return id;
	}
	
	public Long mapEstimateToWorkflow(String fromRoleID, String fromLocID)
	{
		Long wID = null;
		try
		{
			System.out.println("Estimate ID: " + fromRoleID);
			System.out.println("send to: " + fromLocID);
			Session session = sf.openSession();
			Criteria crit = session.createCriteria(Workflow.class);
			WorkflowDaoImpl workflowDaoImpl = new WorkflowDaoImpl();
			
			
				session.close();
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}

}
