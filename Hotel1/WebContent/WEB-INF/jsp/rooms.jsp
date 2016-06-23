<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<br/>
	<table border="1">
		<c:forEach var="room" items="${requestScope.roomsList}">
    		<tr>
    			<td><c:out value="${room.typeName}" /></td>
				<td><c:out value="${room.pricePerDay}" /></td>
				<td><c:out value="${room.bedsNumber}" /></td>
				<td><c:out value="${room.floor}" /></td>
				<td><c:out value="${room.windowView}" /></td>										 
    			<td> <c:out value="${room.number}"/> </td> 
    		</tr>
		</c:forEach>
	</table>
</body>
</html>