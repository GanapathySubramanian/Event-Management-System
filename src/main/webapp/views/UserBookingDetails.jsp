
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

        

            <section class="booking-details" >
                <div class="container" id="contentArea1"><br><br>
                    <div class="row">
                        <c:forEach var="booking" items="${User_bookings}" varStatus="loop">
                       
                            <div id="eventBooking" class="col-lg-4 col-md-6">
                                <div class="card card-margin">
                                    <div class="card-header no-border">
                                        <c:if test = "${booking.accept_status==0  && booking.payment_status==0}">
                                            <h5 class="card-title">Pending</h5>
                                        </c:if>
                                        <c:if test = "${booking.accept_status==1 && booking.payment_status==0}">
                                            <h5 class="card-title">Booking Accepted</h5>
                                        </c:if>
                                        <c:if test = "${booking.accept_status==1 && booking.payment_status==1}">
                                            <h5 class="card-title">Paid</h5>
                                        </c:if>
                                        <c:if test = "${booking.accept_status==2 && booking.payment_status==0}">
                                            <h5 class="card-title">Cancelled by admin</h5>
                                        </c:if>
                                        <c:if test = "${booking.accept_status==3 && booking.payment_status==0}">
                                            <h5 class="card-title">Cancelled by you</h5>
                                        </c:if>
                                    </div>
                                    <div class="card-body pt-0">
                                        <div class="widget-49">
                                            <div class="widget-49-title-wrapper">  
                                                  
                                                        <c:if test = "${booking.accept_status==0  && booking.payment_status==0}">
                                        
                                                        <div class="widget-49-date-warning"> 
                                                            <span class="widget-49-date-day">${loop.index + 1}</span> 
                                                        </div>
                                                        </c:if>
                                                        <c:if test = "${booking.accept_status==1 && booking.payment_status==0}">
                                                       
                                                        <div class="widget-49-date-primary"> 
                                                            <span class="widget-49-date-day">${loop.index + 1}</span> 
                                                        </div>
                                                        </c:if>
                                                        <c:if test = "${booking.accept_status==1 && booking.payment_status==1}">
                                                            <div class="widget-49-date-success"> 
                                                                <span class="widget-49-date-day">${loop.index + 1}</span> 
                                                            </div>
                                                     
                                                        </c:if>
                                                        <c:if test = "${booking.accept_status==2 && booking.payment_status==0}">
                                                            <div class="widget-49-date-secondary"> 
                                                                <span class="widget-49-date-day">${loop.index + 1}</span> 
                                                            </div>
                                                       
                                                        </c:if>
                                                        <c:if test = "${booking.accept_status==3 && booking.payment_status==0}">
                                                            <div class="widget-49-date-secondary"> 
                                                                <span class="widget-49-date-day">${loop.index + 1}</span> 
                                                            </div>
                                                       
                                                        </c:if>
                                                        
                                                    
                                                <div class="widget-49-meeting-info">
                                                    <span class="font-weight-bold text-uppercase">${booking.hotel.hotelName}</span> 
                                                    <span class="widget-49-meeting-time text-uppercase">${booking.event.eventname}</span>
                                                    <span class="widget-49-meeting-time" id="b_date">Booked Date : ${booking.current_date}</span>
                                                </div>
                                            </div>
                                            <ul class="widget-49-meeting-points">
                                                <li class="widget-49-meeting-item"><span class="font-weight-bold ">Catering Name : ${booking.catering.catername}</span></li>
                                                <li class="widget-49-meeting-item"><span class="font-weight-bold ">Event Date : ${booking.event_date}</span></li>
                                                <li class="widget-49-meeting-item"><span class="font-weight-bold ">Event Time : ${booking.start_at}</span></li>
                                                <li class="widget-49-meeting-item"><span class="font-weight-bold ">Event Time Limit : ${booking.max_total_hour} hrs</span></li>
                                                <li class="widget-49-meeting-item"><span class="font-weight-bold ">No of Guest : ${booking.no_of_guest}</span></li>
                                                <c:if test = "${booking.photographer_name_desc != 'none'}">
                                                    <li class="widget-49-meeting-item">
                                                        <span class="font-weight-bold ">Photographer : ${booking.photographer_name_desc}</span>
                                                    </li>
                                                </c:if>
                                                <c:if test = "${booking.photographer_name_desc == 'none'}">
                                                    <li class="widget-49-meeting-item">
                                                        <span class="font-weight-bold ">Photographer : None</span>
                                                    </li>
                                                </c:if>
                                                <c:if test = "${booking.dj_name_desc != 'none'}">
                                                    <li class="widget-49-meeting-item">
                                                        <span class="font-weight-bold ">DJ : ${booking.dj_name_desc}</span>
                                                    </li>
                                                </c:if>
                                                <c:if test = "${booking.dj_name_desc == 'none'}">
                                                    <li class="widget-49-meeting-item">
                                                        <span class="font-weight-bold ">DJ : None</span>
                                                    </li>
                                                </c:if>
                                                <c:if test = "${booking.makeupartist_name_desc != 'none'}">
                                                    <li class="widget-49-meeting-item">
                                                        <span class="font-weight-bold ">Makeupartisit : ${booking.makeupartist_name_desc}</span>
                                                    </li>
                                                </c:if>
                                                <c:if test = "${booking.makeupartist_name_desc == 'none'}">
                                                    <li class="widget-49-meeting-item">
                                                        <span class="font-weight-bold ">Makeupartisit : None</span>
                                                    </li>
                                                </c:if>
                                                <c:if test = "${booking.decorator_name_desc != 'none'}">
                                                    <li class="widget-49-meeting-item">
                                                        <span class="font-weight-bold ">Decorator : ${booking.decorator_name_desc}</span>
                                                    </li>
                                                </c:if>
                                                <c:if test = "${booking.decorator_name_desc == 'none'}">
                                                    <li class="widget-49-meeting-item">
                                                        <span class="font-weight-bold ">Decorator : None</span>
                                                    </li>
                                                </c:if>
                                                 <li class="widget-49-meeting-item"><span class="font-weight-bold ">Total Cost : <i class="fa fa-inr" aria-hidden="true"></i>${booking.amount}</span></li>
                                            </ul>
                                            
                                                <div class="time">
                                                   
                                                    <c:if test = "${booking.accept_status==0  && booking.payment_status==0}">
                                                        <form action="/bookcancelbyuser" method="POST">
                                                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                                            <input type="hidden" value="${booking.id}" name="booking_id">
                                                            <button type="submit" class="btn btn-danger btn-sm ml-3" onclick='return cancelBooking()'>Cancel</button>
                                                        </form>
                                                       
                                                    </c:if>
                                                    <c:if test = "${booking.accept_status==1 && booking.payment_status==0}">
                                                        <div class="d-flex">
                                                             <form action="/paytmuser"  method="POST">
                                                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                                                <input type="hidden" value="${User_id}" name="booking_userid">
                                                                  <input type="hidden" value="${booking.amount}" name="total_amt">
             														  <input type="hidden" value="${booking.id}" name="booking_id">
             													
                                                                <button type="submit" value="Continue to checkout" class="btn btn-primary btn-sm">Pay</button>
                                                            </form>
                                                            <form action="/bookcancelbyuser" method="POST" class="ml-3">
                                                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                                                <input type="hidden" value="${booking.id}" name="booking_id">
                                                                <button type="submit" class="btn btn-danger btn-sm">Cancel</button>
                                                            </form>
                                                        </div>
                                                    </c:if>
                                                    <c:if test = "${booking.accept_status==1 && booking.payment_status==1}">
                                                         <form action="userbookingdetails/export" method="GET">
                                                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                                            <input type="hidden" value="${booking.id}" name="booking_id">
                                                            <button type="submit" class="btn btn-info btn-sm">Bill</button>
                                                        </form>
                                                    </c:if>
                                                    <c:if test = "${booking.accept_status==2 && booking.payment_status==0}">
                                                        <h5 class="card-title"></h5>
                                                    </c:if>
                                                    <c:if test = "${booking.accept_status==3 && booking.payment_status==0}">
                                                        <h5 class="card-title"></h5>
                                                    </c:if>
                                                </div>
                                            </form> 	  
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </section>
        
        
        </div>
     
   
<jsp:include page="includes/footer.jsp" />  

<%}%>
