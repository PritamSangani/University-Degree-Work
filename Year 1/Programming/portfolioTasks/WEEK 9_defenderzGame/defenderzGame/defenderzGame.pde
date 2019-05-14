PImage background;
int x = 0; //global variable background location
Alien alien1;
Defender defender1;

void setup()
{
  size(800,400);
  background = loadImage("spaceBackground.jpg");
  background.resize(width,height);
  
  alien1=new Alien(400,200,-4);
  defender1=new Defender(10,200);
}
void draw ()
{
  backgroundScroll();
  alien1.update();
  
  if(defender1.Crash()==false)
  {
     defender1.render(); 
  }
  if(defender1.Crash())
  {
     defender1=null; 
  }
}


void backgroundScroll()
{
  image(background, x, 0); //draw background twice adjacent
  image(background, x+background.width, 0);
  x -=6;  //scrolls background by x=-4 
  if(x <= -background.width)
  {
    x=0; //wrap background
  }
}

void keyPressed()
{
   if(key==CODED)
   {
     if(keyCode==UP && defender1.y>=10)
     {
       defender1.y=defender1.y-10;
     }
     if(keyCode==DOWN && defender1.y<=height-30)
     {
       defender1.y=defender1.y+10;
     }
   }
}