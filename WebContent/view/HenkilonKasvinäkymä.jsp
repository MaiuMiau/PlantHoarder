<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="fi">

<head>

<title>HenkilonKasvitSivu</title>
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
	<h2>&bull;Tässä kaikki kasvisi&bull;</h2>
	<h2><c:out value="${viesti}" /></h2>

<%-- tulostaa kaikkien kasvien tiedot --%>
	<c:forEach items="${kasvit}" var="kasvi">
		<table>

			<tr>
				<th align="left" width=220>Nimi</th>
				<th align="left" width=220>Kastelu</th>
				<th align="left" width=220>Valo</th>

			</tr>

			<tr>
				<td align="left" width=220><c:out value="${kasvi.nimi}" /></td>
				<td align="left" width=220><c:out value="${kasvi.kastelu}" /></td>
				<td align="left" width=220><c:out value="${kasvi.valo}" /></td>
			</tr>

			<tr>
				<th align="left" width=220>Kuvaus</th>
			</tr>

			<tr>
				<td align="left" colspan="3" width=660><c:out
						value="${kasvi.kuvaus}" /></td>

			</tr>

			<tr>
				<td align="left" class="alinSolu"></td>
				<td align="left" class="alinSolu"></td>
				<td align="left" class="alinSolu"></td>

			</tr>

			<tr>
				<td align="left" class="alinSolu"></td>
				
				<%-- poistaa kasvin kasvinIdn perusteella --%>
				<td align="left" id="poisto"><a id="linkki"
					href="poista-kasvi?id=<c:out value='${kasvi.id}' />&henkiloId=<c:out value='${henkilo.id}' />">Poista</a></td>
				
				<%-- siirtyy muokkaamaan kasvia kasvinIdn perusteella --%>
				<td align="left" id="poisto"><a id="linkki"
					href="muokkaa-kasvin-tietoja?id=<c:out value='${kasvi.id}' />">Muokkaa</a></td>
				<td align="left" class="alinSolu"></td>

			</tr>

		</table>

	</c:forEach>












	<footer id="alaosa">
		<p id="tiedot">Plant Hoarder</p>
	</footer>


</body>

</html>