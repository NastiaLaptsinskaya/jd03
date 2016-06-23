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
	
	<jsp:useBean id="errorRoomMessage" class="java.lang.String" scope="request" />
	<jsp:useBean id="errorShowAllRoomsMessage" class="java.lang.String" scope="request" />
	<jsp:useBean id="errorDeleteRoomMessage" class="java.lang.String" scope="request" />
	<jsp:useBean id="progressMessage" class="java.lang.String" scope="request" />
	<jsp:useBean id="progressMessage2" class="java.lang.String" scope="request" />
	<jsp:useBean id="progressMessage3" class="java.lang.String" scope="request" />
	<jsp:useBean id="user" class="by.htp3.hotel.bean.User" scope="session" />
	
	<h1>
		<i><c:out	value="${user.getName()}" />  <c:out	value="${user.getSurname()}" /></i>
	</h1>
	
	You are in system with the rights of administrator
	<br/>
	<br/>
	<fieldset><legend>1). ADD NEW ROOM: </legend>
	<form action="controller" method="post">
	
		<input type="hidden" name="command" value="add_new_room" /> <br />
		Room number:<br />
		<input type="text" name="roomID" value="" /><br />  
		Type: <br /> <i> (half-lux, econom,<br />
		 family-lux)</i><br />
		<input type="text" name="typeName" value="" /><br />
		
		<i><c:out	value="${errorRoomMessage}" /></i>
		<i><c:out	value="${progressMessage}" /></i>
		<br />
		<input type="submit" name="add new room" value="add new room" /> 
		
	</form>
	</fieldset>
				
	<fieldset><legend>2). SHOW ROOMS: </legend>
	
	<form action="controller" method="post">
	
		<input type="hidden" name="command" value="show_all_rooms" /> <br />
		
		<i><c:out	value="${errorShowAllRoomsMessage}" /></i>
		<i><c:out	value="${progressMessage2}" /></i>
		<br />
		<input type="submit" name="show all rooms" value="show all rooms" /> 
		
	</form>
	
	<table border="1">
	  	  <tr>
		      	<th>Number</th>
		       	<th>Type</th>
		        <th>Price/day</th>
		        <th>Number of beds</th>
		        <th>Floor</th>
		        <th>Window view</th>
	   	  </tr>
   	  
				    <tr>
				    <c:forEach var="room" items="${requestScope.roomsList}">
					    <tr>
						    <td><c:out value="${room.number}" /></td>
						    <td><c:out value="${room.typeName}" /></td>
						    <td><c:out value="${room.pricePerDay}" /></td>
						    <td><c:out value="${room.bedsNumber}" /></td>
						    <td><c:out value="${room.floor}" /></td>
						    <td><c:out value="${room.windowView}" /></td>
					    </tr>
				    </c:forEach>
				    </tr>
        </table>
	
	</fieldset>
	
	<fieldset><legend>3). DELETE ROOM: </legend>
	<form action="controller" method="post">
	
		<input type="hidden" name="command" value="delete_room" /> <br />
		Room number:<br />
		<input type="text" name="room number" value="" /><br />  
		
		<i><c:out	value="${errorDeleteRoomMessage}" /></i>
		<i><c:out	value="${progressMessage3}" /></i>
		<br />
		<input type="submit" name="delete room" value="delete room" /> 
		
	</form>
	</fieldset>
</body>
</html>