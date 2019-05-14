/*=================================       ALIEN CLASS       ===================================*/ 

class Alien
{
  float aliensX, aliensY; 
  float alienSpeed = 2;
  PImage alien;
  boolean atEdge, isHit;
  
  //constructor
  Alien(float aliensX, int aliensY)
  {
    this.aliensX = aliensX * 50;
    this.aliensY = aliensY * 50;
    alien = loadImage("Images/appleLogo.png");
  }
  
  void render()
  {
    display();
    move();
    checkEdge();
  }
  
  void display()
  {
    image(alien, aliensX, aliensY);
  }
  
  void move()
  {
    aliensX = aliensX + alienSpeed;
  }
  
  void moveDown()
  {
    alienSpeed = alienSpeed * -1;
    aliensY = aliensY + 15;
  }
  
  boolean checkEdge()
  {
    if(aliensX <= 0 || aliensX >= width - 40)
    {
      atEdge = true;
    }
    else
    {
      atEdge = false;
    }
    return atEdge;
  }
  
  boolean isHit(float bulletX, float bulletY)
  {
    if((bulletX >= aliensX && bulletX <= aliensX + 43) && (bulletY >= aliensY && bulletY <= aliensY +49))
    {
      isHit = true;
    }
    else
    {
      isHit = false;
    }
    return isHit;
  }
}