<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Student confirmation form</title>
</head>
<body>
The student is confirmed: ${student.firstName } ${student.lastName } ${student.country } ${student.favoriteLanguage } 
Operating systems:
<ul>
<c:forEach var="temp" items="${student.operatingSystems}">
<li>${temp}</li>
</c:forEach>
</ul>
</body>
</html>