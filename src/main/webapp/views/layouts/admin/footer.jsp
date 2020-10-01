					<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
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

	<!-- Scroll to top button -->
	<a class="scroll-to-top rounded" href="#page-top">
		<i class="fas fa-angle-up"></i>
	</a>

	<!-- Logout modal -->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">¿Desea salir?</h5>
					<button class="close" type="button" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">
					Seleccione "Cerrar sesión" abajo si está listo para terminar su sesión actual
				</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>
					<a class="btn btn-primary" href="<spring:url value='/logout' />">Cerrar sesión</a>
				</div>
			</div>
		</div>
	</div>

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

	<!-- Chart JS -->
	<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0/dist/Chart.min.js" integrity="sha256-Uv9BNBucvCPipKQ2NS9wYpJmi8DTOEfTA/nH2aoJALw=" crossorigin="anonymous"></script>

	<!-- DataTable -->
	<script type="text/javascript" src="https://cdn.datatables.net/v/bs4-4.1.1/dt-1.10.21/datatables.min.js"></script>

	<script>
		window.onload = () => {
			if ( document.getElementById( 'table' ) !== undefined )
			{
				$( '#table' ).DataTable(
					{
						"aLengthMenu": [ [ 5, 10, 15, -1 ], [ 5, 10, 15, "Todos" ] ],
						"language": {
							"emptyTable"		: "No datos disponibles en la tabla",
							"info"				: "Mostrando _START_ a _END_ de _TOTAL_ registros",
							"infoEmpty"			: "Mostrando 0 a 0 de 0 registros",
							"infoFiltered"		: "(filtrados de un total de _MAX_ registros)",
							"lengthMenu"		: "Mostrar _MENU_ registros",
							"search"			: "Buscar:",
							"zeroRecords"		: "Ningún registro encontrado",
							"paginate"			: {
								"first"		: "Primero",
								"last"		: "Último",
								"next"		: "Siguiente",
								"previous"	: "Anterior"
							}
						}
					}
				);
			}
		};
	</script>
</body>

</html>