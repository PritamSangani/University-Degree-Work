//EtchySketch
//arrow keys to draw
float x,y;
float deltaX = 0;
float deltaY = -1;

final int CRASHED=0;
final int OK=1;
int gameMode=OK;

float explosionSize;
void setup(){
  size(500,500);
  initialState();
  stroke(255,0,0); //pen red
}

void initialState()
{
  background(0); //background black
  x=200;
  y=200;
  gameMode=OK;
}
void draw(){
  if (gameMode==OK)
  {
    if (crash(x,y))
    {
      initialState();
      gameMode=CRASHED;
      explosionSize=1;
    }
      point(x,y); //draw a point at current (x,y)
      x = x + deltaX;
      y = y + deltaY;
  }
  else //gameMode==CRASHED
  {
    ellipse(x,y,explosionSize,explosionSize); 
    explosionSize=explosionSize+1;
    if (explosionSize>300)
      initialState();
  }
}
void keyPressed(){
if(key == CODED)
 {
 if (keyCode == UP){ //restrict to screen edge
   deltaY = -1;
   deltaX = 0;
 }
 else if(keyCode == DOWN){
   deltaY = 1;
   deltaX = 0;
 }
 else if (keyCode == LEFT){
   deltaY = 0;
   deltaX = -1;
 }
 else if (keyCode == RIGHT){
   deltaY = 0;
   deltaX = 1;
 }
 }
}

boolean crash(float x, float y)
{
color col=get((int)x,(int)y); //get colour of the next position
if (col==color(0,0,0)) //check if colour is background colour, e.g. black
  return false;
 else
  return true;
}