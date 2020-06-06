
public class DefaultStaticMethodInInterface implements Interface1, Interface2{

	public static void main(String[] args) {
		DefaultStaticMethodInInterface obj = new DefaultStaticMethodInInterface();
		obj.display();
		obj.displayName( "Suresh" );
	}

	@Override
	public void display() {
		System.out.println( "In the display().......... " );
	}

	@Override
	public void displayName(String name) {
		Interface1.super.displayName(name);
		Interface2.super.displayName(name);
	}

}
