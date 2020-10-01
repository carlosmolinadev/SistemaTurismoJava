<!-- Includes the header layout of the page -->
<%@ include file="../layouts/admin/header.jsp" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>

<c:set var="isNew" value="${ place.id == null && place.status == null }" />

<!-- Headers section -->
<header>
	<h1><i class="fa fa-map-pin"></i> Lugar</h1>
	<h2>${ isNew ? 'Nuevo' : 'Edición' }</h2>
</header>

<!-- Form -->
<form method="post" action="<spring:url value='/places' />" enctype="multipart/form-data">
	<input type="hidden" name="id" value="${ place.id }" />
	<input type="hidden" name="createdAt" value="${ place.createdAt }" />
	
	<div class="form-row">
		<!-- Id Location -->
		<div class="form-group col-md-6">
	    	<label for="Viaje segun usuario">Ubicacion del lugar</label>
		    <select class="custom-select" id="location" name="location.id">
				<c:forEach items="${ locations }" var="location">
					<option ${ location.id == place.location.id ? 'selected' : ''} value="${ location.id }"> ${ location.name }</option>
				</c:forEach>
			</select>
		</div>
	
		<!-- Id Route -->
		<div class="form-group col-md-6">
	    	<label for="Viaje por ruta">Ruta del lugar</label>
			<select class="custom-select" id="route" name="route.id">
				<c:forEach items="${ routes }" var="route">
					<option ${ route.id == place.route.id ? 'selected' : ''} value="${ route.id }">${ route.name }</option>
				</c:forEach>
			</select>
		</div>
	</div>

	<div class="form-row">
		<!-- Id Type -->
		<div class="form-group col-md-6">
	    	<label for="Viaje por ruta">Tipo de viaje</label>
			<select class="custom-select" id="type" name="type.id">
				<c:forEach items="${ types }" var="type">
					<option ${ type.id == place.type.id ? 'selected' : ''} value="${ type.id }">${ type.name }</option>
				</c:forEach>
			</select>
		</div>

		<!-- Name -->
		<div class="form-group col-md-6">
			<label for="name">Nombre</label>
			<input class="form-control" id="name" placeholder="Nombre" name="name" value="${ place.name }" required />
		</div>
	</div>

	<div class="form-row">
		<div class="form-group col-md-7">
			<label for="image">Imagen</label>
			<div class="custom-file">
				<input type="file" class="custom-file-input" id="image" name="image" />
				<label for="image" class="custom-file-label">Escoge una imagen</label>
			</div>
		</div>
	</div>

	<a href="<spring:url value='/places' />" class="btn btn-secondary">Cancelar</a> <!-- Cancel button -->

	<input type="submit" class="btn btn-primary" value="Guardar" /> <!-- Submit button -->
</form>

<!-- Includes the footer layout of the page -->
<%@ include file="../layouts/admin/footer.jsp" %>