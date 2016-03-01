package bobman;


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
	    
	    public void clockStarter() {
			startClock();
		}
		
		public void clockStop() {
			stopClock();
		}
		
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
	    
		private void startClock()

	    {
		   clockRunning = true;
		}

		 private void stopClock()
		    {
		        clockRunning = false;
		    }

		 
		 
		 void stepClock()
		    {
		        this.timeTick();
		        board.getButtonTimer().setText(this.getTime());
		    }

		public Board getBoard() {
			return board;
		}

		public void setBoard(Board board) {
			this.board = board;
		}

		public boolean isClockRunning() {
			return clockRunning;
		}

		public void setClockRunning(boolean clockRunning) {
			this.clockRunning = clockRunning;
		}

		public NumD getMinutes() {
			return minutes;
		}

		public void setMinutes(NumD minutes) {
			this.minutes = minutes;
		}

		public NumD getSeconds() {
			return seconds;
		}

		public void setSeconds(NumD seconds) {
			this.seconds = seconds;
		}

		public String getDisplayString() {
			return displayString;
		}

		public void setDisplayString(String displayString) {
			this.displayString = displayString;
		}
	    
}

	

