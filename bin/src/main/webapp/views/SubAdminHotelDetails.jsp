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
                    	<h3 class="text-info">HOTEL DETAILS</h3>
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
      <form class="d-flex"  action="/subadminhotelSearch"  method="post" autocomplete="off">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<input class="form-control" type="search" name="valueToSearch" placeholder="Value To Search" aria-label="Search" value="${hotel_keyword}">
            <button class="btn ml-2 btn-info" type="submit" name="search">Search</button>
        </form>
    <form class="d-flex">
        <button type="button" class="btn btn-info ml-2" name="add_hotel" data-toggle="modal" data-target="#AddhotelModal" data-whatever="@mdo">Add hotel</button>
    </form>

     <!-- Add User modal -->
     <div class="modal fade" id="AddhotelModal" tabindex="-1" role="dialog" aria-labelledby="AdduserModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Add Hotel</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form action="/addhotelForm" modelAttribute="hotelForm"  method="POST" enctype= "multipart/form-data">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<input type="hidden" name="subadmin" value="subadmin"/>
				<input type="hidden" name="superadmin" value="not"/>
				
                <div class="modal-body">

                    <div class="form-group">
                        <label for="message-text" class="col-form-label">hotel Name:</label>
                        <input type="text" class="form-control" placeholder="Hotel Name" name="hotelName" id="hotelName" required>
                    </div>
                    <div class="form-group">
                        <label for="message-text" class="col-form-label">hotel Description</label>
						<textarea class="form-control" name="hotelDesc" placeholder="Hotel Description" id="hotel_desc"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="message-text" class="col-form-label">hotel Image:</label>
                        <input type="file" class="form-control" name="hotelImg1" id="hotel_img" required>
                    </div>
                    <div class="form-group">
                        <label for="message-text" class="col-form-label">hotel Price:</label>
						<input  class="form-control"  type="text" name="price"  placeholder="Hotel Price" id="hotel_price" required>
                    </div>
                   
                    <div class="form-group">
                        <label for="message-text" class="col-form-label">hotel Location:</label>
						<textarea class="form-control" name="location" placeholder="Hotel Location" id="hotel_location"></textarea>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-info" name="addhotel" >Add hotel</button>
                </div>
            </form>
            </div>
        </div>
        </div>

</nav>

<br/>
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
                    <th>HOTEL_NAME</th>
                    <th>HOTEL_DESCRIPTION</th>
                    <th>HOTEL_IMG</th>
                    <th>HOTEL_PRICE</th>
                    <th>LOCATION</th>
                    <th>ACTION</th>
                </tr>
            </thead>
                <tbody>
                	 <c:forEach var="allhotel" items="${hotellist}" >
			            <tr>
			            <td>${allhotel.hotelName}</td>
			            <td>${fn:substring(allhotel.hotelDesc, 0, 100)}...</td>
			           <td ><img src="data:image/jpeg;base64,${allhotel.hotelImg1}"  class="rounded-circle"width="100" height="100"/></td>
			            <td>${allhotel.price}</td>
			            <td>${allhotel.location}</td>
                        <td class="d-flex">
                            <a class="btn btn-info edit" data-toggle="modal" name="edit_hotel" data-target="#EdithotelModal" data-whatever="@mdo">EDIT</a>
					         <input type="hidden" value="${allhotel.id}" id="edit_id">
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
			 <div class="modal fade" id="EdithotelModal" tabindex="-1" role="dialog" aria-labelledby="AdduserModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Edit User</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<form action="/EdithotelForm" modelAttribute="hotelEditForm" method="POST" enctype= "multipart/form-data">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						<input type="hidden" name="subadmin" value="subadmin"/>
						<input type="hidden" name="superadmin" value="not"/>					
						<input type="hidden" name="id" id="hotel_id">
						<div class="modal-body">
		
							<div class="modal-body">

								<div class="form-group">
									<label for="message-text" class="col-form-label">hotel Name:</label>
									<input type="text" class="form-control" placeholder="hotelName" name="hotelName" id="hotelName1" required>
								</div>
								<div class="form-group">
									<label for="message-text" class="col-form-label">hotel Description:</label>
									<input type="text" class="form-control" placeholder="hotelDesc" name="hotelDesc" id="hotelDesc1" required>
								</div>
								<div class="form-group">
									<label for="message-text" class="col-form-label">hotel price:</label>
									<input type="text" class="form-control"  placeholder="hotel price Id" name="price" id="price1" required>
								</div>
								<div class="form-group">
									<label for="message-text" class="col-form-label">Address:</label>
									<textarea class="form-control" name="location" placeholder="hotel location" id="location1"></textarea>
								</div>
								<div class="form-group">
                       			 <label for="message-text" class="col-form-label">hotel Image:</label>
                     		   <input type="file" class="form-control" name="hotelImg1" id="hotelImg11" >
                  			  </div>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
							<button type="submit" class="btn btn-info" name="Edithotel" >Edit hotel</button>
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
                    url: "${pageContext.request.contextPath}/hotelfind/"+id, //this is my servlet
                    data: "input=" +$('#ip').val()+"&output="+$('#op').val(),
                    success: function(allhotel){ 
                    		$('#EdithotelModal #hotel_id').val(allhotel.id);
                            $('#EdithotelModal #hotelName1').val(allhotel.hotelName);
							$('#EdithotelModal #hotelDesc1').val(allhotel.hotelDesc);
							$('#EdithotelModal #location1').val(allhotel.location);
							$('#EdithotelModal #price1').val(allhotel.price);
							$('#EdithotelModal #hotelImg11').val(allhotel.hotelImg1);
							
                    }
                });
            });

        });
    </script>
	
<jsp:include page="includes/footer.jsp" />  
<%}%>