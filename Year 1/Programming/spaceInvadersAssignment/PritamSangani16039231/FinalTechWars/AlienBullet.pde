/* --- Bullet class that includes methods to display a bullet, move a bullet and remove a bullet  (for the Alien)--- */

class AlienBullet extends Bullet
{
  //constructor
  AlienBullet(float bulletX, float bulletY)
  {
    super(bulletX, bulletY);
  }
  
  //method to display the bullet
  @Override
  void display()
  {
    //set the weight of the stroke to 2px
    strokeWeight(2);
    //set the stroke colour to the rgb value of 50, 225, 5
    stroke(50, 225, 5);
    //draw a line between the position of bulletX and bulletY AND bulletX and bulletY + 15
    line(bulletX, bulletY, bulletX, bulletY + 15);
  }
  
  //method to move the bullet upwards
  @Override
  void move()
  {
    //move the bullet down the screen by 3px
    bulletY = bulletY + 3;
  }
}