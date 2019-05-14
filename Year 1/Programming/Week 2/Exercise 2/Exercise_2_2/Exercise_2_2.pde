int x=10; 
int y=20;
int number=1;
int bottom=10;

size(300,500); //set size of canvas screen 
for(int i=0;i<11;i=i+1)
{
  for(int j=0;j<number;j=j+1)
  {
  x=x+20;
 // print(" i:"+i+",x:"+x); //display variable value in console window
  ellipse(x,y,20,20); 
  line(x,y-5,x,y+5);
  line(x-5,y,x+5,y);
  }
  x=10;
  y=y+20;
  number=number+1;
}

for(int k=0;k<11;k++)
{
  for(int l=0;l<bottom;l++)
  {
    x=x+20;
    ellipse(x,y,20,20);
    line(x,y-5,x,y+5);
    line(x-5,y,x+5,y); 
  }  
  x=10;
  y=y+20;
  bottom=bottom-1; 
}
  