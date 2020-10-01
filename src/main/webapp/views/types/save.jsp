<!-- Includes the header layout of the page -->
<%@ include file="../layouts/admin/header.jsp" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>


<!-- Headers section -->
<header>
	<h1><i class="fa fa-book-open"></i> Tipo de viaje</h1>
</header>

<!-- Form -->
<form method="post" action="<spring:url value='/types' />">
	<input type="hidden" name="id" value="${ type.id }" />

	<div class="form-row">
		<!-- Name -->
		<div class="form-group col-md-6">
			<label for="name">Nombre</label>
			<input class="form-control" id="name" placeholder="Nombre" name="name" value="${ type.name }" required />
		</div>
	</div>
	
	<div class="form-row">
		<!-- Description -->
		<div class="form-group col-md-6">
			<label for="name">Descripcion</label>
			<input class="form-control" id="description" placeholder="Description" name="description" value="${ type.description }" required />
		</div>
	</div>
	
	<a href="<spring:url value='/types' />" class="btn btn-secondary">Cancelar</a>

	<!-- Submit button -->
	<input type="submit" class="btn btn-primary" value="Guardar" />
</form>

<!-- Includes the footer layout of the page -->
<%@ include file="../layouts/admin/footer.jsp" %>