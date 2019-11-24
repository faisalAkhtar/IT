<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       
        <%  
           String n =  request.getParameter("calculate");
           int n1 =  Integer.parseInt(request.getParameter("n1"));
           int n2 =  Integer.parseInt(request.getParameter("n2"));
           if(n.equals("add"))
               out.print(n1+"+"+n2+"="+(n1+n2));
           else if(n.equals("sub"))
               out.print(n1+"-"+n2+"="+(n1-n2));
           else if(n.equals("multiply"))
               out.print(n1+"*"+n2+"="+(n1*n2));
        %>  
    </body>
</html>