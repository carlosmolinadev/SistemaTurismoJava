<!-- Includes the header layout of the page -->
<%@ include file="../layouts/public/header.jsp" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>

<img src="00.png" alt="">

<div class="row">
	<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img class="d-block w-100" src="https://c.pxhere.com/images/73/66/c4782b254dff9f2101897855182a-1600350.jpg!d" alt="First slide" />
			</div>
			<div class="carousel-item">
				<img class="d-block w-100" src="https://upload.wikimedia.org/wikipedia/commons/f/ff/Turismo_en_Pampatar_6.jpg" alt="Second slide" />
			</div>
			<div class="carousel-item">
				<img class="d-block w-100" src="https://i2.wp.com/background4free.com/download/blue_yellow_light_115379772.jpg" alt="Third slide" />
			</div>
		</div>
		<a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span>
			<span class="sr-only">Previous</span>
		</a>
		<a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>
</div>

<!-- Includes the header layout of the page -->
<%@ include file="../layouts/public/footer.jsp" %>