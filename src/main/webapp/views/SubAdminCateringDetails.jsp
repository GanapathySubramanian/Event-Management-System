<%if (session.getAttribute("Subadmin_email") == null) {response.sendRedirect("/signin"); } else {%> 	
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
                    	<h3 class="text-info">CATERING DETAILS</h3>
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

   

     <form class="d-flex"  action="/subadmincateringSearch"  method="post" autocomplete="off">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<input class="form-control" type="search" name="valueToSearch" placeholder="Value To Search" aria-label="Search" value="${catering_keyword}">
            <button class="btn ml-2 btn-info" type="submit" name="search">Search</button>
        </form>

 <form class="d-flex">
        <button type="button" class="btn btn-info ml-2" name="add_cater" data-toggle="modal" data-target="#AddcaterModal" data-whatever="@mdo">Add cater</button>
    </form>

     <!-- Add User modal -->
     <div class="modal fade" id="AddcaterModal" tabindex="-1" role="dialog" aria-labelledby="AdduserModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Add Cater</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form action="/addcaterForm" modelAttribute="caterForm"  method="POST" enctype= "multipart/form-data">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<input type="hidden" name="superadmin" value="not" />
				<input type="hidden" name="subadmin" value="subadmin" />
                <div class="modal-body">

                    <div class="form-group">
                        <label for="message-text" class="col-form-label">cater Name:</label>
                        <input type="text" class="form-control" placeholder="Cater Name" name="catername" id="catername" required>
                    </div>
                    <div class="form-group">
                        <label for="message-text" class="col-form-label">cater Description</label>
						<textarea class="form-control" name="cater_desc" placeholder="Cater Description" id="cater_desc"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="message-text" class="col-form-label">cater Image:</label>
                        <input type="file" class="form-control" name="cater_img" id="cater_img" required>
                    </div>
                    <div class="form-group">
                        <label for="message-text" class="col-form-label">cater Price:</label>
						<input  class="form-control"  type="text" name="cater_price"  placeholder="Cater Price" id="cater_price" required>
                    </div>
                   
                    <div class="form-group">
                        <label for="message-text" class="col-form-label">cater Location:</label>
						<textarea class="form-control" name="cater_location" placeholder="Cater Location" id="cater_location"></textarea>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-info" name="addcater" >Add cater</button>
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
                    <th>CATER_NAME</th>
                    <th>CATER_DESCRIPTION</th>
                    <th>CATER_IMG</th>
                    <th>CATER_PRICE</th>
                    <th>LOCATION</th>
                    <th>ACTION</th>
                </tr>
            </thead>
                <tbody>
                	 <c:forEach var="allcater" items="${caterlist}" >
			            <tr>
			            <td>${allcater.catername}</td>
			            <td>${allcater.cater_desc}</td>
			           <td ><img src="data:image/jpeg;base64,${allcater.cater_img}" width="100" height="100"/></td>
			            <td>${allcater.cater_price}</td>
			            <td>${allcater.cater_location}</td>
                        <td class="d-flex">
                            <a class="btn btn-info edit" data-toggle="modal" name="edit_cater" data-target="#EditcaterModal" data-whatever="@mdo">EDIT</a>
					         <input type="hidden" value="${allcater.id}" id="edit_id">
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
			 <div class="modal fade" id="EditcaterModal" tabindex="-1" role="dialog" aria-labelledby="AdduserModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Edit User</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<form action="/EditcaterForm" modelAttribute="caterEditForm" method="POST" enctype= "multipart/form-data">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						<input type="hidden" name="subadmin" value="subadmin" />
						<input type="hidden" name="superadmin" value="not" />
						<input type="hidden" name="id" id="cater_id">
						<div class="modal-body">
		
							<div class="modal-body">

								<div class="form-group">
									<label for="message-text" class="col-form-label">cater Name:</label>
									<input type="text" class="form-control" placeholder="caterName" name="catername" id="caterName1" required>
								</div>
								<div class="form-group">
									<label for="message-text" class="col-form-label">cater Description:</label>
									<input type="text" class="form-control" placeholder="caterDesc" name="cater_desc" id="caterDesc1" required>
								</div>
								<div class="form-group">
									<label for="message-text" class="col-form-label">cater price:</label>
									<input type="text" class="form-control"  placeholder="cater price Id" name="cater_price" id="price1" required>
								</div>
								<div class="form-group">
									<label for="message-text" class="col-form-label">Address:</label>
									<textarea class="form-control" name="cater_location" placeholder="cater location" id="location1"></textarea>
								</div>
								<div class="form-group">
                       			 <label for="message-text" class="col-form-label">cater Image:</label>
                     		   <input type="file" class="form-control" name="cater_img" id="caterImg11" >
                  			  </div>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
							<button type="submit" class="btn btn-info" name="Editcater" >Edit cater</button>
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
                    url: "${pageContext.request.contextPath}/caterfind/"+id, //this is my servlet
                    data: "input=" +$('#ip').val()+"&output="+$('#op').val(),
                    success: function(allcater){ 
                    		$('#EditcaterModal #cater_id').val(allcater.id);
                            $('#EditcaterModal #caterName1').val(allcater.catername);
							$('#EditcaterModal #caterDesc1').val(allcater.cater_desc);
							$('#EditcaterModal #location1').val(allcater.cater_location);
							$('#EditcaterModal #price1').val(allcater.cater_price);
							$('#EditcaterModal #caterImg11').val(allcater.cater_img);
							
                    }
                });
            });

        });
    </script>
	
<jsp:include page="includes/footer.jsp" />  
	
<%}%>