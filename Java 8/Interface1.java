
public interface Interface1 {

	public void display();
	
	default void displayName(String name) {
		System.out.println( "In the interface 1:::::     "  +name);
	}
}
