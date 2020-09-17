package numberPlay.patternImp;

import java.util.HashMap;

import numberPlay.driver.AvailableItemReader;
import numberPlay.util.Results;

public class PurchaseDecisionMaker implements IProcessInput{
	
	private Results result;
	
	public PurchaseDecisionMaker(String outfile){
		result = new Results(outfile);
	}
	
	@Override
	public void process(String data) {
		AvailableItemReader availableItemReader = new AvailableItemReader();
		
		HashMap<String, String> itemList = availableItemReader.getItemList();
		if(itemList.containsKey(data)){
			
			String dataCategory = itemList.get(data);
			String output;
			if(StateCalculation.currentState.toString().equals("Extravagant")){
				System.out.println(StateCalculation.currentState+" :: "+data+" :: Yes");
				output = StateCalculation.currentState+" :: "+data+" :: Yes";
			}else if(StateCalculation.currentState.toString().equals("Luxurious") && 
					(dataCategory.equals("basic") || dataCategory.equals("moderatelyExpensive"))){
				System.out.println(StateCalculation.currentState+" :: "+data+" :: Yes");
				output = StateCalculation.currentState+" :: "+data+" :: Yes";
			}else if(StateCalculation.currentState.toString().equals("Basic") && dataCategory.equals("basic")){
				System.out.println(StateCalculation.currentState+" :: "+data+" :: Yes");
				output = StateCalculation.currentState+" :: "+data+" :: Yes";
			}else{
				System.out.println(StateCalculation.currentState+" :: "+data+" :: No");
				output = StateCalculation.currentState+" :: "+data+" :: No";
			}
			result.writeToFile(output);
			
		}else{
			System.out.println("Item is not available in list "+ data);
		}
		
	}
}
