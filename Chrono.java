package tools;

/**
 * The Chrono class
 *
 * You can use this class to time code easily. Result is computed in
 * milliseconds (1 000 milliseconds = 1 second). Example:
 * @note Give name to the Chrono help you to manage several
 * chronos at the same time (if you store several chrono in ArrayList for example).
 */
public class Chrono {
	private long startTime;
	private long endTime;
	private float duration;
	private String name;
	
	public Chrono() {
		name = "default";
		duration = 0;
	}
	
	public Chrono(String name) {
		this.name = name;
		duration = 0;
	}
	
	/**
	 * This method start the chrono
	 */
	public void start() {
		startTime = System.currentTimeMillis();
	}
	
	/**
	 * This method stop the timer and store the result in duration
	 */
	public void stop(){
		endTime = System.currentTimeMillis();
		duration += endTime - startTime;
	}
	
	/**
	 * This method return computed time since chrono was started
	 * @return
	 */
	public float currentTime(){
		endTime = System.currentTimeMillis();
		return endTime - startTime;
	}
	
	/**
	 * Reset timer and set the time to now()
	 */
	public void reset() {
		startTime = System.currentTimeMillis();
		endTime = startTime;
		duration = 0;
	}
	
	/**
	 * Resume timer
	 */
	public void resume() {
		startTime = System.currentTimeMillis();
	} 

	/**
	 * 
	 * @return duration in microseconds
	 */
	public float getDuration() {
		return duration;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Chrono [name=" + name +", duration=" + duration + "]";
	}
	
	
	
	
}
