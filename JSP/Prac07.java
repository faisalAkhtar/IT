package Prac07;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Prac07 extends SimpleTagSupport
{
     String input;
     int start;
     int end;
    
    public void setInput(String input)
    {
        this.input= input;
    }
    
     public void setStart(int start)
    {
        this.start= start;
    }
     
      public void setEnd(int end)
    {
        this.end= end;
    }
    
    @Override
    public void doTag( ) throws JspException, IOException
    {
        JspWriter out=  getJspContext().getOut();
        String output = input.substring(start, end);
        out.print(output);
    }
}
