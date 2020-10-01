<!-- Includes the header layout of the page -->
<%@ include file="../layouts/admin/header.jsp" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>

<c:set var="isNew" value="${ event.id == null && event.status == null }" />

<!-- Headers section -->
<header>
	<h1><i class="far fa-calendar-check"></i> Eventos </h1>
	<h2>${ isNew ? 'Nuevo' : 'Edición' }</h2>
</header>

<!-- Form -->
<form method="post" action="<spring:url value='/events' />">
	<input type="hidden" name="id" value="${ event.id }" />
	<input type="hidden" name="createdAt" value="${ event.createdAt }" />
	<input type="hidden" name="createdAt" value="${ event.updatedAt }" />

	<div class="form-row">
		<!-- Id User -->
		<div class="form-group col-md-6">
			<label for="Viaje segun usuario">Lugar del evento</label>
			<select class="custom-select" id="place" name="place.id">
				<c:forEach items="${ places }" var="place">
					<option ${ place.id == event.place.id ? 'selected' : '' } value="${ place.id }">${ place.name }</option>
				</c:forEach>
			</select>
		</div>
	
		<!-- Event name -->
		<div class="form-group col-md-6">
			<label for="name">Nombre del evento</label>
			<input class="form-control" id="name" placeholder="Nombre" name="name" value="${ event.name }" required />
		</div>
	</div>

	<div class="form-row">
		<!-- Event description -->
		<div class="form-group col-md-12">
			<label for="description">Descripción del evento</label>
			<textarea class="form-control" rows="10" id="description" placeholder="Descripcion" name="description" required>${ event.description }</textarea>
		</div>
	</div>

	<div class="form-row">
		<!-- Start Date -->
		<div class="form-group col-md-6">
			<label for="eventDay">Dia del evento</label>
			<div class="input-group mb-2">
				<div class="input-group-prepend">
					<div class="input-group-text">
						<i class="fa fa-calendar-day"></i>
					</div>
				</div>
				<input pattern="([12]\d{3}\/(0[1-9]|1[0-2])\/(0[1-9]|[12]\d|3[01]))" class="form-control" id="startDate" name="startDate" placeholder="aaaa/mm/dd" value="${ formatter.format(event.startDate) }" required title="aaaa/mm/dd" />
			</div>
		</div>

		<!-- End Date -->
		<div class="form-group col-md-6">
			<label for="eventEnd">Fin del evento</label>
			<div class="input-group mb-2">
				<div class="input-group-prepend">
					<div class="input-group-text">
						<i class="fa fa-calendar-day"></i>
					</div>
				</div>
				<input pattern="([12]\d{3}\/(0[1-9]|1[0-2])\/(0[1-9]|[12]\d|3[01]))" class="form-control" id="endDate" name="endDate" placeholder="aaaa/mm/dd" value="${ formatter.format(event.endDate) }" required title="aaaa/mm/dd" />
			</div>
		</div>
	</div>

	<!-- Cancel button -->
	<a href="<spring:url value='/events' />" class="btn btn-secondary">Cancelar</a>

	<!-- Submit button -->
	<input type="submit" class="btn btn-primary" value="Guardar" />
</form>

<!-- Includes the footer layout of the page -->
<%@ include file="../layouts/admin/footer.jsp" %>