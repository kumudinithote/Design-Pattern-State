package numberPlay.patternImp;

public class StateCalculation implements IProcessInput{
	
	private FixedList fixedList;
	private BasicState basicState;
	private LuxuriousState luxuriousState;
	private ExtravagantState extravagantState;
	private Context context;
	public static State currentState;
	
	public StateCalculation(int runningWindow){
		fixedList = new FixedList(runningWindow);
		basicState = new BasicState();
		currentState = basicState;
		luxuriousState = new LuxuriousState();
		extravagantState = new ExtravagantState();
		context = new Context();
		
	}
	
	/**
	 * @param data is a money from the running input file and we will check if it goes less than 0 then will throw error.
	 * Add money in the FixedList and check for the states of cash after taking running average and context will set the state.
	 */
	
	@Override
	public void process(String data) {
		//System.out.println(data);
		int money = Integer.parseInt(data);
		if(money <= 0)
		{
			System.out.println("ERROR: Money earned in input file is less than 0" + money);
			return;
		}
		
		fixedList.addData(money);
		
		int cash = fixedList.currentCash();
		
		if(cash/2 < 10000){
			basicState.doAction(context);
			currentState = basicState;
		}else if(cash/2 < 50000){
			luxuriousState.doAction(context);
			currentState = luxuriousState;
		}else{
			extravagantState.doAction(context);
			currentState = extravagantState;
		}
		
		
	}
}
