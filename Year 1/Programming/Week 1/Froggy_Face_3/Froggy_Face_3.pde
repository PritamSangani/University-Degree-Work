//moveable and scaleable

void setup(){
   size(500,500); 
   background(255);
}

void draw(){
   //declare variables
   float x,y,size;
   x=280;
   y=275;
   size=375;
   //face
   fill(0,255,0);//fill face completely green
   ellipse(x,y,size,size);
   //left eye
   fill(255);//fill left eye completely white
   ellipse(x-size/4,y-size/5,size/5,size/5);
   //right eye
   fill(255);//fill right eye completely white
   ellipse(x+size/4,y-size/5,size/5,size/5);
   //left pupil
   point(x-size/4,y-size/5);
   //right pupil
   point(x+size/4,y-size/5);
   //nose
   line(x-size/50,y-size/6,x-size/50,y+size/5);
   //mouth
   line(x-size/4,y+size/4,x+size/4,y+size/4);
}