package in.redexp.watersupply.dao.impl;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import in.redexp.watersupply.model.EstimateInbox;
import in.redexp.watersupply.model.Workflow;
import in.redexp.watersupply.util.hibernate.HibernateUtil;

public class WorkflowDaoImpl {
	public WorkflowDaoImpl() {
		super();
		sf = HibernateUtil.getSessionFactory();
	}

	SessionFactory sf;
	
	
	
	public ArrayList<Workflow> getAllWorkflows()
	{
		ArrayList<Workflow> wfList = new ArrayList<Workflow>();
		try
		{
			Session session = sf.openSession();
			Criteria crit = session.createCriteria(Workflow.class);
			System.out.println(crit.list().size());
			if(!crit.list().isEmpty())
			wfList = (ArrayList<Workflow>) crit.list();
			
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return wfList;
	}

	
	public Workflow updateWorkflow(Workflow workflow) {
		Workflow wf = null;
		try
		{
			Session session = sf.openSession();
			System.out.println("in.redexp.watersupply.dao.impl.WorkflowDaoImpl.updateWorkflow(Workflow)");
			
				System.out.println("workflow: " +workflow.getWorkflowID());
				System.out.println("workflow process: " +workflow.getProcessInDays());
			Transaction tx = session.beginTransaction();
			 tx.begin();
			 wf = (Workflow) session.createCriteria(Workflow.class).add(Restrictions.eq("workflowID", workflow.getWorkflowID())).uniqueResult();
			 System.out.println("workflow from session: " +wf.getWorkflowID());
			 wf.setAction(workflow.getAction());
			 wf.setFromLocID(workflow.getFromLocID());
			 wf.setFromRoleId(workflow.getFromRoleId());
			 wf.setProcessInDays(workflow.getProcessInDays());
			 wf.setToLocID(workflow.getToLocID());
			 wf.setToRoleId(workflow.getToRoleId());
			session.saveOrUpdate(wf);
			tx.commit();
			session.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
			
		}
		return wf;
	}

	public Workflow getWorkflowByID(Long workflowID) {
		Workflow workflow = null;
		try
		{
			Session session = sf.openSession();
			Criteria crit = session.createCriteria(Workflow.class);
		crit.add(Restrictions.eq("workflowID", workflowID));
			workflow = (Workflow) crit.uniqueResult();
			
			session.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
			
		}
		return workflow;
	}

	public Workflow updateWorkflow(Long workflowID, String fromRoleID,
			String fromLocID, String toLocID, String toRoleID, String action,
			Integer processInDays) {
		Workflow wf = null;
		try {
			Session session = sf.openSession();
			System.out.println("in.redexp.watersupply.dao.impl.WorkflowDaoImpl.updateWorkflow(Workflow)");
			
			
			Transaction tx = session.beginTransaction();
			 tx.begin();
			 wf = (Workflow) session.createCriteria(Workflow.class).add(Restrictions.eq("workflowID", workflowID)).uniqueResult();
			 System.out.println("workflow from session: " +wf.getWorkflowID());
			 wf.setAction(action);
			 wf.setFromLocID(fromLocID);
			 wf.setFromRoleId(fromRoleID);
			 wf.setProcessInDays(processInDays);
			 wf.setToLocID(toLocID);
			 wf.setToRoleId(toRoleID);
			 session.saveOrUpdate(wf);
				tx.commit();
				session.close();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wf;
	}

	public ArrayList<Workflow> getWorkflowForUser(String fromRoleID, String fromLocID) {
		ArrayList<Workflow> workflowList = null;
		try
		{
			Session session = sf.openSession();
			Criteria crit = session.createCriteria(Workflow.class);
			crit.add(Restrictions.eq("fromRoleId", fromRoleID));
			crit.add(Restrictions.eq("fromLocID", fromLocID));
			workflowList = (ArrayList<Workflow>) crit.list();
			
			session.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
			
		}
		return workflowList;
	}

}
