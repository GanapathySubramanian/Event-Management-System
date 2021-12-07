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
    <a class="navbar-brand text-info font-weight-bold" ><h3>CATERING LIST</h3></a>

    <form class="d-flex">
        <button type="button" class="btn btn-info ml-2" name="add_cater" data-toggle="modal" data-target="#AddcaterModal" data-whatever="@mdo">Add cater</button>
    </form>


    <form class="d-flex"  action="" method="POST" autocomplete="off">
        <input class="form-control" type="search" name="valueToSearch" placeholder="Value To Search" aria-label="Search">
        <button class="btn ml-2 btn-info" type="submit" name="search">Search</button>
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
                <div class="modal-body">

                    <div class="form-group">
                        <label for="message-text" class="col-form-label">Cater Name:</label>
                        <input type="text" class="form-control" placeholder="Cater Name" name="catername" id="catername" required>
                    </div>
                    <div class="form-group">
                        <label for="message-text" class="col-form-label">cater Description</label>
						<textarea class="form-control" name="cater_desc" placeholder="Hotel Description" id="cater_desc"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="message-text" class="col-form-label">cater Image:</label>
                        <input type="file" class="form-control" name="cater_img" id="cater_img" required>
                    </div>
                    <div class="form-group">
                        <label for="message-text" class="col-form-label">cater Price:</label>
						<input  class="form-control"  type="text" name="cater_price"  placeholder="Hotel Price" id="cater_price" required>
                    </div>
                   
                    <div class="form-group">
                        <label for="message-text" class="col-form-label">cater Location:</label>
						<textarea class="form-control" name="cater_location" placeholder="Hotel Location" id="cater_location"></textarea>
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
                    <th>CATER_IMG1</th>
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
                            <a href="" class="btn btn-info">EDIT</a>
                            <a href="/admindeletecater/${allcater.catername}" class="btn btn-danger ml-2">DELETE</a>
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