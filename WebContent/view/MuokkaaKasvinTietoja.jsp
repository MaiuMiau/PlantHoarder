<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="fi">

<head>

<title>Muokkaa Viherkasvin tietoja</title>
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

	<h2>&bull; Muokkaa viherkasvin tietoja &bull;</h2>
	<h2>
		&bull;
		<c:out value="${kasvi.nimi}" />
		&bull;
	</h2>


	<div id="container">



		<form action="#" method="post" id="contact_form">

			<div>
				<label for="kasviId"></label> <input value="${kasvi.id}"
					type="hidden" name="kasviId" readonly>
			</div>

			<div>
				<label for="nimi"></label> <input type="text"
					placeholder="Kasvin nimi" name="nimi" required>
			</div>

			<div>
				<label for="kuvaus"></label> <input type="text"
					placeholder="Kuvaus kasvista" name="kuvaus" required>
			</div>

			<div>
				<label for="kastelu"></label> <input type="text"
					placeholder="Kasteluohje" name="kastelu" required>
			</div>

			<div>
				<label for="valo"></label> <input type="text"
					placeholder="Valon tarve" name="valo" required>
			</div>
			<div>
				<label for="henkiloId"></label> <input value="${kasvi.henkiloId}"
					type="hidden" name="henkiloId" readonly>
			</div>



			<div class="submit">
				<input type="submit" value="P�ivit�" id="form_button" />
			</div>
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