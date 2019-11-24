package Prac06;

import java.io.Serializable;

public class Prac06_2Bean implements Serializable
{
        private String texture;
	public Prac06_2Bean()
        {
            this.texture = null;
	}
        
	public void setTexture(String texture)
        {
            this.texture = texture;
	}
        
	public String getTexture()
        {
            if(this.texture.equals("chewy"))
            	return "FiveStar, BarOne";
            else
		return "Munch, Kitkat";
	}
}
