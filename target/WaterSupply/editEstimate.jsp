<%@page import="in.redexp.watersupply.model.Workflow"%>
<%@page import="in.redexp.watersupply.model.Scheme"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="in.redexp.watersupply.dao.impl.VillageDaoImpl"%>
<%@page import="in.redexp.watersupply.model.Village"%>
<%@page import="in.redexp.watersupply.model.District"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
 <%
      Map categoryMap = (HashMap)request.getAttribute("categoryMap");
 Map populationMap = (HashMap)request.getAttribute("populationMap");
      ArrayList<Village> villList = (ArrayList<Village>)request.getAttribute("villageList");
      Scheme scheme = (Scheme)request.getAttribute("scheme");
      ArrayList<Workflow> wf = (ArrayList<Workflow>)request.getAttribute("workflowList");
      if(wf!=null)
      {
    	  System.out.println("wf.size" + wf.size());
    	  //System.out.println("wf.0.fromRole" + wf.get(0).getFromRoleId());
      }
      %>
<!doctype html>
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js"></script>

    <script type="text/javascript">
    function createOption(ddl, text, value) {
    	
        var opt = document.createElement('option');
        opt.value = value;
        opt.text = text;
        ddl.options.add(opt);
    }
        $(document).ready(function (){
        	
        	 console.log( $("#estimateFilterID").text() );
             if ($("#estimateFilterID").text() == "TUBEWELL") {
            	 console.log("TUBEWELL");
                    $("#tubeWellDiv").show();
					 $("#canalDiv").hide();
					$("#submitDivTW").show();
					$("#submitDivCN").hide();
                }else if($("#estimateFilterID").text() == "CANAL"){
                	console.log("CANAL");
                    $("#canalDiv").show();
					$("#tubeWellDiv").hide();
					$("#submitDivCN").show();
					$("#submitDivTW").hide();
                } 
				else{
					console.log("NONE");
					$("#tubeWellDiv").hide();
                    $("#canalDiv").hide();
					$("#workflowMiniBox").hide();
					$("#submitDivTW").hide();
					$("#submitDivCN").hide();
                } 
				
           
			
			
              
				var count = document.getElementById('villCovered').rows.length;
                if (count > 2) {
					$("#slcFormed").show();
				}
				else
				{
					$("#slcFormed").hide();
				}
				
           
        });
		
		function showWorkflowMiniBox(id, wfBoxID)
		{
			console.log(document.getElementById(id));
			if(document.getElementById(id).value == 'saveAndFinalize')
				$("#"+wfBoxID).show();
			else
				$("#"+wfBoxID).hide();
		}
		
		function  showHideRepairTable()
		{
			var radioButtons = document.getElementsByName("isRepairRequiredExisting");
			  for (var x = 0; x < radioButtons.length; x++) {
			    if (radioButtons[x].checked) {
			      console.log(radioButtons[x].value);
			      if(radioButtons[x].value == 'true')
			    	  $("#repairYesTable").show();
			      else
			    	{
			    	 $("#repairYesTable").hide();
			    	}
			      }
			   
			  }
		}
		
		function showHideCPTable()
		{
			var radioButtons = document.getElementsByName('isRepairCPRequired');
			
			
			for (var x = 0; x < radioButtons.length; x++) {
			    if (radioButtons[x].checked) {
			      console.log(radioButtons[x].value);
			      if(radioButtons[x].value == 'true')
			    	  $("#replacementRepairCPTable").show();
			      else
			    	{
			    	 $("#replacementRepairCPTable").hide();
			    	}
			      }
			   
			  }
		}
		
		function showrepairYesTableRWM()
		{
			var radioButtons = document.getElementsByName('repairRawWater');
			
			
			for (var x = 0; x < radioButtons.length; x++) {
			    if (radioButtons[x].checked) {
			      console.log(radioButtons[x].value);
			      if(radioButtons[x].value == 'true')
			    	  $("#repairYesTableRWM").show();
			      else
			    	{
			    	 $("#repairYesTableRWM").hide();
			    	}
			      }
			   
			  }
		}
		
		function showrepairYesTableClearWaterMotor()
		{
			var radioButtons = document.getElementsByName('repairClearWater');
			
			
			for (var x = 0; x < radioButtons.length; x++) {
			    if (radioButtons[x].checked) {
			      console.log(radioButtons[x].value);
			      if(radioButtons[x].value == 'true')
			    	  $("#repairYesTableRCWM").show();
			      else
			    	{
			    	 $("#repairYesTableRCWM").hide();
			    	}
			      }
			   
			  }
		}
		
		function showRepairCPCanalColumn()
		{
			var radioButtons = document.getElementsByName('repairrepCP');
			
			
			for (var x = 0; x < radioButtons.length; x++) {
			    if (radioButtons[x].checked) {
			      console.log(radioButtons[x].value);
			      if(radioButtons[x].value == 'true'){
			    	  $("#repairCPCanalColumn").show();
			      	$("#costOfRepairCPCanalRow").show();}
			      else
			    	{
			    	 $("#repairCPCanalColumn").hide();
			    	 $("#costOfRepairCPCanalRow").hide();
			    	}
			      }
			   
			  }
		}
		
		
		
		
		
    </script>
<meta charset="utf-8">
<title>ESTIMATION | ADDITIONAL INFORMATION</title>
<style>
div
	{
		padding:2px; padding-top:5px; padding-bottom:5px;
	}
	.informationBar
	{
		clear:both; float:none; display:block; width:100%; 
	}
	.borderDiv{border:1px solid black; padding:2px; padding-top:5px; padding-bottom:5px;float: left;width: 100%; }
	.spacer{height: 30px;
    float: none;
    clear: both;}
</style>
</head>

<body>

<div class="pageWrapper" style="">
	<div class="borderDiv">
    <div style="float:left">
        	<div style="float:left;font-weight:bold">ESTIMATION SCREEN&nbsp;|&nbsp; ADDITIONAL INFORMATION</div>
    </div>
   <div style="float:right">
            <a href="showWorkflow.action">Workflow</a>
            <a href="#">Report</a>
            <a href="getAllSchemes">Scheme Search</a>
<a href="logout.action">Logout</a>
         </div>
    </div>
  <div class="spacer">
    </div>
    <div id="schemeDetails">
    <fieldset>
      <legend>Scheme Details : <%=scheme.getSchemeName() %></legend>
      <s:label value="%{districtID}" name="districtID"><strong>District ID</strong></s:label> <br/>
      <s:label id="estimateFilterID" value="%{sourceOfscheme}" name="sourceOfScheme"><strong>Source Of Scheme</strong></s:label> <br/>
     
     
      <table border="1" id="villCovered">
    
     <tr>
     <th colspan="2">Village Name</th>
     
     
      <th colspan="2">Constituency</th>
     
      <th>Being Covered Under Category</th>
     
      <th>Population</th>
     </tr>
      <%
          
          for(int i = 0; i < villList.size(); i++)
          {
         %>
         <tr>
          <td colspan="2"><%=villList.get(i).getVillageName() %></td>
     
          <td colspan="2"><%=villList.get(i).getConstituencyID() %></td>
         
          <td><%=categoryMap.get(villList.get(i).getVillageID()) %></td>
          
          <td><%=populationMap.get(villList.get(i).getVillageID()) %></td>
         
    	  <%
          }
          %>
        </tr>
        
       
      </table>
     
    </fieldset>
    </div>
      <div class="spacer">
    </div>
    <form action="saveEstimateTubeWell.action?schemeID=<%=request.getParameter("schemeID") %>&divisionID=<%=request.getParameter("locID") %>" method="post">
  
  <div id="tubeWellDiv" style="display:none">
    <div id="subDivDet">
    <fieldset>
      <legend>Sub Division Details </legend>
     
          <s:select name="subDivisionIDList" list="subDivisionList" listKey="subDivisionalID" listValue="subDivisionalName" headerKey="-1" headerValue="--Please Select--" name="subDivisionID"></s:select>
     
      <table>
      
       
        <tr>
          <td>GPWSC Formed</td>
          <td><label for="yesGPSWSC">Yes</label>
    	<input type="radio" name="gpwsc" id="yesGPSWSC" value="true"/>
        <label for="noGPWSC">No</label>
       	<input type="radio" name="gpwsc" id="noGPWSC" value="false" checked="checked"/>
          </td>
        </tr>
        <tr id="slcFormed" style="display:none" >
          <td>SLC Formed</td>
          <td><label for="yesSLC">Yes</label>
    	<input type="radio" name="slcFormed" id="yesSLC" value="true"/>
        <label for="noSLC">No</label>
       	<input type="radio" name="slcFormed" id="noSLC" value="false" checked="checked"/>
          </td>
        </tr>
        
      </table>
     
    </fieldset>
    </div>
   
    
    <table>
    <tr>
    <td>
    	<label for="dischargeOfPump" >Discharge of Pumping Machinery [ in lph ]</label>
    </td>
    <td>
    	<input type="text" id="dischargeOfPump" name="dischargeOfPumpingMachinery"/>
    </td>
    </tr>
    <tr>
    <td>
    	<label for="proposedRunningHrsMachinery" >Proposed Running hours of Pumping Machinery</label>
    </td>
    <td>
    	<input type="text" id="proposedRunningHrsMachinery" name="proposedRunningHrsMachinery"/>
    </td>
    </tr>
    <tr>
    <td>
    <label for="horsePowerForPumpingMachinery" >Horse power of pumping Machinery 
 </label>
    </td>
    <td>
    <input type="text" id="horsePowerForPumpingMachinery" name="hPForPumpingMachinery"/>
    </td>
    </tr>
    </table>
    <div>
    	<p>Is  existing Scheme is sufficient to deliver continuous 10 hours water supply at 70 lpcd?</p>
        <label for="schemeSufficientIDYes">Yes</label>
    	<input type="radio" name="isSchemeSufficient" id="schemeSufficientIDYes" value="true"/>
        <label for="schemeSufficientIDNo">No</label>
       	<input type="radio" name="isSchemeSufficient" id="schemeSufficientIDNo" value="false" checked="checked"/>
    </div>
    <div>
    
    
    </div>
    
    <div>
    <fieldset>
    <legend>
        Repair or Replacement of Existing Machinery, if Required(Yes/No)</legend>
        <div id="isRepairRequiredExisting">
        <label for="repairRequiredYes">Yes</label>
    	<input type="radio" name="isRepairRequiredExisting" id="repairRequiredYes" value="true" onchange="showHideRepairTable()"/>
        <label for="repairRequiredNo">No</label>
       	<input type="radio" name="isRepairRequiredExisting" id="repairRequiredNo" value="false"  onchange="showHideRepairTable()" checked="checked"/>
    </div>
    <table id="repairYesTable" style="display:none">
    <tr>
    <td><label for="repairOrReplacement">Repair</label>
    	<input type="radio" name="existingRepairOrReplacement" id="repair" value="repair"/>
    <label for="repairOrReplacement">Replacement</label>
    	<input type="radio" name="existingRepairOrReplacement" id="replacement" value="replacement"/></td>
    </tr>
    <tr>
    <td>
    <label for="horsePowerInBHP" >Horse Power (in BHP) </label>
    </td>
    <td>
    <input type="text" id="horsePowerInBHP" name="horsePowerInBHP"/>
    </td>
    </tr>
	<tr>
    <td>
    <label for="headInMtrs" >Head [In Mtrs] </label>
    </td>
    <td>
    <input type="text" id="headInMtrs" name="headInMtrs"/>
    </td>
    </tr>
    <tr>
    <td>
    <label for="dischargeInLPH" >Discharge [In lph] </label>
    </td>
    <td>
    <input type="text" id="dischargeInLPH" name="dischargeInLPH"/>
    </td>
    </tr>
    </table>
    </fieldset>
    </div>
    <div id="costOfRepairFields">
    <fieldset>
    <legend>Cost of Repair / Replacement of Control Panel, if Any(Check if applicable) :</legend>
    
     <label for="checkIFRepairCPRequiredIDYes">Yes</label>
    	<input type="radio" name="isRepairCPRequired" id="checkIFRepairCPRequiredIDYes" value="true" onchange="showHideCPTable()"/>
        <label for="checkIFRepairCPRequiredIDYes">No</label>
       	<input type="radio" name="isRepairCPRequired" id="checkIFRepairCPRequiredIDNo" value="false"  onchange="showHideCPTable()" checked="checked"/>
    <table id="replacementRepairCPTable" style="display:none">
    <tr>
    <td><label for="repairCP">Repair</label>
    	<input type="radio" name="cpRepairOrReplacement" id="repairCP" value="repair"/>
    <label for="replacementCP">Replacement</label>
    	<input type="radio" name="cpRepairOrReplacement" id="replacementCP" value="replacement"/></td>
    <td>
    </tr>
    <tr>
    <td>
    Cost:
    <input type="text" id="costOfRepairCP" name="costOfRepairCP"/>
    </td>
    </tr>
    </table>
    </fieldset>
    
    </div>
    
	<div>
    <table>
    <tr>
      <td><label for="costOfRepairPump">Cost of Repair of Pump Chamber, if any (Leave Blank if Not Applicable)  </label></td>
      <td><input type="text" id="costOfRepairPumpID" name="costOfRepairPump"/></td>
    </tr>
    <tr>
      <td><label for="costOfRepairOHSR">Cost of Repair of OHSR , if any (Leave Blank if Not Applicable)</label></td>
      <td><input type="text" id="costOfRepairOHSRID" name="costOfRepairOHSR"/></td>
    </tr>
     <tr>
      <td><label for="costOfRepairExistingComponents">Cost of Repair of other Existing Components of Water Works, if any (Leave Blank if Not Applicable)  </label></td>
      <td><input type="text" id="costOfRepairExistingComponents" name="costOfRepairExistingComponents"/></td>
    </tr>
    <tr>
      <td><label for="costOfChlorination">Chlorination Plant Required? (Yes/No)</label></td>
      <td>
      <label for="costOfChlorinationT">Yes</label>
    	<input type="radio" name="costOfChlorination" id="costOfChlorinationT" value="true"/>
   		<label for="costOfChlorinationF">No</label>
    	<input type="radio" name="costOfChlorination" id="costOfChlorinationF" value="false" checked="checked"/></td>
    </tr>
    <tr>
      <td><label for="costOfRepairPipeLine">Cost of Repair and minor Replacement associated with Cost of Repair of existing pipe line </label></td>
      <td><input type="text" id="costOfRepairPipeLineID" name="costOfRepairPipeLine"/></td>
    </tr>
    <tr>
      <td><label for="costOfController">Cost: Automated water controller switch to Start or Stop the Pump based on water reservoir level </label></td>
      <td><input type="text" id="costOfControllerID" name="costOfController"/></td>
    </tr>
    </table>
    </div>
    
    <div id="distributionDetails">
    	<fieldset>
        	<legend>Distribution Details</legend>
            <p>
            <strong>Enter Length of required pipelines(In Not Covered Areas)</strong>
            </p>
            <table>
            <tr>
            <td>Size : 160mm</td>
            <td><input type="text" name="len160mmPipeline"/></td>
             
    
            </tr>
            <tr>
            <td>Size : 110mm </td>
            <td><input type="text" name="len110mmPipeline"/></td>
             
            </tr>
            <tr>
            <td>Size : 90mm </td>
            <td><input type="text" name="len90mmPipeline"/></td>
            </tr>
            
            <tr>
            <td>Size : 75mm </td>
            <td><input type="text" name="len75mmPipeline"/></td>
            </tr>
            
            <tr>
            <td>Size : 63mm </td>
            <td><input type="text" name="len63mmPipeline"/></td>
            </tr>
            </table>
            
            <p>
            <strong>Sluice Valve</strong>
            </p>
            <table>
            <tr>
            <td>Size : 150mm</td>
            <td><input type="text" name="len150mmSluiceValve"/></td>
            </tr>
            
            <tr>
            <td>Size : 100mm </td>
            <td><input type="text" name="len100mmSluiceValve"/></td>
            </tr>
            
            <tr>
            <td>Size : 80mm </td>
            <td><input type="text" name="len80mmSluiceValve"/></td>
            </tr>
            </table>
            
            <p>
            <strong>Sluice Valve Haudi</strong>
            </p>
            <table>
            <tr>
            <td>[ Size : 0.60 X 0.60 mtr ]</td>
            <td><input type="text" name="len60Mtr"/></td>
            </tr>
            <tr>
            <td>[ Size : 0.90 X 0.90 mtr ]</td>
            <td><input type="text" name="len90Mtr"/></td>
            </tr>
            <tr>
            <td>Dismantling & restoration of Road cut per Mtr. [Brick on edge] , If Required</td>
            <td>Enter numeric value (in mtrs):</td>
            <td><input type="text" name="dismantlingBrick"/></td>
            </tr>
            <tr>
            <td>Dismantling & restoration of Road cut per Mtr. [CC Flooring], If Required </td>
            <td>Enter numeric value (in mtrs):</td>
            <td><input type="text" name="dismantlingCCFlooring"/></td>
            </tr>
            <tr>
            <td>Cost likely BT bill for restoration of Dismanted Metalled Road  </td>
            <td><input type="text" name="BTBillCost"/></td>
            </tr>
            <tr>
            <td>No. of Water Meter [Where ever Villagers Adopt Metering]  </td>
            <td>Enter numeric value :</td>
            <td><input type="text" name="noOfWaterMeter"/></td>
            </tr>
            <tr height="10px"></tr>
            <tr>
            <td>Select One: Installation of new Sign Board or Painting of existing</td>
            </tr>
            <tr>
             <td><label for="installSignBoard">New Installation</label>
    	<input type="radio" name="signBoardDetails" id="installSignBoard" value="install"/>
    <label for="paintSignBoard">Painting</label>
    	<input type="radio" name="signBoardDetails" id="paintSignBoard" value="paint"/></td>
    </tr>
    <tr>
            <td>Cost:<input type="text" name="costOfSignBoard"/></td>
            </tr>
            </table>
        </fieldset>
    </div> <!--End of Distribution Details -->
   
    <div>
    	<fieldset>
        	<legend>Water Connection Details</legend>
           
            <table>
            <tr>
            <td title="Enter value in number"> Additional New Water on new additional pipe line </td>
            <td><input type="text" name="addedNewWaterPipeline"/></td>
            </tr>
             <tr>
            <td title="Enter value in number"> No. of New Water Connection on existing pipe line  </td>
            <td><input type="text" name="numberOfNewWaterPipeline"/></td>
            </tr>
            </table>
        </fieldset>
    </div>
    
     </div><!-- End of Tubewell Div -->
      <div id="submitDivTW" style="display:none">
    	 <select id="actionTypeTW" name="actionType" onchange="showWorkflowMiniBox('actionTypeTW', 'workflowMiniBoxTW')">
    <option value="saveDraft">Save Draft</option>
    <option value="saveAndFinalize">Save And Finalize</option>
    </select> 
      <div id="workflowMiniBoxTW" style="float:left;clear:both;width:100%; display:none">
    
    	<fieldset>
        	<legend>
            	Send To
            </legend>
            <table style="">
            <tr>
            <td>Send To: </td>
            <td>
            <select name="sendTo">
            	<%
            	if(wf != null)
            	for(int i = 0; i < wf.size(); i++)
            	{
            	if(wf.get(i) != null)
            	%>
            	<option value="<%=wf.get(i).getWorkflowID() %>"><%=wf.get(i).getToRoleId() %>(<%=wf.get(i).getToLocID() %>)</option>
            	<%	
            	}
            	%>
            </select>
            </td>
            <td>
            	<input type="text" placeholder="Dispatch No." name="dispatchNo"/>
            </td>
            <td>Remarks</td>
            <td>
            	<textarea name="remarks"></textarea>
            </td>
           
            </tr>
            </table>
        </fieldset>
    
    
    </div>
    <div> <input type="submit" value="Submit" /> </div>
    </div>
    
   
     </form>
     <form action="saveEstimateCanal.action?schemeID=<%=request.getParameter("schemeID") %>&divisionID=<%=request.getParameter("locID") %>" method="post">
     <div id="canalDiv" style="display:none">
    <div id="subDivDet">
    <fieldset>
      <legend>Sub Division Details </legend>
     
          <s:select name="subDivisionIDList" list="subDivisionList" listKey="subDivisionalID" listValue="subDivisionalName" headerKey="-1" headerValue="--Please Select--" name="subDivisionID"></s:select>
     
      <table>
      
       
        <tr>
          <td>GPWSC Formed</td>
          <td><label for="yesGPSWSC">Yes</label>
    	<input type="radio" name="gpwsc" id="yesGPSWSC" value="true"/>
        <label for="noGPWSC">No</label>
       	<input type="radio" name="gpwsc" id="noGPWSC" value="false" checked="checked"/>
          </td>
        </tr>
        <tr id="slcFormed" style="display:none" >
          <td>SLC Formed</td>
          <td><label for="yesSLC">Yes</label>
    	<input type="radio" name="slcFormed" id="yesSLC" value="true"/>
        <label for="noSLC">No</label>
       	<input type="radio" name="slcFormed" id="noSLC" value="false" checked="checked"/>
          </td>
        </tr>
        
      </table>
     
    </fieldset>
    </div>
   	
    
    <table>
    <tr>
    <td>
    	<label for="dischargeOfPumpCanal" >Discharge of Pumping Machinery (Clear Water Motor) [ in lph ] / Discharge of exiting machinery not proposed to be replaced/  discharge of proposed Machinery which is to be replaced </label>
    </td>
    <td>
    	<input type="text" id="dischargeOfPumpCanal" name="dischargeOfPumpingMachinery"/>
    </td>
    </tr>
    <tr>
    <td>
    	<label for="proposedRunningHrsMachinery" >Proposed Running hours of Pumping Machinery (Clear Water Motor)</label>
    </td>
    <td>
    	<input type="text" id="proposedRunningHrsMachineryCanal" name="proposedRunningHrsMachinery"/>
    </td>
    </tr>
    </table>
    <div>
    	<p>Is  existing Scheme is sufficient to deliver continuous 10 hours water supply at 70 lpcd?</p>
        <label for="schemeSufficientIDCanalYes">Yes</label>
    	<input type="radio" name="isSchemeSufficient" id="schemeSufficientIDCanalYes" value="true"/>
        <label for="schemeSufficientIDCanalNo">No</label>
       	<input type="radio" name="isSchemeSufficient" id="schemeSufficientIDCanalNo" value="false" checked="checked"/>
    </div>
    <div>
    
    	<p>Cost of Repair of Inlet Channel</p>
        <input type="text" name="costOfRepairInlet" />
   
    
    
     <div>
     <fieldset>
<legend>    	Repair or Replacement of Raw Water Motor, if Required(Yes/No)?&nbsp; </legend>
         <label for="repairRawWaterYes">Yes</label>
    	<input type="radio" name="repairRawWater" id="repairRawWaterYes" value="true" onChange="showrepairYesTableRWM()"/>
        <label for="repairRawWaterNo">No</label>
       	<input type="radio" name="repairRawWater" id="repairRawWaterNo" value="false" onChange="showrepairYesTableRWM()" checked="checked"/>
     
    
    
    <table id="repairYesTableRWM" style="display: none">
    <tr>
    <td>
    <label for="repairOrReplacementRWM">Repair</label>
    	<input type="radio" name="repairOrReplacementRWM" id="repairRWM" value="repair"/>
    <label for="repairOrReplacementRWM">Replacement</label>
    	<input type="radio" name="repairOrReplacementRWM" id="replacementRWM" value="replacement"/>
    </td>
    </tr>
    <tr>
    <td>
    <label for="horsePowerCanal" >Horse Power (in BHP) </label>
    </td>
    <td>
    <input type="text" name="horsePowerRW"/>
    </td>
    </tr>
	<tr>
    <td>
    <label for="headInMtrsCanal" >Head [In Mtrs] </label>
    </td>
    <td>
    <input type="text" id="headInMtrsCanal" name="headInMtrsRW"/>
    </td>
    </tr>
    <tr>
    <td>
    <label for="dischargeInLPHCanal" >Discharge [In lph] </label>
    </td>
    <td>
    <input type="text" id="dischargeInLPHCanal" name="dischargeInLPHRW"/>
    </td>
    </tr>
    <tr>
    <td>
    <label for="costOfRepairRawWater">Cost of Repair / Replacement </label>
    </td>
    <td>
    <input type="text" id="costOfRepairRawWater" name="repairRawWaterCost"/>
    </td>
    </tr>
   
    </table>
      </fieldset> <!-- End of "Repair or Replacement of Raw Water Motor" fieldset -->
       </div>
       
       
   
    <div>
     <fieldset>
<legend>    
    	Repair or Replacement of Clear Water Motor , if Required (Yes/No)?&nbsp; </legend>
       
         <label for="repairClearWaterYes">Yes</label>
    	<input type="radio" name="repairClearWater" id="repairClearWaterYes" value="true" onChange="showrepairYesTableClearWaterMotor()"/>
        <label for="repairClearWaterNo">No</label>
       	<input type="radio" name="repairClearWater" id="repairClearWaterNo" value="false" onChange="showrepairYesTableClearWaterMotor()" checked="checked"/>
   
     <table id="repairYesTableRCWM" style="display: none">
     <tr>
    <td>
    <label for="repairRCWM">Repair</label>
    	<input type="radio" name="repairOrReplacementRCWM" id="repairRCWM" value="repair"/>
    <label for="replacementRWM">Replacement</label>
    	<input type="radio" name="repairOrReplacementRCWM" id="replacementRCWM" value="replacement"/>
    </td>
    </tr>
	<tr>
    <td>
    <label for="headInMtrsRCWM" >Head [In Mtrs] </label>
    </td>
    <td>
    <input type="text" id="headInMtrsRCWM" name="headInMtrsRCWM"/>
    </td>
    </tr>
    <tr>
    <td>
    <label for="dischargeInLPHRCWM" >Discharge [In lph] </label>
    </td>
    <td>
    <input type="text" id="dischargeInLPHRCWM" name="dischargeInLPHRCWM"/>
    </td>
    </tr>
    <tr>
    <td>
    <label for="costOfRepairRCWM">Cost of Repair / Replacement </label>
    </td>
    <td>
    <input type="text" id="costOfRepairRCWM" name="costOfRepairRCWM"/>
    </td>
    </tr>
   
    </table>
    </fieldset>
    </div>
    <table>
    	<tr>
        <td>Cost of Replenishment of Filter Media [ In case of Slow Sand Filter ] * , if required</td>
        <td><input type="text" name="costOfReplacingFilterMedia"/></td>
        </tr>
        <tr>
        <td>Cost of Repair of Filter beds [ In case of Slow Sand Filter ]</td>
        <td><input type="text" name="costOfRepairFilterBeds"/></td>
        </tr>
        <tr>
        <td>Cost of Repair of Storage & Sedimentation Tank</td>
        <td><input type="text" name="costOfStorageTank"/></td>
        </tr>
        <tr>
        <td>Cost of Repair of High Level Tank] </td>
        <td><input type="text" name="costOfRepairHighLevelTank"/></td>
        </tr>
        <tr>
          <td>Cost of Repair of S &amp; S Well] </td>
         <td><input type="text" name="costOfRepairOfSAndSWell"/></td>
        </tr>
        <tr>
          <td>Cost of Repair of Clear Water Tank] </td>
          <td><input type="text" name="costOfRepairOfClearWater"/></td>
        </tr>
        </table>
        
        <fieldset>
        <legend> Replenishment of Filter Media / Repair of Treatment Plant in Case of CTP, Pressute Filter or CSF ] </legend>
        <table>
        <tr>
         
          </tr>
          <tr>
          <td>
          <label for="repairTreatmentPlant">Repair</label>
    	<input type="radio" name="repairTreatmentPlant" id="repairTreatmentPlant" value="repair"/>
    <label for="repalementTreatmentPlant">Replacement</label>
    	<input type="radio" name="repairTreatmentPlant" id="repalementTreatmentPlant" value="replacement"/>
          </td>
         </tr>
         <tr>
          <td>Cost: <input type="text" name="costOfRepairTreatmentPlant"/></td>
        </tr>
        </table>
        </fieldset>
        
        <div class="spacer"></div>
        <fieldset>
        <legend>Cost of Repair / Replacement of Control Panel, if Any(Yes/No)</legend>
        <table >
        <tr  >
    <td>
    <label for="reapirrepCPYes">Yes </label>
    <input type="radio" name="repairrepCP" id="reapirrepCPYes" value="true" onChange="showRepairCPCanalColumn()"/>
        <label for="reapirrepCPNo">No</label>
       	<input type="radio" name="repairrepCP" id="reapirrepCPNo" value="false" onChange="showRepairCPCanalColumn()" checked="checked"/>
    </td>
    </tr>
    <tr>
    <td id="repairCPCanalColumn" style="display:none">
     <label for="repairCPCanal">Repair</label>
    	<input type="radio" name="repairOrReplacementCPCanal" id="repairCPCanal" value="repair"/>
    <label for="replacementCPCanal">Replacement</label>
    	<input type="radio" name="repairOrReplacementCPCanal" id="replacementCPCanal" value="replacement"/>
    </tr>
    <tr>
    <td id="costOfRepairCPCanalRow" style="display:none">	
    Cost: <input type="text" id="costOfRepairCPCanal" name="costOfRepairCPCanal"/>
   
    </td>
    </tr>
    </table>
    </fieldset>
    
    
     <div class="spacer"></div>
     <fieldset>
   <legend>
    Cost of Repair of Pump Chamber , if any(leave Blank if N/A)</legend>
    
     <table>
     <tr>
      <td>
     <label for="repairPumpCanal">Repair</label>
    	<input type="radio" name="repairOrReplacementPumpCanal" id="repairPumpCanal" value="repair"/>
    <label for="replacementPumpCanal">Replacement</label>
    	<input type="radio" name="repairOrReplacementPumpCanal" id="replacementPumpCanal" value="replacement"/>
    </td>
    </tr>
    <tr>
    <td>Cost: <input type="text" id="costOfRepairPumpCanal" name="costOfRepairPumpCanal"/></td>
    
    </tr>
    </table>
    </fieldset>
    <div class="spacer"></div>
    <table> 
    <tr>
      <td><label for="costOfRepairOHSRCanal">Cost of Repair of OHSR, if any(leave Blank if N/A)  </label></td>
      <td><input type="text" id="costOfRepairOHSRCanal" name="costOfRepairOHSR"/></td>
    </tr>
     <tr>
      <td><label for="costOfExistingCanal">Cost of Repair of other Existing Components of Water Works, if any(leave Blank if N/A) </label>
      </td>
      <td><input type="text" id="costOfExistingCanal" name="costOfRepairExistingComponents" /></td>
    </tr>
    <tr>
      <td><label for="costOfChlorinationCanal">Chlorination Plant Required? (Yes/No) </label></td>
      <td>
         <label for="chlorinationCanalYes">Yes</label>
    	<input type="radio" name="chlorinationCanalRequired" id="chlorinationCanalRequired" value="true" />
        <label for="chlorinationCanalNo">No</label>
       	<input type="radio" name="chlorinationCanalRequired" id="chlorinationCanalNo" value="false" checked="checked"/></td>
    </tr>
    <tr>
      <td><label for="costOfRepairPipeLineCanal">Cost of Repair and minor Replacement associated with Cost of Repair of existing pipe line </label></td>
      <td><input type="text" id="costOfRepairPipeLineCanal" name="costOfRepairPipeLine"/></td>
    </tr>
    <tr>
      <td><label for="controllerCanal">Automated water controller switch to Start or Stop the Pump based on water reservoir level </label></td>
      <td>
       <label for="controllerCanalYes">Yes</label>
      <input type="radio" name="controllerCanalRequired" id="controllerCanalYes" value="true" />
        <label for="controllerCanalNo">No</label>
       	<input type="radio" name="controllerCanalRequired" id="controllerCanalNo" value="false" checked="checked"/>
      </td>
      <td></td>
    </tr>
        
    </table>
    </div>
    <div id="distributionDetailsCanal">
    	<fieldset>
        	<legend>Distribution Details</legend>
            <p>
            <strong>Enter Length of required pipelines</strong>
            </p>
            <table>
            <tr>
            <td>Size : 160mm</td>
            <td><input type="text" name="len160mmPipeline"/></td>
            </tr>
            <tr>
            <td>Size : 110mm </td>
            <td><input type="text" name="len110mmPipeline"/></td>
            </tr>
            <tr>
            <td>Size : 90mm </td>
            <td><input type="text" name="len90mmPipeline"/></td>
            </tr>
            <tr>
            <td>Size : 75mm </td>
            <td><input type="text" name="len75mmPipeline"/></td>
            </tr>
            <tr>
            <td>Size : 63mm </td>
            <td><input type="text" name="len63mmPipeline"/></td>
            </tr>
            </table>
            
            <p>
            <strong>Sluice Valve</strong>
            </p>
            <table>
            <tr>
            <td>Size : 150mm</td>
            <td><input type="text" name="len150mmSluiceValve"/></td>
            </tr>
            <tr>
            <td>Size : 100mm </td>
            <td><input type="text" name="len100mmSluiceValve"/></td>
            </tr>
            <tr>
            <td>Size : 80mm </td>
            <td><input type="text" name="len80mmSluiceValve"/></td>
            </tr>
            </table>
            
            <p>
            <strong>Sluice Valve Haudi</strong>
            </p>
            <table>
            <tr>
            <td>[ Size : 0.60 X 0.60 mtr ]</td>
            <td><input type="text" name="len60Mtr"/></td>
            </tr>
            <tr>
            <td>[ Size : 0.90 X 0.90 mtr ]</td>
            <td><input type="text" name="len90Mtr"/></td>
            </tr>
            <tr>
            <td>Dismantling & restoration of Road cut per Mtr. [Brick on edge] </td>
            <td><input type="text" name="dismantlingBrick"/></td>
            </tr>
            <tr>
            <td>Dismantling & restoration of Road cut per Mtr. [CC Flooring] </td>
            <td><input type="text" name="dismantlingCCFlooring"/></td>
            </tr>
            <tr>
            <td>Cost likely BT bill for restoration of Dismantled Metalled Road </td>
            <td><input type="text" name="BTBillCost"/></td>
            </tr>
            <tr>
            <td>No. of Water Meter [Where ever Villagers Adopt Metering] (Enter numeric value) :</td>
            <td><input type="text" name="noOfWaterMeter"/></td>
            </tr>
            <tr height="10px"></tr>
            <tr>
            <td>Select One: Installation of new Sign Board or Painting of existing</td>
            </tr>
            <tr>
             <td><label for="installSignBoardCanal">New Installation</label>
    	<input type="radio" name="signBoardDetails" id="installSignBoardCanal" value="install"/>
    <label for="paintSignBoardCanal">Painting</label>
    	<input type="radio" name="signBoardDetails" id="paintSignBoardCanal" value="paint"/></td>
    </tr>
    <tr>
            <td>Cost:<input type="text" name="costOfSignBoard"/></td>
            </tr>
            </table>
        </fieldset>
        
    </div> <!--End of Distribution Details -->
    
    <div>
    	<fieldset>
        	<legend>Water Connection Details</legend>
           
            <table>
            <tr>
            <td title="Enter value in number" name="addedNewWaterPipeline"> Additional New Water on new additional pipe line </td>
            <td><input type="text" name=""/></td>
            </tr>
             <tr>
            <td title="Enter value in number" name="numberOfNewWaterPipeline"> No. of New Water Connection on existing pipe line  </td>
            <td><input type="text" name=""/></td>
            </tr>
            </table>
        </fieldset>
    </div>
      
    </div><!--End of Estimate Form -->
 
  
     <div id="submitDivCN" style="display:none">
    <select id="actionTypeCN" name="actionType" onchange="showWorkflowMiniBox('actionTypeCN', 'workflowMiniBoxCN')">
    <option value="saveDraft">Save Draft</option>
    <option value="saveAndFinalize">Save And Finalize</option>
    </select> 
      <div id="workflowMiniBoxCN" style="float:left;clear:both;width:100%; display:none">
    
    	<fieldset>
        	<legend>
            	Send To
            </legend>
            <table style="">
            <tr>
            <td>Send To: </td>
            <td>
            <select name="sendTo">
            	<%
            	if(wf != null)
            	for(int i = 0; i < wf.size(); i++)
            	{
            	if(wf.get(i) != null)
            	%>
            	<option value="<%=wf.get(i).getWorkflowID() %>"><%=wf.get(i).getToRoleId() %>(<%=wf.get(i).getToLocID() %>)</option>
            	<%	
            	}
            	%>
            </select>
            </td>
            <td>
            	<input type="text" placeholder="Dispatch No." name="dispatchNo"/>
            </td>
            <td>Remarks</td>
            <td>
            	<textarea name="remarks"></textarea>
            </td>
            
            </tr>
            </table>
        </fieldset>
    
    
    </div>
    <div><input type="submit" value="Submit" /></div>	
    </div>
    
        
 </form>
 

     
   
   


</body>
</html>
