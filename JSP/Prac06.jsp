<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@taglib prefix="all" uri="WEB-INF/tlds/Prac06.tld" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
             String name =  request.getParameter("name");
        %>
        <all:hello name="${param.name}"/>
        <all:choco texture="${param.choc}"/>
    </body>
</html>
