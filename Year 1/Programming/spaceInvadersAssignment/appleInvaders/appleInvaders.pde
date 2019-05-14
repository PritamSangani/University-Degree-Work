/*=========== RUN CLASS ===========*/

/*====Variable Declarations====*/

PImage startScreenImage;  //background image 
PFont startScreenText;
int screenWidth, screenHeight;

/*== variables for Alien ==*/
Alien [][] alienFleet = new Alien [10][5];  //array of aliens 5 rows by 10 columns
/*== variables for Defender ==*/
Defender android;
ArrayList<Bullet> bullets = new ArrayList<Bullet>();
boolean SPACE;
/*== gameModes ==*/
final int START = 0;
final int INGAME = 1;
final int FINISH = 2;
int gameMode;

void setup()
{ 
  gameMode = START;  // gameMode = START by default when application is opened
  setScreenSize(); //declare size of screen
  startScreen(); //background image and title screen text font declaration
  
  android = new Defender(width * 0.45); //declare instance of a defender
  initialiseArray();    //initialise the array of aliens for use
  println(screenWidth);
  println(screenHeight);
} 

void draw()
{
  if(gameMode == START)  
  {
    displayStartScreen();
    startButton();
  }
  
  else if(gameMode == INGAME)
  {
    boolean xDown = false;
    background(225);
    for (int i = 0; i < alienFleet.length; i++) 
    {
      for(int j = 0; j < alienFleet[0].length; j++)
      {
        if(alienFleet[i][j] != null)
        {
          alienFleet[i][j].render();
          if(alienFleet[i][j].checkEdge())
          {
            xDown = true;  
          }  
        }
      }       
    }
    if(xDown == true)
    {
      moveArrayDown();
    }  
    android.render(); 
    if(SPACE == true)
    {
      for(Bullet counter : bullets)
      {
        counter.render();
      }
    }
    for (int i = 0; i < alienFleet.length; i++) 
    {
      for(int j = 0; j < alienFleet[0].length; j++)
      {
        for(Bullet counter : bullets)
        {
          if(alienFleet[i][j] != null)
          {
            if(alienFleet[i][j].isHit(counter.bulletX, counter.bulletY))
            {
               alienFleet[i][j] = null;
               counter.getRid();
            }
          }
        }
      }       
    }
    for (int i = bullets.size()-1; i >= 0; i--) 
    {
      Bullet d = bullets.get(i);
      if (d.toRemove) 
      {
        bullets.remove(i);
      }
    }
  }
  else if(gameMode == FINISH)
  {
    background(0); 
  }  
}

void mousePressed()
{
  if(gameMode == START && ((mouseX >= 741 && mouseX <= 845) && (mouseY >= 345 && mouseY <= 368)))
  {
    gameMode = INGAME; 
  }
}

void keyPressed()
{
  //splashScreen controls
  
  if(key == ' ' && gameMode == START)  //if SPACE key is pressed and gameMode = START
  {
    gameMode = INGAME;    
  }
  if(key == 'e' && gameMode == INGAME)
  {
    gameMode = FINISH;  
  }
  
  //defender controls
  
  if(keyCode == RIGHT && gameMode == INGAME && android.x < width - 100)
  {
    android.setXDir(1);
  }
  else if(keyCode == LEFT && gameMode == INGAME && android.x > 0)
  {
    android.setXDir(-1);
  }
  if(key == ' ' && gameMode == INGAME)
  {
    SPACE = true;
    bullets.add(new Bullet(android.x + 93, android.y));  
  }
}

void keyReleased() 
{
  if (key != ' ') 
  {
    android.setXDir(0);
  }
}

/* == METHODS USED IN RUN CLASS == */

void initialiseArray()
{
  //initialise 2D array of aliens 
  for (int i = 0; i < alienFleet.length; i++) 
  {
    for(int j = 0; j < alienFleet[0].length; j++)
    {
      alienFleet[i][j] = new Alien(i, j);
    }
  }
}

void setScreenSize()
{
   screenWidth = (int)(displayWidth * 0.8);  //multiply width of device screen by 0.8 and cast to integer type 
   screenHeight = (int)(displayHeight * 0.8);  //multiply height of device screen by 0.8 and cast to integer type 
   surface.setSize(screenWidth, screenHeight);  //declare size of canvas using the two previous calculations of width and height  
}

void startScreen()
{
  startScreenImage = loadImage("Images/appleAndroidFight.png"); //load image from Images folder within the sketch folder
  startScreenImage.resize(width,height);  //resize image so it fills the whole canvas (background for startScreen)
  // font is called AlienEncounters (.vlw font file created within Processing -- Tools > Create Font...)
  startScreenText = loadFont("startScreenTitle.vlw");  //load font from data folder within the sketch folder (title text for startScreen) 
}

void displayStartScreen()
{
  image(startScreenImage,0,0);
  textFont(startScreenText, 60);
  fill(255,0,0);
  text("Tech Wars", (width * 0.55),(height * 0.2));
}

void startButton()
{
  if((mouseX >= (screenWidth * 0.679) && mouseX <= (screenWidth * 0.775)) && (mouseY >= (screenHeight * 0.562) && mouseY <= (screenHeight * 0.599)))
  {
    textFont(startScreenText, 30);
    fill(255, 3, 24);
    text("START", (width * 0.68), (height * 0.6));
  }
  else
  {
    textFont(startScreenText, 30);
    fill(7, 131, 57);
    text("START", (screenWidth * 0.68), (screenHeight * 0.6));
  } 
}

void moveArrayDown()
{
  for(int k = 0; k < alienFleet.length; k++)
  {
    for(int l = 0; l < alienFleet[0].length; l++)
    {
      if(alienFleet[k][l] != null)
      {
         alienFleet[k][l].moveDown();   
      }
    } 
  }
}