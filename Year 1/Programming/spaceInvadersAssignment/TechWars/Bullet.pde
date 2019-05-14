/*=================================       BULLET CLASS       ===================================*/ 

class Bullet
{
  float bulletX;
  float bulletY;
  boolean toRemove;
  
  //constructor
  Bullet(float bulletX, float bulletY)
  {
    this.bulletX = bulletX;
    this.bulletY = bulletY;
  }
  
  void render()
  {
    display();
    move();
  }
  
  void display()
  {
    strokeWeight(2);
    stroke(225, 50, 5);
    line(bulletX, bulletY, bulletX, bulletY + 10);
  }
  
  void move()
  {
    bulletY = bulletY - 5;
  }
  
  void getRid()
  {
    toRemove = true;
  }
}