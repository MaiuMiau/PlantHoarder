<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="fi">

<head>

<title>LisaaKasviSivu</title>
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
				<li><a href="lisaa-henkilo">LISÄÄ PROFIILI</a></li>
				<li><a href="kenen-profiili-naytetaan">PROFIILINI</a></li>
				<li class="aktiivinen">LISÄÄ VIHERKASVI</li>
				<li><a href="kenen-kasvit-haluat-nahda">VIHERKASVINI</a></li>
			</ul>
		</nav>
	</header>
	<h2>&bull; Lisää viherkasvi profiiliisi &bull;</h2>
	<div id="container">
		<form action="#" method="post" id="contact_form">


	<%-- hakee pudotusvalikkoon kaikki profiilit joista käyttäjä voi valita omansa --%>
		<%-- valinnasta välittyy eteenpäin henkiloId --%>

			<h3>Valitse profiili:</h3>
			<select name="henkiloId" id= "select">
				<c:forEach items="${henkilot}" var="henkilo">

					<option value="<c:out value='${henkilo.id}'/>"><c:out
							value='${henkilo.etuNimi} ${henkilo.sukuNimi},  Käyttäjätunnus:  ${henkilo.kayttajaTunnus}' /></option>
				</c:forEach>
			</select> <br> <br>


<%-- syötteille on määritelty maksimipituus joka vastaa tietokantaan määriteltyä maksimipituutta --%>


			<div>
				<label for="nimi"></label> <input type="text" maxlength="30"
					placeholder="Kasvin nimi" name="nimi" required>
			</div>

			<div>
				<label for="kuvaus"></label> <input type="text" maxlength="200"
					placeholder="Kuvaus kasvista" name="kuvaus" required>
			</div>

			<div>
				<label for="kastelu"></label> <input type="text" maxlength="30"
					placeholder="Kasteluohje" name="kastelu" required>
			</div>

			<div>
				<label for="valo"></label> <input type="text" maxlength="30"
					placeholder="Valon tarve" name="valo" required>
			</div>


			<input type="submit" name="submit-button" class="submit-button"
				value="Lisää" id="form_button" /> <%-- painike lisää kasvin ja siirtyy sivulle jossa listataan kaikki henkilonksavit--%>
			<div class="button" id="form_button"><a id="linkki" href="etusivu">Peruuta</a></div>



		</form>
	</div>
	<!-- // End #container -->

</body>
</html>