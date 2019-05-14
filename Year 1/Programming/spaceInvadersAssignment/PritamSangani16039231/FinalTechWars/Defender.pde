/* --- Defender class that includes methods to display, move and a scoring and lives counter --- */

class Defender
{
  /*--Variable Declarations--*/
  private PImage android, livesImage;
  private float x, y;
  private int xDir, score, lives, levelNo, multiplier;
  
  //constructor
  Defender()
  {
    //references x variable with the value of the width of the canvas multiplied by 0.45 (start x value of defender)
    this.x = (width * 0.45);
    //references y variable with the value of the height of the canvas multiplied by 0.8 (start y value of defender)
    this.y = (height * 0.8);
    //references lives variable equal to 5 (start number of lives)
    this.lives = 5;
    //references score variable equal to 0 (game starts with score being 0)
    this.score = 0;
    //load image into a variable called android from the given path (image of defender)
    android = loadImage("Images/android.png");
    //load image into a variable called livesImage from the given path (image being used to display the number of lives left)
    livesImage = loadImage("Images/marshmallow.png");
    this.levelNo = 1;
    this.multiplier = 1;
  }
  
  //method to display and move the defender and render the number of lives left
  void render()
  {
    display();
    move();
    livesCounter();
  }
  
  //method to display defender
  void display()
  {
    //draw the image called 'android' at the current x and y value of the defender
    image(android, x, y);
  }
  
  //method to move defender
  void move()
  {
    //add the current value of xDir to the x variable (if xDir is negative defender is moving left; if xDir is positive defender is moving right)
    x = x + xDir;
    //stop defender going off of the screen (left and right sides)
    if(x < 0 || x > width - 100)
    {
      //set the variable xDir equal to 0 so "x = x + xDir" stays the same value
      xDir = 0;
    }
  }

  //method for scoring
  int increaseScore()
  {
    //add 5 to the score each time this method is called
    score = score + 5 * multiplier;
    //return the value of score
    return score;
  }
  
  //method for lives
  void livesCounter()
  {
    //for the number of lives display the image representing each life
    for(int i = 0; i < lives; i++)
    {
      /* 
        display the image called 'livesImage' for the number of lives at the x value equal to the width of the canvas * 0.7 
        and the y value equal to the height of the canvas * 0.1
      */
      image(livesImage, (width * 0.82) + (i * 35), (height * 0.01 - 10));
    }
  } 
  
  //method for moving defender with keys
  void keyPressed()
  {
    //if the right arrow key is pressed and the gameMode = INGAME and the x value of the defender is less than the width of the canvas - 100
    if(keyCode == RIGHT && currentMode == gameMode.INGAME && x < width - 100)
    {
      //set the value of xDir equal to 1
      setXDir(1);
    }
    //if the left arrow key is pressed and the gameMode = INGAME and the x value of the defender is greater than 0
    if(keyCode == LEFT && currentMode == gameMode.INGAME && x > 0)
    {
      //set the value of xDir equal to -1
      setXDir(-1);
    }
  }
  //method so when keys other than the Space bar are released xDir is set to 0
  void keyReleased()
  {
    //if key not equal to SPACE
    if(key != ' ')
    {
      //set the xDir variable to 0
      setXDir(0);
    }
  }

  boolean isHit(float bulletX, float bulletY)
  {
    boolean isHit;
    /* 
      if the bulletX value is between the defender's x value and the defender's x value + 43 AND 
      the bulletY value is between the alien's y value and the alien's y value + 49 
    */
    if((bulletX >= x && bulletX <= x + 97) && (bulletY >= y && bulletY <= y + 94))
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
  float getDefenderX()
  {
    return x;
  }
  float getDefenderY()
  {
    return y;
  }
  int getScore()
  {
    return score;
  }
  
  int getLives()
  {
    return lives;
  }
  
  int getHighScore()
  {
    return highScore;
  }
  
  int getLevelNo()
  {
    return levelNo;
  }
  
  int getMultiplier()
  {
    return multiplier;
  }
  //SETTERS
  void setLives(int lives)
  {
    this.lives = lives;
  }
  
  //method to set x-direction
  void setXDir(int xDir)
  {
    //reference the variable xDir equal to xDir multiplied by 5
    this.xDir = xDir * 5;
  }
  
  void setScore(int score)
  {
    this.score = score;
  }
  
  void setLevelNo(int levelNo)
  {
    this.levelNo = levelNo;
  }
  
  void setMultiplier(int multiplier)
  {
    this.multiplier = multiplier;
  }
}