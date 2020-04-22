<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Customer confirmation form</title>
</head>
<body>
The customer is confirmed: ${customer.firstName } ${customer.lastName }
<br>
<br>
The number of free passes are: ${customer.freePasses}
<br>
<br>
Postal code: ${customer.postalCode }
<br>
<br>
Course code: ${customer.courseCode }
</body>
</html>