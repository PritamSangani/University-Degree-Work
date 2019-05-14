import java.util.Scanner;

enum state{SUNNY,OVERCAST,RAINING};
public class Weather {

	public static void main(String[] args) {
		state current = state.SUNNY;
		boolean finished=false;
		char command;
		String strIn;
		Scanner in = new Scanner(System.in);
		
		while(!finished){
		 System.out.println("Weather state :"+current);
		 System.out.print("Enter i for improving, d for deteriorating:");
		 strIn = in.nextLine();
		 command = strIn.charAt(0);
		 switch(command){
		 case'i': current = improveState(current);
		 break;
		 case'd': current = worsenState(current);
		 break;
		 default : finished=true; //any other char ends program
		 } //case
		} //while

	} //end main
	
	public static state improveState(state present)
	{
		switch(present){
		case OVERCAST: return state.SUNNY;
		case RAINING: return state.OVERCAST;
		default: return state.SUNNY;
		} //end switch
	}
	public static state worsenState(state present)
	{
		switch(present){
		case SUNNY: return state.OVERCAST;
		case OVERCAST: return state.RAINING;
		default: return state.RAINING;
		} //end switch
	}
}
