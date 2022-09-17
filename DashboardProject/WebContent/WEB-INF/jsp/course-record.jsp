<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
      <link rel="icon" href="dashboard.png"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Course Record</title>

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


/**/
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
  <li class= "li-left"><a href="/DashboardProject/" style= "color: white;">DashboardProject</a></li>
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
    <h2> Edit Course Record <img src="dashboard.png"  alt="" width="30"  > </h2>
     <form action="course-record" method="post">
      <table>
          <tr><td>Course ID:</td>
            <td><input type="text" name="courseID" value="<c:out value="${course.id}" />" /></td>
        </tr>		    	      
        <tr><td>title:</td>
            <td><input type="text" name="title" value="<c:out value="${course.title}" />"/></td>
        </tr>
        <tr><td>professor:</td>
            <td><input type="text" name="professor" value="<c:out value="${course.professor}" />" /></td>
        </tr>
        <tr><td>description:</td>
            <td><input type="text" name="description" value="<c:out value="${course.description}" />" /></td>
        </tr>              
      </table>
      <input type="submit" value="Save" />
    </form>
</body>
</html>