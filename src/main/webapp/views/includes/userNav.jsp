
 <div class="wrapper">
        <!-- Sidebar  -->
        <nav id="sidebar" class="bg-dark">
            <div class="sidebar-header bg-dark">
                <h3>User</h3>
                <h3 class="text-white"><%= session.getAttribute("username") %></h3>
            </div>

            <ul class="list-unstyled components">
                <p></p>
                <!-- 
                	<li class="active">
                    <a href="#homeSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Home</a>
                    <ul class="collapse list-unstyled" id="homeSubmenu">
                        <li>
                            <a href="#">Home 1</a>
                        </li>
                        <li>
                            <a href="#">Home 2</a>
                        </li>
                        <li>
                            <a href="#">Home 3</a>
                        </li>
                    </ul>
                </li>
                 -->
                  <li>
                    <a href="/userhome">Dashboard</a>
                </li>
                <li>
                    <a href="/userhoteldetails">Hotels</a>
                </li>
                 <li>
                    <a href="/usereventdetails">Events</a>
                </li>
                <li>
                    <a href="/usercateringdetails">Catering</a>
                </li>
                <li>
                    <a href="/uservendordetails">Vendor</a>
                </li>
                <li>
                    <a href="/usernewbooking">New Booking</a>
                </li>
                <li>
                    <a href="/userbookingdetails">My Bookings</a>
                </li>
             </ul>

           <ul class="list-unstyled CTAs">
                <li>
                    <a href="/useraccount" class="download">Accounts</a>
                </li>
                <li>
                    <a href="/logout" class="article">Logout</a>
                </li>
            </ul>
        </nav>

    
    