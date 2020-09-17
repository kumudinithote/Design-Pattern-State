package numberPlay.driver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.HashMap;

import numberPlay.util.FileProcessor;

public class AvailableItemReader implements IFileReader{
	private static HashMap<String, String> itemList = new HashMap<String, String>();
	
	/**
	 * @param Here input is file which have list of items.
	 * @exception InvalidPathException, SecurityException, FileNotFoundException, IOException if line contains any invalid characters
	 * 				or file can not be opened or input error.
	 * @return Nothing
	 * readInput will read the input file one line at a time till line is null. 
	 */
	public void readInput(String inputFile){
		FileProcessor fileProcessor;
		try {
			fileProcessor = new FileProcessor(inputFile);
			String line = fileProcessor.poll();
			while(line != null){
				//System.out.println(line);
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
	 * getItemList have key product and value is category of product.
	 * @return itemList will contains the all the items present in input file.
	 */
	
	public HashMap<String, String> getItemList() {
		return itemList;
	}
	
	/**
	 * @param line is input here which is read from the file. check if product is present or not present then it will add.
	 * This method will split the line and will also check if it follows the specified format.
	 * 
	 */
	
	public void processInput(String line){
		String[] temp = line.split(":");
		
		if(temp.length != 2)
		{
			System.out.println("ERROR: This Line in input file does not follow specified format -> " + line);
		}
		
		//System.out.println(temp[1] +"  "+temp[0]);
		if(!itemList.containsKey(temp[1])){
			itemList.put(temp[1], temp[0]);
		}
	}
}
