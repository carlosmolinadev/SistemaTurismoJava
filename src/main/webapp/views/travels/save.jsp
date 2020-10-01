<!-- Includes the header layout of the page -->
<%@ include file="../layouts/admin/header.jsp" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>

<c:set var="isNew" value="${ travel.id == null && travel.status == null }" />

<!-- Headers section -->
<header>
	<h1><i class="fas fa-plane"></i> Viajes </h1>
	<h2>${ isNew ? 'Nuevo' : 'Edición' }</h2>
</header>



<!-- Form -->
<form method="post" action="<spring:url value='/travels' />">
	<input type="hidden" name="id" value="${ travel.id }" />
	<input type="hidden" name="createdAt" value="${ travel.createdAt }" />

	<div class="form-row">
		<!-- Id User -->
		<div class="form-group col-md-6">
	    <label for="Viaje segun usuario">Viaje por usuario</label>
		    <select class="custom-select" id="user" name="user.id">
					<c:forEach items="${ users }" var="user">
						<option ${ user.id == travel.user.id ? 'selected' : ''} value="${ user.id }"> ${ user.firstName }, ${ user.lastName }</option>
					</c:forEach>
				</select>
		</div>
	
		<!-- Id Route -->
		<div class="form-group col-md-6">
	    <label for="Viaje por ruta">Viaje segun la ruta</label>
		    	<select class="custom-select" id="route" name="route.id">
					<c:forEach items="${ routes }" var="route">
						<option ${ route.id == travel.route.id ? 'selected' : ''} value="${ route.id }">${ route.name } - importe total: $${ route.importe }</option>
					</c:forEach>
				</select>
			</div>
	  	</div>
		
	<div class="form-row"> 
		<!-- Start Date -->
		<div class="form-group col-md-6">
			<label for="travelStart">Fecha de inicio</label>
			<div class="input-group mb-2">
				<div class="input-group-prepend">
				  <div class="input-group-text">
					  <i class="fa fa-calendar-day"></i>
				  </div>
				</div>
				<input pattern="([12]\d{3}\/(0[1-9]|1[0-2])\/(0[1-9]|[12]\d|3[01]))" class="form-control" id="startDate" name="startDate" placeholder="aaaa/mm/dd" value="${ formatter.format(travel.startDate) }" required title="aaaa/mm/dd" />
			</div>
		</div>

		<!-- End Date -->
		<div class="form-group col-md-6">
			<label for="travelEnd">Fecha de finalización</label>
			<div class="input-group mb-2">
				<div class="input-group-prepend">
				  <div class="input-group-text">
					  <i class="fa fa-calendar-day"></i>
				  </div>
				</div>
				<input pattern="([12]\d{3}\/(0[1-9]|1[0-2])\/(0[1-9]|[12]\d|3[01]))" class="form-control" id="endDate" name="endDate" placeholder="aaaa/mm/dd" value="${ formatter.format(travel.endDate) }" required title="aaaa/mm/dd" />
			</div>
		</div>
	</div>
	
	<div class="form-row">
		<!-- Rating -->
		<div class="form-group col-xs-2">
    	<label for="rating"> Calificación del viaje</label>
		    <select class="form-control" id="rate" name="rate">
		      <option value='1' ${travel.rate }> 1 </option>
		      <option value='2' ${travel.rate }> 2 </option>
		      <option value='3' ${travel.rate }> 3 </option>
		      <option value='4' ${travel.rate }> 4 </option>
		      <option value='5' ${travel.rate }> 5 </option>
		    </select>
	  </div>
	  </div>
	  

		
	<!-- Cancel button -->
	<a href="<spring:url value='/travels' />" class="btn btn-secondary">Cancelar</a>
	
	<!-- Submit button -->
	<input type="submit" class="btn btn-primary" value="Guardar" />
</form>

<!-- Includes the footer layout of the page -->
<%@ include file="../layouts/admin/footer.jsp" %>



