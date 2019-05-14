/* PARENT CLASS TO ALIENBULLET AND DEFENDER BULLET*/
class Bullet
{
  /*--Variable Declarations--*/
  float bulletX, bulletY;
  boolean toRemove;
  
  Bullet(float bulletX, float bulletY)
  {
    //reference bulletX to the variable bulletX
    this.bulletX = bulletX;
    //reference bulletY to the variable bulletY
    this.bulletY = bulletY;
  }
  
  void render()
  {
    display();
    move();
  }
  
  void display()
  {
  }
  
  void move()
  {
  }
  
  //GETTERS
  boolean getToRemove()
  {
    //return the value of the variable toRemove
    return toRemove;
  }
  float getBulletX()
  {
    return bulletX;
  }
  float getBulletY()
  {
    return bulletY;
  }
  
  //SETTERS
  void setGetRidBoolean(boolean toRemove)
  {
    this.toRemove = toRemove;
  }
}