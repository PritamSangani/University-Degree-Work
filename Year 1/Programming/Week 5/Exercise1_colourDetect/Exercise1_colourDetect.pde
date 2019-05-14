//colour reporter
final int RED=0;  //constants :state why these are useful
final int GREEN=1;
final int BLUE=2;
final int YELLOW=3;
final int OTHER=4;

int testColour(color c) 
//highlight the return type (one of the constants), the parameter
{
  if (c==color(255,0,0))    //testing the colour
     return RED;      //returning the correct constant value
  else if (c==color(0,255,0))
    return GREEN;
  else if (c==color(0,0,255))
    return BLUE;
  else if (c==color(255,255,0))
    return YELLOW;
  else
    return OTHER;
}

void setup(){ 
  size(200,100);
}

void draw(){
  color pixel;  //variable of type color (R,G,B)
  
  background(0);
  fill(255,0,0);      //drawing 3 circles red,green & blue
  ellipse(20,50,20,20);
  fill(0,255,0);
  ellipse(50,50,20,20);
  fill(0,0,255);
  ellipse(80,50,20,20);
  fill(255,255,0);
  ellipse(110,50,20,20);
  pixel = get(mouseX,mouseY); //calling get function: takes x,y parameters, returns color
  if (testColour(pixel)==RED)  //calling our function testColour
  {
    fill(255,0,0);
    text("RED",10,10);    //writing text to the screen at 10,10
  }
  else if (testColour(pixel)==GREEN)
  {
    fill(0,255,0);
    text("GREEN",10,10);
  }
   else if (testColour(pixel)==BLUE)
   {
    fill(0,0,255);
    text("BLUE",10,10);
   }
   else if (testColour(pixel)==YELLOW)
   {
    fill(255,255,0);
    text("YELLOW",10,10);
   }
   else
   {
     fill(255);
     text("OTHER",10,10);
   }
}