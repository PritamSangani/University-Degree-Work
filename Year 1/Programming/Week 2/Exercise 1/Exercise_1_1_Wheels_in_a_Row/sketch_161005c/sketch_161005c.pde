int x=10; 
int y=20;

size(200,100); //set size of canvas screen 
//for(int i=5;i>0;i=i-1)
while(x<width)
{
  x=x+10;
  //print(" i:"+i+",x:"+x); //display variable value in console window
  ellipse(x,y,10,10); 
  line(x,y-5,x,y+5);
  line(x-5,y,x+5,y);
}