<!-- Includes the header layout of the page -->
<%@ include file="../layouts/public/header.jsp" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>

<header class="my-3">
	<h2>Contáctanos</h2>
	<h3>Formulario de contacto</h3>
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

<form action="<spring:url value='/contactUs' />" method="post">
	<div class="form-group">
		<label for="email">Correo electrónico</label>
		<input class="form-control" type="email" name="email" id="email" placeholder="Correo electrónico" required />
	</div>

	<div class="form-group">
		<label for="email">Nombre</label>
		<input class="form-control" name="name" id="name" placeholder="Nombre" />
	</div>
	
	<div class="form-group">
		<label for="message">Mensaje</label>
		<textarea class="form-control" name="message" id="message" rows="10" placeholder="Mensaje" required></textarea>
	</div>

	<input class="btn btn-secondary" type="submit" value="Enviar" />
</form>

<!-- Includes the header layout of the page -->
<%@ include file="../layouts/public/footer.jsp" %>