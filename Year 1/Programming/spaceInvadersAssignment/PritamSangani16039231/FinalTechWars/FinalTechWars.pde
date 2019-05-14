/* --- Run Class where all the main code will run --- */

/*--Variable Declarations--*/

/* -- Screens -- */
GUIScreen Screen;

/* -- Defender -- */
Defender android;

/* -- Bullets -- */
ArrayList<DefenderBullet> defenderBulletsList = new ArrayList<DefenderBullet>();
ArrayList<AlienBullet> alienBulletsList = new ArrayList<AlienBullet>();
boolean spacePressed;

boolean aPressed;
/* -- Aliens -- */
int columns = 9;
int rows = 4;
Alien [][] alienFleet;
boolean alienDown = false;

/* -- Variables for the Game -- */
enum gameMode {START, INGAME, GAMEOVER, HIGHSCORES};
gameMode currentMode;
String nameInput = "Enter your Name";
int alienCounter, highScore;

/* -- HighScores -- */
JSONArray scores;
void setup()
{
  //load JSON file into the JSONArray
  scores = loadJSONArray("scores.json");
  JSONObject highscore = scores.getJSONObject(0);
  highScore = highscore.getInt("score");
  //set the gameMode equal to START when game first runs -- SplashScreen
  currentMode = gameMode.START;
  //create an instance of a new GUIScreen object
  Screen = new GUIScreen();
  //set the size of the canvas as defined in the setScreenSize method within the GUIScreen class
  Screen.setScreenSize();
  //create an instance of a new Defender object
  android = new Defender();
  //create an array of Alien objects
  alienFleet = new Alien [columns][rows];
  //initialise the array of Aliens as defined in the initialiseArray method within this class
  initialiseArray();
}

void draw()
{
  switch(currentMode)
  {
    case START:
    {
      //display the Splash Screen as defined in the displayStartScreen method within the GUIScreen class
      Screen.displayStartScreen(); 
    }
    break;
    case INGAME:
    {
       //set the background colour to being at r, g, b value of (225, 225, 225)
      background(225);
      text("Score: " + android.getScore(), 20, 30);
      text("Level: " + android.getLevelNo(), width*0.3, 30);
      text("HighScore: " + highScore, width*0.6, 30);
      text("x " + android.getMultiplier(), 250, 30);
      //render the defender as defined in the render method within the Defender class
      android.render();
      //render the array of Aliens as defined in the renderAlienArray method within this class
      renderAlienArray();
      //if the boolean variable called xDown is equal to true
      if (alienDown == true)
      {
        //move the array of Aliens down as defined in the moveArrayDown method within this class
        moveArrayDown();
      }
      //if the boolean variable spacePressed is equal to true
      if (spacePressed == true)
      {
        //for all DefenderBullet objects in the defenderBulletsList arrayList
        for (DefenderBullet counter : defenderBulletsList)
        {
          //render the bullet as defined in render method within the DefenderBullet class
          counter.render();
        }
      }
      /* 
       call the method to remove defender bullets from the ArrayList if they go off screen or they hit an alien
       - this method is defined in the removeDefenderBullets method within this class
      */
      removeDefenderBullets();
      //if the number of lives left equals 0 
      if(android.getLives() == 0)
      {
        //freeze the screen for 500ms
        delay(500);
        //switch gameMode to FINISH
        currentMode = gameMode.GAMEOVER;
      }
      
      addAlienBullets();
      shootAlienBullets();
      removeAlienBullets();
      //if the number of Aliens equals 0
      if(alienCounter == 0)
      {
        //increment levelNo
        //levelNo++;
        android.setLevelNo(android.getLevelNo() + 1);
        delay(500);
        //create new Alien objects
        initialiseArray();
      }
    }
    break;
    case GAMEOVER:
    {
      Screen.displayGameOverScreen();
    }
    break;
    case HIGHSCORES:
    {
      displayHighScores();
    }
  }  
}

/* -------- Defined Methods -------- */

//method to initalise the array of Aliens 
void initialiseArray()
{
  //set the AlienCounter variable equal to the number of columns * number of rows
  alienCounter = columns * rows;
  //for an integer, i = 0, i is less than the length of the array, where i is incremented by 1 each time the for loop runs
  for (int i = 0; i < alienFleet.length; i++)
  {
    //for an integer, j = 0, j is less than the rows of the array, where j is incremented by 1 each time the for loop runs
    for (int j = 0; j < alienFleet[0].length; j++)
    {
      //create an instance of an Alien object at the index of the i and j value at which the object was initialised
      alienFleet[i][j] = new Alien(i, j);
    }
  }
}

//method to render the array of Aliens
void renderAlienArray()
{
  //for an integer, i = 0, i is less than the length of the array, where i is incremented by 1 each time the for loop runs
  for (int i = 0; i < alienFleet.length; i++)
  {
    //for an integer, j = 0, j is less than the rows of the array, where j is incremented by 1 each time the for loop runs
    for (int j = 0; j < alienFleet[0].length; j++)
    {
      for (DefenderBullet counter : defenderBulletsList)
      {
        //if the alien at the i and j value index is not null
        if (alienFleet[i][j] != null)
        {
          if (alienFleet[i][j].isHit(counter.getBulletX(), counter.getBulletY()))
          {
            //make the alien at the i and j index equal to null (i.e. remove the alien that has been shot)
            alienFleet[i][j] = null;
            //call the method to set the getRidBoolean variable in the Alien class to true
            counter.setGetRidBoolean(true);
            //call the method to increase the score as defined in the increaseScore method within the Defender class
            android.increaseScore(); 
            
            //decrement the alienCounter by 1
            alienCounter--;
          }
        }
      }
      //if the alien at the i and j value index is not null
      if (alienFleet[i][j] != null)
      {
        //render the Alien object at each index of the i and j value as defined in the render method within the Alien class
        alienFleet[i][j].render();
        //if the checkEdge method as defined within the Alien class has been called
        if (alienFleet[i][j].checkEdge())
        {
          //make the boolean variable called alienDown equal to true
          alienDown = true; 
        }
        //if the y-value of the array of Aliens reaches the y value of the height of the canvas - 200
        if (alienFleet[i][j].getAlienY() >= (height - 200))
        {
          //set the gameMode equal to FINISH
          currentMode = gameMode.GAMEOVER;
        }
      }
    }
  }
}

//method called when aliens hit either side of the canvas to move the array of aliens down
void moveArrayDown()
{
  //reset the variable xDown to false so array doesn't keep on moving down
  alienDown = false;
  //for an integer, i = 0, i is less than the length of the array, where i is incremented by 1 each time the for loop runs
  for (int i = 0; i < alienFleet.length; i++)
  {
    //for an integer, j = 0, j is less than the rows of the array, where j is incremented by 1 each time the for loop runs
    for (int j = 0; j < alienFleet[0].length; j++)
    {
      //if the alien at the i and j value index is not null
      if (alienFleet[i][j] != null)
      {
        //call the moveDown method as defined within the Alien class to move the array of aliens down
        alienFleet[i][j].moveDown();
      }
    }
  }
}

//method called when the mouse is pressed
void mousePressed()
{
  //call the mousePressed method as defined within the GUIScreen class
  Screen.mousePressed();
}

//method called when a key is pressed
void keyPressed()
{
  //call the keyPressed method as defined within the Defender class
  android.keyPressed();
  //if the SPACE bar is pressed and the gameMode is set as INGAME
  if (key == ' ' && currentMode == gameMode.INGAME)
  {
    //make the boolean variable spacePressed equal to true (so bullets keep on displaying after they have been shot even if space bar is released)
    spacePressed = true;
    //if the size of the arrayList of bullets is less than or equal to 4
    if (defenderBulletsList.size() <= 3)
    {
      //add a Bullet object at the x value of the Defender + 93 and the y value of the Defender
      defenderBulletsList.add(new DefenderBullet(android.getDefenderX() + 93, android.getDefenderY()));
    }
  }
  //if the gameMode is equal to FINISH
  if(currentMode == gameMode.GAMEOVER)
  {
    //if the backspace key is pressed
    if(keyCode == BACKSPACE)
    {
      //if the length of the string, myText is > 0
      if(nameInput.length() > 0)
      {
        //remove the last letter of the string
        nameInput = nameInput.substring(0, nameInput.length() - 1);
      }
    }
    
    else if (keyCode != SHIFT && keyCode != CONTROL && keyCode != ALT && keyCode != TAB && keyCode != ENTER && keyCode!= RETURN)
    {
      //add the key that has been pressed to the end of the string
      nameInput = nameInput + key;
    }
    else if(keyCode == ENTER || keyCode == RETURN)
    {
      JSONObject score = new JSONObject();
      score.setInt("score", android.getScore());
      score.setString("name",nameInput);
      scores.setJSONObject(10,score);
      bubbleSort();
      saveJSONArray(scores, "data/scores.json");
      delay(500);
      currentMode = gameMode.HIGHSCORES;
    }
  }
}

//method called when a key is released
void keyReleased()
{
  //call the keyReleased method as defined within the Defender class
  android.keyReleased();
}

//method to remove Bullets from the ArrayList of Bullets
void removeDefenderBullets()
{
  /* 
   for an integer, i is equal to the size of the bulletsList - 1, where i is greater than or equal to 0
   and i is decremented by 1 each time the for loop runs
   Decrement through ArrayList so you don't get a NullPointerException if you remove a Bullet before the 
   for loop reaches the end of the ArrayList
   */
  for (int i = defenderBulletsList.size() - 1; i >= 0; i--)
  {
    /* 
     create a variable called index which takes in a DefenderBullet object and equal it to 
     the index of the DefenderBullet object, it is taking in, within the defenderBulletsList ArrayList
     */
    DefenderBullet index = defenderBulletsList.get(i);
    /*
      if the Bullet has triggered the getRemove method in the DefenderBullet class thus equalling the boolean variable 
      toRemove to true
      OR the the y value of the bullet is less than 0
     */
    if (index.getToRemove() || alienCounter == 0)
    {
      //remove the bullet which has the index i from the bulletsList ArrayList
      defenderBulletsList.remove(i);
      android.setMultiplier(android.getMultiplier() + 1);
    }
    else if(index.getBulletY() < 0)
    {
      defenderBulletsList.remove(i);
      android.setMultiplier(1);
    }
  }
}

//method to add bullets to the ArrayList of AlienBullets
void addAlienBullets()
{
  
  //for an integer, i = 0, i is less than the length of the array, where i is incremented by 1 each time the for loop runs
  for(int i = 0; i < alienFleet.length; i++)
  {
    //for an integer, j = 0, j is less than the rows of the array, where j is incremented by 1 each time the for loop runs
    for(int j = 0; j < alienFleet[0].length; j++)
    {
      //if the alien at the i and j value index is not null AND the size of the AlienBullets ArrayList is less than the number of Aliens
      if(alienFleet[i][j] != null && alienBulletsList.size() < (alienFleet.length * alienFleet[0].length))
      { 
        /*
          if the frameCount % 60 equals 0 AND a random number generated between 0 and 100 is less than
          the levelNumber * 1.1
        */
        if(frameCount%60==0 && random(100)<(android.getLevelNo()* 1.1)){
          //add an AlienBullet at the x and y value of the Alien
          alienBulletsList.add(new AlienBullet(alienFleet[i][j].getAlienX()+ 15, alienFleet[i][j].getAlienY() + 10)); 
        }
      }
    }
  }
}

//method to shoot AlienBullets
void shootAlienBullets()
{
  for(AlienBullet count : alienBulletsList)
  {
    count.render();  
    if(android.isHit(count.getBulletX(),count.getBulletY()))
    {
      //use the setter method for setting the lives variable so the number of lives decreases by 1
      android.setLives(android.getLives()-1);
      count.setGetRidBoolean(true);
    }
  }
}

void removeAlienBullets()
{
  for (int i = alienBulletsList.size() - 1; i >= 0; i--)
  {
    /* 
     create a variable called index which takes in a AlienBullet object and equal it to 
     the index of the AlienBullet object, it is taking in, within the alienBulletsList ArrayList
     */
    AlienBullet index = alienBulletsList.get(i);
    /*
      if the Bullet has triggered the getRemove method in the AlienBullet class thus equalling the boolean variable 
      toRemove to true
      OR the the y value of the bullet is greater than the height of the canvas
     */
    if (index.getToRemove() || index.getBulletY() > height)
    {
      //remove the bullet which has the index i from the alienBulletsList ArrayList
      alienBulletsList.remove(i);
    }
  }
}

//bubblesort highscores
void bubbleSort()
{
  boolean swapped = true;
  int j = 0;
  int  score1, score2;
  //while swapped equal to true
  while(swapped)
  {
    //make swapped equal to false
    swapped = false;
    j++;
    for(int i = 0; i < scores.size() - j; i++)
    {
      //create new JSONObject and get the JSONObject at the i index
      JSONObject value = scores.getJSONObject(i);
      //create new JSONObject and get the JSONObject at the i + 1 index
      JSONObject value1 = scores.getJSONObject(i+1);
      //get the score from the JSONObject called value
      score1 = value.getInt("score");
      //get the score from the JSONObject called value1
      score2 = value1.getInt("score");
      //if score2 is greater than score1
      if(score2 > score1)
      {
        //swap the two JSONObjects
        scores.setJSONObject(i,value1);
        scores.setJSONObject(i+1,value);
        swapped = true;
      } 
    }
  }
}

void displayHighScores()
{
  background(225);
  textAlign(CENTER);
  fill(255, 25, 50);
  text("High Scores", width/2, 50);
  int score;
  String name;
  for(int i = 0; i < scores.size(); i++)
  { 
    //create new JSONObject and get the JSONObject at the i index
    JSONObject value = scores.getJSONObject(i);
    //get the score from the JSONObject called value
    score = value.getInt("score");
    //get the name from the JSONObject called value
    name = value.getString("name");
    
    if(score > 0)
    {
      if(android.getScore() == score && nameInput == name)
      {
        fill(225, 50, 50);
      }
      else
      {
        fill(0);
      }
      text(name, width*0.45, (i + 5)*30);
      text(score, width*0.45 + 200, (i+5)*30);
    }
  }
}