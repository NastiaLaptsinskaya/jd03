<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
<br/>
	Hello, User!
	
	<form action="controller" method="post">
		<input type="hidden" name="command" value="show_free_rooms" /> ${login}
		<input type="submit" name="sign in" value="show free rooms" />

	</form>
	<h1>	
		<%
			by.htp3.hotel.bean.User user = (by.htp3.hotel.bean.User)request.getAttribute("user");
		    out.println(user.getName());
		%>
	</h1>		

	<h2>	
		<%
			out.println(user.getSurname());
		%>

	</h2>
	
	<form action="controller" method="post">
		<input type="hidden" name="command" value="change_account" /> ${login}
		<input type="submit" name="change account" value="change account" />

	</form>
</body>
</html>