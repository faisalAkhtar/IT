<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%  
           out.print("<h2>Using scriptlet tags</h2>");
           String n =  request.getParameter("n");
           out.print("Input Given: "+n+"<br>");
           for(int i=0;i<Integer.parseInt(n);i++)
           {
               for(int j=0;j<=i;j++)
                   out.print(j+1+" ");
               out.print("<br>");
           }
           out.print("<h2>Using c:forEach tags</h2>");
        %>

        <c:forEach var = "i" begin = "1" end ="${param.n}">
            <c:forEach var = "j" begin = "1" end ="${i}">
                ${j}
            </c:forEach>
         <br>
        </c:forEach>
    </body>
</html>