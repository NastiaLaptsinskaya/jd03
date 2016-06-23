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
   <fmt:message bundle="${loc}" key="locale.index.login" var="login" />


	<jsp:useBean id="errorMessage" class="java.lang.String" scope="request" />


	<a href="controller?command=change_language&language=ru">${ru}</a>|
	<a href="controller?command=change_language&language=en">en</a>


	<br />

	<form action="controller" method="post">
		<input type="hidden" name="command" value="logination" /> ${login}: <br />
		<input type="text" name="login" value="" /><br /> Password: <br />
		<input type="password" name="password" value="" /> <br /> <i> 
		
		<c:out	value="${errorMessage}" />

		</i> <br /> <input type="submit" name="action1" value="sign in" /> 
		<input type="submit" name="action2" value="sign in as admin" />

	</form>
	
    <br />
	<br /> 
	<form action="registration">
    <a href="registration">create account </a>
    <br /> <input type="submit" name="create account" value="create account" />
    </form>

</body>
</html>