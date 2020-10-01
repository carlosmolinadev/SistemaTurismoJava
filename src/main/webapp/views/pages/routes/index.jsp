<!-- Includes the header layout of the page -->
<%@ include file="../../layouts/public/header.jsp" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>

<header class="my-3">
	<h2>${ route.name }</h2>
</header>

<section>
	<article>
		<div id="map"></div>
	</article>

	<article>
		<h3>Lugares</h3>
		<div class="row">
			<ul>
				<c:forEach items="${ route.places }" var="place">
					<li>${ place.name }</li>
				</c:forEach>
			</ul>
		</div>
	</article>
</section>

<script>var locations = [];</script>

<c:forEach items="${ route.places }" var="place">
	<script>locations.push( { lat: parseFloat( "${ place.location.latitude }" ), lng: parseFloat( "${ place.location.latitude }" ) } );</script>
</c:forEach>

<script>
	var map;
	function initMap ()
	{
		var map = new google.maps.Map( document.getElementById( 'map' ), { zoom: 9, center: { lat: 13.7483455, lng: -89.4906877 } } );

		var markers = locations.map( ( location, i ) => {
			return new google.maps.Marker(
				{
					position	: location,
					label		: labels[ i % labels.length ]
				}
			);
		} );
	}
</script>

<!-- Google Maps -->
<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAPHUowypYvKzIPphRqDQyMvZPNS07ufd4&callback=initMap"></script>

<!-- Includes the footer layout of the page -->
<%@ include file="../../layouts/public/footer.jsp" %>