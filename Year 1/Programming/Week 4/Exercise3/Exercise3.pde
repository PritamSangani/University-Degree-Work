void setup() 
{ 
  size(500, 500); 
} 

void draw() 
{ 
  ellipse(250,250,mouseX,mouseY);
  if(mouseX>=300||mouseY>=300)
  {
    mouseX=300;
    mouseY=300;
  }
}