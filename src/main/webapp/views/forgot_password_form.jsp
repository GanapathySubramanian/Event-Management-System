<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="includes/header.jsp" />
<jsp:include page="includes/header.jsp" />  
<nav class="navbar navbar-expand-md navbar-dark bg-dark" style="margin-bottom:20px">
    <div class="container-fluid">
      <a class="navbar-brand" href="/signin"><i class="fas fa-backward"></i> Back</a>
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
		            <h1>Enter Your Registered Email</h1>
		            <p class="font-italic text-muted mb-0">We will be sending a reset password link to your email.</p>
					<div c:if="${error != null}">
						<p class="text-danger">${error}</p>
					</div>
					<div c:if="${msg != null}">
					    <p class="text-warning">${msg}</p>
					</div>
		        </div>
		
		        <!-- Forgot Password Form -->
		        <div class="col-lg-6 col-md-12 col-sm-12 mt-5">
		        <div class="login-form">
		        <form action="/forgot_password" method="post" style="max-width: 420px; margin: 0 auto;">
		        <h2 class="text-center mb-4">Forgot Password</h2>
		        <div class="form-group mt-3">
		        	<div class="input-group">
		                <div class="input-group-prepend">
		                    <span class="input-group-text">
		                        <span class="fa fa-user"></span>
		                    </span>                    
		                </div>
		                 <input type="email" name="email" class="form-control" placeholder="Enter your e-mail" required autofocus/>
		            </div>
		        </div>
				
		
		        <div class="form-group ">
		            <input type="submit" value="Send" class="btn btn-primary login-btn btn-block" />
		        </div>
		 
				
				<!-- Divider Text -->
				<div class="form-group col-lg-12 mx-auto d-flex align-items-center my-4">
				    <div class="border-bottom w-100 ml-5"></div>
				    <span class="px-2 small text-muted font-weight-bold text-muted">OR</span>
				    <div class="border-bottom w-100 mr-5"></div>
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