package Prac06;

import java.io.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Prac06_1 extends SimpleTagSupport
{
    String name;
    String texture;
    public void setName(String name)
    {
        this.name=name;
    }

    @Override
    public void doTag() throws IOException
    {
        JspWriter out = getJspContext().getOut();
        out.println("Hello "+ name);
    }
}
