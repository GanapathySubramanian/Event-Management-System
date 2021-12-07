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
                
            </div>
        </nav>

    <div>
    
<nav class="navbar navbar-light">
    <a class="navbar-brand text-info font-weight-bold" ><h3>HOTEL LIST</h3></a>

    <form class="d-flex">
        <button type="button" class="btn btn-info ml-2" name="add_hotel" data-toggle="modal" data-target="#AddhotelModal" data-whatever="@mdo">Add Hotel</button>
    </form>


    <form class="d-flex"  action="" method="POST" autocomplete="off">
        <input class="form-control" type="search" name="valueToSearch" placeholder="Value To Search" aria-label="Search">
        <button class="btn ml-2 btn-info" type="submit" name="search">Search</button>
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
            <form action="/addhotelForm" modelAttribute="hotelForm" method="POST">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                <div class="modal-body">

                    <div class="form-group">
                        <label for="message-text" class="col-form-label">Hotel Name:</label>
                        <input type="text" class="form-control" placeholder="Hotel Name" name="HotelName" id="hotelName" required>
                    </div>
                    <div class="form-group">
                        <label for="message-text" class="col-form-label">Hotel Description</label>
						<textarea class="form-control" name="HotelDescription" placeholder="Hotel Description" id="HotelDescription"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="message-text" class="col-form-label">Hotel Image:</label>
                        <input type="file" class="form-control" name="HotelImg1" id="HotelImg1" required>
                    </div>
                    <div class="form-group">
                        <label for="message-text" class="col-form-label">Hotel Price:</label>
						<input  class="form-control"  type="text" name="Price"  placeholder="Hotel Price" id="HotelPrice" required>
                    </div>
                   
                    <div class="form-group">
                        <label for="message-text" class="col-form-label">Hotel Location:</label>
						<textarea class="form-control" name="Hotellocation" placeholder="Hotel Location" id="Hotellocation"></textarea>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-info" name="addhotel" >Add Hotel</button>
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
                    <th>HOTEL_NAME</th>
                    <th>HOTEL_DESCRIPTION</th>
                    <th>HOTEL_IMG1</th>
                    <th>HOTEL_PRICE</th>
                    <th>LOCATION</th>
                    <th>ACTION</th>
                </tr>
            </thead>
                <tbody>
                	 <c:forEach var="allhotel" items="${Hotellist}" >
			            <tr>
			            <td>${allhotel.hotelName}</td>
			            <td>${allhotel.hotelDesc}</td>
			            <td>${allhotel.hotelImg1}</td>
			            <td>${allhotel.price}</td>
			                      <td>${allhotel.location}</td>
                        <td class="d-flex">
                            <a href="" class="btn btn-info">EDIT</a>
                            <a href="" class="btn btn-danger ml-2">DELETE</a>
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