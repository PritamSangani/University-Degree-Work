/* --- Alien class that includes methods required for rendering aliens, checking the edge of the screen and checking whether an alien has been hit --- */

class Alien
{
  /*--Variable Declarations--*/
  private float alienX, alienY, alienSpeed;
  private PImage alien, alien1;
  private boolean atEdge;
  private boolean alienDown = false;
  private int counter = 0, countDir = 1;
  //constructor
  Alien(float alienX, float alienY)
  {
    //reference alienX to the variable alienX multiplied by 50
    this.alienX = alienX * 50;
    //reference alienY to the variable alienY multiplied by 50
    this.alienY = alienY * 50;
    //load the image to be used as alien into a variable giving the path of where the image is stored
    alien = loadImage("Images/alien.png");
    alien1 = loadImage("Images/alien1.png");
    this.alienSpeed = 2;
  }
  
  //method to render alien (display, move and checkEdge)
  void render()
  {
    display();
    move();
    checkEdge();
  }
  
  //method to display alien
  void display()
  {
    //display an image stored in the variable called 'alien' at location alienX and alienY which are variables
    if(counter >= 0 && counter < 50)
    {
      image(alien, alienX, alienY);
    }
    else if(counter >= 50 && counter <= 100)
    {
      image(alien1,alienX, alienY);
    }
    else
    {
      counter = 0;
    }
    counter = counter + countDir;
  }
  
  //method to move alien
  void move()
  {
    //add the alienX to the alienSpeed to move horizontally
    alienX = alienX + alienSpeed;
  }
  
  //method to move aliens down when an alien hits an edge
  void moveDown()
  {
    //when alien moves down multiply alienSpeed by -1 so movement switches direction
    alienSpeed = alienSpeed * -1;
    //move aliens down by 15 pixels
    alienY = alienY + 15;
  }
  
  //method to check if an alien has hit an edge of the screen
  boolean checkEdge()
  {
    //if the alienX value is less than or equal to 0 or the alienX value is greater than or equal to the width of the screen - 40
    if(alienX <= 0 || alienX >= width - 40)
    {
      //make the boolean variable called 'atEdge' equal to true
      atEdge = true;
    }
    else
    {
      //make the boolean variable called 'atEdge' equal to false
      atEdge = false;
    }
    //return the value of the variable atEdge
    return atEdge;
  }
  
  //method to check if an alien has been hit by a bullet
  boolean isHit(float bulletX, float bulletY)
  {
    boolean isHit;
    /* 
      if the bulletX value is between the alienX value and the alienX value + 43 AND 
      the bulletY value is between the alienY value and the alienY value + 49 
    */
    if((bulletX >= alienX && bulletX <= alienX + 43) && (bulletY >= alienY && bulletY <= alienY + 49))
    {
      //make the boolean variable called 'isHit' equal to true
      isHit = true;
    }
    else
    {
      //make the boolean variable called 'isHit' equal to false
      isHit = false;
    }
    //return the value of the variable isHit
    return isHit;
  }
  
  //GETTERS
  
  float getAlienX()
  {
    //return the value of the variable alienY
    return alienX;
  } 
  
  float getAlienY()
  {
    //return the value of the variable alienY
    return alienY;
  } 
  float getAlienSpeed()
  {
    return alienSpeed;
  }
  
  boolean getAlienDown()
  {
    return alienDown;
  }
  
  //SETTERS
  void setAlienDown(boolean alienDown)
  {
    //make the parameter in the method equal to the variable alienDown
    this.alienDown = alienDown;
  }
 
  void setAlienSpeed(float alienSpeed)
  {
    this.alienSpeed = alienSpeed;
  }
}