<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="fi">

<head>

<title>KenenProfiiliKatsotaan</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<meta name="author" content="Maiju">
<link href="lomakeTyyli.css" rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans+Condensed:300"
	rel="stylesheet">



</head>

<body>
	<header>
		<h1>PLANT HOARDER</h1>

		<nav>
			<ul>
				<li><a href="etusivu">KOTISIVU</a></li>
				<li><a href="lisaa-henkilo">LIS�� PROFIILI</a></li>
				<li class="aktiivinen">PROFIILINI</li>
				<li><a href="uusi-kasvi-henkilolle">LIS�� VIHERKASVI</a></li>
				<li><a href="kenen-kasvit-haluat-nahda">VIHERKASVINI</a></li>
			</ul>
		</nav>
	</header>
	<h2>&bull; Mink� profiilin tiedot haluat n�hd�? &bull;</h2>
	<div id="container">
		<form action="profiilin-tiedot" method="post" id="contact_form">




			<h3>Valitse profiili:</h3>
			<select name="henkiloId">
				<c:forEach items="${henkilot}" var="henkilo">

					<option value="<c:out value='${henkilo.id}'/>"><c:out
							value='${henkilo.etuNimi} ${henkilo.sukuNimi},  K�ytt�j�tunnus:  ${henkilo.kayttajaTunnus}' /></option>
				</c:forEach>
			</select> <input type="submit" value="N�yt�" id="form_button" />



		</form>
	</div>
	<!-- // End #container -->
</body>
</html>