<!-- Includes the header layout of the page -->
<%@ include file="../layouts/admin/header.jsp" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>

<c:set var="isNew" value="${ user.id == null && user.status == null }" />

<!-- Headers section -->
<header>
	<h1><i class="fa fa-user"></i> Usuario</h1>
	<h2>${ isNew ? 'Nuevo' : 'Edición' }</h2>
</header>

<hr />

<!-- Form -->
<form method="post" action="<spring:url value='/users' />" enctype="multipart/form-data">
	<input type="hidden" name="id" value="${ user.id }" />
	<input type="hidden" name="createdAt" value="${ user.createdAt }" />

	<div class="form-row">
		<!-- Name -->
		<div class="form-group col-md-6">
			<label for="name">Nombres</label>
			<input class="form-control" id="name" placeholder="Nombres" name="firstName" value="${ user.firstName }" required />
		</div>

		<!-- Last name -->
		<div class="form-group col-md-6">
			<label for="lastName">Apellidos</label>
			<input class="form-control" id="lastName" placeholder="Apellidos" name="lastName" value="${ user.lastName }" required />
		</div>
	</div>

	<div class="form-row">
		<!-- Email -->
		<div class="form-group col-md-6">
			<label for="email">Correo electrónico</label>
			<div class="input-group mb-2">
				<div class="input-group-prepend">
				  <div class="input-group-text">
					  <i class="fa fa-at"></i>
				  </div>
				</div>
				<input type="email" class="form-control" id="email" placeholder="Correo electrónico" name="email" value="${ user.email }" required />
			</div>
		</div>

		<!-- Birthdate -->
		<div class="form-group col-md-6">
			<label for="birthdate">Fecha de nacimiento</label>
			<div class="input-group mb-2">
				<div class="input-group-prepend">
				  <div class="input-group-text">
					  <i class="fa fa-calendar-day"></i>
				  </div>
				</div>
				<input pattern="([12]\d{3}\/(0[1-9]|1[0-2])\/(0[1-9]|[12]\d|3[01]))" class="form-control" id="birthdate" name="birthdate" placeholder="aaaa/mm/dd" value="${ user.birthdate }" required title="aaaa/mm/dd" />
			</div>
		</div>
	</div>

	<div class="form-row">
		<!-- Place of birth -->
		<div class="form-group col-md-6">
			<label for="placeOfBirth">Lugar de nacimiento</label>
			<div class="input-group mb-2">
				<div class="input-group-prepend">
					<div class="input-group-text">
						<i class="fa fa-map-marker-alt"></i>
					</div>
				</div>
				<select class="custom-select" id="placeOfBirth" name="placeOfBirth.id">
					<c:forEach items="${ locations }" var="location">
						<option ${ location.id == user.placeOfBirth.id ? 'selected' : '' } value="${ location.id }">${ location.name } - ${ location.region.name }</option>
					</c:forEach>
				</select>
			</div>
		</div>
		
		<!-- Gender -->
		<div class="form-group col-md-3">
			<label for="gender">Género</label>
			<select id="gender" class="custom-select" name="gender">
				<c:forEach items="${ genders }" var="gender">
					<option ${ gender == user.gender ? 'selected' : '' }>${ gender }</option>
				</c:forEach>
			</select>
		</div>

		<!-- Phone -->
		<div class="form-group col-md-3">
			<label for="phone">Teléfono</label>
			<div class="input-group mb-2">
				<div class="input-group-prepend">
				  <div class="input-group-text">
					  <i class="fa fa-phone"></i>
				  </div>
				</div>
				<input class="form-control" id="phone" name="phone" placeholder="Teléfono" value="${ user.phone }" />
			</div>
		</div>
	</div>

	<div class="form-row">
		<!-- Role -->
		<div class="form-group col-md-4">
			<label for="role">Rol</label>
			<select id="role" class="custom-select" name="role">
				<c:forEach items="${ roles }" var="role">
					<option ${ role == user.role ? 'selected' : '' }>${ role }</option>
				</c:forEach>
			</select>
		</div>

		<div class="form-group col-md-4">
			<label for="profile">Foto</label>
			<div class="custom-file">
				<input type="file" class="custom-file-input" id="profile" name="profile" />
				<label class="custom-file-label" for="profile">Escoge una foto</label>
			</div>
		</div>

		<!-- Password -->
		<div class="form-group col-md-4" id="form-group-password" ${ isNew ? "" : "style='display:none'" }>
			<label for="password">Contraseña</label>
			<div class="input-group mb-2">
				<div class="input-group-prepend">
					<div class="input-group-text">
						<i class="fa fa-lock"></i>
					</div>
				</div>
				<input type="password" class="form-control" id="password" name="password" placeholder="Contraseña" value="${ user.password }" ${ isNew ? 'required' : '' } />
			</div>
		</div>
	</div>

	<c:if test="${ !isNew }">
		<div class="form-group">
			<div class="custom-control custom-checkbox">
				<input class="custom-control-input" type="checkbox" id="change" onchange="$( '#form-group-password' ).attr( 'style', this.checked ? 'display:block' : 'display:none' ); $( '#password' ).focus()" />
				<label class="custom-control-label" for="change">
					¿Cambiar contraseña?
				</label>
			</div>
		</div>
	</c:if>

	<a href="<spring:url value='/users' />" class="btn btn-secondary">Cancelar</a>

	<!-- Submit button -->
	<input type="submit" class="btn btn-primary" value="Guardar" />
</form>

<!-- Includes the footer layout of the page -->
<%@ include file="../layouts/admin/footer.jsp" %>

<script>
	$( document ).ready(
		$( '#password' ).val( '' )
	);
</script>