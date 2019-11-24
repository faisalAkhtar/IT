<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       
        <%  
           String str =  request.getParameter("word");
           String choice = request.getParameter("choice");
//           out.print("Output: "+str+"<br>:"+ choice); 
           int i, temp=0;
           if(choice.equals("even"))
               i=1;
           else
               i=0;
           for(; i<str.length(); i+=2)
           {
               char c=str.charAt(i);
//               out.print("<br>"+c+ str.length());
               if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u')
                    temp=1;
               else
               {
                    temp=0;
                    break;
               }
           }
           if(temp==1)
                out.print("<br><h1>You win!!</h1>");
           else
           out.print("<br><h1>You lose</h1>");
        %>  
    </body>
</html>