package numberPlay.patternImp;

public class ExtravagantState implements State {

	   public void doAction(Context context) {
	      //System.out.println("Extravagant state");
	      context.setState(this);	
	   }

	   public String toString(){
	      return "Extravagant";
	   }
	}
