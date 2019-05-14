//declare variables
float x = 375;
float y = 150;
float size = 100;

void setup()
{
  //declare canvas size 
   size(750,750);
}

void draw()
{
  //draw head
    ellipse(x,y,size,size);
  //draw body
    line(x,y+size/2,x,y+size*3);
  //draw arms
    line(x-size*1.5,y+size*1.5,x+size*1.5,y+size*1.5);
  //draw left leg
    line(x,y+size*3,x-size*1.5,y+size*4.5);
  //draw right leg
    line(x,y+size*3,x+size*1.5,y+size*4.5);
  //draw left eye
    ellipse(x-size/3.75,y-size/6,size/5,size/5);
  //draw right eye
    ellipse(x+size/3.75,y-size/6,size/5,size/5);
  //draw left pupil
    point(x-size/3.75,y-size/6);
  //draw right pupil
    point(x+size/3.75,y-size/6);
  //draw nose
    line(x,y-size/7.5,x,y+size/7.5);
  //draw mouth
    line(x-size/5,y+size/3.75,x+size/5,y+size/3.75);
}