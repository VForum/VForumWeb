<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1 align="center">answers details</h1>

<table align="center">
<tr>
<th>aPostId</th>
<th>username</th>
<th>answer</th>

</tr>

<c:forEach items="${answersList}" var="answermodel">
<tr>
<td><c:out value="${answermodel.aPostId}"/></td>
<td><c:out value="${answermodel.username}"/></td>
<td><c:out value="${answermodel.answer}"/></td>
</tr>
</c:forEach>
 </table>
<a href="employee.jsp">Back</a> <br>


</body>
</html>