<jsp:include page="includes/header.jsp" />  

<jsp:include page="includes/homeNav.jsp"/>
<style>
  .carousel-item {
  height: 100vh;
  min-height: 300px;
  background: no-repeat center center scroll;
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
}
</style>

<!-- <section id="Carousel-Section " style="margin-top: -40px;">
      <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
  <ol class="carousel-indicators">
    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
  </ol>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img class="d-block w-100" src="../assets/images/hotels/1.jpeg"  alt="First slide">
    	<div class="carousel-caption d-none d-md-block">
		    <h5>...</h5>
		    <p>...</p>
	  	</div>
    </div>
    <div class="carousel-item">
      <img class="d-block w-100"  src="../assets/images/hotels/2.jpeg"  alt="Second slide">
	   	 <div class="carousel-caption d-none d-md-block">
		    <h5>...</h5>
		    <p>...</p>
	  	</div>
    </div>
    <div class="carousel-item">
      <img class="d-block w-100"src="../assets/images/hotels/3.jpeg" alt="Third slide">
    	<div class="carousel-caption d-none d-md-block">
		    <h5>...</h5>
		    <p>...</p>
	  	</div>
    </div>
    <div class="carousel-item">
      <img class="d-block w-100" src="../assets/images/catering/1.jpeg" alt="Third slide">
    	<div class="carousel-caption d-none d-md-block">
		    <h5>...</h5>
		    <p>...</p>
	  	</div>
    </div>
    <div class="carousel-item">
      <img class="d-block w-100" src="../assets/images/catering/2.jpeg" alt="Third slide">
    	<div class="carousel-caption d-none d-md-block">
		    <h5>...</h5>
		    <p>...</p>
	  	</div>
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
	
</section> -->


<header style="margin-top: -40px;">
  <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
      <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
      <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
      <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
      <li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
      <li data-target="#carouselExampleIndicators" data-slide-to="4"></li>
    </ol>
    <div class="carousel-inner" role="listbox">
      <!-- Slide One - Set the background image for this slide in the line below -->
      <div class="carousel-item active" style="background-image: url('../assets/images/hotels/1.jpeg')">
        <div class="carousel-caption d-none d-md-block">
          <h3>EXQUISITE</h3>
          <p class="text-white">The Perfect Planner</p>
        </div>
      </div>
      <!-- Slide Two - Set the background image for this slide in the line below -->
      <div class="carousel-item" style="background-image: url('../assets/images/hotels/2.jpeg')">
        <div class="carousel-caption d-none d-md-block">
          <h3>Main Hall</h3>
          <p class="text-white"> Integer molestie, orci vel ullamcorper aliquet, enim augue tempor massa, non lacinia lectus turpis nec turpis</p>
        </div>
      </div>
      <!-- Slide Three - Set the background image for this slide in the line below -->
      <div class="carousel-item" style="background-image: url('../assets/images/hotels/3.jpeg')">
        <div class="carousel-caption d-none d-md-block">
          <h3>Reception</h3>
          <p class="text-white">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque pharetra neque at erat accumsan commodo. Fusce at augue in metus commodo eleifend vitae ac nibh</p>
        </div>
      </div>
       <!-- Slide four - Set the background image for this slide in the line below -->
       <div class="carousel-item" style="background-image: url('../assets/images/catering/1.jpeg')">
        <div class="carousel-caption d-none d-md-block">
          <h3>Catering Bufe</h3>
          <p class="text-white" >Nulla sagittis elit et velit ultricies, non tincidunt nunc consectetur. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc dapibus sem sed ultrices egestas.</p>
        </div>
      </div>
       <!-- Slide five - Set the background image for this slide in the line below -->
       <div class="carousel-item" style="background-image: url('../assets/images/catering/2.jpeg')">
        <div class="carousel-caption d-none d-md-block">
          <h3>Dulex And SuperDulex</h3>
          <p class="text-white">Donec enim velit, volutpat nec venenatis iaculis, ullamcorper venenatis elit. Cras congue lacus ultricies scelerisque malesuada</p>
        </div>
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
</header>

<section id="service-section" class="mt-5 mb-5 pr-3">
		 <div class="container marketing text-center">

        <!-- Three columns of text below the carousel -->
        <div class="row">
          <div class="col-lg-4 ">
            <img class="rounded-circle" src="https://2.bp.blogspot.com/-uDJeJFTy6e0/Wnqn8j3OOoI/AAAAAAAABTQ/vxh5_Uft6g0BPpjdYkOzMx4NTleHE55PQCLcBGAs/s1600/MS%2BMarriage-marriage-hall-chennai.jpg" alt="Generic placeholder image" width="240" height="240">
            <h2>HALLS</h2>
            <p>Donec sed odio dui. Etiam porta sem malesuada magna mollis euismod. Nullam id dolor id nibh ultricies vehicula ut id elit. Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Praesent commodo cursus magna.</p>
            <!-- <p><a class="btn btn-warning" href="#" role="button">View details &raquo;</a></p> -->
          </div><!-- /.col-lg-4 -->
          <div class="col-lg-4">
            <img class="rounded-circle" src="https://images.pexels.com/photos/2291367/pexels-photo-2291367.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500" alt="Generic placeholder image" width="240" height="240">
            <h2>CATERING</h2>
            <p>Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus sit amet fermentum. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh.</p>
            <!-- <p><a class="btn btn-warning" href="#" role="button">View details &raquo;</a></p> -->
          </div>
          <div class="col-lg-4">
            <img class="rounded-circle" src="https://cdn.xxl.thumbs.canstockphoto.com/scratched-textured-vendor-stamp-seal-vendor-seal-print-with-grunge-effect-red-vector-rubber-print-illustration_csp62954923.jpg" alt="Generic placeholder image" width="240" height="240">
            <h2>VENDORS</h2>
            <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
            <!-- <p><a class="btn btn-warning" href="#" role="button">View details &raquo;</a></p> -->
          </div>
         </div>
</section>



<hr class="featurette-divider">

        <div class="row featurette">
          <div class="col-md-7">
            <div class="mt-1 text-center">
              <h2 class="featurette-heading mt-2">HALLS<p class="text-muted mt-2">It'll blow your mind.</p></h2>
            </div>
            <div class="mt-3">
              <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
            </div>
          </div>
          <div class="col-md-5">
            <img class="featurette-image img-fluid mx-auto"  src="https://i.pinimg.com/originals/32/17/96/321796c217c3fa93013944de4772e7f8.jpg" alt="Generic placeholder image">
          </div>
        </div>

        <hr class="featurette-divider">

        <div class="row featurette">
          <div class="col-md-7 order-md-2">
            <div class="mt-1 text-center">
              <h2 class="featurette-heading mt-2">CATERING <p class="text-muted mt-2">The best memories are made around the dinner table</p></h2>
            </div>
              <div class="mt-3">
                <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
              </div>
           </div>
          <div class="col-md-5 order-md-1">
            <img class="featurette-image img-fluid mx-auto" src="https://arzfinefoods.com/wp-content/uploads/2018/11/Catering_Promo.jpg" alt="Generic placeholder image">
          </div>
        </div>

        <hr class="featurette-divider">

        <div class="row featurette">
          <div class="col-md-7">
            <div class="mt-1 text-center">
              <h2 class="featurette-heading mt-2">VENDORS <p class="text-muted mt-2">An artist is not paid for his Labor but for his vision.</p></h2>
            </div>
            <div class="mt-3">
              <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
            </div>
          </div>
          <div class="col-md-5">
            <img class="featurette-image img-fluid mx-auto" src="https://image.freepik.com/free-vector/various-street-food-vendor-flat-illustration_2482-381.jpg" alt="Generic placeholder image">
          </div>
        </div>



<!-- footer-section -->
        <section class="footer-section">
            <footer class="footer">
                <p class="footer_title">Contact us</p>
                    <div class="footer_social">
                        <a href="#" class="footer_icon"><i class="fab fa-facebook-f"></i></a>
                        <a href="#" class="footer_icon"><i class="fab fa-instagram"></i></a>
                        <a href="#" class="footer_icon"><i class="fab fa-twitter"></i></a>
                    </div>
                <p>&#169; 2021 copyright all right reserved</p>
            </footer>
        </section>
<jsp:include page="includes/footer.jsp" />  