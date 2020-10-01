<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="es">

<head>

	<meta charset="UTF-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
	<meta name="description" content="Project" />
	<meta name="author" content="UES" />

	<title>Sistema Turístico - ${ code }</title>

	<!-- Google font Nunito -->
	<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet" />

	<!-- SBAdmin 2 -->
	<link href="<spring:url value='/assets/css/sb-admin-2.min.css' />" rel="stylesheet" />

</head>

<body id="page-top">

	<!-- Page wrapper -->
	<div id="wrapper">

		<!-- Content wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main content -->
			<div id="content">

				<!-- Begin page content -->
				<div class="container-fluid">

					<!-- Error Text -->
					<div class="text-center">
						<div class="error mx-auto" data-text="${ code }">${ code }</div>
						<p class="lead text-gray-800 mb-5">${ message }</p>
						<p class="text-gray-500 mb-0">Parece que encontraste una falla en la matriz…</p>
						<a href="<spring:url value='/dashboard' />">&larr; Regresar</a>
					</div>

				</div>
				<!-- End page content -->

			</div>
			<!-- End of main content -->

			<!-- Footer -->
			<footer class="sticky-footer bg-white">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Todos los Derechos Reservados &copy; Sistema Turístico <%= java.time.LocalDate.now().getYear() %></span>
					</div>
				</div>
			</footer>
			<!-- End of footer -->

		</div>
		<!-- End of content wrapper -->

	</div>
	<!-- End of page wrapper -->

	<!-- FontAwesome -->
	<script src="https://kit.fontawesome.com/903d43eb4f.js" crossorigin="anonymous"></script>

	<!-- jQuery -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>

	<!-- Bootstrap script -->
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

	<!-- jQuery easing -->
	<script src="<spring:url value='/assets/js/jquery.easing.min.js' />"></script>

	<!-- SBAdmin script -->
	<script src="<spring:url value='/assets/js/sb-admin-2.min.js' />"></script>

</body>

</html>