<%@ page language="java" contentType="text/html; charset=windows-1256"
pageEncoding="windows-1256"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Modifier un Produit</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
</head>
<body>
<br />
<h1 class="text-center fw-bold">Modifier Produit</h1>
<br />
<div class="container">
<form action="updateProduit" method="post">
<pre>
<div class="fw-bold">id :</div><input class="form-control" type="text" name="idProduit" value="${produit.idProduit}">
<div class="fw-bold">nom :</div><input class="form-control" type="text" name="nomProduit" value="${produit.nomProduit}">
<div class="fw-bold">prix :</div><input class="form-control" type="text" name="prixProduit" value="${produit.prixProduit}">
<div class="fw-bold">Date création :</div><fmt:formatDate pattern="yyyy-MM-dd" value="${produit.dateCreation}" var="formatDate"
/><input class="form-control" type="date" name="date" value="${formatDate}"></input>
<input type="submit" value="Modifier">
</pre>
</form>
<br/>
<br/>
<a href="ListeProduits">Liste Produits <i class="bi bi-bag"></i></a>
</div>
</body>
</html> 
