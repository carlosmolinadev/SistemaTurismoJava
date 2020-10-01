<!-- Includes the header layout of the page -->
<%@ include file="../layouts/admin/header.jsp" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>

<!-- Messages section -->
<c:if test="${ message != null }">
	<div class="alert alert-${ type } alert-dismissible fade show" role="alert">
		${ message }
		<button type="button" class="close" data-dismiss="alert" aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
	</div>
</c:if>

<!-- Headers section -->
<header>
	<h1><i class="fa fa-users"></i> Usuarios</h1>
	<h2>Listar</h2>
</header>

<hr />

<!-- New button -->
<a href="<spring:url value='/users/create' />" class="btn btn-primary mb-3">
	<i class="fa fa-plus"></i>&emsp;Nuevo
</a>

<!-- Table -->
<div class="table-responsive">
	<table id="table" class="table table-light table-bordered table-striped table-hover">
		<!-- Table headers -->
		<thead class="bg-gray-900 text-white">
			<tr>
				<th>Foto</th>
				<th>Nombre completo</th>
				<th>Lugar y fecha de nacimiento</th>
				<th>Role</th>
				<th>Acciones</th>
			</tr>
		</thead>

		<!-- Table body -->
		<tbody>
			<c:forEach items="${ users }" var="user">
				<tr>
					<!-- Photo -->
					<td class="text-center">
						<img class="img-thumbnail" style="max-width: 200px" src="${ user.photo }" alt="Foto" />
					</td>

					<!-- Full name -->
					<td>
						<a href="<spring:url value='/users/${ user.id }' />">
							<b>${ user.fullName }</b>
						</a>

						<br />

						<a href="mailto:${ user.email }">
							${ user.email }
						</a>
						
						<br />

						<a href="tel:${ user.phone }">
							${ user.phone }
						</a>
					</td>

					<!-- Date and place of birth -->
					<td>
						${ user.placeOfBirth.name }<br />
						${ user.birthdate }
					</td>

					<td>${ user.role }</td>
					
					<!-- Actions -->
					<td class="text-center">
						<a href="<spring:url value='/users/${ user.id }' />" class="btn btn-secondary">
							<i class="fa fa-eye"></i>
						</a>
						<a href="<spring:url value='/users/${ user.id }/edit' />" class="btn btn-warning">
							<i class="fa fa-edit"></i>
						</a>
						<button class="btn btn-danger" data-toggle="modal" data-target="#deleteModal" onclick="$( '#deleteId' ).attr( 'href', '/users/${ user.id }/delete' )">
							<i class="fa fa-trash"></i>
						</button>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<!-- End table -->

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
				<a id="deleteId" class="btn btn-primary">Aceptar</a>
			</div>
		</div>
	</div>
</div>

<!-- Includes the footer layout of the page -->
<%@ include file="../layouts/admin/footer.jsp" %>