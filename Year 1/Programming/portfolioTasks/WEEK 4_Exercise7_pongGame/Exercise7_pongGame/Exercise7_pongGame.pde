/*--Variable Declare--*/
float LbatY=150;
float RbatY=150;
float ballX=250;
float ballY=125;
float deltaX=2;
float deltaY=2;
int Lscore=0;
int Rscore=0;
int Llives=5;
int Rlives=5;
boolean lost=false;

void setup()
{
   size(500,250); 
}

void draw()
{
   background(0);
   /*--Paddle-Left--*/
   rectMode(CORNERS);
   fill(255);
   rect(10,LbatY,20,LbatY+50);
   /*--Paddle-Right--*/
   rectMode(CORNERS);
   fill(255);
   rect(480,RbatY,490,RbatY+50);
   /*--Ball--*/
   fill(255,255,0);
   ellipse(ballX,ballY,10,10);
   ballX=ballX+deltaX;
   ballY=ballY+deltaY;
   /*--collision detector left wall--*/
   if(ballX<=0)
   {
      ballX= 250;
      Lscore=Lscore-1;
      Llives=Llives-1;
   }
   /*--collision detector right wall--*/
   if(ballX>=500)
   {
      ballX=250;
      Rscore=Rscore-1;
      Rlives=Rlives-1;
   } 
   /*--collision detector tob-bottom walls--*/
   if(ballY<=0 || ballY>=250)
   {
      deltaY=-deltaY; 
   }
   /*--collision detector ball-leftpaddle--*/
   if(ballX==20)
   {
     if(ballY>=LbatY && ballY<=(LbatY+50))
     {
       deltaX=-deltaX;
       Lscore=Lscore+1;
     }
   }
   /*--collision detector ball-rightpaddle--*/
   if(ballX==480)
   {
     if(ballY>=RbatY && ballY<=(RbatY+50))
     {
       deltaX=-deltaX;
       Rscore=Rscore+1;
     }
   }   
   /*--game over rules--*/
   if(Llives==0)
   {
      lost=true;
      noLoop();
      textSize(20);
      fill(255,0,0);
      text("Player 2 Won!  Click to Restart",110,125);    
   }
   if(Rlives==0)
   {
      lost=true;
      noLoop();
      textSize(20);
      fill(255,0,0);
      text("Player 1 Won!  Click to Restart",110,125);
   }
   /*--Player 1-2 text--*/
   fill(255,0,0);
   text("Player 1",90,40);
   text("Player 2",350,40);
   /*--dividing line--*/
   stroke(255);
   line(250,0,250,250);
   /*--scoring text--*/
   textSize(14);
   fill(255,0,0);
   text("score="+ Lscore,30,15);
   text("score="+ Rscore,310,15);
   text("Lives Left:"+Llives,105,15);
   text("Lives Left:"+Rlives,390,15);
}
/*--move paddle with keys--*/
void keyPressed()
{
   /*--up-down left paddle--*/
   if(key==CODED)
   {
     if(keyCode==UP&&LbatY>0)
     {
       LbatY=LbatY-10;
     }
     if(keyCode==DOWN&&LbatY<200)
     {
       LbatY=LbatY+10;
     }
   }
   /*--up-down right paddle--*/
   if(key=='w'&&RbatY>0)
   {
     RbatY=RbatY-10;
   }
   if(key=='s'&&RbatY<200)
   {
     RbatY=RbatY+10;
   }
}

/*--click to reset game--*/
void mousePressed()
{
   if(lost==true)
   {
      Rlives= 5;
      Llives= 5;
      Rscore= 0;
      Lscore= 0;
      lost= false;
      loop();
   }
}
