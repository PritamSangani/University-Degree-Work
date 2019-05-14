//declare canvas size 
void setup(){
   size(750,750);
}

void draw(){
  //declare variables
    float x,y,size;
    x=375;
    y=150;
    size=80;
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
}