<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pet List</title>
</head>
<body>
	<form method = "post" action = "navigationServlet">
		<table>
			<!-- This is a JSP iteration tag from the Standard Tag Library (JSTL) -->
			<c:forEach items="${requestScope.allPets}" var="currentPet">
				<tr>
					<td><input type="radio" name="id" value="${currentPet.id}"></td>
					<td>${currentPet.type}</td>
					<td>${currentPet.name}</td>
					<td>${currentPet.owner}</td>
				</tr>
			</c:forEach>
		</table>
		<input type = "submit" value = "edit" name="actRequest">
		<input type = "submit" value = "delete" name="actRequest">
		<input type="submit" value = "add" name = "actRequest">
	</form>
</body>
</html>