void setup(){
    size(600,600);
}
  
void draw(){
  //declare variables
    float x,y,size;
    x=120;
    y=220;  
  //roof
    triangle(x,y,220,120,320,y);
  //building
    rect(x,y,200,200);
  //door
    rect(140,320,60,100);
  //top window
    rect(220,240,80,60);
  //bottom window
    rect(220,320,80,60); 
}