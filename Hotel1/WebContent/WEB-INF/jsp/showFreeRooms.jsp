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
	
   <fmt:setLocale value="${sessionScope.locale}" /><!-- locale = ru -->
   <fmt:setBundle basename="resources.locale" var="loc" /><!-- locale_ru  -->
   
   <fmt:message bundle="${loc}" key="locale.change_language.ru" var="ru" />
   <fmt:message bundle="${loc}" key="locale.change_language.en" var="en" />
	
	<jsp:useBean id="errorMessage" class="java.lang.String" scope="request" />

	<a href="controller?command=change_language&language=ru">${ru}</a>|
	<a href="controller?command=change_language&language=en">${en}</a>

<br/>
	<table border="1">
		<c:forEach var="room" items="${requestScope.free_rooms}">
    		<tr>
    			<td> <c:out value="${room.type}"/> </td> <!-- with the help of engine this param
    													 will be taken through getParam -->
    			<td> <c:out value="${room.number}"/> </td> 
    		</tr>
		</c:forEach>
	</table>	


</body>
</html>