/*=================================       RUN CLASS       ===================================*/ 

/*===-- VARIABLE DECLARATIONS --===*/

PImage startScreenImage; //startScreen background image
PFont startScreenText; //font for all text on startScreen
int screenWidth, screenHeight; 

/*== --- Variables for Alien --- ==*/
int columns = 9;
int rows = 4;
Alien [][] alienFleet = new Alien [columns][rows]; //2D array of aliens 5 rows by 10 columns

/*== --- Variables for Defender --- ==*/
Defender android;
boolean xDown = false;
ArrayList<Bullet> bullets = new ArrayList<Bullet>();
boolean spacePressed;

/*== --- GameModes --- ==*/
int gameMode;
final int START = 0;
final int INGAME = 1;
final int FINISH = 2;
String[] highScores;

////////////////////////////////////////

void setup()
{
  gameMode = START;
  setScreenSize();
  startScreen();
  
  android = new Defender(width * 0.45);
  initialiseArray();  
  highScores = loadStrings("scores.txt"); 
}

void draw()
{
  println(android.score);
  if(gameMode == START)
  {
    displayStartScreen();
    startButton();
    printArray(highScores);
  }
  
  else if(gameMode == INGAME)
  {
    
    background(205);
    android.render();
    text("Score: " + android.score, 20, 30);
    arrayCode();
    if(xDown == true)
    {
      moveArrayDown();
    }
    if(spacePressed == true)
    {
      for(Bullet counter: bullets)
      {
        counter.render();
      }
    }
    removeBullets();
  }
  else if(gameMode == FINISH)
  {
    background(0);
  }
}

void mousePressed()
{
  if(gameMode == START && (mouseX >= (screenWidth * 0.679) && mouseX <= (screenWidth * 0.775)) && (mouseY >= (screenHeight * 0.562) && mouseY <= (screenHeight * 0.599)))
  {
    gameMode = INGAME;
  }
}

void keyPressed(){
  android.keyPressed();
  if(key == ' ' && gameMode == INGAME)
  {
    spacePressed = true;
    if(bullets.size() <= 2)
    {
      bullets.add(new Bullet(android.x + 93, android.y));
    }
  }
}

void keyReleased()
{
  if(key != ' ')
  {
    android.setXDir(0);
  }
}
    
   
/*== --- Methods used in Run Class --- ==*/

void setScreenSize()
{
  screenWidth = (int)(displayWidth * 0.8); //multiply the width of user's device by 0.8
  screenHeight = (int)(displayHeight * 0.8); //multiply the height of user's device by 0.8
  surface.setSize(screenWidth, screenHeight); //set size of canvas
}

void startScreen()
{
  startScreenImage = loadImage("Images/appleAndroidFight.png"); //load image from Images folder within the main sketch folder
  startScreenImage.resize(width,height); //resize image so fills the whole canvas
  //font is called AlienEncounters (.vlw font file created within Processing -- Tools > Create Font...)
  startScreenText = loadFont("startScreenTitle.vlw"); //load font from data folder within main sketch folder
}

void initialiseArray()
{
  //initialise 2D array of aliens so it can be used
  
  for(int i = 0; i < alienFleet.length; i++)
  {
    for(int j = 0; j < alienFleet[0].length; j++)
    {
      alienFleet[i][j] = new Alien(i, j);
    }
  }
}

void displayStartScreen()
{
  image(startScreenImage, 0, 0);
  textFont(startScreenText, 60);
  fill(255, 0, 0);
  text("Tech Wars", (width * 0.55), (height * 0.2));
}

void startButton()
{
  if((mouseX >= (screenWidth * 0.679) && mouseX <= (screenWidth * 0.775)) && (mouseY >= (screenHeight * 0.562) && mouseY <= (screenHeight * 0.599)))
  {
    textFont(startScreenText, 30);
    fill(255, 3, 24);
    text("START", (width * 0.68), (height* 0.6));
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
  xDown = false;
  for(int i = 0; i < alienFleet.length; i++)
  {
    for(int j = 0; j < alienFleet[0].length; j++)
    {
      if(alienFleet[i][j] != null)
      {
        alienFleet[i][j].moveDown();
      }
    }
  }
}

void arrayCode()
{
  for(int i = 0; i < alienFleet.length; i++)
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
        if(alienFleet[i][j].aliensY >= (height - 200))
        {
          gameMode = FINISH;
        }
      }
    }
  }
}

void removeBullets()
{
  for(int i = bullets.size() - 1; i >= 0; i--)
  {
    Bullet index = bullets.get(i);
    if(index.toRemove)
    {
      bullets.remove(i);
    } 
    if(index.bulletY < 0)
    {
      bullets.remove(i);
    }
  }
}