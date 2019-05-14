float batY=150;
void setup()
{
   size(500,300); 
}

void draw()
{
   background(0,200,0);
   rect(10,batY,10,30); 
}

void keyPressed()
{
  if(key==CODED)
  {
    if(keyCode==UP&&batY>0)
    {
      batY=batY-5;
    }
    if(keyCode==DOWN&&batY<270)
    {
      batY=batY+5;
    }
  }
}