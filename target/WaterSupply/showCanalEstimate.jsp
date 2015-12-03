<%@page import="in.redexp.watersupply.model.EstimateDetailsCanal"%>
<%@page import="in.redexp.watersupply.model.EstimateDetailsTubeWell"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <%
    EstimateDetailsCanal canalEst =  (EstimateDetailsCanal)request.getAttribute("canalEstimate");
    System.out.println("/WaterSupply/WebContent/showCanalEstimate.jsp\n\n" + canalEst);
    %>
   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Canal Estimate</title>
</head>
<body>
<div style="float:right">
            <a href="showWorkflow.action">Workflow</a>
            <a href="#">Report</a>
            <a href="getAllSchemes">Scheme Search</a>
<a href="logout.action">Logout</a>
         </div>
	<div>
	<table>
	<tr>
	<td>Estimate ID</td>
	<td><%=canalEst.getEstimateID() %></td>
	</tr>
	
	<tr>
	<td>Scheme ID</td>
	<td><%=canalEst.getSchemeID() %></td>
	</tr>
	
	<tr>
	<td>Division ID</td>
	<td><%=canalEst.getDivisionID() %></td>
	</tr>
	
	<tr>
	<td>Sub Division ID</td>
	<td><%=canalEst.getSubDivisionID() %></td>
	</tr>
	
	<tr>
	<td>SLC Formed</td>
	<td></td>
	</tr>
	
	
	<tr>
	<td>GPWSC Formed</td>
	<td></td>
	</tr>
	
	<tr>
	<td>Discharge of Pumping Machinery</td>
	<td><%=canalEst.getDischargeOfPumpingMachinery() %></td>
	</tr>
	
	
	<tr>
	<td><label >Proposed Running hours of Pumping Machinery</label></td>
	<td></td>
	</tr>
	
	
	<tr>
	<td><label>Is  existing Scheme is sufficient to deliver continuous 10 hours water supply at 70 lpcd?
 </label></td>
	<td></td>
	</tr>
	
	
	<%-- <tr>
	<td>Repair or Replacement of Existing Machinery, if Required(Yes/No)</td>
	<td><%=canalEst.getIsRepairRequiredExisting().toString() %></td>
	
	<td>Repair/ Replacement</td>
	<td><%=canalEst.getExistingRepairOrReplacement() %></td>
	</tr>
	
	
	<tr>
	<td>Horse Power (in BHP)</td>
	<td><%=canalEst.getHorsePowerInBHP() %></td>
	</tr>
	
	
	<tr>
	<td>Head [In Mtrs]</td>
	<td><%=canalEst.getHeadInMtrs() %></td>
	</tr>
	
	<tr>
	<td>Discharge [In lph]</td>
	<td><%=canalEst.getDischargeInLPH() %></td>
	</tr>
	
	
	<tr>
	<td>Cost of Repair / Replacement of Control Panel, if Any?</td>
	<td><%=canalEst.getIsRepairCPRequired().toString() %></td>
	
	<td>Repair / Replacement of Control Panel</td>
	<td><%=canalEst.getCpRepairOrReplacement()%></td>
	
	<td>Cost</td>
	<td><%=canalEst.getCostOfRepairCP() %></td>
	</tr>
	
	
	<tr>
	<td>Cost of Repair of Pump Chamber, if any </td>
	<td><%=canalEst.getCostOfRepairPump() %></td>
	</tr> --%>
	
	
	<tr>
	<td>Cost of Repair of OHSR , if any  </td>
	<td><%=canalEst.getCostOfRepairOHSR() %></td>
	</tr>
	
	
	<tr>
	<td>Cost of Repair of OHSR , if any  </td>
	<td><%=canalEst.getCostOfRepairOHSR() %></td>
	</tr>
	
	<tr>
	<td>Cost of Repair of other Existing Components of Water Works, if any   </td>
	<td><%=canalEst.getCostOfRepairExistingComponents() %></td>
	</tr>
	
	
	<%-- <tr>
	<td>Chlorination Plant Required?  </td>
	<td><%=canalEst.getCostOfChlorination().toString() %></td>
	</tr>
	 --%>
	
	<tr>
	<td>Cost of Repair and minor Replacement associated with Cost of Repair of existing pipe line  </td>
	<td><%=canalEst.getCostOfRepairPipeLine() %></td>
	</tr>
	
	<%-- <tr>
	<td>Cost: Automated water controller switch to Start or Stop the Pump based on water reservoir level </td>
	<td><%=canalEst.getCostOfController() %></td>
	</tr> --%>
	
	</table>
	 <div id="distributionDetails">
    	<fieldset>
        	<legend>Distribution Details</legend>
            <p>
            <strong>Enter Length of required pipelines(In Not Covered Areas)</strong>
            </p>
            <table>
            <tr>
            <td>Size : 160mm</td>
            <td><%=canalEst.getLen160mmPipeline() %></td>
              <td>Proposed Rate/Cost: 613</td>
      <td>Recommended Rate/Cost: 613</td>
    
            </tr>
            <tr>
            <td>Size : 110mm </td>
            <td><%=canalEst.getLen110mmPipeline()%></td>
               <td>Proposed Rate/Cost: 314</td>
      <td>Recommended Rate/Cost: 314</td>
    
            </tr>
            <tr>
            <td>Size : 90mm </td>
            <td><%=canalEst.getLen90mmPipeline()%></td>
            <td>Proposed Rate/Cost: 221</td>
      <td>Recommended Rate/Cost: 221</td>
            </tr>
            <tr>
            <td>Size : 75mm </td>
            <td><%=canalEst.getLen75mmPipeline()%></td>
             <td>Proposed Rate/Cost: 170</td>
      <td>Recommended Rate/Cost: 170</td>
            </tr>
            <tr>
            <td>Size : 63mm </td>
            <td><%=canalEst.getLen63mmPipeline()%></td>
            <td>Proposed Rate/Cost: 127</td>
      <td>Recommended Rate/Cost: 127</td>
            </tr>
            </table>
            
            <p>
            <strong>Sluice Valve</strong>
            </p>
            <table>
            <tr>
            <td>Size : 150mm</td>
            <td><%= canalEst.getLen150mmSluiceValve()%></td>
             <td>Proposed Rate/Cost: 8475</td>
      <td>Recommended Rate/Cost: 8475</td>
            </tr>
            <tr>
            <td>Size : 100mm </td>
            <td><%= canalEst.getLen100mmSluiceValve()%></td>
            <td>Proposed Rate/Cost: 5700</td>
      <td>Recommended Rate/Cost: 5700</td>
            </tr>
            <tr>
            <td>Size : 80mm </td>
            <td><%= canalEst.getLen80mmSluiceValve()%></td>
             <td>Proposed Rate/Cost: 4178.50</td>
      <td>Recommended Rate/Cost: 4178.50</td>
            </tr>
            </table>
            
            <p>
            <strong>Sluice Valve Haudi</strong>
            </p>
            <table>
            <tr>
            <td>[ Size : 0.60 X 0.60 mtr ]</td>
            <td><%= canalEst.getLen60Mtr() %></td>
            </tr>
            <tr>
            <td>[ Size : 0.90 X 0.90 mtr ]</td>
            <td><%= canalEst.getLen90Mtr() %></td>
            </tr>
            <tr>
            <td>Dismantling & restoration of Road cut per Mtr. [Brick on edge] , If Required</td>
            <td>Enter numeric value (in mtrs):</td>
            <td><%= canalEst.getDismantlingBrick() %></td>
            </tr>
            <tr>
            <td>Dismantling & restoration of Road cut per Mtr. [CC Flooring], If Required </td>
            <td>Enter numeric value (in mtrs):</td>
            <td><%= canalEst.getDismantlingCCFlooring()%></td>
            </tr>
            <tr>
            <td>Cost likely BT bill for restoration of Dismanted Metalled Road  </td>
            <td><%= canalEst.getBTBillCost()%></td>
            </tr>
            <tr>
            <td>No. of Water Meter [Where ever Villagers Adopt Metering]  </td>
            <td>Enter numeric value :</td>
            <td><%= canalEst.getNoOfWaterMeter()%></td>
            </tr>
            <tr height="10px"></tr>
            <tr>
            <td>Installation of new Sign Board or Painting of existing?</td>
            </tr>
            <tr>
             <td><%= canalEst.getInstallSignBoard()%></td>
    </tr>
    <tr>
            <td>Cost of Sign Board: <%= canalEst.getCostOfSignBoard()%></td>
            </tr>
            </table>
        </fieldset>
    </div> <!--End of Distribution Details -->
	</div>
</body>
</html>