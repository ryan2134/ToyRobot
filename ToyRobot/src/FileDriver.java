// Work of Ryan Cheng 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/* Class responsible for reading txt files in the src folder for input
 * it assumes that the end is when the file ends rather than when 
 * the REPORT command is given */
public class FileDriver {
	private Direction direction;
	private Robot robot;
	
	public FileDriver() throws IOException{
		Scanner fileNameReader = new Scanner(System.in);
		String s = fileNameReader.nextLine();
		String fileName = "src/" + s + ".txt";
		extractPlace(fileName);
	}
	
	/**
	 * Obtains the first line of the file which contains where the Robot 
	 * will be placed 
	 * @param fileName 	name of the file within the src folder
	 * @throws IOException	throws an exception when file doesn't exist
	 */
	public void extractPlace(String fileName) throws IOException{
		File file = new File(fileName);
		BufferedReader br = new BufferedReader(new FileReader(file));  
		String st = br.readLine();
		
		// Grabs the first line (e.g. PLACE 1,0,EAST)
		String[] splitString = st.split("\\s+"); 
		
		// Retains only the 1,0,EAST segment
		String[] splitString2 = splitString[1].split(",", 3);
		int xPos = Integer.parseInt(splitString2[0]);
		int yPos = Integer.parseInt(splitString2[1]);
		direction = Direction.valueOf(splitString2[2]);
		robot = new Robot(xPos, yPos, direction);
		readRest(file, br);
	}
	
	/**
	 * Method that reads the rest of the file where the buffered reader has stopped at
	 * (presumably after only the first line of the file)
	 * @param file 	contains all the commands for the Robot
	 * @param br	the buffered reader continuing from reading the file 
	 * @throws IOException	this exception is thrown when the file doesn't exist
	 */
	public void readRest(File file, BufferedReader br) throws IOException {
		String st;
		while ((st = br.readLine()) != null) {
			if(st.equals("LEFT") || st.equals("RIGHT")){
	        	robot.turnDirection(st);
	        }
	        else if(st.equals("MOVE")) {
	        	robot.move();
	        }
			// Get to here when REPORT command has been entered   
	        else {
	        	robot.currentPos();
	        	break;
	        }
		}
	}
}