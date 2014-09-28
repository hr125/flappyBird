
public class FlappyBird implements Runnable
{
	 Bird bird;
	 Pipes pipes;
	 Pipes pipes2;
	
	 int score;
	 
	 public FlappyBird()
	 {//the top and bottom have a final DIFFERNCE OF 60
		 bird = new Bird();
	     pipes = new Pipes(350, 350,0,355);
	     pipes2 = new Pipes(750, 750, 30,385);
	     
	     score = 0;
	 }
	 
	 public void addToScore(Pipes p){
		 if(bird.birdRect.x == p.pipeRectBottom.x)
			 score++;
	 }
	 
	 public void detectCollison(Pipes p)
	 {
		 addToScore(p);
		 
		 if(bird.birdRect.intersects(p.pipeRectTop) ||
				 bird.birdRect.intersects(p.pipeRectBottom)){
			 /*bird.birdRect.y = bird.y;
			 p.pipeRectTop.x = p.xTop;
			 p.pipeRectTop.y = p.yTop;
			 p.pipeRectBottom.x = p.xBottom;
			 p.pipeRectBottom.y = p.yBottom;*/
			 score = 0;
		 }
	 }
	 
	 public void moveBird()
		{
		 	bird.moveDown();
		 	
		 	detectCollison(pipes);
		 	detectCollison(pipes2);
		 	
		 	
		 	bird.birdRect.y += bird.yD;
			
			if(bird.birdRect.y <= 35)
				bird.setYDir(Direction.DOWN.getDirection());
			if(bird.birdRect.y >= 460)
				bird.birdRect.y = 460;
				
		}

	 @Override
	 public void run()
		{
			try{
				while(true){
					moveBird();
					pipes.movePipe();
					pipes2.movePipe();
					//this will check if its moving up, if it is make thread sleep faster
					
					
					Thread.sleep(4);
				}
				
			}
			catch(Exception e){
				System.err.println(e.getMessage());
				
			}
		}

	
	 
}
