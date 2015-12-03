package in.redexp.watersupply.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table
@Entity(name="prwss_main.mst_tubewell_estimate")
public class EstimateDetailsTubeWell implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long estimateID;
	private String schemeID= "-";
	private String divisionID= "-";
	private String subDivisionID= "-";
	private ArrayList<SubDivision> subDivisionIDList;
	private Boolean slcFormed;
	private Boolean gpwsc;
	private String dischargeOfPumpingMachinery= "-";
	private String proposedRunningHrsMachinery= "-";
	private String hPForPumpingMachinery= "-";
	private Boolean isSchemeSufficient;
	private Boolean isRepairRequiredExisting;
	private String existingRepairOrReplacement= "-";
	private String horsePowerInBHP= "-";
	private String headInMtrs = "-";
	private String dischargeInLPH= "-";
	private Boolean isRepairCPRequired;
	private String cpRepairOrReplacement= "-";
	private String costOfRepairPump= "-";
	private String costOfRepairCP= "-";
	private String costOfRepairOHSR= "-";
	private String costOfRepairExistingComponents= "-";
	private String costOfChlorination= "-";
	private String costOfRepairPipeLine= "-";
	private String costOfController;
	private String len160mmPipeline = "-";
	private String len110mmPipeline = "-";
	private String len90mmPipeline = "-";
	private String len75mmPipeline = "-";;
	private String len63mmPipeline = "-";
	private String len150mmSluiceValve = "-";
	private String len100mmSluiceValve= "-";
	private String len80mmSluiceValve= "-";
	private String len60Mtr = "-";
	private String len90Mtr = "-";
	private String dismantlingBrick= "-";
	private String dismantlingCCFlooring= "-";
	private String BTBillCost= "-";
	private String noOfWaterMeter= "-";
	private String installSignBoard= "-"; //choose between paint/existing
	private String signBoardDetails= "-";
	private String costOfSignBoard= "-";
	private String addedNewWaterPipeline= "-";
	private String numberOfNewWaterPipeline= "-";
	private String categoryID = "";
	public String getSubDivisionID() {
		return subDivisionID;
	}
	public void setSubDivisionID(String subDivisionID) {
		this.subDivisionID = subDivisionID;
	}
	public Boolean isSlcFormed() {
		return slcFormed;
	}
	public void setSlcFormed(Boolean slcFormed) {
		this.slcFormed = slcFormed;
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
		this.schemeID = schemeID;
	}
	public String getDivisionID() {
		return divisionID;
	}
	public void setDivisionID(String divisionID) {
		this.divisionID = divisionID;
	}
	public ArrayList<SubDivision> getSubDivisionIDList() {
		return subDivisionIDList;
	}
	public void setSubDivisionIDList(ArrayList<SubDivision> subDivisionIDList) {
		this.subDivisionIDList = subDivisionIDList;
	}
	
	
	public Boolean isGpwsc() {
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
	public String getCostOfSignBoard() {
		return costOfSignBoard;
	}
	public void setCostOfSignBoard(String costOfSignBoard) {
		this.costOfSignBoard = costOfSignBoard;
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
	
	public Boolean getGpwsc() {
		return gpwsc;
	}
	public String getCostOfRepairCP() {
		return costOfRepairCP;
	}
	public void setCostOfRepairCP(String costOfRepairCP) {
		this.costOfRepairCP = costOfRepairCP;
	}
	public String getCpRepairOrReplacement() {
		return cpRepairOrReplacement;
	}
	public void setCpRepairOrReplacement(String cpRepairOrReplacement) {
		this.cpRepairOrReplacement = cpRepairOrReplacement;
	}
	public Boolean getSlcFormed() {
		return slcFormed;
	}
	public String getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
	}
	
}
