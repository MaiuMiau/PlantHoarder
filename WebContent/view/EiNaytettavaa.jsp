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
				<li><a href="lisaa-henkilo">LISƒƒ PROFIILI</a></li>
				<li><a href="kenen-profiili-naytetaan">PROFIILINI</a></li>
				<li><a href="uusi-kasvi-henkilolle">LISƒƒ VIHERKASVI</a></li>
				<li><a href="kenen-kasvit-haluat-nahda">VIHERKASVINI</a></li>
			</ul>
		</nav>
	</header>
	<h2>
		&bull;
		<c:out value="${henkilo.etuNimi}" />
		&bull;
	</h2>
	
	<div id="container">
	<br>
	<h3>Et ole lis‰nnyt viel‰ yht‰‰n kasvia!</h3> 
	<h3>T‰st‰ p‰‰set lis‰‰m‰‰n kasvin profiiliisi</h3>
	<br>
	<div class="submit">
		<div class="button" id="form_button"><a id="linkki" href="uusi-kasvi-henkilolle">Lis‰‰ kasvi</a></div> 
			<div class="button" id="form_button"><a id="linkki" href="etusivu">Peruuta</a></div>
			</div>
			<br>
			<br>
		
	</div>














	<footer id="alaosa">
		<p id="tiedot">Plant Hoarder</p>
	</footer>


</body>

</html>