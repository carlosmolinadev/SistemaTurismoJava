<!-- Includes the header layout of the page -->
<%@ include file="../layouts/admin/header.jsp" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<c:set var="isNew" value="${ route.id == null && route.status == null }" />

<!-- Headers section -->
<header>
	<div class="col-6">
		<h1><i class="fas fa-map-marked-alt"></i> Nuevas Rutas</h1>
	</div>
</header>

<hr />

<form method="post" action="<spring:url value='/routes' />">
	<input type="hidden" name="id" value="${ route.id }" />

	<div class="form-row">
		<!-- Name -->
		<div class="form-group col-md-6">
			<label for="name">Nombre de ruta</label>
			<input class="form-control" id="name" placeholder="Nueva ruta" name="name" value="${ route.name }"
				required />
		</div>

		<!-- Type -->
		<div class="form-group col-md-6">
			<label for="Guia a asignar">Categoria de ruta</label>
			<select class="custom-select" id="type" name="type.id">
				<c:forEach items="${ types }" var="type">
					<option ${ user.id==route.type.id ? 'selected' : '' } value="${ type.id }"> ${ type.name }</option>
				</c:forEach>
			</select>
		</div>
	</div>

	<div class="form-row">
		<!-- Description -->
		<div class="form-group col-md-12">
			<label for="description">Descripción</label>
			<input class="form-control" id="description" placeholder="Breve descripción" name="description" value="${ route.description }" required />
		</div>
	</div>

	<div class="form-row">
		<!-- Duration -->
		<div class="form-group col-md-6">
			<label for="duration">Duración en días</label>
			<div class="input-group mb-2">
				<div class="input-group-prepend">
					<div class="input-group-text">
						<i class="fas fa-hourglass-start"></i>
					</div>
				</div>
				<input type="number" min=".25" step=".25" class="form-control" id="duration" placeholder="Duracion aproximada en días" name="duration" value="${ route.duration }" required title="Duración en días" />
			</div>
		</div>

		<!-- Importe -->
		<div class="form-group col-md-6">
			<label for="importe">Costo por persona</label>
			<div class="input-group mb-2">
				<div class="input-group-prepend">
					<div class="input-group-text">
						<i class="fas fa-funnel-dollar"></i>
					</div>
				</div>
				<input type="number" min="0" step=".01" class="form-control" id="importe" name="importe" value="${ route.importe }" required title="Costo por persona" placeholder="Costo por persona" />
			</div>
		</div>
	</div>

	<div class="form-row">
		<!-- Guide -->
		<div class="form-group col-md-6">
			<label for="Guia a asignar">Guia a asignar</label>
			<select class="custom-select" id="guide" name="guide">
				<c:forEach items="${ users }" var="user">
					<option ${ user.id==travel.user.id ? 'selected' : '' } value="${ user.id }"> ${ user.firstName }, ${
						user.lastName }</option>
				</c:forEach>
			</select>
		</div>

	</div>

	<a href="<spring:url value='/routes' />" class="btn btn-secondary">Cancelar</a>

	<!-- Submit button -->
	<input type="submit" class="btn btn-primary" value="Guardar" />
</form>

<%@ include file="../layouts/admin/footer.jsp" %>