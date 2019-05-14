int x=10; 
int y=20;

size(200,200); //set size of canvas screen 
for(int i=0;i<10;i=i+1)
//while(x<width-10)
{
  y=y+10;
  print(" i:"+i+",y:"+y); //display variable value in console window
  ellipse(x,y,10,10); 
  line(x,y-5,x,y+5);
  line(x-5,y,x+5,y);
}
  