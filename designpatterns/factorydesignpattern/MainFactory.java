package factorydesignpattern;

public class MainFactory {

	public static void main(String[] args) {

		ShapeFactory shapeFactory = new ShapeFactory();
		Shape shape = shapeFactory.getShape("Square");
		shape.draw();
	}

}
