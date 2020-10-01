<!-- Includes the header layout of the page -->
<%@ include file="../../layouts/public/header.jsp" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>

<header class="my-3">
	<h2>Formulario</h2>
	<h3>Resultados</h3>
</header>

<!-- Messages section -->
<c:if test="${ message != null }">
	<div class="alert alert-${ type } alert-dismissible fade show" role="alert">
		${ message }
		<button type="button" class="close" data-dismiss="alert" aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
	</div>
</c:if>

<h4>Rutas sugeridas</h4>

<c:choose>
	<c:when test="${ routes != null and !routes.isEmpty() }">
		<c:forEach items="${ routes }" var="route">
			<div class="card text-center my-5">
				<div class="card-header">
					Recomendado
				</div>
				<div class="card-body">
					<h5 class="card-title">${ route.name }</h5>
					<p class="card-text">${ route.description }</p>
					<p class="card-text">Costo por persona: $${ route.importe }</p>
					<p class="card-text">Cantidad de días: ${ route.duration }</p>
					<a href="<spring:url value='/public/routes/${ route.id }' />" class="btn btn-primary">Detalles</a>
				</div>
				<div class="card-footer text-muted">
					Total importe: $${ form.persons * route.importe }
				</div>
			</div>
		</c:forEach>
	</c:when>
	<c:otherwise>
		<p>Lo sentimos, no tenemos rutas sugeridas para ti, pero puedes ver <a href="<spring:url value='/public/events' />">eventos</a></p>
	</c:otherwise>
</c:choose>

<!-- Includes the header layout of the page -->
<%@ include file="../../layouts/public/footer.jsp" %>