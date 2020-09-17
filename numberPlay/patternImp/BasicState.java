package numberPlay.patternImp;

public class BasicState implements State {

	   public void doAction(Context context) {
	      //System.out.println("Basic state");
	      context.setState(this);	
	   }

	   public String toString(){
	      return "Basic";
	   }
	}
