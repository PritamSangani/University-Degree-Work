void setup()
{
   size(500,500);
   motorbike(100,200,200);
}

void motorbike(float x, float y, float size)
{
    triangle(x,y,size);
    wheel(x,y,size);        //left wheel
    wheel(x+size,y,size);   //right wheel
}

void triangle(float x, float y, float size)
{
    float triHeight =size/2;
    line(x,y,x+size,y);
    line(x,y,x+triHeight,y-triHeight);
    line(x+triHeight,y-triHeight,x+size,y);
}

void wheel(float x, float y, float size)
{
    float diameter =size/3;
    fill(0,0,0); //black tyre
    ellipse(x,y,diameter,diameter);
    fill(255,255,255); //white hub
    ellipse(x,y,diameter/1.5,diameter/1.5);
    for(int i=0;i<360;i=i+30) 
    {
      line(x,y,x+diameter/2*sin(radians(i)),y+diameter/2*cos(radians(i))); 
    }
}