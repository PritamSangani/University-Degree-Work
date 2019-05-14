float x= 25;
float y=25;
float radius = 20;
for(int i=0;i<360;i=i+10) 
{
  line(x,y,x+radius*sin(radians(i)),y+radius*cos(radians(i))); 
  float r = random(50); //random number [0..50] 
  float g = random(50);
  float b = random(50);
  stroke(r*5,g*5,b*5); //random line colour
}