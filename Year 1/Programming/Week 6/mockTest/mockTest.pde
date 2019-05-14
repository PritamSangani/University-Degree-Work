float x=0;
float y=0;
float size=50;

void setup(){
   size(500,500); 
   for(int i=0;i<5;i++){
     for(int j=0;j<5;j++){
        square(x,y,size);
        circle(x,y,size);
        x=x+size; 
      }
      x=0;
      y=y+size;
   }
}

void square(float x, float y,float size){
   rectMode(CORNERS);
   rect(x,y,x+size,y+size);
}

void circle(float x,float y,float size){
   ellipse(x+size/2,y+size/2,size/2,size/2); 
}