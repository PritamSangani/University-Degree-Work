int x=10; 
int y=20;
int number=5;

size(200,200); //set size of canvas screen 
for(int i=0;i<5;i=i+1)
{
  for(int j=0;j<number;j=j+1)
  {
  x=x+10;
  print(" i:"+i+",x:"+x); //display variable value in console window
  ellipse(x,y,10,10); 
  line(x,y-5,x,y+5);
  line(x-5,y,x+5,y);
  }
  x=10;
  y=y+10;
  number=number-1;
}
  