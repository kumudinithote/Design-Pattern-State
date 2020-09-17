package numberPlay.driver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;

import numberPlay.patternImp.PurchaseDecisionMaker;
import numberPlay.patternImp.StateCalculation;
import numberPlay.util.FileProcessor;

public class RunningDataReader implements IFileReader{
	
	StateCalculation stateCalculation;
	PurchaseDecisionMaker purchaseDecisionMaker;
	
	public RunningDataReader(int runningWindow, String outfile){
		stateCalculation = new StateCalculation(runningWindow);
		purchaseDecisionMaker = new PurchaseDecisionMaker(outfile);
	}
	
	/**
	 * @param  inputFile :- running Input file. 
	 * This method reads the running input file one line at a time till the line is null, process it and catch the exception if any.
	 * 
	 */
	
	public void readInput(String inputFile){
		FileProcessor fileProcessor;
		try {
			fileProcessor = new FileProcessor(inputFile);
			String line = fileProcessor.poll();
			while(line != null){
				processInput(line);
				line = fileProcessor.poll();
			}
		} catch (InvalidPathException e) {
			System.out.println("InvalidPathException occured");
		} catch (SecurityException e) {
			System.out.println("SecurityException occured");
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException occured");
		} catch (IOException e) {
			System.out.println("IOException occured");
		}
	}
	
	
	/**
	 * @param line :- read from the running input file
	 * This method split the line,check if specified format is followed or not.
	 * Check if length of split line is less than 2 then error will be thrown.
	 * It will take money and calculate running average with respect to window size.
	 * It will make the decision to purchase the item or not and will show the state.
	 * 
	 */
	
	public void processInput(String line){
		
		String[] temp = line.split(":");
		
		if(temp.length != 2)
		{
			System.out.println("ERROR: This Line in input file does not follow specified format" + line);
		}
		
		if("money".equalsIgnoreCase(temp[0])){
			stateCalculation.process(temp[1]);
		}else if("item".equalsIgnoreCase(temp[0])){
			purchaseDecisionMaker.process(temp[1]);
		}else{
			System.out.println("ERROR : Not valid input");
		}
	}
}
