class Walker
{
   int x; 
   int y; 
   int speedX;
   PImage img1,img2, img3, img4;  //member : instance of a PImage class
   int counter=0;
   int countDir=1;
   
   Walker(int x,int y,int speed){
     this.x=x;
     this.y=y;
     speedX=speed;
     img1 = loadImage("walk1.gif");
     img2 = loadImage("walk2.gif");
     img3 = loadImage("walk3.gif");
     img4 = loadImage("walk4.gif");
   }
   
   void render(){
     
     if(counter*speedX>=0 && counter*speedX<=40){
        image(img1,x,y);
     }
     else if(counter*speedX>40 && counter*speedX<=80){
        image(img2,x,y); 
     }
     else if(counter*speedX>80 && counter*speedX<=120){
        image(img3,x,y);
     }
     else if(counter*speedX>120 && counter*speedX<=160){
        image(img4,x,y); 
     }
     else{
        counter=0; 
     }
     counter=counter+countDir;
   }
   
   void move(){
     x= x + speedX;
     if(x>width){
        x=-img1.width;
     }
   }
   
   void update(){
      move();
      render();
   }
}