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
                    
                </div>
            </nav>

        <div>
        
    <nav class="navbar navbar-light">
        <a class="navbar-brand text-info font-weight-bold" ><h3>Users List</h3></a>
        
        
        <form class="d-flex">
            <button type="button" class="btn btn-info ml-2" name="add_user" data-toggle="modal" data-target="#AdduserModal" data-whatever="@mdo">Add User</button>
        </form>
		
		<form class="d-flex"  action="" method="POST" autocomplete="off">
            <input class="form-control" type="search" name="valueToSearch" placeholder="Value To Search" aria-label="Search">
            <button class="btn ml-2 btn-info" type="submit" name="search">Search</button>
        </form>
        
        <!-- Add User modal -->
        <div class="modal fade" id="AdduserModal" tabindex="-1" role="dialog" aria-labelledby="AdduserModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Add User</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form action="/adduserForm" modelAttribute="registerForm" method="POST">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		
                <div class="modal-body">

                    <div class="form-group">
                        <label for="message-text" class="col-form-label">First Name:</label>
                        <input type="text" class="form-control" placeholder="FirstName" name="FirstName" id="firstName" required>
                    </div>
                    <div class="form-group">
                        <label for="message-text" class="col-form-label">Last Name:</label>
                        <input type="text" class="form-control" placeholder="LastName" name="LastName" id="lastName" required>
                    </div>
                    <div class="form-group">
                        <label for="message-text" class="col-form-label">Email Id:</label>
                        <input type="text" class="form-control" name="email" placeholder="Email Id"id="email" required>
                    </div>
                    <div class="form-group">
                        <label for="message-text" class="col-form-label">Phone Number:</label>
						<input  class="form-control"  type="tel" name="contactno" pattern="[6789][0-9]{9}" placeholder="Phone Number" id="phoneNumber" required>
                    </div>
                    <div class="form-group">
                        <label for="message-text" class="col-form-label">Address:</label>
						<textarea class="form-control" name="Address" placeholder="Address" id="floatingTextarea"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="message-text" class="col-form-label">Gender:</label>
                        <select id="gender" name="gender" class="form-control" required>
							<option value="">Choose the Gender</option>
							<option value="male">Male</option>
							<option value="female">Female</option>
						</select>
                    </div>
                    <div class="form-group">
                        <label for="message-text" class="col-form-label">Password:</label>
                        <input id="password" type="password" name="password" placeholder="Password" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label for="message-text" class="col-form-label">Confirm Password:</label>
                        <input id="passwordConfirmation" type="password" name="ConfirmPassword" placeholder="Confirm Password" class="form-control" required>
                    </div>
					<div class="form-group">
						<label for="message-text" class="col-form-label">Role</label>
						<select id="job" name="role" class="form-control" required>
							<option value="">Choose the role</option>
							<option value="User">User</option>
							<option value="SubAdmin">SubAdmin</option>
							<option value="SuperAdmin">SuperAdmin</option>
						</select>
					</div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-info" name="adduser" >Add User</button>
                </div>
            </form>
            </div>
        </div>
        </div>


    </nav>


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
		                    
		                    <th>FIRST_NAME</th>
		                    <th>LAST_NAME</th>
		                    <th>EMAIL_ID</th>
		                    <th>GENDER</th>
		                    <th>CONTACT_NO</th>
		                    <th>ADDRESS</th>
		                    <th>ROLE</th>
		                    <th>Action</th>
		                </tr>
		            </thead>
		                <tbody>
		                ${Uselist}
		                	 <c:forEach var="user" items="${Userlist}" >
					            <tr>
					            <td>${user.firstName}</td>
					            <td>${user.lastName}</td>
					            <td>${user.email}</td>
					            <td>${user.gender}</td>
					            <td>${user.contactno}</td>
					            <td>${user.address}</td>
					            <td>${user.role}</td>
					            <td class="d-flex">
					            	<a href="" class="btn btn-info">EDIT</a>
					            	<a href="/admindeleteuser/${user.email}" class="btn btn-danger ml-2">DELETE</a>
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
	
<jsp:include page="includes/footer.jsp" />  