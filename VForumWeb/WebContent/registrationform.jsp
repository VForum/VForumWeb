<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Form</title>
<style>
input[type=text], 
    input[type=password],input[type=date] { 
        width: 90%; 
        padding: 12px 20px; 
        margin: 8px 0; 
        display: inline-block; 
        border: 1px solid #ccc; 
        box-sizing: border-box; 
    } 
    #select{
    width: 90%; 
        padding: 12px 20px; 
        margin: 8px 0; 
        display: inline-block; 
        border: 1px solid #ccc; 
        box-sizing: border-box; 
    }
 .button { 
        background-color: #4CAF50; 
        color: black; 
        padding: 14px 20px; 
        margin-left:100px;
        border: none; 
        cursor: pointer; 
        width: 40%; 
    } 
    .container { 
    	
       	padding: 0px;
        margin-left: 250px;
        margin-right: 250px; 
        
    } 
    form { 
        border: 45px solid #f1f1f1;
        padding:250px; 
    } 
    .btncncl { 
        background-color: #f44336; 
        padding: 14px 20px; 
       margin-left:180px;
        border: none; 
        cursor: pointer; 
        width: 10%; 
    } 
</style>
</head>
<body>

<form action="employee" method="post" autocomplete="off">
 <div class="container">
			<table style="with: 50%">
			<h1 align="center">Employee Registration Form</h1>
				<tr>
					<td>UserName:</td>
					<td><input type="text" name="user_name" /></td>
				</tr>
				<tr>
					<td>First Name:</td>
					<td><input type="text" name="first_name" /></td>
				</tr>
				<tr>
					<td>Last Name:</td>
					<td><input type="text" name="last_name" /></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><input type="text" name="email" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td>Phone Number:</td>
					<td><input type="text" name="phone_number" /></td>
				</tr>
				<tr>
					<td>Designation:</td>
					<td><select name="designation" id="select">
					<option value="select">select</option>
  					<option value="Project Manager">Project Manager</option>
  					<option value="Associate-Engineer">Associate-Engineer</option>
  					<option value="Trainee Engineer">Trainee Engineer</option>
  					<option value="System Analyst">System Analyst</option>
					</select></td>
				</tr>
				<tr>
				<td>Date Of Birth:</td>
				<td><input type="date" name="date" /></td>
				</tr>
				<tr>
				<td><input type="submit" class="button" value="Submit">
				<td><input type="reset" class="btncncl" value="Reset"></td> 
				</tr>
				</table>
				
				</div> 
				</form>
</body>
</html>