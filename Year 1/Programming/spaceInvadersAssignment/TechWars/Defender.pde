/*=================================       DEFENDER CLASS       ===================================*/ 

class Defender
{
  PImage android;
  PImage marshmallow;
  float x;
  float y;
  int xDir;
  int score = 0;
  int lives = 5;
  int livesX = 870;
  int livesY = 2;
  
  //constructor
  Defender(float x)
  {
    this.x = (width * 0.45);
    this.y = (height * 0.8);
    android = loadImage("Images/android.png");
    android.resize(100,100);
    marshmallow = loadImage("Images/marshmallow.png");
    marshmallow.resize(50,50);
  }
  
  void render()
  {
    display();
    move();
    livesCounter();
  }
  
  void display()
  {
    image(android, x, y);
  }
  
  void move()
  {
    x = x + xDir;
    if(x < 0 || x > width - 100)
    {
      xDir = 0;
    }
  }
  
  void setXDir(int xDir)
  {
    this.xDir = xDir * 5;
  }
  
  int score()
  {
    score = score + 5; 
    return score;
  }
  
  void livesCounter()
  {
    for(int i = 0; i < lives; i++)
    {
      image(marshmallow, livesX + (i * 35), livesY);
    }
  }
  void keyPressed()
  {
    if(keyCode == RIGHT && gameMode == INGAME && x < width - 100)
    {
      setXDir(1);
    }
    if(keyCode == LEFT && gameMode == INGAME && x > 0)
    {
      setXDir(-1);
    }
  }
}