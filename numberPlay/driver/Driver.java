package numberPlay.driver;

/**
 * @author Kumudini Thote
 *
 */
public class Driver {
	

	public static void main(String[] args) {
		
		if ((args.length != 4) || (args[0].equals("${inputFile}")) || (args[1].equals("${availableItemsFile}")) || (args[2].equals("${runningAverageWindowSize}"))
				|| (args[3].equals("${outputFile}"))) {
			System.err.println("Error: Incorrect number of arguments. Program accepts 4 arguments.");
			System.exit(0);
		}
		if(Integer.parseInt(args[2]) <= 0)
			{
				System.out.println("ERROR: Value for running Average Window Size ≤ 0");
				System.exit(0);
			}
		
		
		AvailableItemReader itemReader = new AvailableItemReader();
		itemReader.readInput(args[0]);	
		
		RunningDataReader dataReader = new RunningDataReader(Integer.parseInt(args[2]), args[3]);
		dataReader.readInput(args[1]);
		
	}
}
