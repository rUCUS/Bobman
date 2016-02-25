package bobman;

public class ClockD {

	    private NumD minutes;
	    private NumD seconds;
	    private String displayString;    // simulates the actual display
	    
	    /**
	     * Constructor for ClockDisplay objects. This constructor 
	     * creates a new clock set at 00:00.
	     */
	    public ClockD()
	    {
	        minutes = new NumD(60);
	        seconds = new NumD(60);
	        updateDisplay();
	    }
	    
	    public void reset(){
	    	minutes = new NumD(60);
	    	seconds = new NumD(60);
	    	updateDisplay();
	    	
	    }
	    
	    /**
	     * This method should get called once every minute - it makes
	     * the clock display go one minute forward.
	     */
	    public void timeTick()
	    {
	        seconds.increment();
	        if(seconds.getValue() == 0) {  // it just rolled over!
	            minutes.increment();
	        }
	        updateDisplay();
	    }


	    public String getTime()
	    {
	        return displayString;
	    }
	    
	    /**
	     * Update the internal string that represents the display.
	     */
	    private void updateDisplay()
	    {
	        displayString = minutes.getDisplayValue() + ":" + 
	                        seconds.getDisplayValue();
	    }
	    
	}
