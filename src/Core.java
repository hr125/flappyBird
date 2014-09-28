 import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
 


public class Core extends JFrame{
	
	
	static FlappyBird fbu;
	
	Image image;
	Graphics doubleBuffer;
	
	public class Mouse extends MouseAdapter{
		@Override
		public void mousePressed(MouseEvent e)
		{
			fbu.bird.mousePressed(e);
		}
	}
	
	
	//constructor for jframe
	public Core() 
	{
        setSize(640,480);
        setResizable(false);
        setTitle("Flappy Bird");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setBackground(Color.BLACK);
         
        addMouseListener(new Mouse());
        
        
        fbu = new FlappyBird();
        
    }
 
	
	//where the execution starts, have contructor then threads
	public static void main(String[] args)
	{
		Core core = new Core();
		
		Thread t1 = new Thread(fbu);
		
		t1.start();
		
	}
	
	//draw and paint classes, it will use double buffering
	@Override
    public void paint(Graphics g)
    {
    	image = createImage(getWidth(),getHeight());
    	
    	doubleBuffer = image.getGraphics();
    	
    	draw(doubleBuffer);
    	g.drawImage(image, 0, 0, this);
    }
    
    public void draw(Graphics g)
    {
    	fbu.bird.draw(g);
    	fbu.pipes.draw(g);
    	fbu.pipes2.draw(g);
    	
    	//draw for the score
    	g.setColor(Color.WHITE);
    	g.drawString(""+ fbu.score, 15, 50);
    	
    	repaint();
    }

}
