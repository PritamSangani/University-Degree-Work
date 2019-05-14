import processing.core.*;
public class TestSketch extends PApplet{
	class Walker { 
		   int x; 
		   int y;
		   int velocityX;  
		   int counter = 0;
		   PImage sequence1,sequence2,sequence3,sequence4;
		   
		   Walker(int x, int y, int dx)
		   {
		     this.x = x;
		     this.y = y;
		     this.velocityX=dx;
		     sequence1 = loadImage("walk1.gif");
		     sequence2 = loadImage("walk2.gif");
		     sequence3 = loadImage("walk3.gif");
		     sequence4 = loadImage("walk4.gif");
		   }
		   
		   void update()
		   {
		     render();
		     move();
		   }
		   
		   void render()
		   {
		      if (counter<10)
		      {
		        image(sequence1,x,y);
		      }
		      else if (counter<20)
		      {
		        image(sequence2,x,y);
		      }
		      else if (counter<30)
		      {
		        image(sequence3,x,y);
		      }
		      else if (counter<40)
		      {
		        image(sequence4,x,y);
		      }
		      else 
		      {
		        counter=0; 
		      }
		      counter = counter+1;
		   }
		   
		   boolean reachedEdge()
		   {
		     return this.x>=width;
		   }
		   
		 void move()
		 {
		   if (reachedEdge())
		     x=0;
		   else
		     x = x+velocityX;
		 }
		} 

		Walker walter, wanda;

		public void setup()
		{
		   size(500,500);
		   walter = new Walker(10,100,3);
		   wanda= new Walker(10,150,5);
		  
		}

		public void draw()
		{
		  background(255);
		  walter.update();
		  wanda.update();
		}
}
