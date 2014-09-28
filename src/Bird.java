import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.sql.Date;




public class Bird 
{
	int x, y, width, height;//related to shape and positition of rectangle
	int yD;//the direction it will move in
	
	Rectangle birdRect;
	
	int yPosUpwardStart = 0;
	
	public Bird()
	{
		this.x = 120;
		this.y = 200;
		
		width = height = 20;
		
		
		setYDir(Direction.DOWN.getDirection());
		
		birdRect = new Rectangle(this.x,this.y,width,height);
	}
	
	

	public void setYDir(int yD)
	{
		this.yD = yD;
	}
	
	
	//graphics related
	public void draw(Graphics g)
	{
		g.setColor(Color.CYAN);
		g.fillRect(birdRect.x,birdRect.y,birdRect.width,birdRect.height);
	}
	
	//mouse press stuff
	public void mousePressed(MouseEvent e)
	{
		yPosUpwardStart = birdRect.y;
		setYDir(Direction.UP.getDirection());
	}
	
	//move back down after a certain time going up
	public void moveDown()
	{
		if(yPosUpwardStart - 70 == birdRect.y)
			setYDir(Direction.DOWN.getDirection());
	}
}
