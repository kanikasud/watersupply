package in.redexp.watersupply.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table
@Entity(name="prwss_main.mst_canal_estimate")
public class EstimateDetailsCanal implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long estimateID;
	private String schemeID;
	private String divisionID;
	private String subDivisionID;
	private ArrayList<SubDivision> subDivisionIDList;
	private Boolean slcFormed;
	private Boolean gpwsc;
	
	private String dischargeOfPumpingMachinery;
	private String proposedRunningHrsMachinery;
	private Boolean isSchemeSufficient;
	
	private String costOfRepairInlet;
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
	public String getSubDivisionID() {
		return subDivisionID;
	}
	public void setSubDivisionID(String subDivisionID) {
		this.subDivisionID = subDivisionID;
	}
	public Boolean isSlcFormed() {
		System.out.println("in.redexp.watersupply.model.EstimateDetailsCanal.isSlcFormed(): " + slcFormed);
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
		System.out.println("in.redexp.watersupply.model.EstimateDetailsCanal.isGpwsc: " + gpwsc);
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
	
	public Boolean getIsSchemeSufficient() {
		System.out.println("getIsSchemeSufficient" + isSchemeSufficient);
		return isSchemeSufficient;
	}
	public void setIsSchemeSufficient(Boolean isSchemeSufficient) {
		this.isSchemeSufficient = isSchemeSufficient;
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
	
	public String getCostOfRepairPipeLine() {
		return costOfRepairPipeLine;
	}
	public void setCostOfRepairPipeLine(String costOfRepairPipeLine) {
		this.costOfRepairPipeLine = costOfRepairPipeLine;
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
		System.out.println("in.redexp.watersupply.model.EstimateDetailsCanal.getGpwsc()" + gpwsc);
		return gpwsc;
	}
	public String getCostOfRepairInlet() {
		return costOfRepairInlet;
	}
	public void setCostOfRepairInlet(String costOfRepairInlet) {
		this.costOfRepairInlet = costOfRepairInlet;
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
		System.out.println("in.redexp.watersupply.model.EstimateDetailsCanal.getRepairTreatmentPlant(): " + repairTreatmentPlant);
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
	public Boolean getSlcFormed() {
		System.out.println("in.redexp.watersupply.model.EstimateDetailsCanal.getSlcFormed(): " + slcFormed);
		return slcFormed;
	}
	public String getRepairOrReplacementPumpCanal() {
		return repairOrReplacementPumpCanal;
	}
	public void setRepairOrReplacementPumpCanal(String repairOrReplacementPumpCanal) {
		this.repairOrReplacementPumpCanal = repairOrReplacementPumpCanal;
	}
	public Boolean getChlorinationCanalRequired() {
		return chlorinationCanalRequired;
	}
	public void setChlorinationCanalRequired(Boolean chlorinationCanalRequired) {
		this.chlorinationCanalRequired = chlorinationCanalRequired;
	}
	public Boolean getControllerCanalRequired() {
		return controllerCanalRequired;
	}
	public void setControllerCanalRequired(Boolean controllerCanalRequired) {
		this.controllerCanalRequired = controllerCanalRequired;
	}
	
	
}
