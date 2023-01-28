<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<pre>
<table>
<tr>
<th>ID</th>
<th>Name</th>
<th>Address</th>
<th>Mobile</th>
</tr>

<c:forEach var="row" items="${list}">
<tr>
<td>${row.id}</td>
<td>${row.empname}</td>
<td>${row.empaddress}</td>
<td>${row.empmobile}</td>
</tr>
</c:forEach>
</table>
</pre>
</body>
</html>