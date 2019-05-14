class Ball{
  int x,y;
  int speedX, speedY;   //ball members
  color colour;
  
  Ball(int x, int y, int speedHoriz, int speedY, color col ) //constructor
  {
   this.x = x;
   this.y =y;
   speedX = speedHoriz;
   this.speedY = speedY;
   colour = col;
  }
  void move()
  {
    x=x+speedX;
    y =y+speedY; 
  }
  
  void render()
  {
     fill(colour);
     ellipse(x,y,30,30);
  }
}


Ball ball1, ball2; //global variables of type class Ball

void setup()
{
 ball1 = new Ball(50,30,2,0,color(0,255,0)); //call constructors
 ball2 = new Ball(90,60,-1,1, color(0,0,255)); 
 size(500,500);
}

void draw()
{
  ball1.render();
  ball1.move();
  ball2.render();
  ball2.move();
}
