float size=100;
void setup()
{
   size(500,500); 
}

void draw()
{
   size=100; 
   background(180);
   for(int i=0;i<3;i++)
   {
      ellipse(mouseX,mouseY,size,size);
      size=size-40; //<>//
   }    
}