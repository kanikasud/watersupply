<%@page import="in.redexp.watersupply.model.Workflow"%>
<%@page import="in.redexp.watersupply.model.EstimateDetailsTubeWell"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <%
    EstimateDetailsTubeWell tubewellEstimate =  (EstimateDetailsTubeWell)request.getAttribute("tubewellEstimate"); 
    Workflow wf = (Workflow)request.getAttribute("workflow");
    %>
   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TubeWell Estimate</title>
<style>

</style>
</head>
<body>
<div style="float:right">
            <a href="showWorkflow.action">Workflow</a>
            <a href="#">Report</a>
            <a href="getAllSchemes">Scheme Search</a>
<a href="logout.action">Logout</a>
         </div>
<div><a href="exportTWEstimateDetails.action?tubewellEstimateID=<%=tubewellEstimate.getEstimateID() %>">Export To Excel</a></div>
	<div>
	<fieldset>
	<legend>Basic Details</legend>
	<table>
	<tr>
	<td>Estimate ID</td>
	<td><%=tubewellEstimate.getEstimateID() %></td>
	</tr>
	
	<tr>
	<td>Scheme ID</td>
	<td><%=tubewellEstimate.getSchemeID() %></td>
	</tr>
	
	<tr>
	<td>Division ID</td>
	<td><%=tubewellEstimate.getDivisionID() %></td>
	</tr>
	
	<tr>
	<td>Sub Division ID</td>
	<td><%=tubewellEstimate.getSubDivisionID() %></td>
	</tr>
	
	<tr>
	<td>SLC Formed</td>
	<td><%=
	tubewellEstimate.isSlcFormed().toString() %></td>
	</tr>
	
	
	<tr>
	<td>GPWSC Formed</td>
	<td><%=tubewellEstimate.getGpwsc().toString() %></td>
	</tr>
	</table>
	</fieldset>
	
	<div><fieldset>
	<legend>Estimate Details</legend>
	<table>
	
	
	
	<tr>
	<td>Discharge of Pumping Machinery</td>
	<td><%=tubewellEstimate.getDischargeOfPumpingMachinery() %></td>
	</tr>
	
	
	<tr>
	<td><label >Proposed Running hours of Pumping Machinery</label></td>
	<td><%=tubewellEstimate.getGpwsc().toString() %></td>
	</tr>
	
	
	<tr>
	<td><label>Is  existing Scheme is sufficient to deliver continuous 10 hours water supply at 70 lpcd?
 </label></td>
	<td><%=tubewellEstimate.getIsSchemeSufficient().toString() %></td>
	</tr>
	
	<tr>
	<td colspan="2"><hr/></td>
	</tr>
	<tr>
	<td>Repair or Replacement of Existing Machinery, if Required(Yes/No)</td>
	<td><%=tubewellEstimate.getIsRepairRequiredExisting().toString() %></td>
	</tr>
	<tr>
	<td>Repair/ Replacement</td>
	<td><%=tubewellEstimate.getExistingRepairOrReplacement() %></td>
	</tr>
	
	
	<tr>
	<td>Horse Power (in BHP)</td>
	<td><%=tubewellEstimate.getHorsePowerInBHP() %></td>
	</tr>
	
	
	<tr>
	<td>Head [In Mtrs]</td>
	<td><%=tubewellEstimate.getHeadInMtrs() %></td>
	</tr>
	
	<tr>
	<td>Discharge [In lph]</td>
	<td><%=tubewellEstimate.getDischargeInLPH() %></td>
	</tr>
	<tr>
	<td colspan="2"><hr/></td>
	</tr>
	<tr>
	<td colspan="2"><hr/></td>
	</tr>
	<tr>
	<td>Repair / Replacement of Control Panel, if Any?</td>
	<td><%=tubewellEstimate.getIsRepairCPRequired().toString() %></td>
	</tr>
	
	
	<tr>
	<td>Repair / Replacement of Control Panel</td>
	<td><%=tubewellEstimate.getCpRepairOrReplacement() %></td>
	</tr>
	<tr>
	<td>Cost</td>
	<td><%=tubewellEstimate.getCostOfRepairCP() %></td>
	</tr>
	<tr>
	<td colspan="2"><hr/></td>
	</tr>
	
	<tr>
	<td>Cost of Repair of Pump Chamber, if any </td>
	<td><%=tubewellEstimate.getCostOfRepairPump() %></td>
	</tr>
	
	
	<tr>
	<td>Cost of Repair of OHSR , if any  </td>
	<td><%=tubewellEstimate.getCostOfRepairOHSR() %></td>
	</tr>
	
	
	<tr>
	<td>Cost of Repair of OHSR , if any  </td>
	<td><%=tubewellEstimate.getCostOfRepairOHSR() %></td>
	</tr>
	
	<tr>
	<td>Cost of Repair of other Existing Components of Water Works, if any   </td>
	<td><%=tubewellEstimate.getCostOfRepairExistingComponents() %></td>
	</tr>
	
	
	<tr>
	<td>Chlorination Plant Required?  </td>
	<td><%=tubewellEstimate.getCostOfChlorination().toString() %></td>
	</tr>
	
	
	<tr>
	<td>Cost of Repair and minor Replacement associated with Cost of Repair of existing pipe line  </td>
	<td><%=tubewellEstimate.getCostOfRepairPipeLine() %></td>
	</tr>
	
	<tr>
	<td>Cost: Automated water controller switch to Start or Stop the Pump based on water reservoir level </td>
	<td><%=tubewellEstimate.getCostOfController() %></td>
	</tr>
	
	</table>
	</fieldset>
	</div>
	 <div id="distributionDetails">
    	<fieldset>
        	<legend>Distribution Details</legend>
            <p>
            <strong>Enter Length of required pipelines(In Not Covered Areas)</strong>
            </p>
            <table>
            <tr>
            <td colspan="3">Size : 160mm</td>
            <td colspan="2"><%=tubewellEstimate.getLen160mmPipeline() %></td>
              <td>(Proposed Rate/Cost: 613)</td>
      <td>(Recommended Rate/Cost: 613)</td>
    
            </tr>
            <tr>
            <td colspan="3">Size : 110mm </td>
            <td colspan="2"><%=tubewellEstimate.getLen110mmPipeline()%></td>
               <td>(Proposed Rate/Cost: 314)</td>
      <td>(Recommended Rate/Cost: 314)</td>
    
            </tr>
            <tr>
            <td colspan="3">Size : 90mm </td>
            <td colspan="2"><%=tubewellEstimate.getLen90mmPipeline()%></td>
            <td>(Proposed Rate/Cost: 221)</td>
      <td>(Recommended Rate/Cost: 221)</td>
            </tr>
            <tr>
            <td colspan="3">Size : 75mm </td>
            <td colspan="2"><%=tubewellEstimate.getLen75mmPipeline()%></td>
             <td>(Proposed Rate/Cost: 170)</td>
      <td>(Recommended Rate/Cost: 170)</td>
            </tr>
            <tr>
            <td colspan="3">Size : 63mm </td>
            <td colspan="2"><%=tubewellEstimate.getLen63mmPipeline()%></td>
            <td>(Proposed Rate/Cost: 127)</td>
      <td>(Recommended Rate/Cost: 127)</td>
            </tr>
            </table>
            
            <p>
            <strong>Sluice Valve</strong>
            </p>
            <table>
            <tr>
            <td colspan="3">Size : 150mm</td>
            <td colspan="2"><%= tubewellEstimate.getLen150mmSluiceValve()%></td>
             <td>(Proposed Rate/Cost: 8475)</td>
      <td>(Recommended Rate/Cost: 8475)</td>
            </tr>
            <tr>
            <td colspan="3">Size : 100mm </td>
            <td colspan="2"><%= tubewellEstimate.getLen100mmSluiceValve()%></td>
            <td>(Proposed Rate/Cost: 5700)</td>
      <td>(Recommended Rate/Cost: 5700)</td>
            </tr>
            <tr>
            <td colspan="3">Size : 80mm </td>
            <td colspan="2"><%= tubewellEstimate.getLen80mmSluiceValve()%></td>
             <td>(Proposed Rate/Cost: 4178.50)</td>
      <td>(Recommended Rate/Cost: 4178.50)</td>
            </tr>
            </table>
            
            <p>
            <strong>Sluice Valve Haudi</strong>
            </p>
            <table>
            <tr>
            <td colspan="3">[ Size : 0.60 X 0.60 mtr ]</td>
            <td colspan="2"><%= tubewellEstimate.getLen60Mtr() %></td>
            </tr>
            <tr>
            <td colspan="3">[ Size : 0.90 X 0.90 mtr ]</td>
            <td colspan="2"><%= tubewellEstimate.getLen90Mtr() %></td>
            </tr>
            <tr>
            <td colspan="3">Dismantling & restoration of Road cut per Mtr. [Brick on edge] , If Required</td>
            <td>Enter numeric value (in mtrs):</td>
            <td colspan="2"><%= tubewellEstimate.getDismantlingBrick() %></td>
            </tr>
            <tr>
            <td colspan="3">Dismantling & restoration of Road cut per Mtr. [CC Flooring], If Required </td>
            <td>Enter numeric value (in mtrs):</td>
            <td colspan="2"><%= tubewellEstimate.getDismantlingCCFlooring()%></td>
            </tr>
            <tr>
            <td colspan="3">Cost likely BT bill for restoration of Dismanted Metalled Road  </td>
            <td colspan="2"><%= tubewellEstimate.getBTBillCost()%></td>
            </tr>
            <tr>
            <td colspan="3">No. of Water Meter [Where ever Villagers Adopt Metering]  </td>
            <td>Enter numeric value :</td>
            <td colspan="2"><%= tubewellEstimate.getNoOfWaterMeter()%></td>
            </tr>
            <tr height="10px"></tr>
            <tr>
            <td>Installation of new Sign Board or Painting of existing?</td>
            </tr>
            <tr>
             <td colspan="2"><%= tubewellEstimate.getInstallSignBoard()%></td>
    </tr>
    <tr>
            <td colspan="2">Cost of Sign Board: <%= tubewellEstimate.getCostOfSignBoard()%></td>
            </tr>
            </table>
        </fieldset>
    </div> <!--End of Distribution Details -->
	</div>
</body>
</html>