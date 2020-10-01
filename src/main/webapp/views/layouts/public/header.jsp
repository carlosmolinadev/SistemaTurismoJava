<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">

<head>
	<title>Sistema Turístico</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
	<style>#map { height: 500px; }</style>
</head>

<body>

	<div class="jumbotron text-center" style="margin-bottom:0">
		<h1>Sistema Turístico</h1>
		<p>Encuentra los mejores sitios turísticos</p>
	</div>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="<spring:url value='/' />">Sistema Turístico</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText"
			aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarText">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active">
					<a class="nav-link" href="<spring:url value='/' />">Inicio <span class="sr-only">(current)</span></a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="<spring:url value='/aboutUs' />">Acerca de</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="<spring:url value='/contactUs' />">Contáctanos</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="<spring:url value='/form' />">Formulario</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="<spring:url value='/public/events' />">Eventos</a>
				</li>
			</ul>
			<ul class="navbar-nav">
				<span class="nav-item">
					<a href="<spring:url value='/login' />" class="nav-link">Iniciar sesión</a>
				</span>
			</ul>
		</div>
    </nav>
    
    <!-- Container -->
	<div class="container" style="margin-top:30px">