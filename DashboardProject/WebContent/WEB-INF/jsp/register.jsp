<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
      <link rel="icon" href="dashboard.png"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Record</title>

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
 <li class= "li-left"><a href="/DashboardProject/" style= "color: white;">Dashboard Project</a></li>
  <li><a href="/DashboardProject/" style= "color: white;">Back</a>
		<!--   <form action="logoutServlet" method="post">
		     <input type="submit" value="Logout" >
		</form> --> 
  
  </li>
</ul>

    <h2> <img src="dashboard.png"  alt="Dashboard Project" width="30"> Register Account </h2>
   
     <form action="registerServlet" method="post">
      <table>
        <tr><td></td>
            <td><input type="hidden" readonly="readonly" name="id"/></td>
        </tr>		    	
        <tr><td>login:</td>
            <td><input type="text" name="login"/></td>
        </tr>
        <tr><td>password:</td>
            <td><input type="password" name="pwd"/></td>
        </tr>
        <tr><td>account code:</td>
            <td><input type="text" name="accountcode"/></td>
        </tr>
         <tr><td>Assigned Course ID:</td>
            <td><input type="text" name="assignedCourseID"/></td>
        </tr>
      </table>
      <input type="submit" value="Register" />
    </form>

</body>
</html>