<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<link rel="icon" href="house.png"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rooms</title>

<style>
body {font-family: Arial, Helvetica, sans-serif;}
/*  https://www.w3schools.com/html/tryit.asp?filename=tryhtml_lists_menu */
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: DarkGreen  ;
}

li {
    float: right;
}

.li-left {
    float: left;
}

li a {
    display: block;
    color: white;  
    text-align: center;
    padding: 16px;
    text-decoration: none;
}

li a:hover {
    background-color: #111111;
}


/* https://www.w3schools.com/html/html_tables.asp */

table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 50%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
h4 {
    float: right;
}

img {
    float: left;
}

a:link {
    color: #0404B4;
    background-color: transparent;
    text-decoration: none;
}
a:visited {
    color: #0404B4;
    background-color: transparent;
    text-decoration: none;
}
a:hover {
    color: #0404B4;
    background-color: transparent;
    text-decoration: none;
}
a:active {
    color: #0404B4;
    background-color: transparent;
    text-decoration: none;
    }
</style>

</head>
<body>
<ul>
  <li class= "li-left" ><a href="/HouseAccounting/"  style= "color: white;">House Accounting</a></li>
  
  <li><a href="/HouseAccounting/logoutServlet" style= "color: white;">Logout</a>

  </li>
  
    <li><a href="rooms" style= "color: white;">  
					<c:forEach var="cookies" items="${cookie}">						        
					    <c:if test="${cookies.key == 'login'}" >					
					 	   <c:out value="${cookies.value.value}"/>					
						</c:if>    
					</c:forEach>     
   </a>
   </li>
 
</ul>
<%	Cookie[] cookies=request.getCookies();
	if(cookies!=null)
	for(Cookie cookie: cookies)
		if(cookie.getName().equals("role"))
			if(cookie.getValue().equals("admin")) {
			%>			
  		<c:choose>
     		<c:when test = "${roomAll != null}">
      		<h4> <a href="room-record" >NEW ROOM</a> </h4>
      		<h1>Rooms   <img src="house.png"  alt="House Accounting" width="30"  > </h1>
    
    		<table>
			    <tr>
			        <th>ID</th>
			        <th>Number</th>
			        <th>Size</th>
			        <th>Price</th>
			        <th>UserID</th>
			        <th>People</th>
			        <th>Payday</th>
			        <th>Status</th>
			        <th colspan=2>Actions</th>
			    </tr>        
			<c:forEach items="${roomAll}" var="room"> 
				<tr>
					<td>     
			    		${room.id}
			     	</td>
			     	<td>     
			    		${room.number}
			     	</td>
			     	<td>     
			    		${room.size}
			     	</td>
			     	<td>     
			    		${room.price}
			     	</td>
			     	<td>     
			    		${room.userID}
			     	</td>
			     	<td>     
			    		${room.people}
			     	</td>
			     	<td>     
			    		${room.payday}
			     	</td>
			     	<td>     
			    		${room.status}
			     	</td>
			    	<td>	
					<form action="rooms" method="get">
					    <input type="hidden" name="action" value= "edit" /> 
					    <input type="hidden" name="roomId" value= "${room.id}" /> 					    
					    <input type="submit" value="Edit" />
					</form> 
 					</td>
					 <td>		     	
					 <form action="rooms" method="get">
					    <input type="hidden" name="action" value= "delete" /> 
					    <input type="hidden" name="roomId" value= "${room.id}" /> 					    
					    <input type="submit" value="Delete" />
					</form> 
					</td>
			    </tr>
			</c:forEach>  
			</table>
  		 </c:when>
   		 <c:otherwise>
		 <hr>
   		 <h3 style="color:red;">No rooms found</h3>
    	 <hr>
   		 <br>
   		 <h1>Add Room<img src="house.png"  alt="House Accounting" width="30"  > </h1>
    		 <form action="room-record" method="post">
    		  <table>
      		   <tr><td>number:</td>
       		       <td><input type="text" name="number"/></td>
      		   </tr>
     		   <tr><td>size:</td>
      		       <td><input type="text" name="size"/></td>
     		   </tr>
     		   <tr><td>price:</td>
      		       <td><input type="text" name="price"/></td>
      		   </tr>
     		   <tr><td>userID:</td>
     		       <td><input type="text" name="userID"/></td>
     		   </tr>
     		   <tr><td>people:</td>
     		       <td><input type="text" name="people"/></td>
    		   </tr>
       		   <tr><td>payday:</td>
       		       <td><input type="text" name="payday"/></td>
       		   </tr>
      		   <tr><td>status:</td>
        		   <td><input type="text" name="status"/></td>
       		   </tr>
      		  </table>
      		  <p>
      			<input type="submit" value="Save" />
    		  </p>
   			 </form>
   		 </c:otherwise>
		</c:choose>
<% } else { %>
		<c:choose>
     	 <c:when test = "${roomAll != null}">
      		<h1>Rooms   <img src="house.png"  alt="House Accounting" width="30"  > </h1>
    		<table>
			    <tr>
			        <th>ID</th>
			        <th>Number</th>
			        <th>Size</th>
			        <th>Price</th>
			        <th>UserID</th>
			        <th>People</th>
			        <th>Payday</th>
			        <th>Status</th>
			    </tr>        
			<c:forEach items="${roomAll}" var="room"> 
				<tr>
					<td>     
			    		${room.id}
			     	</td>
			     	<td>     
			    		${room.number}
			     	</td>
			     	<td>     
			    		${room.size}
			     	</td>
			     	<td>     
			    		${room.price}
			     	</td>
			     	<td>     
			    		${room.userID}
			     	</td>
			     	<td>     
			    		${room.people}
			     	</td>
			     	<td>     
			    		${room.payday}
			     	</td>
			     	<td>     
			    		${room.status}
			     	</td>
			    </tr>
			</c:forEach>  
			</table>
  		 </c:when>
   		 <c:otherwise>
		  <hr>
   		  <h3 style="color:red;">No rooms found</h3>
    	  <hr>
   		  <br>
   		 </c:otherwise>
   		</c:choose>
<% } %>
</body>
</html>