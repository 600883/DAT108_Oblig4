<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/simple.css">
    <title>Påmeldingsbekreftelse</title>
</head>
<body>
	<h2>Påmeldingsbekreftelse</h2>
	<p>Påmeldingen er mottatt for</p>
	<p>
		<p>Mobil: <c:out value="${deltager.mobil}"/><br>
		<p>Fornavn: <c:out value="${deltager.fornavn}"/><br>
		<p>Etternavn: <c:out value="${deltager.etternavn}"/><br>
		<p>Kjønn: <c:out value="${deltager.kjonn}"/><br>
	</p>
	<a href="deltagerliste">Gå til deltagerlisten</a>
</body>
</html>