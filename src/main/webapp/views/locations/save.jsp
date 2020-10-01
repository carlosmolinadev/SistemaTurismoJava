<!-- Includes the header layout of the page -->
<%@ include file="../layouts/admin/header.jsp" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>

<c:set var="isNew" value="${ location.id == null && location.status == null }" />

<!-- Headers section -->
<header>
	<h1><i class="fas fa-map-marker-alt"></i> Ubicaciones </h1>
	<h2>${ isNew ? 'Nuevo' : 'Edición' }</h2>
</header>

<!-- Form -->
<form method="post" action="<spring:url value='/locations' />">
	<input type="hidden" name="id" value="${ location.id }" />
	<input type="hidden" name="createdAt" value="${ location.createdAt }" />

	<div class="form-row">
		<!-- Id Region -->
		<div class="form-group col-md-6">
			<label for="Región de la ubicación">Región</label>
			<select class="custom-select" id="region" name="region.id">
				<c:forEach items="${ regions }" var="region">
					<option ${ region.id == location.region.id ? 'selected' : ''} value="${ region.id }">${ region.name }</option>
				</c:forEach>
			</select>
		</div>
	</div>
	
	<div class="form-row">
		<!-- Location name -->
		<div class="form-group col-md-6">
			<label for="name">Nombre de la ubicación</label>
			<input class="form-control" id="name" placeholder="Nombre" name="name" value="${ location.name }" required />
		</div>

		<!-- Location description -->
		<div class="form-group col-md-6">
			<label for="description">Descripción de la ubicación</label>
			<input class="form-control" id="description" placeholder="Descripcion" name="description" value="${ location.description }" required />
		</div>
	</div>

	<div id="map"></div>
	
	<div class="form-row">
		<div class="form-group col-md-6">
			<input class="form-control" id="latitude" name="latitude"  value="${ location.latitude }" />
		</div>
		<div class="form-group col-md-6">
			<input class="form-control" id="longitude" name="longitude" value="${ location.longitude }" />
		</div>
	</div>
	
	<!-- Cancel button -->
	<a href="<spring:url value='/locations' />" class="btn btn-secondary">Cancelar</a>
	
	<!-- Submit button -->
	<input type="submit" class="btn btn-primary" value="Guardar" />
</form>

<script>
	var map;
	function initMap ()
	{
		var latitudeLongitude = { lat: 13.7483455, lng: -89.4906877 }; // El Salvador

		var map = new google.maps.Map( document.getElementById( 'map' ), { zoom: 9, center: latitudeLongitude } );

		// Create the initial InfoWindow.
		var infoWindow = new google.maps.InfoWindow( { content: 'Haz clic en el lugar de tu locación', position: latitudeLongitude } );
		infoWindow.open( map );

		map.addListener( 'click', ( mapsMouseEvent ) => // Configure the click listener.
		{
			infoWindow.close(); // Close the current InfoWindow.

			infoWindow = new google.maps.InfoWindow( { position: mapsMouseEvent.latLng } ); // Create a new InfoWindow.
			infoWindow.setContent( mapsMouseEvent.latLng.toString() );

			document.getElementById( 'latitude' ).value		= mapsMouseEvent.latLng.lat();
			document.getElementById( 'longitude' ).value	= mapsMouseEvent.latLng.lng();

			infoWindow.open( map );
		} );
	}
</script>

<!-- Google Maps -->
<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAPHUowypYvKzIPphRqDQyMvZPNS07ufd4&callback=initMap"></script>

<!-- Includes the footer layout of the page -->
<%@ include file="../layouts/admin/footer.jsp" %>