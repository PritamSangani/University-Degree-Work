void keyPressed(){
  if(key==' ' && gameMode!=RACING && gameOver==false){
     gameMode=RACING;
     bike1.x=10;
     bike2.x=10;
     bike3.x=10;
     winnerText="";
     winner=false;
  }
  
  if(key=='r' && gameOver==true){
     gameMode=START;
     bike1.x=10;
     bike2.x=10;
     bike3.x=10;
     winRed=0;
     winGreen=0;
     winBlue=0;
     loop();
     gameOver=false;
  }
  
  
}