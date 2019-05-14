float x= 50;
float y=250;
float size=50;

void setup(){
   size(500,500); 
   snake(x,y,size);
}

void snake(float x,float y,float size){
   for(int i=0; i<8;i++){
      circle(x,y,size);
      size=size*0.9;
      x=x+size;
   }
   
}

void circle(float x, float y, float size){
   ellipse(x,y,size,size); 
}