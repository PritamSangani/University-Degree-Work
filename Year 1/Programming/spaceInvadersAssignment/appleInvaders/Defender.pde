/*=========== DEFENDER CLASS ===========*/

class Defender
{
  PImage Android;
  float x = width * 0.45;
  float y = height * 0.8;
  int xDir;
  
  //constructor
  Defender(float x)
  {
    this.x = x;
    Android = loadImage("Images/android.png");
    Android.resize(100,100);
  }
  
  void render()
  {
    display();
    move();
  }
  void display()
  {
    image(Android, x, y);
  }
  
  void move()
  {
    x = x + xDir * 5;
    if(x <= 0 || x >= width - 100)
    {
      xDir = 0;
    }
  }
  
  void setXDir(int xDir) 
  {
    this.xDir = xDir;
  }
  
}