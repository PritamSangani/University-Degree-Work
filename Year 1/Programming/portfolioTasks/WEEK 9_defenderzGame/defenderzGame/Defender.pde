class Defender
{
   int x;
   int y;
   
   Defender(int x, int y)
   {
     this.x=x;
     this.y=y;
   }
  
   void render()
   {
     fill(255,0,0);
     rect(x,y,50,20);
     triangle(x+50,y,x+50,y+20,x+60,y+10);
     fill(0,0,100);
     rect(x,y-10,20,10);  
   }
   
   boolean Crash()
   {
     for(int pixelY=y-10; pixelY<=y+20; pixelY++)
     {
       if (get(x+62,y) == ALIEN1 || get(x,y) == ALIEN2)
       {
         return true;
       }
     }
     return false;
   }
}