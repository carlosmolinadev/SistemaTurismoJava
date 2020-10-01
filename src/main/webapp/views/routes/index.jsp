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
    <div class="col-3">
        <h1><i class="fas fa-map-marked-alt"></i> Rutas</h1>
    </div>
</header>

<!-- New button -->
<a href="<spring:url value='/routes/create' />" class="btn btn-primary mb-3">
	<i class="fas fa-globe-americas" ></i>&emsp; Agregar
</a>

<hr>
<div class="table-responsive">
	<table id="table" class="table table-light table-bordered table-striped table-hover">
		<!-- Table headers -->
		<thead class="bg-gray-900 text-white">
			<tr>
                <th>Codigo</th>
				<th>Ruta</th>
				<th>Duración de recorrido</th>
				<th>Descripcion</th>
				<th>Acciones</th>
			</tr>
		</thead>

		<!-- Table body -->
		<tbody>
			<c:forEach items="${ routes }" var="route">
				<tr>
					<!-- id route-->
					<td>
						<a href="<spring:url value='/routes/${ route.id }' />">
                        <b>${ route.id }</b>
						</a>

					<!-- route name -->
					<td>
						${route.name }
						
					</td>
                    <!--Duration route-->
					<td>${ route.duration }</td>
                    <!--Descriptions-->
                    <td>${route.description}</td>
					<!-- Actions -->
					<td>
						<a href="<spring:url value='/routes/${ route.id }' />" class="btn btn-secondary">
							<i class="fa fa-eye"></i>
						</a>
						<a href="<spring:url value='/routes/${ route.id }/edit' />" class="btn btn-warning">
							<i class="fa fa-edit"></i>
						</a>
						<button class="btn btn-danger" data-toggle="modal" data-target="#deleteModal" onclick="$( '#deleteId' ).attr( 'href', '/routes/${ route.id }/delete' )">
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
				Esta seguro?
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