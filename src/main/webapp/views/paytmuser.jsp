<%if (session.getAttribute("User_email") == null) {
      response.sendRedirect("/signin");
       } else {%> 
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <jsp:include page="includes/header.jsp" />  




<nav class="navbar navbar-expand-md navbar-dark  bg-dark">
    <div class="container-fluid">
      <a class="navbar-brand" href="/userbookingdetails"><i class="fas fa-backward"></i> Back</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
     </div>
  </nav>
  
  <section class="container ">
  		<div class="container">
    			<div class="row align-items-center my-5">
        				<!-- For Demo Purpose -->
        				<div class="col-md-12 col-lg-6 col-sm-12 mb-5">
            			<!-- <img src="assets/picture/icons/thumbs-up.png" alt="" class="img-fluid mb-3 d-none d-md-block"> -->   
       						<h1>Welcome to Paytm Payment</h1>
           					<p class="font-italic text-muted mb-0">You are 30 seconds away from earning your own money!</p>
           			    </div>

				        <!-- Registeration Form -->
				        <div class="col-md-12 col-lg-6 col-sm-12 mt-3">
				           <form action="/pgredirect" method="POST">
				           		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				                <div class="row">
				                   
                    
                                    <div class="col-lg-5 col-md-5 col-sm-12 mb-2 ml-3">
                                        <div class="form-group">
                                            <label for="exampleInputPassword1">Transaction Id</label>
                                            <input id="ORDER_ID" tabindex="1" maxlength="20" size="20" value="" name="ORDER_ID" autocomplete="off" class="form-control" placeholder="orderID" readonly>
                                          </div>
                                    </div>

                                    <div class="col-lg-5 col-md-5 col-sm-12 mb-2 ml-3">
                                        <div class="form-group">
                                            <label for="exampleInputPassword1">Customer Id</label>
                                            <input type="text" class="form-control" placeholder="Customer ID" value="${user_id}" name="CUST_ID" readonly/>
                                        </div>
                                    </div>
                                    
                                    <div class="col-lg-5 col-md-5 col-sm-12 mb-2 ml-3">
                                        <div class="form-group">
                                            <label for="exampleInputPassword1">Industry Type</label>
                                            <input type="text" class="form-control" placeholder="INDUSTRY_TYPE_ID" value="Reatil" name="INDUSTRY_TYPE_ID" readonly/>
                                        </div>
                                    </div>
                                    <div class="col-lg-5 col-md-5 col-sm-12 mb-2 ml-3">
                                        <div class="form-group">
                                            <label for="exampleInputPassword1">Channel ID</label>
                                            <input type="text" class="form-control" placeholder="Channel" value="WEB"  name="CHANNEL_ID" readonly/>
                                        </div>
                                    </div>

                                    <div class="mx-auto col-sm-12 mb-2">
                                        <div class="form-group">
                                            <label for="exampleInputPassword1">Total Amount</label>
                                            <input type="text" class="form-control" placeholder="Amount" value="${amt}"    name="TXN_AMOUNT" readonly/>
                                        </div>
                                    </div>
				                    <!-- Submit Button -->
				                    <div class="form-group col-lg-12 mx-auto mb-0">
				                        <button type="submit" class="btn btn-primary btn-block py-2" name="adduser" >
				                            <span class="font-weight-bold">Pay With Paytm</span>
				                        </button>
				                    </div>

			                </div>
            	     </form>
			        </div>
			    </div>
			</div>

  </section>


<script>
    let x = Math.floor((Math.random() * 10000) + 1);
    document.getElementById("ORDER_ID").value = x;
    </script>
<jsp:include page="includes/footer.jsp" />  
<%}%>