<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="fi">

<head>

<title>Profiilisivu</title>
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
				<li><a href="lisaa-henkilo">LISÄÄ PROFIILI</a></li>
				<li><a href="kenen-profiili-naytetaan">PROFIILINI</a></li>
				<li><a href="uusi-kasvi-henkilolle">LISÄÄ VIHERKASVI</a></li>
				<li><a href="kenen-kasvit-haluat-nahda">VIHERKASVINI</a></li>
			</ul>
		</nav>
	</header>
	<h2>
		&bull;
		<c:out value="${henkilo.etuNimi}" />
		&bull;
	</h2>
	<h2>&bull; Profiilin tiedot &bull;</h2>




	<table >

		<tr>
			<th align="left" width=200>id</th>
			<th align="left" width=200>Käyttäjätunnus</th>
			<th align="left" width=200>Etunimi</th>
			<th align="left" width=200>Sukunimi</th>

		</tr>

		<tr>
			<td align="left" width=30><c:out value="${henkilo.id}" /></td>
			<td align="left" width=300><c:out
					value="${henkilo.kayttajaTunnus}" /></td>
			<td align="left" width=200><c:out value="${henkilo.etuNimi}" /></td>
			<td align="left" width=200><c:out value="${henkilo.sukuNimi}" /></td>
		</tr>

		<tr>
			<td align="left" class="alinSolu"></td>
			<td align="left" class="alinSolu"></td>
			<td align="left" class="alinSolu"></td>
			<td align="left" class="alinSolu"></td>
		</tr>

		<tr>
			<td align="left" class="alinSolu"></td>
			
			<td align="left" id="poisto"><a id="linkki" href="poista-henkilo?id=<c:out value='${henkilo.id}' />">Poista</a></td>
			
			<td align="right" id="poisto" ><a id="linkki" href="muokkaa-profiilin-tietoja?id=<c:out value='${henkilo.id}' />">Muokkaa</a></td>
			<td align="left" class="alinSolu"></td>

		</tr>
	</table>














	<footer id="alaosa">
		<p id="tiedot">Plant Hoarder</p>
	</footer>


</body>

</html>