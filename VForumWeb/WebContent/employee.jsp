<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>
</script>
</head>
<body  background="images/bg.jpg">

<% String username=(String)request.getAttribute("username"); 
	request.setAttribute("username",username); %>
<a href="employee?action=viewprofile"><b>View Profile</b> </a><br>
<a href="employee?action=viewposts"><b> View Questions</b> </a><br>
<a href="employee?action=postquestion"><b>Post Question</b></a><br>
<a href="employee?action=logout"> <b>logout </b></a><br>
</body>
</html>