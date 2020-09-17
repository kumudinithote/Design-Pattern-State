package numberPlay.patternImp;

public class LuxuriousState implements State {

	   public void doAction(Context context) {
	      //System.out.println("Luxurious state");
	      context.setState(this);	
	   }

	   public String toString(){
	      return "Luxurious";
	   }
	}
