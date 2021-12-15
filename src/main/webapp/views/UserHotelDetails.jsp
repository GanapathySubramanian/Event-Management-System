
	<%if (session.getAttribute("User_email") == null) {
       response.sendRedirect("/signin");
        } else {%> 

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="includes/header.jsp" />  
	<style>
	.card:hover {
    transform: scale(1.05);
    box-shadow: 0 10px 20px rgba(0, 0, 0, .12), 0 4px 8px rgba(0, 0, 0, .06);
    transition: 0.3s ease-in-out;
    cursor:pointer;
}
	</style>
	<jsp:include page="includes/userNav.jsp" />  
	
	
	    <!-- Page Content  -->
        <div id="content">

            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">

                    <button type="button" id="sidebarCollapse" class="btn btn-info">
                        <i class="fas fa-align-left"></i>
                        <span>Toggle Sidebar</span>
                    </button>
                    <div>
                    	<h3 class="text-info">HOTEL DETAILS</h3>
                    </div>
                   <div>
                    	<p>Welcome 
                    	<% if(session.getAttribute("User_gender").equals("male")){ %> 
                    		Mr.
                    	<%}else{%> 
                    		Miss.
                    	<%}%> 
                    	<span class="font-weight-bold text-info">${User_firstname} ${User_lastname}</span></p>
                    </div>
                </div>
            </nav>
          

          
<div class="album py-5 bg-light">
        <div class="container">

          <div class="row">
              <c:forEach var="allhotel" items="${hotellist}">
                  <div class="col-md-12 col-lg-4 col-sm-12 ">
                      <div class="card mb-4 box-shadow">
                          <img class="card-img-top" img src="data:image/jpeg;base64,${allhotel.hotelImg1}";bg=55595c&amp;fg=eceeef&amp;text=Thumbnail" alt="Thumbnail [100%x225]" style="height: 225px; width: 100%; display: block;"  data-holder-rendered="true">
                            <div class="card-body">
                              <p class="card-text font-weight-bold text-info text-center text-uppercase">${allhotel.hotelName}</p>
                              <p class="text-center">
                                <span class="price mb-2">
                                  <sup>Rs</sup> 
                                  <span class="number h1 text-info ">${allhotel.price}</span> 
                                  <sub>/per hour</sub>
                                </span>
                              </p>
                              
                              <p class="pricing-text mb-3 ml-3 text-center">
                                <span>Location : ${allhotel.location}</span>                     
                              </p>
                              <span class="text-muted"> ${allhotel.hotelDesc}</span> 
                              <hr>
                              <div class="d-flex justify-content-between align-items-center">
                                <div class="btn-group">
                                  <div class="text-center my-4"> <a href="/usernewbooking" class="btn btn-info">Book</a> </div>
                                </div>
                              </div>
                          </div>
                      </div>
                  </div>  
                </c:forEach>
          </div>
        </div>
      </div>

	

	
<jsp:include page="includes/footer.jsp" />  
<%}%>