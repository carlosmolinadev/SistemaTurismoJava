<!-- Includes the header layout of the page -->
<%@ include file="../layouts/admin/header.jsp" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>

<!-- Page Heading -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<header>
		<h1><i class="fa fa-tachometer-alt"></i> Tablero</h1>
		<h2>Sistema Turístico</h2>
	</header>
</div>

<!-- Content -->
<div class="row">

	<!-- Users card -->
	<div class="col-xl-3 col-md-6 mb-4">
		<a href="<spring:url value='/users' />" class="text-decoration-none">
			<div class="card border-left-primary shadow h-100 py-2">
				<div class="card-body">
					<div class="row no-gutters align-items-center">
						<div class="col mr-2">
							<div class="text-xs font-weight-bold text-primary mb-1">Administrador</div>
							<div class="h5 mb-0 font-weight-bold text-gray-800 text-uppercase">Usuarios</div>
						</div>
						<div class="col-auto">
							<i class="fas fa-users fa-2x text-gray-300"></i>
						</div>
					</div>
				</div>
			</div>
		</a>
	</div>

	<!-- Travels card -->
	<div class="col-xl-3 col-md-6 mb-4">
		<a href="<spring:url value='/travels' />" class="text-decoration-none">
			<div class="card border-left-success shadow h-100 py-2">
				<div class="card-body">
					<div class="row no-gutters align-items-center">
						<div class="col mr-2">
							<div class="text-xs font-weight-bold text-success mb-1">Usuario</div>
							<div class="h5 mb-0 font-weight-bold text-gray-800 text-uppercase">Viajes</div>
						</div>
						<div class="col-auto">
							<i class="fas fa-globe-americas fa-2x text-gray-300"></i>
						</div>
					</div>
				</div>
			</div>
		</a>
	</div>

	<!-- Types card -->
	<div class="col-xl-3 col-md-6 mb-4">
		<a href="<spring:url value='/types' />" class="text-decoration-none">
			<div class="card border-left-info shadow h-100 py-2">
				<div class="card-body">
					<div class="row no-gutters align-items-center">
						<div class="col mr-2">
							<div class="text-xs font-weight-bold text-info mb-1">Usuario</div>
							<div class="h5 mb-0 font-weight-bold text-gray-800 text-uppercase">Tipos de viajes</div>
						</div>
						<div class="col-auto">
							<i class="fas fa-book-open fa-2x text-gray-300"></i>
						</div>
					</div>
				</div>
			</div>
		</a>
	</div>

	<!-- Events card -->
	<div class="col-xl-3 col-md-6 mb-4">
		<a href="<spring:url value='/events' />" class="text-decoration-none">
			<div class="card border-left-warning shadow h-100 py-2">
				<div class="card-body">
					<div class="row no-gutters align-items-center">
						<div class="col mr-2">
							<div class="text-xs font-weight-bold text-warning mb-1">Usuario</div>
							<div class="h5 mb-0 font-weight-bold text-gray-800 text-uppercase">Eventos</div>
						</div>
						<div class="col-auto">
							<i class="fas fa-calendar-check fa-2x text-gray-300"></i>
						</div>
					</div>
				</div>
			</div>
		</a>
	</div>
</div>

<div class="row">

	<!-- Routes card -->
	<div class="col-xl-3 col-md-6 mb-4">
		<a href="<spring:url value='/routes' />" class="text-decoration-none">
			<div class="card border-left-danger shadow h-100 py-2">
				<div class="card-body">
					<div class="row no-gutters align-items-center">
						<div class="col mr-2">
							<div class="text-xs font-weight-bold text-danger mb-1">Usuario</div>
							<div class="h5 mb-0 font-weight-bold text-gray-800 text-uppercase">Rutas</div>
						</div>
						<div class="col-auto">
							<i class="fas fa-map-marked-alt fa-2x text-gray-300"></i>
						</div>
					</div>
				</div>
			</div>
		</a>
	</div>
	
	<!-- Places card -->
	<div class="col-xl-3 col-md-6 mb-4">
		<a href="<spring:url value='places' />" class="text-decoration-none">
			<div class="card border-left-secondary shadow h-100 py-2">
				<div class="card-body">
					<div class="row no-gutters align-items-center">
						<div class="col mr-2">
							<div class="text-xs font-weight-bold text-secondary mb-1">Usuario</div>
							<div class="h5 mb-0 font-weight-bold text-gray-800 text-uppercase">Lugares</div>
						</div>
						<div class="col-auto">
							<i class="fas fa-map-pin fa-2x text-gray-300"></i>
						</div>
					</div>
				</div>
			</div>
		</a>
	</div>

	<!-- Locations card -->
	<div class="col-xl-3 col-md-6 mb-4">
		<a href="<spring:url value='/locations' />" class="text-decoration-none">
			<div class="card border-left-light shadow h-100 py-2">
				<div class="card-body">
					<div class="row no-gutters align-items-center">
						<div class="col mr-2">
							<div class="text-xs font-weight-bold text-light mb-1">Usuario</div>
							<div class="h5 mb-0 font-weight-bold text-gray-800 text-uppercase">Ubicaciones</div>
						</div>
						<div class="col-auto">
							<i class="fas fa-map-marker-alt fa-2x text-gray-300"></i>
						</div>
					</div>
				</div>
			</div>
		</a>
	</div>
</div>
<!-- /Content -->

<!-- Includes the header layout of the page -->
<%@ include file="../layouts/admin/footer.jsp" %>