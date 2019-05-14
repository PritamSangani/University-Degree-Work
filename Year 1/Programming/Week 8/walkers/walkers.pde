Walker img1,img2,img3,img4;

void setup(){
  size(700,1000);
  img1 = new Walker(50,50,1);
  img2 = new Walker(50,250,2);
  img3 = new Walker(50,450,3);
  img4 = new Walker(50,650,2);
}

void draw(){
  background(240);
  img1.update();
  img2.update();
  img3.update();
  img4.update();
}