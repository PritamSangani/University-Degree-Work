// Draughts game

public class DraughtsBoard { 

	final int BLANK = 0;
    final int BLACK = 1;
    final int WHITE = 2;
    	
	int Xsize   = 8;
	int Ysize   = 8;
	int [][] Board = new int[Xsize][Ysize];
	
	public DraughtsBoard()
	{
		int Place = BLANK;
		int Row, Column;
		
		for (Row = 0; Row < Ysize; Row++) 
		{
	    	for (Column = 0; Column < Xsize; Column++) 
			{
				if (Row <= 2) // Black
				{
					if (Row == 0 || Row == 2)
					{	
						if (Column % 2 == 1) // Odd columns
							Place = BLACK;
						else
							Place = BLANK;	
					}
					else if (Row == 1) // Row 1
					{
						if (Column % 2 == 0) // Even columns
							Place = BLACK;
						else
							Place = BLANK;
					}
				}
				else
				if (Row >= 5) // White
				{
					if (Row == 5 || Row == 7)
					{
						if (Column % 2 == 0) // Even columns
							Place = WHITE;
						else
							Place = BLANK;
					}
					else if (Row == 6) // Row 6
					{
						if (Column % 2 == 1) // Even columns
							Place = WHITE;
						else
							Place = BLANK;
					}
				}
				else
					Place = BLANK;
				
				Board[Column][Row] = Place;
			}	
		}
	}
	
	public int checkMove(int startX, int startY, int endX, int endY)
	{
		//keep pieces on board
		//if end x is less than or greater than the bounds of the array
		//if end y is less than or greater than bounds of the array
		if(endX < 0 || endX > 7 || endY < 0 || endY > 7 )
		{
			return 0;
		}
		//CHECK BLACK MOVE
		//check start is black and destination is blank
		//AND the destination is on the diagonal
		if(Board[startX][startY] == BLACK && Board[endX][endY] == BLANK)
		{
			if(((startX - endX) == 1 || (startX - endX) == -1) && ((startY - endY == -1)))
			{
				//VALID
				return 1;
			}
			else if(((startX - endX) == 2 || (startX - endX) == -2) && ((startY - endY == -2)))
			{
				if(Board[startX-1][startY+1] == WHITE || Board[startX+1][startY+1] == WHITE)
				{
					return 2;
				}
				else
				{
					return 0;
				}
			}
			else
			{
				return 0;
			}
		}

		//CHECK WHITE MOVE
		else if(Board[startX][startY] == WHITE && Board[endX][endY] == BLANK)
		{
			if(((startX - endX) == 1 || (startX - endX) == -1) && ((startY - endY == 1)))
			{
				//VALID
				return 1;
			}
			else if(((startX - endX) == 2 || (startX - endX) == -2) && ((startY - endY == 2)))
			{
				if(Board[startX-1][startY-1] == BLACK || Board[startX+1][startY-1] == BLACK)
				{
					return 2;
				}
				else
				{
					return 0;
				}
			}
			else
			{
				return 0;
			}
		}
		else
		{
			//INVALID
			return 0;
		}
	}
	public int get_square (int X, int Y)
	{
		return Board[X][Y];
	}
	
	public void set_square (int X, int Y, int V)
	{
		Board[X][Y] = V;
	}
	
	
	
	public void draw()
	{
		// Print the board
		for (int Row = -1; Row < Ysize; Row++) 
		{
	    	for (int Column = -1; Column < Xsize; Column++) 
			{
					if (Row == -1 && Column > -1)
						System.out.print(" " + (Column+1) + " ");
					else
					if (Column == -1 && Row >= -1)
						System.out.print(Row+1);
					else
					{
						switch (Board[Column][Row])
						{
							case BLANK:
							System.out.print(" . ");
							break;
						
							case BLACK:
							System.out.print(" @ ");
							break;
						
							case WHITE:
							System.out.print(" O ");
							break;
						}
					}
			}
	    // New line at end of every row
	    System.out.print("\n");	
	
		}
	}
}