// Work of Ryan Cheng 
import java.io.IOException;
import java.util.Scanner;

/* This class is used a the main driver of the project; allows the user to decide what 
   type of input can be used */
public class ToyRobot {
	
	/**
	 * main method that drives the simulation of the project
	 * @param args
	 * @throws IOException
	 */
	public static void main(String args[]) throws IOException {
		System.out.println("Type 1 for manual input ||| Type 2 for file input");
		Scanner input = new Scanner(System.in);
		int readerInt = input.nextInt();
		if(readerInt == 1) {
			System.out.println("Manual input chosen. Choose Robot's start in the format: PLACE X,Y,Direction");
			ManualDriver manual = new ManualDriver();
		}
		
		else if(readerInt == 2) {
			System.out.println("File input chosen. Choose file for robot's movements");
			FileDriver file = new FileDriver();
		}
		
		else {
			System.out.println("Invalid input, exiting simulation");
		}
	}
}
