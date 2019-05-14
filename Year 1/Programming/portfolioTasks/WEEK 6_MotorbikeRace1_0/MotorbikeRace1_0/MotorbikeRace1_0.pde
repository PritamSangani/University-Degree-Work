/*===Variable Declaration===*/
final color RED = color(255,0,0);
final color BLUE = color(0,0,255);
final color GREEN = color(0,255,0);
motorbike bike1, bike2, bike3;

final int START=0;
final int RACING=1; 
final int FINISH=2; 
int gameMode;

int winRed = 0;
int winBlue = 0;
int winGreen = 0;
boolean winner=false;
String winnerText = "";
boolean gameOver=false;

void setup()
{
   gameMode=START;
   bike1 = new motorbike(30,RED);
   bike2 = new motorbike(60,GREEN);
   bike3 = new motorbike(90,BLUE);
   size(750,150);
   gameOver=false;
}

void draw()
{
   background(125);
   //when game is at start bikes only rendered on screen and not moving
   if(gameMode==START)
   {
     bike1.render();
     bike2.render();
     bike3.render(); 
     textSize(20);
     text("Press spacebar to start",280,75);
   }
   //if game mode is RACING or FINISHED render and move motorbikes
   if(gameMode!=START)
   {
     bike1.update();
     bike2.update();
     bike3.update();
   }
   //prints on screen the score
   textSize(13);
   text("Red:"+winRed,10,140);
   text("Green:"+winGreen,50,140);
   text("Blue:"+winBlue,105,140);
   //Scoring system
   if(gameMode==RACING)
   {
     if(bike1.finished())
     {
        winRed++;
        gameMode=FINISH;
     }
     else if(bike2.finished())
     {   
        winGreen++; 
        gameMode=FINISH;
     }
     else if(bike3.finished())
     {
        winBlue++;
        gameMode=FINISH;
     }
   }
   //prints which motorbike wins each race in top left corner
   text(winnerText,10,10);
   //system to show which motorbike wins each race equates a string to variable "winnerText"
   if(gameMode==FINISH && winner==false)
   {
     if (bike1.finished())
     {
        winnerText="Red Wins";
     }
     else if(bike2.finished())
     {   
        winnerText="Green Wins";
     }
     else if(bike3.finished())
     {
        winnerText="Blue Wins";
     }
     winner=true;
   }
   //GameOver System
   if(winRed>=5 || winGreen>=5 || winBlue>=5)
   {
      gameOver=true;
      gameMode=FINISH; 
      if(winRed>winBlue)
      {
         if(winRed>winGreen)
         {
            textSize(14);
            text("Red Wins!",300,75); 
         }
      }
      else if(winGreen>winRed)
      {
         if(winGreen>winBlue)
         {
            textSize(14);
            text("Green Wins!",300,75); 
         }
       }
      else
      {
         textSize(14);
         text("Blue Wins!",300,75); 
      }
   }
}