<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
      <link rel="icon" href="dashboard.png"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Courses</title>


<style>
body {font-family: Arial, Helvetica, sans-serif;}
/*  https://www.w3schools.com/html/tryit.asp?filename=tryhtml_lists_menu */
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: black  ;
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
  <li class= "li-left" ><a href="/DashboardProject/"  style= "color: white;">DashboardProject</a></li>
  
  <li><a href="/DashboardProject/logoutServlet" style= "color: white;">Logout</a>
		<!--   <form action="logoutServlet" method="post">
		     <input type="submit" value="Logout" >
		</form> --> 
  
  </li>
   <li><a href="courses" style= "color: white;">  
					<c:forEach var="cookies" items="${cookie}">						        
					    <c:if test="${cookies.key == 'loginName'}" >					
					 	   <c:out value="${cookies.value.value}"/>					
						</c:if>    
					</c:forEach>     
   </a>
   </li>

 
</ul>
<%	Cookie[] cookies=request.getCookies();
	if(cookies!=null)
	for(Cookie cookie: cookies)
		if(cookie.getName().equals("accountType"))
			if(cookie.getValue().equals("Admin")) {
			%>	
  <c:choose>
      <c:when test = "${courseAll != null}">
      <h1>Courses <img src="dashboard.png"  alt="Dashboard" width="30"  > </h1>
    
    <table>
			    <tr>
			        <th>ID</th>
			        <th>Title</th>
			        <th>Professor</th>
			        <th>Description</th>
			        <th colspan=2>Actions</th>
			    </tr>        
			<c:forEach items="${courseAll}" var="course"> 
				<tr>
					<td>     
			    		${course.id}
			     	</td>
			     	<td>     
			    		${course.title}
			     	</td>
			     	<td>     
			    		${course.professor}
			     	</td>
			     	<td>     
			    		${course.description}
			     	</td>
			     <td>
					 <form action="courses" method="get">
					    <input type="hidden" name="action" value= "delete" /> 
					    <input type="hidden" name="courseID" value= "${course.id}" /> 					    
					    <input type="submit" value="Delete" />
					</form>
				</td>											     
			    </tr>
			</c:forEach>  
			</table>
	<h1>Add a course<img src="dashboard.png"  alt="Dashboard Project" width="30"  > </h1>  
     <form action="course-record" method="post">
      <table>
        <tr><td>Course ID:</td>
            <td><input type="text" name="courseID"/></td>
        </tr>
        <tr><td>Professor:</td>
            <td><input type="text" name="professor"/></td>
        </tr>
        <tr><td>Title:</td>
            <td><input type="text" name="title" /></td>
        </tr>
        <tr><td>Description:</td>
            <td><textarea name="description" rows="5" cols="30"></textarea></td>
        </tr>        
      </table>
      <p>
      	<input type="submit" value="Save" />
      </p>	
    </form>
    <br>      
   </c:when>
   <c:otherwise>
	<hr>
  	<h3 style="color:red;">No courses found</h3>
    <h1>Add a course<img src="dashboard.png"  alt="Dashboard Project" width="30"  > </h1>
   
     <form action="course-record" method="post">
      <table>
        <tr><td>Course ID:</td>
            <td><input type="text" name="courseID"/></td>
        </tr>
        <tr><td>Professor:</td>
            <td><input type="text" name="professor"/></td>
        </tr>
        <tr><td>Title:</td>
            <td><input type="text" name="title" /></td>
        </tr>
        <tr><td>Description:</td>
            <td><textarea name="description" rows="5" cols="30"></textarea></td>
        </tr>        
      </table>
      <p>
      	<input type="submit" value="Save" />
      </p>	
    </form>	  
   </c:otherwise>
</c:choose> 
<%} else { %> 
	<c:choose>
      <c:when test = "${courseAll != null}">
      <h1>Courses <img src="dashboard.png"  alt="Dashboard" width="30"  > </h1>
    
    <table>
			    <tr>
			        <th>ID</th>
			        <th>Title</th>
			        <th>Professor</th>
			        <th>Description</th>
			        <th colspan=2>Actions</th>
			    </tr>        
			<c:forEach items="${courseAll}" var="course"> 
				<tr>
					<td>     
			    		${course.id}
			     	</td>
			     	<td>     
			    		${course.title}
			     	</td>
			     	<td>     
			    		${course.professor}
			     	</td>
			     	<td>     
			    		${course.description}
			     	</td>					     	
			     	<td>						
					 <form action="http://www.ntu.edu.ua/studentam/navchalni-plani/" method="get">
					    <input type="hidden" name="action" value= "view" /> 
					    <input type="hidden" name="courseId" value= "${course.id}" /> 					    
					    <input type="submit" value="View" />
					</form>
					</td> 															     
			    </tr>
			</c:forEach>  
	</table>	 	
	</c:when>
	<c:otherwise>
		  <hr>
   		  <h3 style="color:red;">No Courses found</h3>
   		  <h2> 
   		  		Contact our Support team at +38(097)1811980 or support@example.com <br> 
   		   	    in case there are any issues. We work from 10 AM to 10 PM!
   		  </h2>
    	  <hr>
   	</c:otherwise>
	</c:choose>
<%} %>
</body>
</html>