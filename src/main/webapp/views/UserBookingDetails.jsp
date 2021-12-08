<%if (session.getAttribute("User_email") == null) {
            response.sendRedirect("/signin");
        } else {%> 


<jsp:include page="includes/header.jsp" />  
	
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
                    	<h3 class="text-info">USER BOOKING HISTORY</h3>
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
       		UserBookingDetails
        </div>
    </div>
	
<jsp:include page="includes/footer.jsp" />  
<%}%>