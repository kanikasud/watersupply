package in.redexp.watersupply.controller;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.redexp.watersupply.dao.impl.WorkflowDaoImpl;
import in.redexp.watersupply.model.User;
import in.redexp.watersupply.model.Workflow;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

public class WorkflowController implements Action, ModelDriven<Workflow>, ServletContextAware, ServletRequestAware, ServletResponseAware {
	public WorkflowController() {
		super();
		workflow = new Workflow();
	}

	private HttpServletRequest request = null;
    private HttpServletResponse response = null;
    private ServletContext servletContext;
    private Workflow workflow;
	private ArrayList<Workflow> wfList;
	private String fromRoleID;
	private String fromLocID;
	private String toRoleID;
	private String toLocID;
	private Integer processInDays;
	private String action;
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		response = arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		request = arg0;
		
	}

	@Override
	public void setServletContext(ServletContext arg0) {
		servletContext = arg0;
		
	}

	@Override
	public Workflow getModel() {
		
		return workflow;
	}

	@Override
	public String execute() throws Exception {
		try
		{
			System.out.println("in.redexp.watersupply.controller.WorkflowController.execute()");
			WorkflowDaoImpl dao = new WorkflowDaoImpl();
			wfList = dao.getAllWorkflows();
			if(wfList== null || wfList.size() == 0)
				return ERROR;
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String updateWorkflow()
	{
		try
		{
			WorkflowDaoImpl dao = new WorkflowDaoImpl();
			Long workflowID = Long.valueOf(request.getParameter("workflowID"));
			/*workflow.setWorkflowID(workflowID);
			 workflow = dao.getWorkflowByID(workflowID);*/
			 System.out.println("in.redexp.watersupply.controller.WorkflowController.updateWorkflow()");
				System.out.println(workflowID);
				//workflow = dao.getWorkflowByID(workflowID);
				System.out.println("Request Parameter: Before Update: " + request.getParameter("process"));
				System.out.println("Before Update: " + workflow.getProcessInDays());
				System.out.println("Before Update: " + workflow.getAction());
			
			fromRoleID = request.getParameter("fromRoleID");
			fromLocID = request.getParameter("fromLocID");
			toLocID = request.getParameter("toLocID");
			toRoleID = request.getParameter("toRoleID"); 
			action = request.getParameter("action");
			processInDays = Integer.parseInt(request.getParameter("process"));
			
			
			workflow = dao.updateWorkflow(workflowID, fromRoleID, fromLocID, toLocID, toRoleID, action, processInDays);
			System.out.println("Updated Workflow Process: " + workflow.getProcessInDays());
			if(workflow == null)
				return ERROR;
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return SUCCESS;
	}

	public HttpServletRequest getRequest() {
		return request;
	}


	
	
	public ArrayList<Workflow> getWfList() {
		return wfList;
	}

	public void setWfList(ArrayList<Workflow> wfList) {
		this.wfList = wfList;
	}

	public ServletContext getServletContext() {
		return servletContext;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public String getFromRoleID() {
		return fromRoleID;
	}

	public void setFromRoleID(String fromRoleID) {
		this.fromRoleID = fromRoleID;
	}

	public String getFromLocID() {
		return fromLocID;
	}

	public void setFromLocID(String fromLocID) {
		this.fromLocID = fromLocID;
	}

	public String getToRoleID() {
		return toRoleID;
	}

	public void setToRoleID(String toRoleID) {
		this.toRoleID = toRoleID;
	}

	public String getToLocID() {
		return toLocID;
	}

	public void setToLocID(String toLocID) {
		this.toLocID = toLocID;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public Integer getProcessInDays() {
		return processInDays;
	}

	public void setProcessInDays(Integer processInDays) {
		this.processInDays = processInDays;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Workflow getWorkflow() {
		return workflow;
	}

	public void setWorkflow(Workflow workflow) {
		this.workflow = workflow;
	}

}
