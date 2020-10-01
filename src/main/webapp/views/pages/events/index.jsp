<!-- Includes the header layout of the page -->
<%@ include file="../../layouts/public/header.jsp" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>

<header class="my-3">
	<h2>Eventos</h2>
</header>

<c:choose>
	<c:when test="${ events != null and !events.isEmpty() }">
		<c:forEach items="${ events }" var="event" varStatus="loop">
			<c:choose>
				<c:when test="${ event.status }">
					<c:choose>
						<c:when test="${ event.endDate.compareTo( today ) > 0 and event.startDate.compareTo( today ) < 0 }">
							<c:set var="status" value="Actualmente" />
						</c:when>
						<c:when test="${ today.compareTo( event.endDate ) > 0 }">
							<c:set var="status" value="Pasado" />
						</c:when>
						<c:otherwise>
							<c:set var="status" value="Próximo" />
						</c:otherwise>
					</c:choose>
				</c:when>
				<c:otherwise>
					<c:set var="status" value="Cancelado" />
				</c:otherwise>
			</c:choose>

			<c:if test="${ loop.index % 4 == 0 }">
				<div class="row">
			</c:if>

			<div class="col-md-3 p-1">
				<a href="<spring:url value='/public/events/${ event.id }' />" class="text-decoration-none">
					<div class="card">
						<img class="card-img-top" src="${ event.place.photo }" alt="Card image cap">
						<div class="card-body text-white bg-${ status == 'Próximo' ? 'primary' : status == 'Actualmente' ? 'success' : status == 'Cancelado' ? 'danger' : 'secondary' }">
							<h3 class="card-title">${ event.name }</h3>
							<p class="card-text text-truncate">${ event.description }</p>
						</div>
						<ul class="list-group list-group-flush text-dark">
							<li class="list-group-item">Locación: ${ event.place.name }</li>
							<li class="list-group-item">${ formatter.format( event.startDate ) } - ${ formatter.format( event.endDate ) }</li>
						</ul>
						<div class="card-body">
							Estado:	<c:out value="${ status }" />
						</div>
					</div>
				</a>
			</div>

			<c:if test="${ loop.count % 4 == 0 }">
				</div>
			</c:if>
		</c:forEach>
	</c:when>
	<c:otherwise>
		<p>Lo sentimos, no hay eventos, pero puedes llenar nuestro <a href="<spring:url value='/form' />">formulario</a> para ver posibles rutas turísticas para tí basado en tus necesidades</p>
	</c:otherwise>
</c:choose>

<!-- Includes the header layout of the page -->
<%@ include file="../../layouts/public/footer.jsp" %>