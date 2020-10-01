<!-- Includes the header layout of the page -->
<%@ include file="../layouts/public/header.jsp" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>

<!-- Outer Row -->
<div class="row justify-content-center">
	<div class="col-md-9">

		<!-- Messages section -->
		<c:if test="${ param.error != null }">
			<div class="alert alert-danger alert-dismissible fade show" role="alert">
				Usuario o contraseña incorrecto
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:if>

		<c:if test="${ param.logout != null }">
			<div class="alert alert-info alert-dismissible fade show" role="alert">
				Se ha cerrado su sesión
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:if>
		<!-- /Messages section -->

		<div class="card o-hidden border-0 shadow-lg my-5">
			<div class="card-body p-0">

				<!-- Nested Row within Card Body -->
				<div class="row">
					<div class="col-md-12">
						<div class="p-5">
							<h4 class="mb-4 text-center">¡Bienvenido nuevamente!</h4>

							<form action="<spring:url value='/login' />" method="post">
								<div class="form-group">
									<input class="form-control" id="username" name="username" placeholder="Usuario" tabindex="1" autofocus required />
								</div>

								<div class="form-group">
									<input type="password" class="form-control" id="password" name="password" placeholder="Contraseña" tabindex="2" required />
								</div>

								<div class="form-group">
									<div class="custom-control custom-checkbox small">
										<input type="checkbox" class="custom-control-input" id="remember" tabindex="3" />

										<label class="custom-control-label" for="remember">Recordar</label>
									</div>
								</div>

								<input type="submit" class="btn btn-primary btn-block" value="Iniciar sesión" tabindex="4" />
							</form>

							<hr />

							<div class="text-center">
								<a class="small" href="/">¿Olvidó su contraseña?</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- Includes the header layout of the page -->
<%@ include file="../layouts/public/footer.jsp" %>