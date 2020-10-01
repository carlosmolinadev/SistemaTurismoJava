<!-- Includes the header layout of the page -->
<%@ include file="../../layouts/public/header.jsp" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>

<header class="my-3">
	<h2>Formulario</h2>
</header>

<form action="<spring:url value='/form' />" method="post">
	<div class="card mb-5">
		<div class="card-header">
			<nav>
				<div class="nav nav-tabs card-header-tabs" id="nav-tab" role="tablist">
					<a class="nav-item nav-link active" id="nav-personal-tab" data-toggle="tab" href="#nav-personal" role="tab" aria-controls="nav-personal" aria-selected="true">
						Personal
					</a>
					<a class="nav-item nav-link" id="nav-contact-tab" data-toggle="tab" href="#nav-contact" role="tab" aria-controls="nav-contact" aria-selected="false">
						Contacto
					</a>
					<a class="nav-item nav-link" id="nav-interests-tab" data-toggle="tab" href="#nav-interests" role="tab" aria-controls="nav-interests" aria-selected="false">
						Intereses
					</a>
				</div>
			</nav>
		</div>

		<div class="card-body">
			<div class="tab-content" id="nav-tabContent">
				<!-- Personal -->
				<div class="tab-pane fade show active" id="nav-personal" role="tabpanel" aria-labelledby="nav-personal-tab">
					<div class="my-3">
						<h3>Información Personal</h3>
					</div>
		
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
					<div class="form-group col-md-6">
						<label for="gender">Género</label>
						<select id="gender" class="custom-select" name="gender">
							<c:forEach items="${ genders }" var="gender">
								<option ${ gender == user.gender ? 'selected' : '' }>${ gender }</option>
							</c:forEach>
						</select>
					</div>
		
					<input type="button" class="btn btn-secondary" value="Siguiente" onclick="$( '#nav-personal-tab' ).removeClass( 'active' ); $( '#nav-personal' ).removeClass( 'show active' ); $( '#nav-contact-tab' ).addClass( 'active' ); $( '#nav-contact' ).tab( 'show' )" />
				</div>
		
				<!-- Contact -->
				<div class="tab-pane fade" id="nav-contact" role="tabpanel" aria-labelledby="nav-contact-tab">
					<div class="my-3">
						<h3>Información de Contacto</h3>
					</div>
		
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
		
					<!-- Phone -->
					<div class="form-group col-md-6">
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
		
					<input type="button" class="btn btn-secondary" value="Siguiente" onclick="$( '#nav-contact-tab' ).removeClass( 'active' ); $( '#nav-contact' ).removeClass( 'show active' ); $( '#nav-interests-tab' ).addClass( 'active' ); $( '#nav-interests' ).tab( 'show' )" />
				</div>
		
				<!-- Interests -->
				<div class="tab-pane fade" id="nav-interests" role="tabpanel" aria-labelledby="nav-interests-tab">
					<div class="my-3">
						<h3>Intereses</h3>
					</div>
		
					<!-- Budget -->
					<div class="form-group col-md-6">
						<label for="budget">Presupuesto</label>
						<div class="input-group mb-2">
							<div class="input-group-prepend">
								<div class="input-group-text">
									<i class="fa fa-dollar-sign"></i>
								</div>
							</div>
							<input type="number" min="0" step=".01" class="form-control" id="budget" name="budget" placeholder="0.00" value="${ form.budget }" title="Presupuesto" required />
						</div>
					</div>
		
					<!-- Duration -->
					<div class="form-group col-md-6">
						<label for="duration">Duración máxima en días</label>
						<input type="number" class="form-control" min="1" max="30" id="duration" name="duration" value="${ form.duration }" list="duration-marks" title="Duración máxima en días" required />
		
						<datalist id="duration-marks">
							<option value="1" label="1 día" />
							<option value="3" label="3 días" />
							<option value="7" label="1 semana" />
							<option value="10" label="10 días" />
							<option value="12" label="12 días" />
							<option value="15" label="2 semanas" />
							<option value="18" label="18 días" />
							<option value="21" label="3 semanas" />
							<option value="24" label="4 días" />
							<option value="27" label="27 días" />
							<option value="30" label="1 mes" />
						</datalist>
					</div>
		
					<!-- Persons -->
					<div class="form-group col-md-6">
						<label for="persons">Personas</label>
						<input type="number" class="form-control" min="1" max="10" id="persons" name="persons" value="${ form.persons }" title="Cantidad de personas" required />
					</div>

					<!-- Attributes -->
					<div class="form-group col-md-6">
						<label for="attributes">Atributos</label>
						<input class="form-control" id="attributes" name="attributes" value="${ form.persons }" title="Atributos" />
					</div>

					<!-- Interests -->
					<div class="form-group col-md-6">
						<label for="interests">Intereses</label>
						<input class="form-control" id="interests" name="interests" value="${ form.interests }" title="Intereses" />
					</div>

					<!-- Comments -->
					<div class="form-group col-md-6">
						<label for="interests">Comentarios</label>
						<textarea class="form-control" id="comments" name="comments" title="Comentarios">${ form.comments }</textarea>
					</div>

					<!-- Types -->
					<div class="form-group col-md-6">
						<label for="types">Tipo de viaje</label>
						<form:select items="${ types }" multiple="true" path="user.types" class="custom-select" itemValue="id" itemLabel="name" />
						<small id="typesHelp" class="form-text text-muted">Puedes escoger más de uno</small>
					</div>
		
					<input class="btn btn-primary" type="submit" value="Enviar" />
				</div>
			</div>
		</div>
	</div>
</form>

<!-- Includes the header layout of the page -->
<%@ include file="../../layouts/public/footer.jsp" %>