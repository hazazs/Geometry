package hu.hazazs.geometry.shape;

public enum ShapeEnum {

	SQUARE(new Square()), RECTANGLE(new Rectangle()), PARALLELOGRAM(new Parallelogram()), RHOMBUS(new Rhombus()),
	KITE(new Kite());

	private final Shape shape;

	private ShapeEnum(Shape shape) {
		this.shape = shape;
	}

	public Shape getShape() {
		return shape;
	}

}