<!-- Includes the header layout of the page -->
<%@ include file="../../layouts/public/header.jsp" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>

<header class="my-3">
	<h2>${ event.name }</h2>
</header>

<section>
	<article>
		<div class="row">
			<div class="col-md-6">
				<p>${ event.description }</p>
				<p>${ event.startDate } - ${ event.endDate }</p>
				<p>${ event.status ? event.endDate.compareTo( today ) > 0 and event.startDate.compareTo( today ) < 0 ? 'Actualmente' : today.compareTo( event.endDate ) > 0 ? 'Pasado' : 'Próximo' : 'Cancelado' }</p>
				<img class="img-fluid" src="${ event.place.photo }" alt="Foto" />
			</div>
			<div class="col-md-6">
				<h3>${ event.place.name }</h3>
				<div id="map"></div>
			</div>
		</div>
		<div class="row">
			<a href="<spring:url value='/public/events' />" class="btn btn-secondary">Regresar</a>
		</div>
	</article>
</section>

<script>
	var map;
	function initMap ()
	{
		var map = new google.maps.Map( document.getElementById( 'map' ),
			{
				zoom: 15,
				
				center: {
					lat: parseFloat( "${ event.place.location.latitude }" ),
					lng: parseFloat( "${ event.place.location.longitude }" )
				}
			}
		);
	}
</script>

<!-- Google Maps -->
<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAPHUowypYvKzIPphRqDQyMvZPNS07ufd4&callback=initMap"></script>

<!-- Includes the header layout of the page -->
<%@ include file="../../layouts/public/footer.jsp" %>