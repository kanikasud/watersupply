package in.redexp.watersupply.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="prwss_main.mst_workflow_mapping")
public class Workflow implements Serializable{

	public Workflow() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Long workflowID;
	String fromRoleId;
	String fromLocID;
	String toRoleId;
	String toLocID;
	String action;
	Integer processInDays;
	public Long getWorkflowID() {
		return workflowID;
	}
	public void setWorkflowID(Long workflowID) {
		this.workflowID = workflowID;
	}
	public String getFromLocID() {
		return fromLocID;
	}
	public void setFromLocID(String fromLocID) {
		this.fromLocID = fromLocID;
	}
	public String getToRoleId() {
		return toRoleId;
	}
	public void setToRoleId(String toRoleId) {
		this.toRoleId = toRoleId;
	}
	public String getToLocID() {
		return toLocID;
	}
	public void setToLocID(String toLocID) {
		this.toLocID = toLocID;
	}
	public String getFromRoleId() {
		return fromRoleId;
	}
	public void setFromRoleId(String fromRoleId) {
		this.fromRoleId = fromRoleId;
		//System.out.println("in.redexp.watersupply.model.Workflow.setFromRoleId(String): " + fromRoleId);
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Integer getProcessInDays() {
		return processInDays;
	}
	public void setProcessInDays(Integer processInDays) {
		this.processInDays = processInDays;
	}
	
	
}
