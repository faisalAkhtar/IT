package Prac09;

import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.*;
import java.io.*;
import java.util.Calendar;

public class Prac09 extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException 
   {
       JspWriter out = getJspContext().getOut(); 
        out.print("<br>Today's Date: ");  
        out.print(Calendar.getInstance().getTime());
   }
    
}