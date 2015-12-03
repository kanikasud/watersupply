<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<%@page import="in.redexp.watersupply.model.Scheme"%>
<%@page import="java.util.List"%>
<%@page import="in.redexp.watersupply.model.UserLocation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<%
List<UserLocation> locIDList = (List<UserLocation>)request.getAttribute("locationIDList");
//System.out.println("locIDList:: " + locIDList);
request.setAttribute("locationIDList", locIDList);
String userRoleID = (String)request.getAttribute("userRoleID");
System.out.println("userRoleID:: " + userRoleID);
request.setAttribute("userRoleID", userRoleID);
List<Scheme> schemes = (List<Scheme>)request.getAttribute("schemesList");
Map map = (Map) ActionContext.getContext().get("session");
Integer numberOfLocations = locIDList.size();

List<Scheme> schemesByNameFilter = (List<Scheme>)request.getAttribute("schemesByNameFilter");
//Iterator<Scheme> schemeListIterator = schemes.iterator();
/*while(schemeListIterator.hasNext())
{
	//System.out.println(schemeListIterator.next().getSchemeID());
}*/
%>
<!doctype html>
<html>
<head>
<style>
	.table
	{
	border-collapse: collapse;
    border-spacing: 0;
    width: 100%;
    display: table;
	border-collapse: collapse;
    border-spacing: 0;
    width: 100%;
    display: table;
	border-spacing: 2px;
    border-color: grey;	}
	.table td, th
	{
		width: 8%;
		display: table-cell;
    	text-align: left;
    	vertical-align: top;
	}
	.table tr:nth-child(even) {
    background-color: #f2f2f2;
	}
	.tr:nth-child(odd) {
    background-color: white;
	}
	.borderDiv{border:1px solid black; padding:2px; padding-top:5px; padding-bottom:5px;float: left;width: 100%; }
	.spacer{height: 30px;
    float: none;
    clear: both;}
	div
	{
		padding:2px; padding-top:5px; padding-bottom:5px;
	}
	.informationBar
	{
		clear:both; float:none; display:block; width:100%; 
	}
</style>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js"></script>
<script type="text/javascript">


function showSearchResults()
{
	
	document.getElementById("searchResults").style.display = 'block';
	
	document.getElementById("summaryText").style.display = 'block';
}

function createOption(ddl, text, value) {
    var opt = document.createElement('option');
    opt.value = value;
    opt.text = text;
    ddl.options.add(opt);
}

function setAction(schemeID, locID)
{
	var userByLocation = $('#userByLocationIDList option:selected').text();
	
	userByLocation = $('#userByLocationID').text();
	console.log(userByLocation+ "userByLocation");
	var href='editSchemeEstimation?schemeID='+schemeID+'&locID='+locID+'&userByLocation='+userByLocation.trim();
	console.log("Target: " + href);
	window.location.href = href;
}

function displayAllSchemes()
{
	
	document.getElementById('searchResults').style.display = 'block';
	
}
$(document).ready(function (){
	
		// = 0;
	$('#btnFilter').click(function() {
		   
	    
	   console.log(document.getElementById('schemeNameFilterID').value);
	   
	   var columns = document.getElementsByClassName("schemeNameColumn");
	   
	   
	   for(i = 0; i < columns.length; i++)
		   {
		   if(columns[i].innerHTML == document.getElementById('schemeNameFilterID').value)
		   	{
			   console.log(columns[i].innerHTML);
			   columns[i].parentNode.style.display = 'table-row';
		   	}
		   else
			 {
			   columns[i].parentNode.style.display = 'none';
			 }
		   }
		  
	   
	   /*  $('tr').show();

	    $('tr td.schemeName').each(function() {
	        if ($("#schemeNameFilterID").val() ==  $('tr td.schemeName').text())
	        {
	            $(this).parent().hide();
	        }
	    }); */
	    
	});
	
	
	$('#allSchemesBtn').click(function() {
		   
	    
		   //console.log(document.getElementById('schemeNameFilterID').value);
		   
		   var rows = document.getElementsByTagName("tr");
		   
		   
		   for(i = 0; i < rows.length; i++)
			   {
			   
			   rows[i].style.display = 'table-row';
			   
			   }
			  
		   
		   /*  $('tr').show();

		    $('tr td.schemeName').each(function() {
		        if ($("#schemeNameFilterID").val() ==  $('tr td.schemeName').text())
		        {
		            $(this).parent().hide();
		        }
		    }); */
		    
		});
	
});
</script>
<meta charset="utf-8">
<title>Estimation | Water Supply</title>
</head>

<body>

	<div class="pageWrapper" style="">
    	<div id="informationBar"  class="borderDiv"  style="">
        <div style="float:left">
        	<div style="float:left;font-weight:bold">ESTIMATION SCREEN&nbsp;|&nbsp;</div>
            <div style="float:left">
            Welcome&nbsp;
            <%
            	if(locIDList != null && locIDList.size() > 1){
            		%>
            <select name="userByLocation" id="userByLocationIDList">
            	<%
            		for(int i = 0; i < locIDList.size(); i++){
            		UserLocation currLocation = locIDList.get(i);
            		String currLocationString = "(" + currLocation +")";
            		String currOption = userRoleID + currLocation;
            	%>
            	<option value="<%=currOption%>"><%=currOption %></option>
            	<%}%>
            </select>
            <%}else if(locIDList != null && locIDList.size() == 1){ 
            	
            %>
            <label id="userByLocationID"><%=userRoleID%>(<%=locIDList.get(0)%>)</label>
            <%} %>
            </div>
         </div>
         <div style="float:right">
            <a href="showWorkflow.action">Workflow</a>
            <a href="#">Report</a>
            <a href="#">Help</a>
<a href="logout.action">Logout</a>
         </div>
        </div>
        
       <div class="spacer">
       </div> 
      
      <div id="estimateSearchFilter" >
         <fieldset class="borderDiv">
      	<legend style="font-weight:bold;">ESTIMATION SEARCH FILTER</legend>
        	<!-- <div style="clear:both; float:none; display:block; width:100%; border:black">
              <div style="float:left; width:33%">
                  <div id="divisionLabel" style="float:left; width: 100px">Division</div>
                  <div id="comboBoxDivision" style="padding-left:100px">
                  <input list="division">
                      <datalist id="division">
                          <option value="Division1"></option>
                          <option value="Division2"></option>
                          <option value="Division3"></option>
                          <option value="Division4"></option>
                          <option value="Division5"></option>
                      </datalist>
                  </div>
               </div>
               
                 <div style="float:left; width:33%">
                  <div id="villageLabel" style="float:left; width: 100px">Village</div>
                  <div id="comboBoxVillage" style="padding-left:100px">
                  <input list="village">
                      <datalist id="village">
                          <option value="village1"></option>
                          <option value="village2"></option>
                          <option value="village3"></option>
                          <option value="village4"></option>
                          <option value="village5"></option>
                      </datalist>
                  </div>
                </div>
            </div>
            
            
            <div style="clear:both; float:none; display:block; width:100%; border:black">
              <div style="float:left; width:33%">
                  <div id="categoryLabel" style="float:left; width:100px">Category</div>
                  <div id="comboBoxCatehory" style="padding-left:100px">
                  <input list="category">
                      <datalist id="category">
                          <option value="category1"></option>
                          <option value="category2"></option>
                          <option value="category3"></option>
                          <option value="category4"></option>
                          <option value="category5"></option>
                      </datalist>
                  </div>
               </div> -->
                
               <div style="float:left; width:33%">
               
                  <div id="schemeLabel" style="width:100px;float:left">Scheme Name</div>
                  <div id="textScheme" style="padding-left:100px">
                  	
                  	<input list="filter" title="Enter scheme name which you want to search" name="schemeNameFilter" id="schemeNameFilterID">
                      <datalist id="filter">
                     
                           <%
         for(int i = 0; i < schemes.size(); i++) 
         {
         %>
         				<option value="<%= schemes.get(i).getSchemeName() %>"></option>
         				<% } %>
                      </datalist>
                  </div>
                </div>
                  <div id="submitDiv" style="float:left; width:70%">
                  	<input type="button"  value="submit" name="btnFilter" id="btnFilter"/>
                  </div>
                  <div style="float:left; width:70%">
                  	<input type="button"  id="allSchemesBtn" value="Display All Schemes"/>
                  </div>
                </fieldset>
                 
                
            </div>
            
            
           
            
        
             
        
        <div class="spacer">
       </div>
  
      
        
        <div id="searchResults">
         <fieldset  class="borderDiv">
         <legend style="text-align:left; font-weight:bold">SEARCH RESULTS: ALL SCHEMES</legend>
       	  <table style="width:100%; " class="table">
       	  <tr>
            	<th>#</th>
				<th>Div</th>
			    <th>Scheme Name</th>
                <th>Status</th>
                <th>Source</th>
                <th>Action</th>
			</tr>
         <%
         for(int i = 0; i < schemes.size(); i++) 
         {
         %>
            
            <tr>
              <td><%=i+1 %></td>
              <td><%=schemes.get(i).getLocationID() %></td>
              <td class="schemeNameColumn"><%=schemes.get(i).getSchemeName() %></td>
              <td><%=schemes.get(i).getStatus() %></td>
              <td><%=schemes.get(i).getSchemeSource() %></td>
              <td><input type="button" name="estimateButton" onclick="setAction('<%=schemes.get(i).getSchemeID() %>','<%=schemes.get(i).getLocationID() %>')" value="Edit estimate"></input></td>
            </tr>
            <%} %>
          	</table>
           </fieldset>
        </div>
        
        <div class="spacer">
       </div>
        <div id="summaryText"  class="borderDiv" style="display:none" >
        	<div style="width:25%; float:left">
            	<p><strong>Summary for SDO1 Ludhiana</strong></p>
                <p>Sent=2</p>
              <p>Received Draft=4</p>
                <p>Received But Yet To Start=0</p>
                <p>Yet To Process</p>
            </div>
            
           <!--  <div style="width:25%; float:left; display:inline; padding-left:25px">
            	<p><strong>Message from HOD</strong><br/>On 15/11/2015 Please Expedite The Process.</p>
            </div> -->
            
            <div style="width:25%; float:right; clear:right; display:inline; padding-left:25px">
            	<p><strong>ALERT</strong> - SCHEME IS PENDING</p>
            </div>
        </div>
    </div>
    
</body>
</html>
