<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>

</script>
</head>
<body>
<% String username=(String)request.getAttribute("username"); 
	request.setAttribute("username",username); %>
	
<a href="employee?action=viewprofile"> View Profile </a><br>
<a href="employee?action=viewposts"> View Questions </a><br>
<a href="employee?action=postquestion">Post Question</a><br>
<a href="employee?action=logout"> logout </a><br></body>
</html>