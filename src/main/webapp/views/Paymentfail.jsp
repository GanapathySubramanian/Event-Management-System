<%if (session.getAttribute("User_email") == null) {response.sendRedirect("/signin"); } else {%> 
<jsp:include page="includes/header.jsp" />  
<nav class="navbar navbar-expand-md navbar-dark bg-dark" style="margin-bottom:20px">
    <div class="container-fluid">
      <a class="navbar-brand" href="/userbookingdetails"><i class="fas fa-backward"></i> Back</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
     </div>
  </nav>


    <div class="container mt-5">
        <div class="row">
            <div class="col-md-3">

            </div>
            <div class="col-md-6">
               
                        <center>
                            <h1><i style="color: red;"  class="fas fa-exclamation-circle"></i> Payment Failed</h1><br>
                        </center>
                   
            </div>
            <div class="col-md-3">

            </div>

        </div>
    </div>

  <jsp:include page="includes/footer.jsp" />  
  <%}%>