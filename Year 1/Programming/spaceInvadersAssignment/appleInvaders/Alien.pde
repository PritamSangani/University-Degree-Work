/*=========== ALIEN CLASS ===========*/


class Alien
{
  float aliensX;  
  float aliensY;
  float alienSpeed = 2;
  PImage invader;
  boolean atEdge;
  boolean isHit;
  
  //constructor
  Alien(float aliensX, int aliensY)
  {
    this.aliensX = aliensX * 50;
    this.aliensY = aliensY * 50;
    invader = loadImage("Images/appleLogo.png");
  }
  
  //methods required for alien class
  void render()
  {
    display();
    move(); 
    //moveDown();
    checkEdge();
  }
  
  //method to draw aliens
  void display()
  {
    image(invader, aliensX, aliensY);
  }
  
  //method to move alien
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
    if(aliensX <=0  || aliensX >= width - 40)
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
    if((bulletX >= aliensX && bulletX <= aliensX + 43) && (bulletY >= aliensY && bulletY <= aliensY + 49))
    {
      isHit = true;   
    }
    else
    {
      isHit =  false;
    }
    return isHit;
  }
}