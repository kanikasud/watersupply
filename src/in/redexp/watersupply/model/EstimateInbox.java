package in.redexp.watersupply.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table
@Entity(name="prwss_main.mst_estimate_inbox")
public class EstimateInbox implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Long inboxId;
	String estimateID;
	String sendToID;
	String sendToLoc;
	String dispatchNo;
	String remarks;
	public Long getInboxId() {
		return inboxId;
	}
	public void setInboxId(Long inboxId) {
		this.inboxId = inboxId;
	}
	public String getEstimateID() {
		return estimateID;
	}
	public void setEstimateID(String estimateID) {
		this.estimateID = estimateID;
	}
	public String getSendToID() {
		return sendToID;
	}
	public void setSendToID(String sendToID) {
		this.sendToID = sendToID;
	}
	public String getSendToLoc() {
		return sendToLoc;
	}
	public void setSendToLoc(String sendToLoc) {
		this.sendToLoc = sendToLoc;
	}
	public String getDispatchNo() {
		return dispatchNo;
	}
	public void setDispatchNo(String dispatchNo) {
		this.dispatchNo = dispatchNo;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	

}
