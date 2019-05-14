//moveable

void setup(){
   size(500,500); 
   background(255);
}

void draw(){
   //declare variables
   float x,y;
   x=400;
   y=275;
   //face
   fill(0,255,0);//fill face completely green
   ellipse(x,y,250,250);
   //left eye
   fill(255);//fill left eye completely white
   ellipse(x-70,y-50,50,50);
   //right eye
   fill(255);//fill right eye completely white
   ellipse(x+60,y-50,50,50);
   //left pupil
   point(x-70,y-50);
   //right pupil
   point(x+60,y-50);
   //nose
   line(x-5,y-45,x-5,y+50);
   //mouth
   line(x-70,y+65,x+60,y+65);
}