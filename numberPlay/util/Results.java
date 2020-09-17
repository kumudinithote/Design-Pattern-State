package numberPlay.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {
	private BufferedWriter writer;
	private String outputFileName;
	
	public Results(String outputFileName) {
		this.outputFileName = outputFileName; 
		try {
			this.writer = new BufferedWriter(new FileWriter(outputFileName, false));
		} catch (IOException e) {
			System.out.println("Error while writing into file");
		}
	}

	/**
	 * This method write the prime number to  output file
	 * @param line data received from the client in queue
	 * @return write to the output file
	 */
	
	@Override
	public void writeToFile(String line) {
	    try {
	    	writer = new BufferedWriter(new FileWriter(outputFileName, true));
			writer.newLine();
			writer.write(line);
		    writer.close();
		} catch (IOException e) {
			System.out.println("Error while writing into file");
		}
	}
	
	/**
	 * This method prints the prime number on the console.
	 * @param data received from the client in queue
	 */
	@Override
	public void writeToStdout(String line) {
		System.out.println(line);
	}
}
