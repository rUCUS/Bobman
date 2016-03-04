package bobman;


/*
 * this class creates a clock with minutes and seconds
 * 
 * @author Danny Lam
 * @version 2016-02-28
 */


public class ClockD {
		
		private Board board;
		private boolean clockRunning;
	    private NumD minutes;
	    private NumD seconds;
	    private String displayString;    // simulates the actual display
	    
	    /**
	     * Constructor for ClockDisplay objects. This constructor 
	     * creates a new clock set at 00:00.
	     */
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
	    
	    /*
	     * this method starts our clock
	     */
	    
	    public void clockStarter() {
			startClock();
		}
		
	    /*
	     * this method stops our clock
	     */
	    
		public void clockStop() {
			stopClock();
		}
		
		/*
		 * this method resets our clock to 00:00 
		 */
		
		public void resetClock(){
			this.reset();
			board.getButtonTimer().setText("00:00");
		}
	    
	    /*
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
	    
	    /*
	     * this method gets our time
	     * @return displayString
	     */


	    public String getTime()
	    {
	        return displayString;
	    }
	    
	    /*
	     * Update the internal string that represents the display.
	     */
	    
	    private void updateDisplay()
	    {
	        displayString = minutes.getDisplayValue() + ":" + 
	                        seconds.getDisplayValue();
	    }
	    
	    /*
	     * this method is called upon when we start or restart
	     * our game and it starts our clock
	     */
	    
		private void startClock()

	    {
		   clockRunning = true;
		}
		
		/*
	     * this method is called upon when we pause our game
	     */

		 private void stopClock()
		    {
		        clockRunning = false;
		    }
		 
		 /*
		  * steps our clock
		  */
		 
		 void stepClock()
		    {
		        this.timeTick();
		        board.getButtonTimer().setText(this.getTime());
		    }
		 
		 /*
		  * returns the class board
		  * @returns board
		  */

		 public Board getBoard() {
			return board;
		 }

		 /*
		  * sets our board
		  * @param board
		  */
		 
		 public void setBoard(Board board) {
			this.board = board;
		 }
		 
		 /*
		  * returns the whether the clock is running or not
		  * @returns false
		  */

		 public boolean isClockRunning() {
			return clockRunning;
		 }
		 
		 /*
		  * sets whether the clock is running or not
		  * @param clockRunning
		  */

		 public void setClockRunning(boolean clockRunning) {
			this.clockRunning = clockRunning;
		 }
		 
		 /*
		  * return the minute
		  * @returns minutes
		  */

		 public NumD getMinutes() {
			return minutes;
		 }
		 
		 /*
		  * sets the minutes
		  * @param minutes
		  */

		 public void setMinutes(NumD minutes) {
			this.minutes = minutes;
		 }
		 
		 /*
		  * returns the seconds
		  * @returns seconds
		  */

		 public NumD getSeconds() {
			return seconds;
		 }
		 
		 /*
		  * sets the seconds
		  * @param seconds
		  */

		 public void setSeconds(NumD seconds) {
			this.seconds = seconds;
		 }
		 
		 /*
		  * returns the display time text/string
		  * @returns displayString
		  */
		 
		 public String getDisplayString() {
			return displayString;
		 }
		 
		 /*
		  * sets the display time text/string
		  * @param displayString
		  */

		 public void setDisplayString(String displayString) {
			this.displayString = displayString;
		 }
	    
}

	

