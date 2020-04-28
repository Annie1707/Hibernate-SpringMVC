<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>list customers</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>
<div id = "wrapper">
	<div id = "header">
		<h2>CRM - Customer Relationship Management</h2>
	</div>
</div>
<div id = "container">
	<div id ="content">
	<input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd'; return false;" class="add-button"/>
	
	<form:form action="search" method="GET">
                Search customer: <input type="text" name="input" />
                
                <input type="submit" value="Search" class="add-button" />
            </form:form>
	
	<table>
	<tr>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Email</th>
		<th>Action</th>
	</tr>
	<c:forEach var="temp" items="${customers}">
	<c:url var = "updateLink" value="/customers/showFormForUpdate">
		<c:param name="customerId" value="${temp.id}"/>
	</c:url>
	
	<c:url var = "deleteLink" value="/customers/delete">
		<c:param name="customerId" value="${temp.id}"/>
	</c:url>
	
	<tr>
	<td>${temp.firstName}</td>
	<td>${temp.lastName}</td>
	<td>${temp.email}</td>
	<td>
	<a href="${updateLink}">Update</a>
	|
	<a href="${deleteLink}"
	onclick="if(!confirm(('Are you sure you want to delete this customer?'))) return false">Delete</a>
	</td>
	</tr>
	</c:forEach>
	</table>
	
	</div>

</div>


</body>
</html>