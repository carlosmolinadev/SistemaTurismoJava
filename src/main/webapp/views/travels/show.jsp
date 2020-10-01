<!-- Includes the header layout of the page -->
<%@ include file="../layouts/admin/header.jsp" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>

<!-- Headers section -->
<header>
	<h1><i class="fas fa-plane"></i> Viajes </h1>
	<h2>Detalle</h2>
</header>

<div class="container">
	<div class="table-responsive">
		<table class="table table-bordered table-hover">
			<caption>Detalle del viaje</caption>
			<thead class="thead-dark">
				<tr>
					<th>Propiedad</th>
					<th>Valor</th>
				</tr>
			</thead>
			<tbody>
				
				<!-- ID -->
				<tr>
					<td class="table-secondary">
						<b>ID</b>
					</td>
					<td class="table-light">${ travel.id }</td>
				</tr>
				
				<c:forEach items="${ routes }" var="route">
				<c:if test="${ route.id == travel.route.id}">
				<!-- Trip location -->
				<tr>
					<td class="table-secondary">
						<b>Lugar visitado</b>
					</td>
					<td class="table-light">${ route.name }</td>		
				</tr>
				</c:if>
				</c:forEach>
				
				<!-- Rate -->
				<tr>
					<td class="table-secondary">
						<b>Calificacion del viaje</b>
					</td>
					<td class="table-light">${ travel.rate }</td>
				</tr>

				<!-- Date travel started -->
				<tr>
					<td class="table-secondary">
						<b>Fecha inicial del viaje</b>
					</td>
					<td class="table-light">${ formatter.format( travel.startDate ) }</td>
				</tr>


				<!-- Date travel finished -->
				<tr>
					<td class="table-secondary">
						<b>Fecha finalizacion del viaje</b>
					</td>
					<td class="table-light">
						${ formatter.format( travel.endDate ) }
					</td>
				</tr>
				
			</tbody>
		</table>
		
<div class="text-center">
			<a href="<spring:url value='/travels' />" class="btn btn-secondary">
				<i class="fa fa-chevron-left"></i> Regresar
			</a>
			<a href="<spring:url value='/travels/${ travel.id }/edit' />" class="btn btn-warning">
				<i class="fa fa-edit"></i> Editar
			</a>
			<button class="btn btn-danger" data-toggle="modal" data-target="#deleteModal">
				<i class="fa fa-trash"></i> Eliminar
			</button>
		</div>
	</div>
</div>
	
<!-- Delete Modal -->
<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="deleteModalTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="deleteModalTitle">Eliminación</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
				<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				¿Está seguro?
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
				<a href="<spring:url value='/travels/${ travel.id }/delete' />" class="btn btn-primary">Aceptar</a>
			</div>
		</div>
	</div>
</div>

<!-- Includes the footer layout of the page -->
<%@ include file="../layouts/admin/footer.jsp" %>