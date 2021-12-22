
<jsp:include page="includes/header.jsp" /> 
 
<section class="mt-5">
	
		<div class="container">
		    <div class="row align-items-center my-5">
		        <!-- For Demo Purpose -->
		        <div class="col-md-12 col-lg-6 col-sm-12 mb-5">
		            <h1>Reset Your Password</h1>
		            <p class="font-italic text-muted mb-0">Fill out the Information provided here to reset your password.</p>
		            </p>
		        </div>
		
		        <!-- Reset password Form -->
		        <div class="col-lg-6 col-md-12 col-sm-12 mt-5">
		        <div class="login-form">
		         <form action="/reset_password" method="post" style="max-width: 350px; margin: 0 auto;">
		           <input type="hidden" name="token" value="${token}" />
		        <h2 class="text-center mb-4">Reset Your Password</h2>
				<div class="form-group">
		            <div class="input-group">
		                <div class="input-group-prepend">
		                    <span class="input-group-text">
		                        <i class="fa fa-lock"></i>
		                    </span>                    
		                </div>
		               <input type="password" name="password" id="password" class="form-control" placeholder="Enter your new password" required autofocus />				
		            </div>
		        </div>    
		
		<div class="form-group">
		            <div class="input-group">
		                <div class="input-group-prepend">
		                    <span class="input-group-text">
		                        <i class="fa fa-lock"></i>
		                    </span>                    
		                </div>
		                <input type="password" class="form-control" placeholder="Confirm your new password"  required oninput="checkPasswordMatch(this);" />				
		            </div>
		        </div>   
		        <div class="form-group ">
		            <input type="submit" value="Change Password" class="btn btn-primary login-btn btn-block" />
		        </div>
		
		    </form>
		    
			 
				</div>
		        </div>
		    </div>
		</div>
					
		
	</section>

  

<script>
function checkPasswordMatch(fieldConfirmPassword) {
    if (fieldConfirmPassword.value != $("#password").val()) {
        fieldConfirmPassword.setCustomValidity("Passwords do not match!");
    } else {
        fieldConfirmPassword.setCustomValidity("");
    }
}
</script>
<jsp:include page="includes/footer.jsp" /> 