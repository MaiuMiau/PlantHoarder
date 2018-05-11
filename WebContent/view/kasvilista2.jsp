<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="fi">

<head>

<title>LOMAKESIVU</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<meta name="author" content="Maiju">
<link href="lomakeTyyli.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Open+Sans+Condensed:300" rel="stylesheet">



</head>

<body>
	<header>
		<h1>PLANT HOARDER</h1>

		<nav>
			<ul>
				<li><a href="etusivu">ETUSIVU</a></li>
				<li><a href="lisaa-henkilo">LISÄÄ PROFIILI</a></li>
				<li><a href="lisaa-kasvi">LISÄÄ VIHERKASVI</a></li>
				<li class="aktiivinen">VIHERKASVINI</li>
			</ul>
		</nav>
	</header>
	<h2>&bull;Tässä kaikki viherkasvisi&bull;</h2>
	
		
				<c:forEach items="${kasvit}" var="kasvi">
				<table>
				
					<tr >
						<th  align="left" width=200>Nimi</th>
						<th  align="left" width=200>Kastelu</th>
						<th  align="left" width=200>Valo</th>
						
					</tr>
					
					<tr>
						<td align="left" width=200><c:out value="${kasvi.nimi}" /></td>
						<td align="left" width=200><c:out value="${kasvi.kastelu}" /></td>
						<td align="left" width=200><c:out value="${kasvi.valo}" /></td>
					</tr>
					
					<tr>
						<th align="left" width=200>Kuvaus</th>
					</tr>
					
					<tr>
						<td align="left" colspan="3" width=600><c:out
								value="${kasvi.kuvaus}" /></td>
						
					</tr>
					
					<tr>
						<td  align="left" class="alinSolu"></td>
						<td align="left" class="alinSolu"></td>
						<td align="left" class="alinSolu"></td>
						
					</tr>

					<tr>
						<td align="left" class="alinSolu"></td>
						<td align="left" id="poisto"><a href="poista-kasvi?id=<c:out value='${kasvi.id}' />">Poista</a></td>
						<td align="left" class="alinSolu"></td>

					</tr>
					</table>
					
				</c:forEach>

			
	
	




	



	<footer id="alaosa">
		<p id="tiedot">Plant Hoarder</p>
	</footer>


</body>

</html>