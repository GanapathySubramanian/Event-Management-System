<%if (session.getAttribute("Subadmin_email") == null) {response.sendRedirect("/signin"); } else {%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  

<jsp:include page="includes/header.jsp" />  
	
<jsp:include page="includes/subadminNav.jsp" />  


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
                    	<% if(session.getAttribute("Subadmin_gender").equals("male")){ %> 
                    		Mr.
                    	<%}else{%> 
                    		Miss.
                    	<%}%> 
                    	<span class="font-weight-bold text-info">${Subadmin_firstname} ${Subadmin_lastname}</span></p>
                    </div>
                </div>
            </nav>

    <div>
    
<nav class="d-flex justify-content-between">

   
  		<form class="d-flex"  action="/subadmineventSearch"  method="post" autocomplete="off">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<input class="form-control" type="search" name="valueToSearch" placeholder="Value To Search" aria-label="Search" value="${event_keyword}">
            <button class="btn ml-2 btn-info" type="submit" name="search">Search</button>
        </form>
	
    <form class="d-flex">
        <button type="button" class="btn btn-info ml-2" name="add_event" data-toggle="modal" data-target="#AddeventModal" data-whatever="@mdo">Add event</button>
    </form>
	

     <!-- Add User modal -->
     <div class="modal fade" id="AddeventModal" tabindex="-1" role="dialog" aria-labelledby="AdduserModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Add event</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form action="/addeventForm" modelAttribute="eventForm"  method="POST" enctype= "multipart/form-data">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<input type="hidden" name="superadmin" value="not"/>
				<input type="hidden" name="subadmin" value="subadmin" />
                <div class="modal-body">

                    <div class="form-group">
                        <label for="message-text" class="col-form-label">event Name:</label>
                        <input type="text" class="form-control" placeholder="event Name" name="eventname" id="eventname" required>
                    </div>
                    <div class="form-group">
                        <label for="message-text" class="col-form-label">event Description</label>
						<textarea class="form-control" name="event_desc" placeholder="Event Description" id="event_desc"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="message-text" class="col-form-label">event Image:</label>
                        <input type="file" class="form-control" name="event_img" id="event_img" required>
                    
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-info" name="addevent" >Add event</button>
                </div>
            </form>
            </div>
        </div>
        </div>

</nav>

<br />
<br/>
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
                    <th>EVENT_NAME</th>
                    <th>EVENT_DESCRIPTION</th>
                    <th>EVENT_IMG</th>
                    <th>ACTION</th>
                </tr>
            </thead>
                <tbody>
                	 <c:forEach var="allevent" items="${eventlist}" >
			            <tr>
			            <td>${allevent.eventname}</td>
			            <td>${fn:substring(allevent.event_desc, 0, 100)}...</td>
			           <td ><img src="data:image/jpeg;base64,${allevent.event_img}"class="rounded-circle" width="100" height="100"/></td>
                        <td class="d-flex">
                            <a class="btn btn-info edit" data-toggle="modal" name="edit_event" data-target="#EditeventModal" data-whatever="@mdo">EDIT</a>
					         <input type="hidden" value="${allevent.id}" id="edit_id">
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
     <!-- Edit User modal -->
			 <div class="modal fade" id="EditeventModal" tabindex="-1" role="dialog" aria-labelledby="AdduserModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Edit User</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<form action="/EditeventForm" modelAttribute="eventEditForm" method="POST" enctype= "multipart/form-data">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						<input type="hidden" name="superadmin" value="not"/>
						<input type="hidden" name="subadmin" value="subadmin" />
						
						<input type="hidden" name="id" id="event_id">
						<div class="modal-body">
		
							<div class="modal-body">

								<div class="form-group">
									<label for="message-text" class="col-form-label">event Name:</label>
									<input type="text" class="form-control" placeholder="eventName" name="eventname" id="eventName1" required>
								</div>
								<div class="form-group">
									<label for="message-text" class="col-form-label">event Description:</label>
									<input type="text" class="form-control" placeholder="eventDesc" name="event_desc" id="eventDesc1" required>
								</div>
								
								<div class="form-group">
                       			 <label for="message-text" class="col-form-label">event Image:</label>
                     		   <input type="file" class="form-control" name="event_img" id="eventImg11" >
                  			  </div>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
							<button type="submit" class="btn btn-info" name="Editevent" >Edit event</button>
						</div>
					</form>
					</div>
				</div>
				</div>
				
				
	<script type="text/javascript">
        $(document).ready(function() {
            $('table .edit').click(function ()
            {
				var id=$(this).parent().find('#edit_id').val();

				console.log(id)
                $.ajax({
                    type: "GET",
                    url: "${pageContext.request.contextPath}/eventfind/"+id, //this is my servlet
                    data: "input=" +$('#ip').val()+"&output="+$('#op').val(),
                    success: function(allevent){ 
                    		$('#EditeventModal #event_id').val(allevent.id);
                            $('#EditeventModal #eventName1').val(allevent.eventname);
							$('#EditeventModal #eventDesc1').val(allevent.event_desc);
							$('#EditeventModal #eventImg11').val(allevent.event_img);
							
                    }
                });
            });

        });
    </script>
    
<jsp:include page="includes/footer.jsp" />  
<%}%>