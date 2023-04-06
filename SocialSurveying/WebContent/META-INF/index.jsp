<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
      <link rel="icon" href="mail.png"/>
      <title>MAIL.NET</title>

<!--  https://www.w3schools.com/html/tryit.asp?filename=tryhtml_lists_menu -->
<style>
body {font-family: Arial, Helvetica, sans-serif;}

ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: navy  ;
}
/*
.navbar-left{
  margin-right: 0;
}

.navbar-left li {
     float: left;
}*/

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


</style>

</head>
<body>
<c:choose>
		<c:when test = "${session==null}">
			<ul>
  				<li class="li-left"><a href="/MailLab6/">MAIL.NET</a></li> 
 				<li><a href="/MailLab6/loginServlet">Login</a></li>
 				<li><a href="/MailLab6/registerServlet">Register</a></li>
			</ul>
		</c:when>
		
		<c:otherwise>  
			<ul>
  				<li class= "li-left"><a href="/MailLab6/" style= "color: white;">MAIL.NET</a></li>
  				<li><a href="/MailLab6/logoutServlet" style= "color: white;">Logout</a></li>
  				<li><a href="mails" style= "color: white;">  
					<c:forEach var="cookies" items="${cookie}">
					    <c:if test="${cookies.key == 'login'}" >
					    	<c:out value="${cookies.value.value}"/>
						</c:if>    
					</c:forEach>     
  				    </a>
  				</li>
  
			</ul>
		</c:otherwise>
</c:choose>
</body>
</html>