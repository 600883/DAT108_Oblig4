<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/simple.css" type="text/css">
<title>Logg inn</title>
</head>
<body>
	<h2>Logg inn</h2>
	<p style="color:red">${errorMessage}</p>

	<form action="login" method="post">
		<fieldset>
			<label for="mobil">Mobil:</label> <input type="text" name="mobil" />
			<label for="passord">Passord:</label> <input type="password" name="passord" />
			<br><br><button type="submit">Logg inn</button>

		</fieldset>
	</form>

   <li><a href="/home/">Avbryt</a></li>

</body>
</html>