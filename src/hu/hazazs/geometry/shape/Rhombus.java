package hu.hazazs.geometry.shape;

import hu.hazazs.geometry.InputHandler;
import hu.hazazs.geometry.metric.MetricUnit;

public final class Rhombus extends Shape {

	private Side A;
	private double angleBetweenAB;

	@Override
	public void getAndSetSidesAndAngles(InputHandler handler) {
		A = handler.getSide("A");
		angleBetweenAB = handler.getAngle("A and A");
	}

	@Override
	public void printAreaAndPerimeter(MetricUnit unit) {
		double convertedA = convert(A, unit);
		printAreaAndPerimeter(calculateArea(convertedA, angleBetweenAB), calculatePerimeter(convertedA),
				unit.getUnit());
	}

	private double calculateArea(double convertedA, double angleBetweenAB) {
		return Math.pow(convertedA, 2) * Math.sin(Math.toRadians(angleBetweenAB));
	}

	private double calculatePerimeter(double convertedA) {
		return 4 * convertedA;
	}

}