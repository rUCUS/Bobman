package bobman;

public class NumD {
	
	    private int limit;
	    private int value;

	    
	    public NumD(int rollOverLimit)
	    {
	        limit = rollOverLimit;
	        value = 0;
	    }

	    /*
	     * Return the current value.
	     */
	    public int getValue()
	    {
	        return value;
	    }

	    /*
	     * Return the display value (that is, the current value as a two-digit
	     * String. If the value is less than ten, it will be padded with a leading
	     * zero).
	     */
	    public String getDisplayValue()
	    {
	        if(value < 10) {
	            return "0" + value;
	        }
	        else {
	            return "" + value;
	        }
	    }

	    /*
	     * Set the value of the display to the new specified value. If the new
	     * value is less than zero or over the limit, do nothing.
	     */
	    
	    public void setValue(int replacementValue)
	    {
	        if((replacementValue >= 0) && (replacementValue < limit)) {
	            value = replacementValue;
	        }
	    }

	    /*
	     * increments the value until the limit has been reached
	     */
	    
	    public void increment()
	    {
	        value = (value + 1) % limit;
	    }
	}

