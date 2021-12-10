<%if (session.getAttribute("Admin_email") == null) {
    response.sendRedirect("/signin");
     } else {%> 

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
                      <h3 class="text-info">MY ACCOUNT </h3>
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

      <div>
    <form   action="editadminprofile" modelAttribute="adminEditProfile" method="POST" autocomplete="off">
          <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
          <input type="hidden"  name="id" value="${Admin_id}"/>
          <input  type="hidden" name="password" value="${Admin_password}"/>
          <input  type="hidden" name="confirmPassword" value="${Admin_cpassword}"/>
          <input  type="hidden"  name="role" value="${Admin_role}"/>
              <div class="form-group ">
                      <label for="message-text" class="col-form-label">First Name:</label>
                      <input type="text" class="form-control" value="${Admin_firstname}" placeholder="FirstName" name="FirstName" id="f_name" required>
                  </div>
                  <div class="form-group">
                      <label for="message-text" class="col-form-label">Last Name:</label>
                      <input type="text" class="form-control" value="${Admin_lastname}" placeholder="LastName" name="LastName" id="L_Name" required>
                  </div>
                  <div class="form-group">
                      <label for="message-text" class="col-form-label">Email Id:</label>
                      <input type="text" class="form-control" value="${Admin_email}" placeholder="Email Id" name="email" id="email_id" required>
                  </div>
                  <div class="form-group">
                      <label for="message-text" class="col-form-label">Phone Number:</label>
                      <input  class="form-control"  type="tel" name="contactno" value="${Admin_phone}" pattern="[6789][0-9]{9}" placeholder="Phone Number" id="contact" required>
                  </div>
                  <div class="form-group">
                      <label for="message-text" class="col-form-label">Address:</label>
                      <input type="text" class="form-control" value="${Admin_address}" name="Address" placeholder="Address" id="add"/>
                  </div>
                  <div class="form-group">
                      <label for="message-text" class="col-form-label">Gender:</label>
                      <input type="text" id="gen" name="gender" value="${Admin_gender}" class="form-control" required>
                  </div>	
                 <div class="form-group">
                  <button type="submit" class="btn btn-info" name="editAdmin" >EDIT</button>
                  </div>
                   </form>
                  </div>
                 
      </div>
  </div>
  
<jsp:include page="includes/footer.jsp" />  
<%}%>