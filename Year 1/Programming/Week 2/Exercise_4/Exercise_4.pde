//void setup(){
   size(800,700); 
//}

//void draw(){
   float x,y,radius,r,g,b;
   x=10;
   y=40;
   radius=35;
   
   for(int i=0;i<10;i++)
   {     
       for(int j=0;j<10;j++)
       {
           r=random(50);
           g=random(50);
           b=random(50);
           stroke(r*5,g*5,b*5);         
           x=x+70;
           ellipse(x,y,70,70);
             for(int k=0;k<360;k=k+10)
             {
                 line(x,y,x+radius*sin(radians(k)),y+radius*cos(radians(k)));
             }            
      }
     
    x=10;
    y=y+70;
  }
  
//}