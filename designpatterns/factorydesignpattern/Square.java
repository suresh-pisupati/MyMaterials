package factorydesignpattern;

/**
 * Class which implements the base interface and provides the custom logic.
 * 
 * @author pksuresh
 *
 */
public class Square implements Shape {

	@Override
	public void draw() {

		System.out.println("In Square::::draw()::::");
	}

}
