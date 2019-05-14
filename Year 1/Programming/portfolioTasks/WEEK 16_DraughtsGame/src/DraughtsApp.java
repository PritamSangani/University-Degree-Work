//Pritam Sangani - 16039231

import java.io.IOException;
import java.util.Scanner;

public class DraughtsApp
{
	public static void main (String [] args)
	{
		DraughtsBoard GameBoard = new DraughtsBoard();
		Scanner in = new Scanner(System.in);
		//player colours
		//ADD HERE FOR KING PIECE
		//e.g. final int KING = 3;
		final int BLANK = 0;
    	final int BLACK = 1;
    	final int WHITE = 2; 
    	
    	//coordinate system
		int X, Y;
		int endX, endY;
		int Piece = 0;
		X=0;
		Y=0;
		endX = 0;
		endY = 0;
		
		
		//draw the game board
		GameBoard.draw();
		System.out.println();
		System.out.println();
		System.out.println("White Piece = O");
		System.out.println("Black Piece = @");
		//while x != 1 
		//do stuff
		while (X != -1)
		{		
			//GameBoard.draw();
			//stop condition message
			System.out.println("\nEnter -1 to quit");
			//enter x coordinate
			System.out.print("Enter X coordinate: ");
			//read in x coordinate
			X = in.nextInt();
			//if x != -1 
			//do stuff
			if (X != -1)
			{
				//enter y coordinate message
				System.out.print("Enter Y coordinate: ");
				Y = in.nextInt();
				//tell player what current start x and start y are (colour)
				//call get square method
				Piece = GameBoard.get_square(X-1, Y-1);
				System.out.print("\nSquare at "+X+","+Y+" is ");
				switch (Piece)
				{
					case BLANK:
						System.out.println("blank");
						break;
					
					case BLACK:
						System.out.println("a black piece");
						//ask for end x coordinate
						System.out.print("Enter end X coordinate: ");
						//read in end x coordinate
						endX = in.nextInt();
						//ask for y coordinate
						System.out.print("Enter end Y coordinate: ");
						//read in end y coordinate
						endY = in.nextInt();
						//if move legal
						//do stuff
						if(GameBoard.checkMove(X - 1, Y - 1, endX -1, endY - 1) == 1)
						{
							System.out.println("That is a valid move");
							//set position of current piece to be at end x and end y to BLACK
							GameBoard.set_square(endX-1, endY-1, BLACK);
							//set position of previous position to BLANK
							GameBoard.set_square(X-1, Y-1, BLANK);
							GameBoard.draw();
						}
						else
						{
							if(GameBoard.checkMove(X - 1, Y -1, endX -1, endY-1)==0)
							{
								System.out.println("That is an invalid move");
								//redraw game board
								GameBoard.draw();
							}
							if(GameBoard.checkMove(X - 1,Y - 1, endX - 1, endY - 1) == 2)
							{
								System.out.println("That is a valid move");
								GameBoard.set_square(endX - 1, endY - 1, BLACK);
								GameBoard.set_square(X - 1, Y - 1, BLANK);
								if(X > endX)
								{
									GameBoard.set_square(X - 2, Y, BLANK);
								}
								else
								{
									GameBoard.set_square(X, Y, BLANK);
								}
								GameBoard.draw();
							}
						}
						break;
					
					case WHITE:
						System.out.println("a white piece");
						//ask for end x coordinate
						System.out.print("Enter end X coordinate: ");
						//read in end x coordinate
						endX = in.nextInt();
						//ask for y coordinate
						System.out.print("Enter end Y coordinate: ");
						//read in end y coordinate
						endY = in.nextInt();
						//if move legal
						//do stuff
						if(GameBoard.checkMove(X - 1, Y - 1, endX - 1, endY - 1) == 1)
						{
							System.out.println("That is a valid move");
							//set position of current piece to be at end x and end y to WHITE
							GameBoard.set_square(endX-1, endY-1, WHITE);
							//set position of previous position to BLANK
							GameBoard.set_square(X-1, Y-1, BLANK);
							GameBoard.draw();
						}
						
						else
						{
							if(GameBoard.checkMove(X - 1, Y -1, endX -1, endY-1)==0)
							{
								System.out.println("That is an invalid move");
								//redraw game board
								GameBoard.draw();
							}
							if(GameBoard.checkMove(X - 1, Y - 1, endX - 1, endY - 1) == 2)
							{
								System.out.println("That is a valid move");
								//set position of current piece to be at end x and end y to WHITE
								GameBoard.set_square(endX-1, endY-1, WHITE);
								//set position of previous position to BLANK
								GameBoard.set_square(X-1, Y-1, BLANK);
								if(X > endX)
								{
									GameBoard.set_square(X-2, Y, BLANK);
								}
								else
								{
									GameBoard.set_square(X, Y, BLANK);
								}
								GameBoard.draw();
							}
						}
						break;
				}
			}
		}
	}	
}
