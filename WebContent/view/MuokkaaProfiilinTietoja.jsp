<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="fi">

<head>

<title>Muokkaa Profiilin tietoja</title>
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
				<li><a href="kenen-profiili-naytetaan">PROFIILINI</a></li>
				<li><a href="uusi-kasvi-henkilolle">LIS�� VIHERKASVI</a></li>
				<li><a href="kenen-kasvit-haluat-nahda">VIHERKASVINI</a></li>
			</ul>
		</nav>
	</header>

	<h2>&bull; Muokkaa Profiilisi tietoja &bull;</h2>
	<h2>
		&bull;
		<c:out value="${henkilo.etuNimi}" />
		&bull;
	</h2>


	<div id="container">



		<form action="#" method="post" id="contact_form">
<%-- sy�tteille on m��ritelty maksimipituus joka vastaa tietokantaan m��ritelty� maksimipituutta --%>
			<div>
				<label for="Id"></label> <input value="${henkilo.id}" 
					type="hidden" name="Id">  
					<%-- henkiloId ei ole k�ytt�j�n muokattavissa --%>
			</div>

			<div>
				<label for="kayttajaTunnus"></label> <input type="text" maxlength="30"
					placeholder="Anna uniikki k�ytt�j�tunnus esim. s�hk�posti" name="kayttajaTunnus" required>
			</div>

			<div>
				<label for="etuNimi"></label> <input type="text" maxlength="30"
					placeholder="Etunimi" name="etuNimi" required>
			</div>

			<div>
				<label for="sukuNimi"></label> <input type="text" maxlength="30"
					placeholder="Sukunimi" name="sukuNimi" required>
			</div>


			
				<input type="submit" value="P�ivit�" id="form_button" />
				<%-- painike p�ivitt��  tiedot ja siirtyy sivulle jossa listataan kaikki henkilonksavit--%>
			
			<div class="button" id="form_button"><a id="linkki" href="etusivu">Peruuta</a></div>
		</form>
		<!-- // End form -->
	</div>
	<!-- // End #container -->
	<br>
	<br>




	<footer id="alaosa">
		<p id="tiedot">PLANT HOARDER</p>
	</footer>


</body>

</html>