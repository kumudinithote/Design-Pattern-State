package numberPlay.patternImp;

import java.util.ArrayList;

public class FixedList {
    private int maxSize;
    ArrayList<Integer> cashFlow;
 
    public FixedList(int maxSize) {
        this.maxSize = maxSize;
        cashFlow = new ArrayList<Integer>();
    }
     
    public void addData(int money) {
        if (cashFlow.size() == maxSize){
        	cashFlow.remove(0);
        }
        cashFlow.add(money);
    }
    
    public int currentCash(){
    	int runningCash = 0;
    	
    	for(int i = 0; i < cashFlow.size(); i++){
    		runningCash += cashFlow.get(i);
    		//System.out.println("money :"+cashFlow.get(i));
    	}
    	
    	return runningCash;
    }
}