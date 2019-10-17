<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@include file="taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Posts Details!!!</title>
<style>
table, th, td {

  border: 1px solid black;
}
</style>
</head>
<body>
<h1 align="center">Posts Details</h1>

<table align="center">
<tr>
<th>UserId</th>
<th>PostId</th>
<th>Post</th>
<th>Category</th>
</tr>

<c:forEach items="${postModelList}" var="postmodel">
<tr>
<td><c:out value="${postmodel.userId}"/></td>
<td><c:out value="${postmodel.postId}"/></td>
<td><c:out value="${postmodel.post}"/></td>
<td><c:out value="${postmodel.category}"/></td>
</tr>
</c:forEach>
 </table>
<a href="deleteposts.html">Delete posts</a> <br>
<a href="admin.html">Back</a> 

</body>
</html>