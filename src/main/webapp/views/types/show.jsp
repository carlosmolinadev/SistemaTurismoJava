<!-- Includes the header layout of the page -->
<%@ include file="../layouts/admin/header.jsp" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>

<!-- Headers section -->
<header>
	<h1><i class="fa fa-user"></i> Tipo de viaje</h1>
	<h2>Detalle</h2>
</header>

<hr />

<div class="container">
	<div class="table-responsive">
		<table class="table table-bordered table-hover">
			<caption>Informacion sobre tipos de viaje</caption>
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
					<td class="table-light">${ type.id }</td>
				</tr>

				<!-- Name -->
				<tr>
					<td class="table-secondary">
						<b>Nombre</b>
					</td>
					<td class="table-light">${ type.name }</td>
				</tr>

				<!-- Description -->
				<tr>
					<td class="table-secondary">
						<b>Descripcion</b>
					</td>
					<td class="table-light">${ type.description }</td>
				</tr>
				
				

				<!-- Created at -->
				<tr>
					<td class="table-secondary">
						<b>Creado</b>
					</td>
					<td class="table-light">
						${ type.createdAt }
					</td>
				</tr>
			
			</tbody>
		</table>

		<div class="text-center">
			<a href="<spring:url value='/types' />" class="btn btn-secondary">
				<i class="fa fa-chevron-left"></i> Regresar
			</a>
			<a href="<spring:url value='/types/${ type.id }/edit' />" class="btn btn-warning">
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
				<a href="<spring:url value='/types/${ type.id }/delete' />" class="btn btn-primary">Aceptar</a>
			</div>
		</div>
	</div>
</div>

<!-- Includes the footer layout of the page -->
<%@ include file="../layouts/admin/footer.jsp" %>