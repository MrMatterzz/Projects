<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <link rel="icon" href="icons8-survey-100.png"/>
    <title>Social Surveying</title>
    <link rel="stylesheet" type="text/css" href="indexStyle.css" />
</head>
<body>
    <div id="header">
        <ul>
            <li id="name"><a href="#"> <img src="online-computer-survey.png" height="40" style="float:left;"/> SOCIAL SURVEYING</a></li>     
            <li class="li-right"><a id="lgnBtn" href="/SocialSurveying/logoutServlet">Вийти</a></li>    
        </ul> 
    </div>
    <div id="siteBody">
        <div id='leftside'></div>
        <div class="surveyChose" id="infotext">
        <%	Cookie[] cookies=request.getCookies();
			if(cookies!=null)
			for(Cookie cookie: cookies)
				if(cookie.getName().equals("loginName"))
					if(cookie.getValue().equals("Admin")) {
					%>	
		<c:choose>
			<c:when test="${submissionAll != null}">
            <center>
            <p><h1>Submissions</h1></p>
            </center>
            <table>
                <tr>
                	<th>Id</th>
                	<th>Вік</th>
                	<th>Регіон</th>
                	<th>Дата</th>
                	<th class="answerTab">Відповіді</th>
                </tr>
                <c:forEach items="${submissionAll}" var="submission">
                <tr>
                	<td>${submission.submission_ID}</td>
                	<td>${submission.userAge}</td>
                	<td>${submission.userRegion}</td>
                	<td>${submission.submissionDate}</td>
                	<td class="answerTab">${submission.answers}</td>
                </tr>
                </c:forEach>
            </table>
            </c:when>
            <c:otherwise>
            	<hr>
            	<h3 style="color:red;">No submissions found</h3>
            </c:otherwise>
        </c:choose>
        <%} else {%>
        <script>
			document.write("<h1>ACCESS FORBIDDEN</h1>");
		</script>
		<%} %>
        </div>
        <div id='rightside'></div>
    </div>
    <script src="mainPage.js"></script>
</body>