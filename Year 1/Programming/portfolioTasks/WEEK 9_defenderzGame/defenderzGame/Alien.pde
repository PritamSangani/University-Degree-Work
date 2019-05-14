final color ALIEN1 = color(0,255,0);
final color ALIEN2 = color(50,100,0);

class Alien
{
  int y;
  int x;
  int speed;
  int speedY=1;
  
   Alien(int x, int y, int speed)
   {
     this.x=x;
     this.y=y;
     this.speed=speed;
   }
    
   void update()
   {
     render();
     move();
   }
   
   void render()
   {
     fill(ALIEN1);
     ellipse(x,y,30,30);
     fill(ALIEN2);
     ellipse(x,y,50,15);  
   }
   
   void move()
   {
     float r= random(0,100);
     if(r<=10 && x>=0)
     {
        speedY=-speedY; 
     }
     if(x<-30)
     {
        x=width+400; 
     }
     if(y<10 || y>height-10)
     {
        speedY=-speedY; 
     }
     x=x+speed;
     y=y+speedY; 
   } 
}