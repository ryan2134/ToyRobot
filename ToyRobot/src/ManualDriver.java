import java.util.Scanner;

/* This class is responsible for the manual input from the user in the console
 * it will stop it once the REPORT command has been entered */
public class ManualDriver {
	private Direction direction;
	private Robot robot;
	
	public ManualDriver() {
		Scanner posReader = new Scanner(System.in);
		String s = posReader.nextLine();
		
		// Grabs the first line (e.g. PLACE 1,0,EAST)
		String[] splitString = s.split("\\s+");
		
		// Retains only the 1,0,EAST segment
		String[] splitString2 = splitString[1].split(",", 3);
		int xPos = Integer.parseInt(splitString2[0]);
		int yPos = Integer.parseInt(splitString2[1]);
		direction = Direction.valueOf(splitString2[2]);
		robot = new Robot(xPos, yPos, direction);
		manualInput();
	}
	
	/**
	 * This method allows the user to input all the valid commands to the robot
	 * and will only stop once the REPORT command has been issued
	 */
	public void manualInput() {
		System.out.println("Time to give the robot some commands (Check Command Enum)");
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while(!(input.equals("REPORT"))){
        	input = scanner.next();
            if(input.equals("LEFT") || input.equals("RIGHT")){
            	robot.turnDirection(input);
            }
            else if(input.equals("MOVE")) {
            	robot.move();
            }
        }
        // Get to here when REPORT command has been entered
        robot.currentPos();
	}
}
