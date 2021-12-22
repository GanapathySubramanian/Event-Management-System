<%if (session.getAttribute("Admin_email") == null) {response.sendRedirect("/signin"); } else {%> 

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <jsp:include page="includes/header.jsp" />  
        
        <jsp:include page="includes/adminNav.jsp" />  
        
        
            <!-- Page Content  -->
            <div id="content">
    
                  <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <div class="container-fluid">
    
                        <button type="button" id="sidebarCollapse" class="btn btn-info">
                            <i class="fas fa-align-left"></i>
                            <span>Toggle Sidebar</span>
                        </button>
                        <div>
                            <h3 class="text-info">ADMIN BOOKINGDETAILS</h3>
                        </div>
                       <div>
                            <p>Welcome 
                            <% if(session.getAttribute("Admin_gender").equals("male")){ %> 
                                Mr.
                            <%}else{%> 
                                Miss.
                            <%}%> 
                            <span class="font-weight-bold text-info">${Admin_firstname} ${Admin_lastname}</span></p>
                        </div>
                    </div>
                </nav>
    
             
	<div class="d-flex justify-content-between">
	    
		  <!--
		  <form class="d-flex"  action="/bookingSearch"  method="post" autocomplete="off">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<input class="form-control" type="search" name="valueToSearch" placeholder="Value To Search" aria-label="Search" value="${booking_keyword}">
            <button class="btn ml-2 btn-info" type="submit" name="search">Search</button>
        </form>
		    --> 
			
			<form>
				<a href="/downloadExcel" class="btn btn-info">Download Report</a>
			</form>
	    </div>

<br /><br/>
                <label class="text-info font-weight-bold"> Select No.of.rows to display :</label>
                <select class  ="form-control" name="state" id="maxRows">
                      <option value="5000">Show ALL Rows</option>
                      <option value="5">5</option>
                      <option value="10">10</option>
                      <option value="15">15</option>
                      <option value="20">20</option>
                      <option value="50">50</option>
                      <option value="70">70</option>
                      <option value="100">100</option>
                  </select>
          
          
                  <div class="table-responsive">
                      <table class="content-table table" id="table-id">
                          <thead>
                              <tr>
                              <th>USER_NAME</th>
                              <th>USER_EMAIL</th>
                              <th>HOTEL_NAME</th>
                              <th>EVENT_NAME</th>
                              <th>CATERING_NAME</th>
                              <th>PHOTOGRAPHER_NAME</th>
                              <th>DJ_NAME</th>
                              <th>MAKEUPARTIST_NAME</th>
                              <th>DECORATOR_NAME</th>
                              <th>EVENT_DATE</th>
                              <th>EVENT_BOOKED_ON</th>
                              <th>EVENT_START_TIME</th>
                              <th>MAX_TIME_EVENT</th>
                              <th>NO_OF_GUEST</th>
                              <th>STATUS</th>
                              <th>ACTION</th>
                          </tr>
                      </thead>
                           <tbody>
                               <c:forEach var="allbooking" items="${admin_booking}" >
                                  <tr>
                                      <td>${allbooking.user.firstName} ${allbooking.user.lastName}</td>
                                      <td>${allbooking.user.email}</td>
                                      <td>${allbooking.hotel.hotelName}</td>
                                      <td>${allbooking.event.eventname}</td>
                                      <td>${allbooking.catering.catername}</td>
                                      <td>${allbooking.photographer_name_desc}</td>
                                      <td>${allbooking.dj_name_desc}</td>
                                      <td>${allbooking.makeupartist_name_desc}</td>
                                      <td>${allbooking.decorator_name_desc}</td>
                                      <td>${allbooking.event_date}</td>
                                      <td>${allbooking.current_date}</td>
                                      <td>${allbooking.start_at}</td>
                                      <td>${allbooking.max_total_hour} hours</td>
                                      <td>${allbooking.no_of_guest}</td>
                                      <td class="d-flex">
                                        <c:if test = "${allbooking.accept_status==0 && allbooking.payment_status==0}">
                                            <span class="text-muted">Pending</span>
                                        </c:if>
                                        <c:if test = "${allbooking.accept_status==1 && allbooking.payment_status==0}">
                                            <span class="text-muted">Booking Accepted</span>
                                        </c:if>
                                        <c:if test = "${allbooking.accept_status==1 && allbooking.payment_status==1}">
                                            <span class="text-muted">Paid</span>
                                        </c:if>
                                        <c:if test = "${allbooking.accept_status==2 && allbooking.payment_status==0}">
                                            <span class="text-muted">Cancelled by you</span>
                                        </c:if>
                                        <c:if test = "${allbooking.accept_status==3 && allbooking.payment_status==0}">
                                            <span class="text-muted">Cancelled by user</span>
                                        </c:if>
                                      </td>
                                      <td>
                                        <c:if test = "${allbooking.accept_status==0 && allbooking.payment_status==0}">
                                           <div class="d-flex">

                                            <form action="/bookacceptbyadmin" method="POST">
                                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                                <input type="hidden" value="${allbooking.id}" name="booking_id">
                                                <button type="submit" class="btn btn-success  ml-3">Accept</button>
                                            </form>
                                            <form action="/bookcancelbyadmin" method="POST">
                                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                                <input type="hidden" value="${allbooking.id}" name="booking_id">
                                                <button type="submit" class="btn btn-danger ml-3" onclick='return cancelBooking()'>Cancel</button>
                                            </form>
                                           </div>
                                        </c:if>
                                    </td>
                                  </tr>
                              </c:forEach>
                           </tbody>  
                          </table> 
                      </div>
                      
                        <div class='pagination-container mt-2'>
                      <nav>
                          <ul class="pagination">
                             <li class="page-item" style="cursor:pointer;" data-page="prev" ><span class="page-link"> < <span class="sr-only">(current)</span></span></li>
                             <!--	Here the JS Function Will Add the Rows -->
                              <li class="page-item" style="cursor:pointer;"  data-page="next" id="prev"><span class="page-link"> > <span class="sr-only">(current)</span></span></li>
                          </ul>
                      </nav>
                  </div>
              </div>        
          
    
        
                    </div>
                    </div>
                </div>
    
    
        
                
        
    
    
        <jsp:include page="includes/footer.jsp" />  
        <%}%>
        