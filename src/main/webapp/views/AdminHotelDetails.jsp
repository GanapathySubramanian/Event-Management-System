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
        	AdminHotelDetails
        	
        	${Hotellist}

        	
        	<nav class="navbar navbar-light">
        <a class="navbar-brand text-primary font-weight-bold" href="#"><h3>Hotel List</h3></a>
        <form class="d-flex"  action="" method="POST" autocomplete="off">
            <input class="form-control me-2" type="search" name="valueToSearch" placeholder="Value To Search" aria-label="Search">
            <button class="btn ml-2 btn-primary" type="submit" name="search">Search</button>
        </form>
    </nav>
<label class="text-primary font-weight-bold"> Select No.of.rows to display :</label>
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
                    <th>S.NO</th>
                    <th>HOTEL_NAME</th>
                    <th>HOTEL_DESCRIPTION</th>
                    <th>HOTEL_IMG1</th>
                </tr>
            </thead>
                <tbody>
                	 <c:forEach var="allhotel" items="${Hotellist}" >
			            <tr>
			            <td>${allhotel.Id}</td>
			            <td>${allhotel.hotel_name}</td>
			            <td>${allhotel.hotelDesc}</td>
			            <td>${allhotel.hotelImg1}</td>
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