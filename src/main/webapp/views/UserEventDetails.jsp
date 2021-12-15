
	<%if (session.getAttribute("User_email") == null) {
       response.sendRedirect("/signin");
        } else {%> 

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  

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
                    	<h3 class="text-info">EVENT DETAILS</h3>
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

        <div>
       		<div class="album py-5 bg-light">
        <div class="container">

          <div class="row">
          <c:forEach var="allevent" items="${eventlist}">
            <div class="col-md-12 col-lg-4 col-sm-12 ">
              <div class="card mb-4 box-shadow">
                <img class="card-img-top" img src="data:image/jpeg;base64,${allevent.event_img}";bg=55595c&amp;fg=eceeef&amp;text=Thumbnail" alt="Thumbnail [100%x225]" style="height: 225px; width: 100%; display: block;" src="data:image/svg+xml;charset=UTF-8,%3Csvg%20width%3D%22208%22%20height%3D%22225%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20viewBox%3D%220%200%20208%20225%22%20preserveAspectRatio%3D%22none%22%3E%3Cdefs%3E%3Cstyle%20type%3D%22text%2Fcss%22%3E%23holder_17d99700aac%20text%20%7B%20fill%3A%23eceeef%3Bfont-weight%3Abold%3Bfont-family%3AArial%2C%20Helvetica%2C%20Open%20Sans%2C%20sans-serif%2C%20monospace%3Bfont-size%3A11pt%20%7D%20%3C%2Fstyle%3E%3C%2Fdefs%3E%3Cg%20id%3D%22holder_17d99700aac%22%3E%3Crect%20width%3D%22208%22%20height%3D%22225%22%20fill%3D%22%2355595c%22%3E%3C%2Frect%3E%3Cg%3E%3Ctext%20x%3D%2266.9453125%22%20y%3D%22117.3%22%3EThumbnail%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fsvg%3E" data-holder-rendered="true">
                <div class="card-body">
                  <p class="card-text font-weight-bold text-info text-center text-uppercase">${allevent.eventname}</p>
                  <span class="text-muted"> ${allevent.event_desc}</span> 
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
    </div>
	
<jsp:include page="includes/footer.jsp" />  
<%}%>