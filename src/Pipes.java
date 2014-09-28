import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

//the y directions of the pipes have a differnce of 325
//the x directions with difference of 550
public class Pipes
{
	int xTop,xBottom, yTop,yBottom, width, height;//rectangle parameters
	int xD;
	
	Rectangle pipeRectTop;
	Rectangle pipeRectBottom;
	
	public Pipes(int xT, int xB, int yT, int yB)
	{
		width = 80;
		height = 225;
		
		xTop = xT;
		xBottom = xB;
		
		yTop = yT;
		yBottom = yB;
		
		//will start of falling due to this statement
		setXDir(Direction.LEFT.getDirection());
		
		//make 2 rectangles one for top and other for bottom
		pipeRectTop = new Rectangle(xTop,yTop,width,height);
		pipeRectBottom = new Rectangle(xBottom,yBottom,width,height);
	}
	
	//is pipe goes out of screen to the left, reset it to the right
	public void resetPosition()
	{
		if(pipeRectTop.x + 120 < 0){
			pipeRectTop.x = 640;
			pipeRectBottom.x = 640;
			
			//randomize the pipes after it goes to the right, before that 
			
			randomizePipes();
			
		}
	}
	
	//this function will randomize the y postion and height of the pipes after reset
	public void randomizePipes()
	{//the pipes will have a differnce of 60 points in the y 
		Random r = new Random();
		int randDif = r.nextInt(60);
		
		
		//choose between moving up or down randomly
		if(r.nextInt(2) == 0){
			pipeRectTop.y += randDif;
			pipeRectBottom.y += randDif;
			
		}
		else{
			pipeRectTop.y -= randDif;
			pipeRectBottom.y -= randDif;
		}
		
		//check if the y potions are too high or low
		if(pipeRectTop.y >= 0){
			pipeRectTop.y -= randDif;
			pipeRectBottom.y -= randDif;
		}
		else if( (pipeRectBottom.y + 25) <= 460){
			pipeRectTop.y += randDif;
			pipeRectBottom.y += randDif;
		} 
	}
	
	
	public void setXDir(int xD)
	{
		this.xD = xD;
	}
	
	public void movePipe()
	{
		resetPosition();
		
		pipeRectTop.x += xD;
		pipeRectBottom.x += xD;
	}

	
	//draw pipes
	public void draw(Graphics g)
	{
		g.setColor(Color.RED);
		g.fillRect(pipeRectTop.x,pipeRectTop.y,pipeRectTop.width,pipeRectTop.height);
		
		g.setColor(Color.RED);
		g.fillRect(pipeRectBottom.x,pipeRectBottom.y,pipeRectBottom.width,pipeRectBottom.height);
	}

}
