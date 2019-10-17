<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employees Details!!!</title>
<style>
table, th, td {

  border: 1px solid black;
}
</style>
</head>
<body>
<h1 align="center">Employees Details</h1>

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

<c:forEach items="${employeesModelList}" var="employeemodel">
<tr>
<td><c:out value="${employeemodel.employeeUid}"/></td>
<td><c:out value="${employeemodel.firstName}"/></td>
<td><c:out value="${employeemodel.lastName}"/></td>
<td><c:out value="${employeemodel.email}"/></td>
<td><c:out value="${employeemodel.phoneNumber}"/></td>
<td><c:out value="${employeemodel.designation}"/></td>
<td><c:out value="${employeemodel.dob}"/></td>
</tr>
</c:forEach>
</table>
</body>
</html>