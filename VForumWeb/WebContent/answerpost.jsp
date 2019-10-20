
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
<body background="images/bg.jpg">

<form action="postanswer" method="post" autocomplete="off">
 <div class="container">
 			
			<table style="with: 50%">
			<tr>
			<td> Enter post id:</td>
			<td><input type="number" name="postid" required/></td>
			</tr>
			
				<tr>
					<td>Enter Answer:</td>
					<td><textarea rows="4" cols="50" name="textarea"></textarea></td>
				</tr>
				
				
				<tr>
				<td><input type="submit" class="button" value="submit">
				<td><input type="reset" class="btncncl" value="Reset"></td> 
				</tr>
				</table>
				
				</div> 
				</form>
</body>
</html>