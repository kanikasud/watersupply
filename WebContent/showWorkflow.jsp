<%@page import="in.redexp.watersupply.model.Workflow"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    ArrayList<Workflow> wfList = (ArrayList<Workflow>)request.getAttribute("wfList");
    %>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!doctype html>
<html>
<head>
<style>
.informationBar
	{
		clear:both; float:none; display:block; width:100%; 
	}
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
	.spacer{height:30px;}
</style>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js"></script>
<script>

        
 function submitForm(id, fromRoleId, fromLocId, toRoleID, toLocID, actionID, processID)
 {
	 console.log("Update: " + id)
	 console.log(document.getElementById(actionID).value);
	 var action = document.getElementById(actionID).value;
	 console.log(document.getElementById(processID).value);
	 var process = document.getElementById(processID).value;
	 document.forms[0].action = 'updateWorkflowRow.action?workflowID='+id+'&fromRoleID='+fromRoleId+'&fromLocID='+fromLocId
			 +'&toRoleID='+toRoleID+'&toLocID='+toLocID+"&action="+action+'&process='+process;
	 document.forms[0].submit();
 }

	
	

</script>
<meta charset="utf-8">
<title>Workflow Screen</title>
</head>

<body>
<form method="post">

<div class="pageWrapper" style="clear:both; float:none; display:block; width:100%; ">
    	<div id="informationBar"  class="borderDiv informationBar"  style="width:100%; float:left">
        <div style="width:40%; float:left"><strong>WORKFLOW SCREEN | WELCOME ADMIN</strong></div>
        <div style="width:60%; float:left; text-align:right"><a href="#">Report</a>
            <a href="#">Help</a>
            <a href="LoginScreen.html">Logout</a></div>
        </div>
       
        <div class="spacer">
        </div>
         <div class="spacer">
        </div>
        <div id="workflowTable">
         <fieldset  class="borderDiv">
           <legend style="text-align:left; font-weight:bold">WORKFLOW</legend>
           <table style="width:100%; " class="table">
         
            <tr>
            	<th>Row No</th>
            	<th>From Location</th>
				<th>From Designation </th>
				<th>To Location</th>
				<th>To Designation</th>		
				<th>Special Action Privilege </th>
                <th>Process in Days</th>
                <th></th>
</tr>
<% for(int i = 0; i < wfList.size(); i++){ %>
<tr>
<td><label><%=i + 1%></label></td>
 <td>
       			<input type="text" name="fromLocID" value="<%=wfList.get(i).getFromLocID()%>">
              </td>
 				<td>
 				<input type="hidden" name="workflowID" value="<%=wfList.get(i).getWorkflowID()%>"></input>
 				
              <input type="text" name="fromRoleID" value="<%=wfList.get(i).getFromRoleId()%>">
              </td>
             
             
               <td>
              <input type="text" name="toRoleID" value="<%=wfList.get(i).getToRoleId()%>">
              </td>
              <td>
              <input type="text" name="toLocID" value="<%=wfList.get(i).getToLocID()%>">
              </td> 
             
              <td><input type="text" id="action<%=i %>" name="action" value="<%=wfList.get(i).getAction()%>"></td>
              <td><input type="text" id="process<%=i%>" name="processInDays" value="<%=wfList.get(i).getProcessInDays()%>"></td>
              <th><input type="submit" value="Update" onclick="submitForm('<%=wfList.get(i).getWorkflowID()%>', '<%=wfList.get(i).getFromRoleId()%>', '<%=wfList.get(i).getFromLocID()%>', '<%=wfList.get(i).getToRoleId()%>', '<%=wfList.get(i).getToLocID()%>', 'action<%=i %>', 'process<%=i%>')"></th></tr>
<%} %>
          	</table>
           </fieldset>
        </div>
        <div class="spacer">
        </div>
 </div>

 </form>
</body>
</html>
