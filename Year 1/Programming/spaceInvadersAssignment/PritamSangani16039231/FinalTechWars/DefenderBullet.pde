/* --- Bullet class that includes methods to display a bullet, move a bullet and remove a bullet  (for the Defender)--- */

class DefenderBullet extends Bullet
{ 
  //constructor
  DefenderBullet(float bulletX, float bulletY)
  {
    super(bulletX, bulletY);
  }
   
  //method to display the bullet
  @Override
  void display()
  {
    //set the weight of the stroke to 2px
    strokeWeight(2);
    //set the stroke colour to the rgb value of 255, 50, 5
    stroke(225, 50, 5);
    //draw a line between the position of bulletX and bulletY AND bulletX and bulletY + 10
    line(bulletX, bulletY, bulletX, bulletY + 10);
  }
  
  //method to move the bullet upwards
  @Override
  void move()
  {
    //move the bullet up the screen by 5px
    bulletY = bulletY - 5;
  }
}