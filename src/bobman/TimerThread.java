/**package bobman;

public class TimerThread extends Thread
{
	private ClockD clock;
    
	
	
	
	public TimerThread(ClockD clock) {
		super();
		this.clock = clock;
	}

	public void run()
    {
        while (clock.isClockRunning()) {
            clock.stepClock();
            pauseClock();
        }
    }
    
    public void pauseClock()
    {
        try {
            Thread.sleep(1000);   // pause for 300 milliseconds
        }
        catch (InterruptedException exc) {
        }
    }
}
*/