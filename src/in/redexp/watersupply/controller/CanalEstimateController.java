package in.redexp.watersupply.controller;

import in.redexp.watersupply.dao.impl.EstimateDaoImpl;
import in.redexp.watersupply.dao.impl.WorkflowDaoImpl;
import in.redexp.watersupply.model.EstimateDetailsCanal;
import in.redexp.watersupply.model.EstimateDetailsTubeWell;
import in.redexp.watersupply.model.EstimateInbox;
import in.redexp.watersupply.model.SubDivision;
import in.redexp.watersupply.model.Workflow;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CanalEstimateController extends ActionSupport implements Action , ModelDriven<EstimateDetailsCanal>, ServletContextAware, 
ServletRequestAware, ServletResponseAware{
	public CanalEstimateController() {
		super();
		canalEstimate = new EstimateDetailsCanal();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long estimateID;
	private String schemeID;
	private String divisionID;
	private String subDivisionID;
	private Boolean slcFormed;
	private Boolean gpwsc;
	
	private Boolean repairRawWater;
	private String repairOrReplacementRWM;
	
	private String horsePowerRW;
	private String headInMtrsRW;
	private String dischargeInLPHRW;
	private String repairRawWaterCost;
	
	private Boolean repairClearWater;
	private String repairOrReplacementRCWM;
	private String costOfRepairRCWM;
	private String headInMtrsRCWM;
	private String dischargeInLPHRCWM;
	
	private String costOfReplacingFilterMedia;
	private String costOfRepairFilterBeds;
	private String costOfStorageTank;
	private String costOfRepairHighLevelTank;
	private String costOfRepairOfSAndSWell;
	private String costOfRepairOfClearWater;
	
	private Boolean repairTreatmentPlant;
	private String costOfRepairTreatmentPlant;
	
	
	
	
	private Boolean repairrepCP;
	private String repairOrReplacementCPCanal;
	private String costOfRepairCPCanal;
	private String costOfRepairPumpCanal;
	private String repairOrReplacementPumpCanal;
	
	private String costOfRepairOHSR;
	private String costOfRepairExistingComponents;
	private Boolean chlorinationCanalRequired;
	private String costOfRepairPipeLine;
	private Boolean controllerCanalRequired;
	private String len160mmPipeline;
	private String len110mmPipeline;
	private String len90mmPipeline;
	private String len75mmPipeline;
	private String len63mmPipeline;
	private String len150mmSluiceValve;
	private String len100mmSluiceValve;
	private String len80mmSluiceValve;
	private String len60Mtr;
	private String len90Mtr;
	private String dismantlingBrick;
	private String dismantlingCCFlooring;
	private String BTBillCost;
	private String noOfWaterMeter;
	private String installSignBoard; //choose between paint/existing
	private String signBoardDetails;
	private String costOfSignBoard;
	private String addedNewWaterPipeline;
	private String numberOfNewWaterPipeline;
	
	
	private HttpServletResponse response;
	private HttpServletRequest request;
	private ServletContext servletContext;
	private EstimateDetailsCanal canalEstimate;
	private String actionType;
	private String dispatchNo;
	private String remarks;
	private String sendTo;
	
	
	public String showCanalEstimate()
	{
		try
		{
			EstimateDaoImpl dao = new EstimateDaoImpl();
			Long id = (Long) request.getAttribute("id");
			EstimateDetailsCanal canalEstimate = dao.getCanalEstimateByID(id);
			System.out.println(canalEstimate);
			if(canalEstimate!=null)
			{
				System.out.println("canalEstimate: " +canalEstimate.getEstimateID());
				request.setAttribute("canalEstimate", canalEstimate);
			}
			
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	
	
	
	
	
	
	public String saveEstimateCanal()
	{
		System.out.println("in.redexp.watersupply.controller.TubeWellEstimateController.saveEstimateCanal()");
		
		try
		{
			
			
			
			canalEstimate.setDivisionID(request.getParameter("divisionID"));
			canalEstimate.setSchemeID(request.getParameter("schemeID"));
			
			
				
			EstimateDaoImpl dao = new EstimateDaoImpl();
			Long id = dao.saveCanalEstimate(canalEstimate);
			System.out.println("actionType: " + actionType);
			if(actionType.equals("saveAndFinalize") && id != null)
			{
				//store workflow and estimate id in a table - inbox
				EstimateInbox inbox = new EstimateInbox();
				inbox.setDispatchNo(dispatchNo);
				inbox.setEstimateID(String.valueOf(id));
				inbox.setRemarks(remarks);
				System.out.println("sendToString:::" + sendTo);
				/*int beginIndex = sendTo.indexOf('(');
				int endIndex = sendTo.indexOf(')');
				int roleIDBeginIndex = 0;
				int roleIDEndIndex = sendTo.indexOf('(') - 1;
				String sendToLocID = sendTo.substring(beginIndex+1, endIndex);
				String sendToRoleID = sendTo.substring(roleIDBeginIndex, roleIDEndIndex);*/
				
				WorkflowDaoImpl wfDao = new WorkflowDaoImpl();
				Workflow wf = wfDao.getWorkflowByID(Long.valueOf(sendTo));
				String sendToRoleID  = wf.getToRoleId();
				String sendToLocID  = wf.getToLocID();
				inbox.setSendToID(sendToRoleID);
				inbox.setSendToLoc(sendToLocID);
				dao.saveToInbox(inbox);
				System.out.println("Sending to: " + sendToRoleID + "at location: " + sendToLocID);
			}
			request.setAttribute("id", id);
			if(id == null)
				return ERROR;
		}catch(Exception ex)
		{
			ex.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	
	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	

	public Long getEstimateID() {
		return estimateID;
	}

	public void setEstimateID(Long estimateID) {
		this.estimateID = estimateID;
	}

	public String getSchemeID() {
		return schemeID;
	}

	public void setSchemeID(String schemeID) {
		System.out.println(schemeID);
		this.schemeID = schemeID;
	}

	public String getDivisionID() {
		return divisionID;
	}

	public void setDivisionID(String divisionID) {
		this.divisionID = request.getParameter(divisionID);
	}

	

	public Boolean getSlcFormed() {
		return slcFormed;
	}

	public void setSlcFormed(Boolean slcFormed) {
		this.slcFormed = slcFormed;
	}

	public Boolean getGpwsc() {
		return gpwsc;
	}

	public void setGpwsc(Boolean gpwsc) {
		this.gpwsc = gpwsc;
	}

	
	public ServletContext getServletContext() {
		return servletContext;
	}


	public String getSubDivisionID() {
		return subDivisionID;
	}


	public void setSubDivisionID(String subDivisionID) {
		this.subDivisionID = subDivisionID;
	}

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
		
	}

	@Override
	public EstimateDetailsCanal getModel() {
		// TODO Auto-generated method stub
		return canalEstimate;
	}

	public EstimateDetailsCanal getCanalEstimate() {
		return canalEstimate;
	}

	public void setCanalEstimate(EstimateDetailsCanal canalEstimate) {
		this.canalEstimate = canalEstimate;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
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

	public String getSendTo() {
		return sendTo;
	}

	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}






	public Boolean getRepairRawWater() {
		return repairRawWater;
	}






	public void setRepairRawWater(Boolean repairRawWater) {
		this.repairRawWater = repairRawWater;
	}






	public String getRepairOrReplacementRWM() {
		return repairOrReplacementRWM;
	}






	public void setRepairOrReplacementRWM(String repairOrReplacementRWM) {
		this.repairOrReplacementRWM = repairOrReplacementRWM;
	}






	public String getHorsePowerRW() {
		return horsePowerRW;
	}






	public void setHorsePowerRW(String horsePowerRW) {
		this.horsePowerRW = horsePowerRW;
	}






	public String getHeadInMtrsRW() {
		return headInMtrsRW;
	}






	public void setHeadInMtrsRW(String headInMtrsRW) {
		this.headInMtrsRW = headInMtrsRW;
	}






	public String getDischargeInLPHRW() {
		return dischargeInLPHRW;
	}






	public void setDischargeInLPHRW(String dischargeInLPHRW) {
		this.dischargeInLPHRW = dischargeInLPHRW;
	}






	public String getRepairRawWaterCost() {
		return repairRawWaterCost;
	}






	public void setRepairRawWaterCost(String repairRawWaterCost) {
		this.repairRawWaterCost = repairRawWaterCost;
	}






	public Boolean getRepairClearWater() {
		return repairClearWater;
	}






	public void setRepairClearWater(Boolean repairClearWater) {
		this.repairClearWater = repairClearWater;
	}






	public String getRepairOrReplacementRCWM() {
		return repairOrReplacementRCWM;
	}






	public void setRepairOrReplacementRCWM(String repairOrReplacementRCWM) {
		this.repairOrReplacementRCWM = repairOrReplacementRCWM;
	}






	public String getCostOfRepairRCWM() {
		return costOfRepairRCWM;
	}






	public void setCostOfRepairRCWM(String costOfRepairRCWM) {
		this.costOfRepairRCWM = costOfRepairRCWM;
	}






	public String getHeadInMtrsRCWM() {
		return headInMtrsRCWM;
	}






	public void setHeadInMtrsRCWM(String headInMtrsRCWM) {
		this.headInMtrsRCWM = headInMtrsRCWM;
	}






	public String getDischargeInLPHRCWM() {
		return dischargeInLPHRCWM;
	}






	public void setDischargeInLPHRCWM(String dischargeInLPHRCWM) {
		this.dischargeInLPHRCWM = dischargeInLPHRCWM;
	}






	public String getCostOfReplacingFilterMedia() {
		return costOfReplacingFilterMedia;
	}






	public void setCostOfReplacingFilterMedia(String costOfReplacingFilterMedia) {
		this.costOfReplacingFilterMedia = costOfReplacingFilterMedia;
	}






	public String getCostOfRepairFilterBeds() {
		return costOfRepairFilterBeds;
	}






	public void setCostOfRepairFilterBeds(String costOfRepairFilterBeds) {
		this.costOfRepairFilterBeds = costOfRepairFilterBeds;
	}






	public String getCostOfStorageTank() {
		return costOfStorageTank;
	}






	public void setCostOfStorageTank(String costOfStorageTank) {
		this.costOfStorageTank = costOfStorageTank;
	}






	public String getCostOfRepairHighLevelTank() {
		return costOfRepairHighLevelTank;
	}






	public void setCostOfRepairHighLevelTank(String costOfRepairHighLevelTank) {
		this.costOfRepairHighLevelTank = costOfRepairHighLevelTank;
	}






	public String getCostOfRepairOfSAndSWell() {
		return costOfRepairOfSAndSWell;
	}






	public void setCostOfRepairOfSAndSWell(String costOfRepairOfSAndSWell) {
		this.costOfRepairOfSAndSWell = costOfRepairOfSAndSWell;
	}






	public String getCostOfRepairOfClearWater() {
		return costOfRepairOfClearWater;
	}






	public void setCostOfRepairOfClearWater(String costOfRepairOfClearWater) {
		this.costOfRepairOfClearWater = costOfRepairOfClearWater;
	}






	public Boolean getRepairTreatmentPlant() {
		return repairTreatmentPlant;
	}






	public void setRepairTreatmentPlant(Boolean repairTreatmentPlant) {
		this.repairTreatmentPlant = repairTreatmentPlant;
	}






	public String getCostOfRepairTreatmentPlant() {
		return costOfRepairTreatmentPlant;
	}






	public void setCostOfRepairTreatmentPlant(String costOfRepairTreatmentPlant) {
		this.costOfRepairTreatmentPlant = costOfRepairTreatmentPlant;
	}






	public Boolean getRepairrepCP() {
		return repairrepCP;
	}






	public void setRepairrepCP(Boolean repairrepCP) {
		this.repairrepCP = repairrepCP;
	}






	public String getRepairOrReplacementCPCanal() {
		return repairOrReplacementCPCanal;
	}






	public void setRepairOrReplacementCPCanal(String repairOrReplacementCPCanal) {
		this.repairOrReplacementCPCanal = repairOrReplacementCPCanal;
	}






	public String getCostOfRepairCPCanal() {
		return costOfRepairCPCanal;
	}






	public void setCostOfRepairCPCanal(String costOfRepairCPCanal) {
		this.costOfRepairCPCanal = costOfRepairCPCanal;
	}






	public String getCostOfRepairPumpCanal() {
		return costOfRepairPumpCanal;
	}






	public void setCostOfRepairPumpCanal(String costOfRepairPumpCanal) {
		this.costOfRepairPumpCanal = costOfRepairPumpCanal;
	}






	public String getRepairOrReplacementPumpCanal() {
		return repairOrReplacementPumpCanal;
	}






	public void setRepairOrReplacementPumpCanal(String repairOrReplacementPumpCanal) {
		this.repairOrReplacementPumpCanal = repairOrReplacementPumpCanal;
	}






	public String getCostOfRepairOHSR() {
		return costOfRepairOHSR;
	}






	public void setCostOfRepairOHSR(String costOfRepairOHSR) {
		this.costOfRepairOHSR = costOfRepairOHSR;
	}






	public String getCostOfRepairExistingComponents() {
		return costOfRepairExistingComponents;
	}






	public void setCostOfRepairExistingComponents(
			String costOfRepairExistingComponents) {
		this.costOfRepairExistingComponents = costOfRepairExistingComponents;
	}






	public Boolean getChlorinationCanalRequired() {
		return chlorinationCanalRequired;
	}






	public void setChlorinationCanalRequired(Boolean chlorinationCanalRequired) {
		this.chlorinationCanalRequired = chlorinationCanalRequired;
	}






	public String getCostOfRepairPipeLine() {
		return costOfRepairPipeLine;
	}






	public void setCostOfRepairPipeLine(String costOfRepairPipeLine) {
		this.costOfRepairPipeLine = costOfRepairPipeLine;
	}






	public Boolean getControllerCanalRequired() {
		return controllerCanalRequired;
	}






	public void setControllerCanalRequired(Boolean controllerCanalRequired) {
		this.controllerCanalRequired = controllerCanalRequired;
	}






	public String getLen160mmPipeline() {
		return len160mmPipeline;
	}






	public void setLen160mmPipeline(String len160mmPipeline) {
		this.len160mmPipeline = len160mmPipeline;
	}






	public String getLen110mmPipeline() {
		return len110mmPipeline;
	}






	public void setLen110mmPipeline(String len110mmPipeline) {
		this.len110mmPipeline = len110mmPipeline;
	}






	public String getLen90mmPipeline() {
		return len90mmPipeline;
	}






	public void setLen90mmPipeline(String len90mmPipeline) {
		this.len90mmPipeline = len90mmPipeline;
	}






	public String getLen75mmPipeline() {
		return len75mmPipeline;
	}






	public void setLen75mmPipeline(String len75mmPipeline) {
		this.len75mmPipeline = len75mmPipeline;
	}






	public String getLen63mmPipeline() {
		return len63mmPipeline;
	}






	public void setLen63mmPipeline(String len63mmPipeline) {
		this.len63mmPipeline = len63mmPipeline;
	}






	public String getLen150mmSluiceValve() {
		return len150mmSluiceValve;
	}






	public void setLen150mmSluiceValve(String len150mmSluiceValve) {
		this.len150mmSluiceValve = len150mmSluiceValve;
	}






	public String getLen100mmSluiceValve() {
		return len100mmSluiceValve;
	}






	public void setLen100mmSluiceValve(String len100mmSluiceValve) {
		this.len100mmSluiceValve = len100mmSluiceValve;
	}






	public String getLen80mmSluiceValve() {
		return len80mmSluiceValve;
	}






	public void setLen80mmSluiceValve(String len80mmSluiceValve) {
		this.len80mmSluiceValve = len80mmSluiceValve;
	}






	public String getLen60Mtr() {
		return len60Mtr;
	}






	public void setLen60Mtr(String len60Mtr) {
		this.len60Mtr = len60Mtr;
	}






	public String getLen90Mtr() {
		return len90Mtr;
	}






	public void setLen90Mtr(String len90Mtr) {
		this.len90Mtr = len90Mtr;
	}






	public String getDismantlingBrick() {
		return dismantlingBrick;
	}






	public void setDismantlingBrick(String dismantlingBrick) {
		this.dismantlingBrick = dismantlingBrick;
	}






	public String getDismantlingCCFlooring() {
		return dismantlingCCFlooring;
	}






	public void setDismantlingCCFlooring(String dismantlingCCFlooring) {
		this.dismantlingCCFlooring = dismantlingCCFlooring;
	}






	public String getBTBillCost() {
		return BTBillCost;
	}






	public void setBTBillCost(String bTBillCost) {
		BTBillCost = bTBillCost;
	}






	public String getNoOfWaterMeter() {
		return noOfWaterMeter;
	}






	public void setNoOfWaterMeter(String noOfWaterMeter) {
		this.noOfWaterMeter = noOfWaterMeter;
	}






	public String getInstallSignBoard() {
		return installSignBoard;
	}






	public void setInstallSignBoard(String installSignBoard) {
		this.installSignBoard = installSignBoard;
	}






	public String getSignBoardDetails() {
		return signBoardDetails;
	}






	public void setSignBoardDetails(String signBoardDetails) {
		this.signBoardDetails = signBoardDetails;
	}






	public String getCostOfSignBoard() {
		return costOfSignBoard;
	}






	public void setCostOfSignBoard(String costOfSignBoard) {
		this.costOfSignBoard = costOfSignBoard;
	}






	public String getAddedNewWaterPipeline() {
		return addedNewWaterPipeline;
	}






	public void setAddedNewWaterPipeline(String addedNewWaterPipeline) {
		this.addedNewWaterPipeline = addedNewWaterPipeline;
	}






	public String getNumberOfNewWaterPipeline() {
		return numberOfNewWaterPipeline;
	}






	public void setNumberOfNewWaterPipeline(String numberOfNewWaterPipeline) {
		this.numberOfNewWaterPipeline = numberOfNewWaterPipeline;
	}
	
}
