package Prac08;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Prac08 extends SimpleTagSupport
{
    String input;
    
    public void setInput(String input)
    {
        this.input= input;
    }
    
    @Override
    public void doTag( ) throws JspException, IOException
    {
        StringBuilder sb=new StringBuilder(input);  
        sb.reverse();  
        input= sb.toString();  
        JspWriter out=  getJspContext().getOut();
        out.print(input);
    }
    
}
