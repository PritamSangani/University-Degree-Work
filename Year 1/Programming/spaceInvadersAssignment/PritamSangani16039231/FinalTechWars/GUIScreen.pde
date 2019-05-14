class GUIScreen
{
  private PImage startScreenImage;
  private PFont startScreenText;
  private int screenWidth, screenHeight;
  
  GUIScreen()
  {
    this.screenWidth = (int)(displayWidth * 0.8);
    this.screenHeight = (int)(displayHeight * 0.8);
    startScreenImage = loadImage("Images/startBackground.png");  
    startScreenText = loadFont("startScreenTitle.vlw");
  }
  //set the screen size equal to the variables declared in the constructor
  void setScreenSize()
  { 
    surface.setSize(screenWidth, screenHeight);
  }
  
  void displayStartScreen()
  {
    startScreenImage.resize(width, height);
    image(startScreenImage,0,0);
    textFont(startScreenText, 60);
    fill(255, 0, 0);
    text("Tech Wars", (width * 0.55), (height * 0.2));
    
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
  
  void displayGameOverScreen()
  {
    textFont(startScreenText, 30);
    //set the background colour to r, g, b value of (125, 125, 125)
    background(125);
    textAlign(CENTER);
    fill(225, 25, 50);
    text("GAME OVER...", width/2, 50);
    //make text size equal to 30px
    textSize(30);
    //align text in the centre of the screen
    textAlign(CENTER, CENTER);
    //make the font colour black
    fill(0);
    //write the string variable nameInput to screen at x values (0, width) and y values (0, height)
    text(nameInput, 0, 0, width, height);
    
  }
  void mousePressed()
  {
    if(currentMode == gameMode.START && (mouseX >= (Screen.screenWidth * 0.679) && mouseX <= (Screen.screenWidth * 0.775)) && (mouseY >= (Screen.screenHeight * 0.562) && mouseY <= (Screen.screenHeight * 0.599)))
    {
      currentMode = gameMode.INGAME;
    }
  }
  
  
}