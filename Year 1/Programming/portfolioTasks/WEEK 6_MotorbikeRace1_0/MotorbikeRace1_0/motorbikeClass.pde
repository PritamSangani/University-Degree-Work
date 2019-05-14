class motorbike{
    int x = 5;
    int y;
    int speed = 2;
    int size = 30;
    color colour;
   
    motorbike(int y,color col){
       this.y = y;
       this.speed = (int)random(5.0);
       this.colour = col;
    }
    
    void render(){
       float wheelHeight = size/3;
       fill(colour);
       triangle(x,y,x+size,y,x+size/2,y-size/2);
       drawWheel(x,y,wheelHeight);
       drawWheel(x+size,y,wheelHeight);
    }
     
    void drawWheel(int x,int y, float size){
       float inner = size*2/3;
       fill(0);
       ellipse(x,y,size,size);
       fill(255);
       ellipse(x,y,inner,inner);
    }
    
    void move(){
       speed = (int)random(5.0);
       x = x + speed;
    }
    
    void update(){
       if(!finished()){
         move();
         render();
       }
       else{     
         render();  
      }
    }
    
    boolean finished(){
       return x > (width-size); 
    } 
}