<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
	<link href="css/simple.css" rel="stylesheet" type="text/css" />
	<title>Påmelding</title>
</head>

<body>
	<h2>Påmelding</h2>
	<p style="color:red">${errorMessage}</p>
	<form method="post" action="paamelding">
		<fieldset>

			<label>Fornavn</label>
			<input type="text" name="fornavn" placeholder="Fornavn" value="" />

			<label>Etternavn</label>
			<input type="text" name="etternavn" placeholder="Etternavn" value="" />

			<label>Mobil (8 siffer)</label>
			<input type="text" name="mobil" placeholder="98765432" value="" />

			<label>Passord</label>
			<input type="password" name="passord" placeholder="passord" />

			<label>Passord repetert</label>
			<input type="password" name="passordRepetert" placeholder="Repeter passord" />

			<label>Kjønn</label>
			<input type="radio" name="kjonn" value="mann"   />mann
			<input type="radio" name="kjonn" value="kvinne" />kvinne

			<br><br><button type="submit">Meld meg på</button>
		</fieldset>
	</form>

</body>
</html>