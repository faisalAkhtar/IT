package Prac06;

import java.io.IOException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Prac06_2 extends SimpleTagSupport
{
    String texture;
    private Prac06_2Bean prac06_2Bean;

    public Prac06_2() {
        this.prac06_2Bean = new Prac06_2Bean();
    }
    
    public void setTexture(String texture)
    {
        this.texture= texture;
        prac06_2Bean.setTexture(texture);
    }

    @Override
    public void doTag() throws IOException
    {
        JspWriter out= getJspContext().getOut();
        out.println("<br>Texture : " + texture +"<br>");
	out.println("\tNames : " + prac06_2Bean.getTexture());
    }
}
