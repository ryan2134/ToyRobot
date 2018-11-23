// Work of Ryan Cheng 
/* This class represents the main object at hand and is responsible for
 * appropriately acting within the given specifications of the project
 * (i.e. Handling the directions and not falling off the table) */
public class Robot {
	private int xPos;
	private int yPos;
	private Direction direction;
	private Command command;
	
	/**
	 * Constructor method for the Robot
	 * @param xPos	the x position of the Robot
	 * @param yPos	the y position of the Robot
	 * @param direction	a provided enum for the directions the robot can be facing
	 */
	public Robot(int xPos, int yPos, Direction direction) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.direction = direction;
	}
	
	/**
	 * Turns the robot with respect to the given direction and which direction
	 * the robot is facing 
	 * @param turn	the command is either LEFT or RIGHT which determines which 
	 * 		  cardinal direction the robot should be facing
	 */
	public void turnDirection(String turn) {
		if(turn.equals("LEFT")) {
			switch(this.direction) {
				case NORTH:
					System.out.println("Turning LEFT from NORTH to WEST");
					this.direction = Direction.WEST;
					break;
				case EAST:
					System.out.println("Turning LEFT from EAST to NORTH");
					this.direction = Direction.NORTH;
					break;
				case SOUTH:
					System.out.println("Turning LEFT from SOUTH to EAST");
					this.direction = Direction.EAST;
					break;
				case WEST:
					System.out.println("Turning LEFT from WEST to SOUTH");
					this.direction = Direction.SOUTH;
					break;
			}
		}
		
		// The only other command is to turn RIGHT
		else {
			switch(this.direction) {
			case NORTH:
				System.out.println("Turning RIGHT from NORTH to EAST");
				this.direction = Direction.EAST;
				break;
			case EAST:
				System.out.println("Turning RIGHT from EAST to SOUTH");
				this.direction = Direction.SOUTH;
				break;
			case SOUTH:
				System.out.println("Turning RIGHT from SOUTH to WEST");
				this.direction = Direction.WEST;
				break;
			case WEST:
				System.out.println("Turning RIGHT from WEST to NORTH");
				this.direction = Direction.NORTH;
				break;
			}
		}
	}
	
	/**
	 * Method that allows the Robot to move across the table and checks 
	 * if the move is valid
	 */
	public void move() {
		if(this.direction == Direction.NORTH && this.yPos < 4) {
			this.yPos++;
		}
		else if(this.direction == Direction.SOUTH && this.yPos > 0) {
			this.yPos--;
		}
		else if(this.direction == Direction.EAST && this.xPos < 4) {
			this.xPos++;
		}
		else if(this.direction == Direction.WEST && this.xPos > 0) {
			this.xPos--;
		}
		else {
			System.out.println("ERROR: Robot will fall off table with this MOVE");
			return;
		}
	}
	
	/**
	 * Reports the current position of the Robot
	 */
	public void currentPos() {
		System.out.println("Reporting Robot's values: ");
		System.out.printf("Output: %d,%d,%s\n",this.xPos, this.yPos, this.direction);
	}
}
