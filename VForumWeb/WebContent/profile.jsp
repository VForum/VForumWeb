<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile !!!</title>
<style>
table, th, td {

  border: 1px solid black;
}
</style>
</head>
<body>
<h1 align="center">My Profile</h1>

<table align="center">
<tr>
<th>EmployeeUId</th>
<th>FirstName</th>
<th>LastName</th>
<th>Email</th>
<th>PhoneNumber</th>
<th>Designation</th>
<th>dob</th>
</tr>

<c:forEach items="${profile}" var="profilemodel">
<tr>
<td><c:out value="${profilemodel.employeeUid}"/></td>
<td><c:out value="${profilemodel.firstName}"/></td>
<td><c:out value="${profilemodel.lastName}"/></td>
<td><c:out value="${profilemodel.email}"/></td>
<td><c:out value="${profilemodel.phoneNumber}"/></td>
<td><c:out value="${profilemodel.designation}"/></td>
<td><c:out value="${profilemodel.dob}"/></td>
</tr>
</c:forEach>
</table>
<a href="employee.jsp">Back</a> 
</body>
</html>