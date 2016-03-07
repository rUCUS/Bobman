package bobman;


/**
 * this class creates a clock with minutes and seconds
 * 
 * @author Danny Lam
 * @version 2016-02-28
 */


public class ClockD {
		
		/**
		 * @uml.property  name="board"
		 * @uml.associationEnd  multiplicity="(1 1)" inverse="clock:bobman.Board"
		 */
		private Board board;
		/**
		 * @uml.property  name="clockRunning"
		 */
		private boolean clockRunning;
	    /**
		 * @uml.property  name="minutes"
		 * @uml.associationEnd  multiplicity="(1 1)"
		 */
	    private NumD minutes;
	    /**
		 * @uml.property  name="seconds"
		 * @uml.associationEnd  multiplicity="(1 1)"
		 */
	    private NumD seconds;
	    /**
		 * @uml.property  name="displayString"
		 */
	    private String displayString;    // simulates the actual display
	    
	    
	    public ClockD(Board board)
	    {
	    	clockRunning = false;
	    	this.board = board;
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
	     * this method starts our clock
	     */
	    
	    public void clockStarter() {
			startClock();
		}
		
	    /**
	     * this method stops our clock
	     */
	    
		public void clockStop() {
			stopClock();
		}
		
		/**
		 * this method resets our clock to 00:00 
		 */
		
		public void resetClock(){
			this.reset();
			board.getButtonTimer().setText("00:00");
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
	    
	    /**
	     * this method gets our time
	     * @return displayString
	     */


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
	    
	    /**
	     * this method is called upon when we start or restart
	     * our game and it starts our clock
	     */
	    
		private void startClock()

	    {
		   clockRunning = true;
		}
		
		/**
	     * this method is called upon when we pause our game
	     */

		 private void stopClock()
		    {
		        clockRunning = false;
		    }
		 
		 /**
		  * steps our clock
		  */
		 
		 void stepClock()
		    {
		        this.timeTick();
		        board.getButtonTimer().setText(this.getTime());
		    }
		 
		 /**
		 * returns the class board
		 * @return  board
		 * @uml.property  name="board"
		 */

		 public Board getBoard() {
			return board;
		 }

		 /**
		 * sets our board
		 * @param  board
		 * @uml.property  name="board"
		 */
		 
		 public void setBoard(Board board) {
			this.board = board;
		 }
		 
		 /**
		 * returns the whether the clock is running or not
		 * @return  false
		 * @uml.property  name="clockRunning"
		 */

		 public boolean isClockRunning() {
			return clockRunning;
		 }
		 
		 /**
		 * sets whether the clock is running or not
		 * @param  clockRunning
		 * @uml.property  name="clockRunning"
		 */

		 public void setClockRunning(boolean clockRunning) {
			this.clockRunning = clockRunning;
		 }
		 
		 /**
		 * return the minute
		 * @return  minutes
		 * @uml.property  name="minutes"
		 */

		 public NumD getMinutes() {
			return minutes;
		 }
		 
		 /**
		 * sets the minutes
		 * @param  minutes
		 * @uml.property  name="minutes"
		 */

		 public void setMinutes(NumD minutes) {
			this.minutes = minutes;
		 }
		 
		 /**
		 * returns the seconds
		 * @return  seconds
		 * @uml.property  name="seconds"
		 */

		 public NumD getSeconds() {
			return seconds;
		 }
		 
		 /**
		 * sets the seconds
		 * @param  seconds
		 * @uml.property  name="seconds"
		 */

		 public void setSeconds(NumD seconds) {
			this.seconds = seconds;
		 }
		 
		 /**
		 * returns the display time text/string
		 * @return  displayString
		 * @uml.property  name="displayString"
		 */
		 
		 public String getDisplayString() {
			return displayString;
		 }
		 
		 /**
		 * sets the display time text/string
		 * @param  displayString
		 * @uml.property  name="displayString"
		 */

		 public void setDisplayString(String displayString) {
			this.displayString = displayString;
		 }
	    
}

	

