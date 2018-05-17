<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="fi">

<head>

<title>HenkiloLomakeSivu</title>
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
				<li><a href="etusivu">ETUSIVU</a></li>
				<li class="aktiivinen">LISÄÄ PROFIILI</li>
				<li><a href="kenen-profiili-naytetaan">PROFIILINI</a></li>
				<li><a href="uusi-kasvi-henkilolle">LISÄÄ VIHERKASVI</a></li>
				<li><a href="kenen-kasvit-haluat-nahda">VIHERKASVINI</a></li>
			</ul>
		</nav>
	</header>
	<h2>&bull;Luo profiili itsellesi&bull;</h2>


	<div id="container">


		<%-- syötteille on  määritelty maksimipituus joka vastaa tietokantaan määriteltyä maksimipituutta --%>
		<form action="#" method="post" id="contact_form">

			<div>
				<label for="kayttajaTunnus"></label> <input type="text" maxlength="30"
					placeholder="Anna uniikki käyttäjätunnus esim. sähköposti" name="kayttajaTunnus" required>
			</div>

			<div>
				<label for="etuNimi"></label> <input type="text" maxlength="30"
					placeholder="Etunimi" name="etuNimi" required>
			</div>

			<div>
				<label for="sukuNimi"></label> <input type="text" maxlength="30"
					placeholder="Sukunimi" name="sukuNimi" required>
			</div>


			
				<input type="submit" value="Luo profiili" id="form_button" />
				<%-- painike lisää profiilin ja siirtyy sivulle jossa näkyvät profiilin tiedot--%>
			
			<div class="button" id="form_button"><a id="linkki" href="etusivu">Peruuta</a></div>
		</form>
		<!-- // End form -->
	</div>
	<!-- // End #container -->





	<footer id="alaosa">
		<p id="tiedot">Plant Hoarder</p>
	</footer>


</body>

</html>