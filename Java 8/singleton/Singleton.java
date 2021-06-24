package singleton;

public class Singleton {

	private static Singleton singletonInstance;
	private static volatile Singleton volatileSingletonInstance;
	private static Singleton earlyInitializingSingletonInstance = new Singleton();

	/**
	 * This is the traditional way of creating a singleton instance. Also
	 * considered as lazy initialization.
	 * 
	 * Problem: Even though this is thread-safe, performance will be draw back
	 * as each and every time we need to acquire lock on the class.
	 * 
	 */
	public static synchronized Singleton getInstance() {
		if (singletonInstance == null) {
			singletonInstance = new Singleton();
		}
		return singletonInstance;
	}

	/**
	 * To overcome the problem of acquiring the unnecessary lock, double check
	 * is performed.
	 * 
	 * In this case first check is performed on the instance is required for
	 * creation and the second check is performed on the synchronized block.
	 * 
	 * For this pattern we need to have volatile object
	 */
	public static Singleton getSingletonInstance() {
		if (volatileSingletonInstance == null) { // Single check
			synchronized (Singleton.class) {
				if (volatileSingletonInstance == null) { // Double check
					volatileSingletonInstance = new Singleton();
				}
			}
		}
		return volatileSingletonInstance;
	}

	/**
	 * The easiest way of creation of singleton object is by using early
	 * initialization. In this approach class variable will be initialized with
	 * new object.
	 */
	public static Singleton getInstanceByEarlyInitialization() {

		return earlyInitializingSingletonInstance;
	}

	/**
	 * Another approach is to have static inner class which holds the instance
	 * of required singleton class object returns this object only on demand.
	 *
	 */
	private static class InstanceHolder {
		private static Singleton getInstance = new Singleton();
	}

	public static Singleton getSingletonInstanceByInstanceHolder() {
		return InstanceHolder.getInstance;
	}

	/**
	 * This is the last and efficient approach of creating a singleton instance.
	 * 
	 * Calling of singleton class using enum is:<br>
	 * EnumSingleton.INSTANCE;<br>
	 * Once the above is executed internally, it will converted something like
	 * this <br>
	 * <blockquote> public enum EnumSingleton { <br>
	 * INSTANCE; <br>
	 * public final static MySingleton INSTANCE = new MySingleton(); <br>
	 * private EnumSingleton() {
	 * 
	 * } <br>
	 * } </blockquote>
	 */
	public enum EnumSingleton {
		INSTANCE;
	}

	// Private constructor so that no one should call
	private Singleton() {

	}
}
