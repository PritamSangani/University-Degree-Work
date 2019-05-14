//Global variables
int x,y; //ball x position
 //ball y position
int deltaX = 3; //ball x direction is right, step 5
int deltaY=2;
void setup() //runs once at start
{
   size(500,250);
}
void draw() //runs repeatedly
{
   background(200); //clear screen RGB = 200 (grey)
  //draw and update ball position
   ellipse(x,y,10,10);
   x = x + deltaX; //move ball x right
   y = y + deltaY; //move ball y down

 //Collision Detection
 //collide right hand edge?
 if (x>=500||x<=0)
   deltaX = -deltaX; //reverse x direction
 //collide left hand edge?
  
 //collide top edge?
 if (y<=0||y>=250)
   deltaY=-deltaY;
 //collide bottom edge?
}