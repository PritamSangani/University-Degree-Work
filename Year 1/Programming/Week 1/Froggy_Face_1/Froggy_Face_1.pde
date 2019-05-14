void setup(){
   size(500,500); 
   background(255);
}

void draw(){
   //face
   fill(0,255,0);//fill face completely green
   ellipse(250,250,250,250);
   //left eye
   fill(255);//fill left eye completely white
   ellipse(180,200,50,50);
   //right eye
   fill(255);//fill right eye completely white
   ellipse(310,200,50,50);
   //left pupil
   point(180,200);
   //right pupil
   point(310,200);
   //nose
   line(245,205,245,300);
   //mouth
   line(180,315,310,315);
}