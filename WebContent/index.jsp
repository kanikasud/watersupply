<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login here</title>
</head>
<body>
<div>
  <div id="loginTitle" style="height:100px; background-color:grey;color:white; text-align:center; font-size:18px; vertical-align:middle; padding-top:50px">
    <strong>Login to Estimate Subsystem</strong>
  </div>
  <form action="login" method="post">
  <div id="userInfo" style="height:50px; text-align:center; padding-top:10px">
    <label for="userNameText">User ID: </label>
    <input id="userNameText" name="userName" type="text" />
    </div>
    <div id="passwordInfo" style="height:50px; text-align:center;">
      <label for="password">Password: </label>
      <input type="password" id="passwordText" name="pwd" />
    </div>
    <div id="submitDiv" style="height:50px; text-align:center;">
     <input type="submit"/>
    </div>
  <div id="footer" style="height:30px;background-color:grey;color:white; text-align:center; font-size:18px; vertical-align:middle;margin-bottom:0 ">
    &copy; Water Sanitation Deptt
    </div>
   </form>
</div>
</body>
</html>