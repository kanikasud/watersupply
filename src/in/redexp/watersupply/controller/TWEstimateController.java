package in.redexp.watersupply.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import in.redexp.watersupply.dao.impl.DivisionDaoImpl;
import in.redexp.watersupply.dao.impl.EstimateDaoImpl;
import in.redexp.watersupply.dao.impl.SchemeDaoImpl;
import in.redexp.watersupply.dao.impl.SchemeVillageDaoImpl;
import in.redexp.watersupply.dao.impl.SubDivisionDaoImpl;
import in.redexp.watersupply.dao.impl.VillageDaoImpl;
import in.redexp.watersupply.dao.impl.WorkflowDaoImpl;
import in.redexp.watersupply.model.Division;
import in.redexp.watersupply.model.EstimateDetailsCanal;
import in.redexp.watersupply.model.EstimateDetailsTubeWell;
import in.redexp.watersupply.model.EstimateInbox;
import in.redexp.watersupply.model.Scheme;
import in.redexp.watersupply.model.SchemeVillage;
import in.redexp.watersupply.model.SubDivision;
import in.redexp.watersupply.model.Village;
import in.redexp.watersupply.model.VillagePopulation;
import in.redexp.watersupply.model.Workflow;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class TWEstimateController extends ActionSupport implements Action , ModelDriven<EstimateDetailsTubeWell>, ServletContextAware, 
ServletRequestAware, ServletResponseAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String dispatchNo;
	private String remarks;
	private InputStream inputStream;
	

	public TWEstimateController() {
		super();
		tubewellEstimate = new EstimateDetailsTubeWell();
	}

	
	@Override
	public String execute() {
		
		System.out.println("in.redexp.watersupply.controller.TubeWellEstimateController.execute()");
		return SUCCESS;
	}
	
	
	public String showTubeWellEstimate()
	{
		try
		{
			EstimateDaoImpl dao = new EstimateDaoImpl();
			Long id = (Long) request.getAttribute("id");
			EstimateDetailsTubeWell tubewellEstimate = dao.getTWEstimateByID(id);
			System.out.println(tubewellEstimate);
			if(tubewellEstimate!=null)
			{
				System.out.println("tubewellEstimate: " +tubewellEstimate.getEstimateID());
				request.setAttribute("tubewellEstimate", tubewellEstimate);
			}
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	

	
	
	public String saveEstimateTubeWell()
	{
		System.out.println("in.redexp.watersupply.controller.TubeWellEstimateController.saveEstimateTubeWell()");
		
		try
		{
			
			
			
				tubewellEstimate.setDivisionID(request.getParameter("divisionID"));
				tubewellEstimate.setSchemeID(request.getParameter("schemeID"));
			
				
				
			EstimateDaoImpl dao = new EstimateDaoImpl();
			Long id = dao.saveTWEstimate(tubewellEstimate);
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
	
	
	public String exportTWEstimateDetails() {
		  
		  try {
		   
			  String path = servletContext.getRealPath(File.separator) + "\\report.xls";
			  @SuppressWarnings("resource")
			HSSFWorkbook workbook = new HSSFWorkbook();
			  HSSFSheet sheet = workbook.createSheet("Basic");
			 
			  FileOutputStream out = 
			            new FileOutputStream(path);
			  Map<String, ArrayList<String>> data = new HashMap<String, ArrayList<String>>();
			 
			  
			  //get Estimate by id
			  Long estimateID = Long.valueOf(request.getParameter("tubewellEstimateID"));
			  EstimateDaoImpl dao = new EstimateDaoImpl();
			  EstimateDetailsTubeWell twEstimate =  dao.getTWEstimateByID(estimateID);
			  String divID = twEstimate.getDivisionID();
			  String subDivID = twEstimate.getSubDivisionID();
			  String schemeID = twEstimate.getSchemeID();
			  
			  SubDivisionDaoImpl subDivDao = new SubDivisionDaoImpl();
			  SubDivision subDiv= subDivDao.getSubDivisionById(subDivID);
			  
			  DivisionDaoImpl divDao = new DivisionDaoImpl();
			  Division div = divDao.getDivisionByID(divID);
			  
			  SchemeDaoImpl schemeDao = new SchemeDaoImpl();
			  Scheme scheme = schemeDao.getSchemeByID(schemeID);
			  
			 SchemeVillageDaoImpl schemeVillageMapping = new SchemeVillageDaoImpl();
			 SchemeVillage schemeVillage = schemeVillageMapping.getSchemePrepDetailsBySchemeID(schemeID);
			
			 // Objecet[] headerArray = new Object[] {"Division", "SubDivision", "Name Of Scheme"};
			  //data.put("1", headerArray);
			  //Object[] rowObject = new Object[]{div.getDivName(), subDiv.getSubDivisionalName(), scheme.getSchemeName()};
			  //data.put("2", rowObject);
			  
			  ArrayList<String> headerArray = new ArrayList<String>();
			  headerArray.add("District");
			  headerArray.add("Division");
			  headerArray.add("Sub Division");
			  headerArray.add("Scheme Name");
			  
			  
			  //headerArray.add("Constituencies");
			  //headerArray.add("Block");
			 
			  //headerArray.add("Villages Covered (No. of Villages with Name and Hadbast No)");
			  headerArray.add("Date of Previous Commissioning with program");
			  headerArray.add("Date of Completion");
			  //headerArray.add("Total Present No. of House Holds");
			  //headerArray.add("Existing No. of Connections");
			//  headerArray.add("Previously Executed Scheme under SWAP");
			 // headerArray.add("Scheme Quality Affected");
			 // headerArray.add("Previous Service Level (lpcd)");
			 // headerArray.add("Resolution Received ?");
			  headerArray.add("GPWSCs Formed ?");
			  headerArray.add("SLC Formed Formed ?");
			  
			  ArrayList<String> row1 = new ArrayList<String>();
			  row1.add(div.getDistID());
			  row1.add(div.getDivName());
			  row1.add(subDiv.getSubDivisionalName());
			  row1.add(scheme.getSchemeName());
			  row1.add(schemeVillage.getSchemeCommisionedDate());
			  row1.add(schemeVillage.getSchemeCompletedDate());
			  if(twEstimate.getGpwsc() != null)
			   {row1.add(twEstimate.getGpwsc().toString());}
			  else
			   {row1.add("false");}
			  if(twEstimate.getSlcFormed() != null)
			  row1.add(twEstimate.getSlcFormed().toString());
			  else
			   {row1.add("false");}
			  
			  data.put("1", headerArray);
			  data.put("2", row1);
			  Set<String> keyset = data.keySet();
			  int rownum = 0;
			  for (String key : keyset) {
			      Row row = sheet.createRow(rownum++);
			      ArrayList<String> arr = data.get(key);
			      int cellnum = 0;
			      for (Object obj : arr) {
			          Cell cell = row.createCell(cellnum++);
			          if(obj instanceof Date) 
			              cell.setCellValue((Date)obj);
			          else if(obj instanceof Boolean)
			              cell.setCellValue((Boolean)obj);
			          else if(obj instanceof String)
			              cell.setCellValue((String)obj);
			          else if(obj instanceof Double)
			              cell.setCellValue((Double)obj);
			      }
			  }
			  
			  HSSFSheet sheet2 = workbook.createSheet("Technical");
			  headerArray = new ArrayList<String>();
			 
			  headerArray.add("Division");
			  headerArray.add("Sub Division");
			  headerArray.add("Scheme Name");
			  headerArray.add("Whether existing Sch. is sufficient to deliver 10 hours water supply at 70 lpcd");
			  headerArray.add("Discharge of Pumping Machinery");
			  headerArray.add("Proposed Running Hours");
			  
			  headerArray.add("Repair or Replacement of Existing Machinery, if Required(Yes/No)");
			  headerArray.add("Repair/Replacement of existing machinery");
			  headerArray.add("Horse Power (in BHP)");
			  headerArray.add("Head [In Mtrs]");
			  headerArray.add("Discharge [In lph]");
			  /*ArrayList<String> subheaderArray = new ArrayList<String>();
			  subheaderArray.add("Proposed Running Hours");*/
			 /* headerArray.add("Repair / Replacement of Control Panel, if Any?");
			  headerArray.add("Repair / Replacement of Control Panel");
			  headerArray.add("Cost");
			  
			  headerArray.add("Cost of Repair of Pump Chamber, if any");
			  headerArray.add("Cost of Repair of OHSR , if any");
			  headerArray.add("Cost of Repair of other Existing Components of Water Works, if any");*/
			  
			  
			  row1 = new ArrayList<String>();
			  row1.add(div.getDistID());
			  row1.add(div.getDivName());
			  row1.add(subDiv.getSubDivisionalName());
			  row1.add(scheme.getSchemeName());
			  if(twEstimate.getIsSchemeSufficient() != null)
				  row1.add(twEstimate.getIsSchemeSufficient().toString());
			  {row1.add("false");}
			  row1.add(twEstimate.getDischargeOfPumpingMachinery());
			  row1.add(twEstimate.getProposedRunningHrsMachinery());
			  if(twEstimate.getIsRepairRequiredExisting() != null)
				  row1.add(twEstimate.getIsRepairRequiredExisting().toString());
			  else
				  row1.add("false");
			  row1.add(twEstimate.getHorsePowerInBHP());
			  
			  data.put("1", headerArray);
			  data.put("2", row1);
			  keyset = data.keySet();
			 rownum = 0;
			  for (String key : keyset) {
			      Row row = sheet2.createRow(rownum++);
			      ArrayList<String> arr = data.get(key);
			      int cellnum = 0;
			      for (Object obj : arr) {
			          Cell cell = row.createCell(cellnum++);
			          if(obj instanceof Date) 
			              cell.setCellValue((Date)obj);
			          else if(obj instanceof Boolean)
			              cell.setCellValue((Boolean)obj);
			          else if(obj instanceof String)
			              cell.setCellValue((String)obj);
			          else if(obj instanceof Double)
			              cell.setCellValue((Double)obj);
			      }
			  }
			  
			  workbook.write(out);
			  out.close();
			  
			  File fileToDownload = new File(path);
			  
		        inputStream = new FileInputStream(fileToDownload);
		        
		         
		   } catch (Exception e) {
		   e.printStackTrace();
		   return ERROR;
		  }
		return SUCCESS;
	}
		
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		response =arg0;
	}
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		request = arg0;
	}
	@Override
	public void setServletContext(ServletContext arg0) {
		// TODO Auto-generated method stub
		servletContext = arg0;
	}
	@Override
	public EstimateDetailsTubeWell getModel() {
		// TODO Auto-generated method stub
		return tubewellEstimate;
	}
	
	
	private Long estimateID;
	private String schemeID;
	private String divisionID;
	private ArrayList<SubDivision> subDivisionIDList;
	private Boolean slcFormed;
	private Boolean gpwsc;
	private String dischargeOfPumpingMachinery;
	private String proposedRunningHrsMachinery;
	private String hPForPumpingMachinery;
	private Boolean isSchemeSufficient;
	private Boolean isRepairRequiredExisting;
	private String existingRepairOrReplacement;
	private String horsePowerInBHP;
	private String headInMtrs;
	private String dischargeInLPH;
	private Boolean isRepairCPRequired;
	private String cpRepair;
	private String costOfRepairPump;
	private String costOfRepairOHSR;
	private String costOfRepairExistingComponents;
	private String costOfChlorination;
	private String costOfRepairPipeLine;
	private String costOfController;
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
	private String subDivisionID;
	private String addedNewWaterPipeline;
	private String numberOfNewWaterPipeline;
	private HttpServletResponse response;
	private HttpServletRequest request;
	private ServletContext servletContext;
	private String actionType;
	private EstimateDetailsTubeWell tubewellEstimate;
	private String sendTo;
	
	
	
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

	public EstimateDetailsTubeWell getTubewellEstimate() {
		return tubewellEstimate;
	}

	public void setTubewellEstimate(EstimateDetailsTubeWell tubewellEstimate) {
		this.tubewellEstimate = tubewellEstimate;
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

	public ArrayList<SubDivision> getSubDivisionIDList() {
		return subDivisionIDList;
	}

	public void setSubDivisionIDList(ArrayList<SubDivision> subDivisionIDList) {
		this.subDivisionIDList = subDivisionIDList;
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

	public String getDischargeOfPumpingMachinery() {
		return dischargeOfPumpingMachinery;
	}

	public void setDischargeOfPumpingMachinery(String dischargeOfPumpingMachinery) {
		this.dischargeOfPumpingMachinery = dischargeOfPumpingMachinery;
	}

	public String getProposedRunningHrsMachinery() {
		return proposedRunningHrsMachinery;
	}

	public void setProposedRunningHrsMachinery(String proposedRunningHrsMachinery) {
		this.proposedRunningHrsMachinery = proposedRunningHrsMachinery;
	}

	public String gethPForPumpingMachinery() {
		return hPForPumpingMachinery;
	}

	public void sethPForPumpingMachinery(String hPForPumpingMachinery) {
		this.hPForPumpingMachinery = hPForPumpingMachinery;
	}

	public Boolean getIsSchemeSufficient() {
		return isSchemeSufficient;
	}

	public void setIsSchemeSufficient(Boolean isSchemeSufficient) {
		this.isSchemeSufficient = isSchemeSufficient;
	}

	public Boolean getIsRepairRequiredExisting() {
		return isRepairRequiredExisting;
	}

	public void setIsRepairRequiredExisting(Boolean isRepairRequiredExisting) {
		this.isRepairRequiredExisting = isRepairRequiredExisting;
	}

	public String getExistingRepairOrReplacement() {
		return existingRepairOrReplacement;
	}

	public void setExistingRepairOrReplacement(String existingRepairOrReplacement) {
		this.existingRepairOrReplacement = existingRepairOrReplacement;
	}

	public String getHorsePowerInBHP() {
		return horsePowerInBHP;
	}

	public void setHorsePowerInBHP(String horsePowerInBHP) {
		this.horsePowerInBHP = horsePowerInBHP;
	}

	public String getHeadInMtrs() {
		return headInMtrs;
	}

	public void setHeadInMtrs(String headInMtrs) {
		this.headInMtrs = headInMtrs;
	}

	public String getDischargeInLPH() {
		return dischargeInLPH;
	}

	public void setDischargeInLPH(String dischargeInLPH) {
		this.dischargeInLPH = dischargeInLPH;
	}

	public Boolean getIsRepairCPRequired() {
		return isRepairCPRequired;
	}

	public void setIsRepairCPRequired(Boolean isRepairCPRequired) {
		this.isRepairCPRequired = isRepairCPRequired;
	}

	public String getCpRepair() {
		return cpRepair;
	}

	public void setCpRepair(String cpRepair) {
		this.cpRepair = cpRepair;
	}

	public String getCostOfRepairPump() {
		return costOfRepairPump;
	}

	public void setCostOfRepairPump(String costOfRepairPump) {
		this.costOfRepairPump = costOfRepairPump;
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

	public String getCostOfChlorination() {
		return costOfChlorination;
	}

	public void setCostOfChlorination(String costOfChlorination) {
		this.costOfChlorination = costOfChlorination;
	}

	public String getCostOfRepairPipeLine() {
		return costOfRepairPipeLine;
	}

	public void setCostOfRepairPipeLine(String costOfRepairPipeLine) {
		this.costOfRepairPipeLine = costOfRepairPipeLine;
	}

	public String getCostOfController() {
		return costOfController;
	}

	public void setCostOfController(String costOfController) {
		this.costOfController = costOfController;
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

	public ServletContext getServletContext() {
		return servletContext;
	}


	public String getSubDivisionID() {
		return subDivisionID;
	}


	public void setSubDivisionID(String subDivisionID) {
		this.subDivisionID = subDivisionID;
	}


	public String getActionType() {
		return actionType;
	}


	public void setActionType(String actionType) {
		this.actionType = actionType;
	}


	public String getSendTo() {
		return sendTo;
	}


	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
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


	public InputStream getInputStream() {
		return inputStream;
	}


	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	

	
}
