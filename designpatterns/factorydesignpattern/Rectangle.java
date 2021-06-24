package factorydesignpattern;

/**
 * Class which implements the base interface and provides the custom logic.
 * 
 * @author pksuresh
 *
 */
public class Rectangle implements Shape {

	@Override
	public void draw() {

		System.out.println("In Rectangle::::draw()::::");
	}

}
