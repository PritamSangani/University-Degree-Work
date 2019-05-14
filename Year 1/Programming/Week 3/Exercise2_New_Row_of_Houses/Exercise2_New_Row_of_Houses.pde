void setup()
{
    size(1500,750);
    drawRow(100,100,100,8);
}

void drawRow(float x,float y,float size, int number)
{
    for(int i=0;i<number;i++)
    {
       house(x,y,size); 
       x=x+size*1;
    }
}

void house(float x,float y,float size)
{
    building(x,y,size);
    roof(x,y,size);
    door(x,y,size);
    windows(x,y,size);
}

void building(float x,float y,float size)
{
    rectMode(CORNERS);
    rect(x,y,x+size,y+size);
}

void roof(float x,float y,float size)
{
    float triHeight=size/2;
    line(x,y,x+size,y);
    line(x,y,x+triHeight,y-triHeight);
    line(x+triHeight,y-triHeight,x+size,y);
}

void door(float x,float y,float size)
{
    rectMode(CORNERS);
    rect(x+(size*0.1),y+size,x+(size*0.4),y+(size/2));
}

void windows(float x,float y,float size)
{
    rectMode(CORNERS);
    rect(x+(size/2),y+(size*0.8),x+(size*0.9),y+(size/2));    //bottom window
    rect(x+(size/2),y+(size*0.4),x+(size*0.9),y+(size*0.1));  //top window
    
    ellipse(x+(size/2),y-(size*0.15),size/5,size/5);
}