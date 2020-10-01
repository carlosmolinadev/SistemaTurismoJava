<!-- Includes the header layout of the page -->
<%@ include file="../layouts/admin/header.jsp" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>

<!-- Headers section -->
<header>
	<h1><i class="fa fa-user"></i> Usuario</h1>
	<h2>Detalle</h2>
</header>

<div class="container">
	<div class="table-responsive">
		<table class="table table-bordered table-hover">
			<caption>Detalle usuario</caption>
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
					<td class="table-light">${ user.id }</td>
				</tr>

				<!-- Photo -->
				<tr>
					<td class="table-secondary">
						<b>Foto</b>
					</td>
					<td class="table-light">
						<img clas="img-fluid" style="max-width: 200px" src="${ user.photo }" alt="Foto" />
					</td>
				</tr>

				<!-- Name -->
				<tr>
					<td class="table-secondary">
						<b>Nombre</b>
					</td>
					<td class="table-light">${ user.firstName }</td>
				</tr>

				<!-- Last name -->
				<tr>
					<td class="table-secondary">
						<b>Apellido</b>
					</td>
					<td class="table-light">${ user.lastName }</td>
				</tr>

				<!-- Email -->
				<tr>
					<td class="table-secondary">
						<b>Correo electrónico</b>
					</td>
					<td class="table-light">
						<a href="mailto:${ user.email }">${ user.email }</a>
					</td>
				</tr>

				<!-- Birthdate -->
				<tr>
					<td class="table-secondary">
						<b>Birthdate</b>
					</td>
					<td class="table-light">${ user.birthdate }</td>
				</tr>

				<!-- Phone -->
				<tr>
					<td class="table-secondary">
						<b>Teléfono</b>
					</td>
					<td class="table-light">
						<a href="tel:${ user.phone }">${ user.phone }</a>
					</td>
				</tr>

				<!-- Status -->
				<tr>
					<td class="table-secondary">
						<b>Estado</b>
					</td>
					<td class="table-light">
						${ user.status ? 'Activo' : 'Inactivo' }
					</td>
				</tr>

				<!-- Created at -->
				<tr>
					<td class="table-secondary">
						<b>Creado</b>
					</td>
					<td class="table-light">
						${ user.createdAt }
					</td>
				</tr>

				<!-- Gender -->
				<tr>
					<td class="table-secondary">
						<b>Género</b>
					</td>
					<td class="table-light">
						${ user.gender }
					</td>
				</tr>

				<!-- Role -->
				<tr>
					<td class="table-secondary">
						<b>Rol</b>
					</td>
					<td class="table-light">
						${ user.role }
					</td>
				</tr>

				<!-- Place of birth -->
				<tr>
					<td class="table-secondary">
						<b>Lugar de nacimiento</b>
					</td>
					<td class="table-light">
						${ user.placeOfBirth.name }
					</td>
				</tr>

				<!-- Types -->
				<tr>
					<td class="table-secondary">
						<b>Preferencias</b>
					</td>
					<td class="table-light">
						<c:choose>
							<c:when test="${ user.types != null && !user.types.isEmpty() }">
								<c:forEach items="${ user.types }" var="type">
									${ type }<br />
								</c:forEach>
							</c:when>
							<c:otherwise>
								No hay datos
							</c:otherwise>
						</c:choose>
					</td>
				</tr>

				<!-- Travels -->
				<tr>
					<td class="table-secondary">
						<b>Viajes</b>
					</td>
					<td class="table-light">
						<c:choose>
							<c:when test="${ user.travels != null && !user.travels.isEmpty() }">
								<c:forEach items="${ user.travels }" var="travel">
									${ travel }<br />
								</c:forEach>
							</c:when>
							<c:otherwise>
								No hay datos
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</tbody>
		</table>

		<div class="text-center">
			<a href="<spring:url value='/users' />" class="btn btn-secondary">
				<i class="fa fa-chevron-left"></i> Regresar
			</a>
			<a href="<spring:url value='/users/${ user.id }/edit' />" class="btn btn-warning">
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
				<a href="<spring:url value='/users/${ user.id }/delete' />" class="btn btn-primary">Aceptar</a>
			</div>
		</div>
	</div>
</div>

<!-- Includes the footer layout of the page -->
<%@ include file="../layouts/admin/footer.jsp" %>