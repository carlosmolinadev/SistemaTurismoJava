<!-- Includes the header layout of the page -->
<%@ include file="../layouts/admin/header.jsp" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>

<!-- Headers section -->
<header>
	<h1><i class="fa fa-user"></i> Lugar </h1>
	<h2>Detalle</h2>
</header>

<div class="container">
	<div class="table-responsive">
		<table class="table table-bordered table-hover">
			<caption>Detalles del lugar</caption>
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
					<td class="table-light">${ place.id }</td>
				</tr>

				<!-- Photo -->
				<tr>
					<td class="table-secondary">
						<b>Foto</b>
					</td>
					<td class="table-light">
						<img clas="img-fluid" style="max-width: 200px" src="${ place.photo }" alt="Foto" />
					</td>
				</tr>
				
				<!-- Location -->
				<tr>
					<td class="table-secondary">
						<b>Nombre del lugar</b>
					</td>
					<td class="table-light">${ place.name }</td>
				</tr>

				<!-- Route -->
				<tr>
					<td class="table-secondary">
						<b>Ruta</b>
					</td>
					<td class="table-light">${ place.route.name }</td>		
				</tr>
				
				<!-- Type -->
				<tr>
					<td class="table-secondary">
						<b>Tipo de lugar</b>
					</td>
					<td class="table-light">${ place.type.name }</td>		
				</tr>
				
				<!-- Created at -->
				<tr>
					<td class="table-secondary">
						<b>Creado</b>
					</td>
					<td class="table-light">
						${ place.createdAt }
					</td>
				</tr>		
			</tbody>
		</table>

<div class="text-center">
			<a href="<spring:url value='/places' />" class="btn btn-secondary">
				<i class="fa fa-chevron-left"></i> Regresar
			</a>
			<a href="<spring:url value='/places/${ place.id }/edit' />" class="btn btn-warning">
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
				<h5 class="modal-title" id="deleteModalTitle">Eliminaci�n</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
				<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				�Est� seguro?
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
				<a href="<spring:url value='/places/${ place.id }/delete' />" class="btn btn-primary">Aceptar</a>
			</div>
		</div>
	</div>
</div>

<!-- Includes the footer layout of the page -->
<%@ include file="../layouts/admin/footer.jsp" %>