package factorydesignpattern;

/**
 * Factory class which is responsible for creating the objects without knowing
 * or exposing the creational logic. This type of creational logic is used when
 * we are not aware of the objects that are to be created up-front.
 * 
 * @author pksuresh
 *
 */
public class ShapeFactory {

	public Shape getShape(String type) {

		if (null == type) {
			return null;
		}
		switch (type) {
		case "Circle":
			return new Circle();
		case "Rectangle":
			return new Rectangle();
		case "Square":
			return new Square();
		default:
			return null;
		}
	}
}
