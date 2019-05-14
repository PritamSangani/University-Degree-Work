void setup()
{
  //declare canvas size
   size(750,750);  
   //draw row of monsters using given parameters
   rowMonsters(50,100,50);
}
//method to draw row of monsters
void rowMonsters(float x,float y,float size)
{
   for(int i=0;i<3;i++)
   {
      monster(x,y,size);
      x=x*2.5;
      size=size*2;
   }
}
//method to draw one monster
void monster(float x,float y,float size)
{
   head(x,y,size);
   face(x,y,size);
}
//method to draw head of monster
void head(float x,float y,float size)
{
   //head
   rectMode(CORNERS);
   fill(0,255,0);
   rect(x,y,x+size,y+(size*1.5)); 
   //triangle on top of head(...hair???)
   float triHeight=size/6;
   line(x+(triHeight*2),y,x+size,y);
   line(x+(triHeight*2),y,x+(triHeight*3),y-triHeight);
   line(x+(triHeight*3),y-triHeight,x+(triHeight*4),y);
}
//method to draw face of monster
void face(float x,float y,float size)
{
   //left eye
   fill(255,255,255);
   ellipse(x+(size/4),y+(size/4),size/3,size/3);
   //left pupil
   fill(0,0,0);
   ellipse(x+(size/3),y+(size/3),size/11,size/11);
   //right eye
   fill(255,255,255);
   ellipse(x+(size/1.3),y+(size/4),size/3,size/3);
   //right pupil
   fill(0,0,0);
   ellipse(x+(size/1.45),y+(size/3),size/11,size/11);
   //nose
   fill(255,0,0);
   ellipse(x+(size/2),y+(size/2),size/6,size/6);
   //left tooth
   float triHeight=size/6;
   line(x,y+size,x+(triHeight*2),y+size);
   line(x,y+size,x+triHeight,y+(triHeight*5));
   line(x+triHeight,y+(triHeight*5),x+(triHeight*2),y+size);
   //line separating teeth
   line(x,y+size,x+size,y+size);
   //right tooth
   line(x+(triHeight*4),y+size,x+size,y+size);
   line(x+(triHeight*4),y+size,x+(triHeight*5),y+(triHeight*5));
   line(x+(triHeight*5),y+(triHeight*5),x+size,y+size); 
}