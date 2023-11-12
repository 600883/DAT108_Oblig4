<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/simple.css">
	<title>Deltagerliste</title>
</head>
<body>
        <p>Logget inn som:</p>
        <p>Mobil: <c:out value="${deltager.mobil}"/><br>
		<p>Navn: <c:out value="${deltager.fornavn}"/> <c:out value="${deltager.etternavn}"/><br>

	<h2>Deltagerliste</h2>
	<table>
	    <tr>
	        <th>Kjønn</th>
	        <th>Fornavn</th>
	        <th>Etternavn</th>
	        <th>Mobil</th>
	    </tr>

	    <c:forEach var="deltagere" items="${deltagerListe}">
	         <tr style="${deltagere.mobil eq deltager.mobil  ? 'background-color: greenyellow;' : ''}">

	            <td><c:out value="${deltagere.kjonn}" /></td>
	            <td><c:out value="${deltagere.fornavn}" /></td>
	            <td><c:out value="${deltagere.etternavn}" /></td>
	            <td><c:out value="${deltagere.mobil}" /></td>
	        </tr>
	    </c:forEach>
	</table>
	<br>
	<form action="logout" method="post">
        <p><input type="submit" value="Logg ut" /></p>
    </form>
</body>
</html>