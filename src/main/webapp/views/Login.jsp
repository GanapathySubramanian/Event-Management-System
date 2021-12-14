<jsp:include page="includes/header.jsp" />  
<nav class="navbar navbar-expand-md navbar-dark bg-dark" style="margin-bottom:20px">
    <div class="container-fluid">
      <a class="navbar-brand" href="/"><i class="fas fa-backward"></i> Back</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
     </div>
  </nav>
  
	<section class="mt-5">
	
		<div class="container">
		    <div class="row align-items-center my-5">
		        <!-- For Demo Purpose -->
		        <div class="col-md-12 col-lg-6 col-sm-12 mb-5">
		            <img src="assets/picture/icons/thumbs-up.png" alt="" class="img-fluid mb-3 d-none d-md-block">
		            <h1>Login and Book Your Halls</h1>
		            <p class="font-italic text-muted mb-0">Fill out the Information provided here to sign in.</p>
		            </p>
		        </div>
		
		        <!-- Registeration Form -->
		        <div class="col-lg-6 col-md-12 col-sm-12 mt-5">
		        <div class="login-form">
		         <form action="/login-validation" modelAttribute="loginForm" method="POST" >
		        <h2 class="text-center mb-4">Sign in</h2>
		        <div class="form-group mt-3">
		        	<div class="input-group">
		                <div class="input-group-prepend">
		                    <span class="input-group-text">
		                        <span class="fa fa-user"></span>
		                    </span>                    
		                </div>
		                <input type="text" class="form-control" name="email" placeholder="Email" required="required">				
		            </div>
		        </div>
				<div class="form-group">
		            <div class="input-group">
		                <div class="input-group-prepend">
		                    <span class="input-group-text">
		                        <i class="fa fa-lock"></i>
		                    </span>                    
		                </div>
		                <input type="password" class="form-control" name="password" placeholder="Password" required="required">				
		            </div>
		        </div>    
		
		        <div class="form-group ">
		            <button type="submit" name="user_login" class="btn btn-primary login-btn btn-block">Sign in</button>
		        </div>
		 
				<div class="text-center w-100">
					<p class="text-muted font-weight-bold">Forgot Password <a href="/forgot_password" class="text-primary ml-2">Click here!</a></p>
			   </div>
				<!-- Divider Text -->
				<div class="form-group col-lg-12 mx-auto d-flex align-items-center my-4">
				    <div class="border-bottom w-100 ml-5"></div>
				    <span class="px-2 small text-muted font-weight-bold text-muted">OR</span>
				    <div class="border-bottom w-100 mr-5"></div>
				</div>
				                    
				                    
		        <p class="text-center">Login with your social media account</p>
		        <div class="text-center social-btn">
		            <a href="#" class="btn btn-secondary"><i class="fab fa-facebook"></i>&nbsp; Facebook</a>
		            <a href="#" class="btn btn-info"><i class="fab fa-twitter"></i>&nbsp; Twitter</a>
					<a href="#" class="btn btn-danger"><i class="fab fa-google"></i>&nbsp; Google</a>
		        </div>
		    </form>
		    
			  <!-- not Already Registered -->
			  	   <div class="text-center w-100">
			             <p class="text-muted font-weight-bold">Don't have an account? <a href="signup" class="text-primary ml-2">Sign up here!</a></p>
			        </div>
				</div>
		        </div>
		    </div>
		</div>
					
		
	</section>

<jsp:include page="includes/footer.jsp" />  