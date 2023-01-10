package hu.hazazs.geometry.shape;

import hu.hazazs.geometry.metric.MetricUnit;
import hu.hazazs.geometry.util.InputHandler;

public final class Kite extends Shape {

	private Side A;
	private Side B;
	private double angleBetweenAB;

	@Override
	public void getAndSetSidesAndAngles(InputHandler handler) {
		A = handler.getSide("A");
		B = handler.getSide("B");
		angleBetweenAB = handler.getAngle("A and B");
	}

	@Override
	public void printAreaAndPerimeter(MetricUnit unit) {
		double convertedA = convert(A, unit);
		double convertedB = convert(B, unit);
		printAreaAndPerimeter(calculateArea(convertedA, convertedB, angleBetweenAB),
				calculatePerimeter(convertedA, convertedB), unit.getUnit());
	}

	private double calculateArea(double convertedA, double convertedB, double angleBetweenAB) {
		return convertedA * convertedB * Math.sin(Math.toRadians(angleBetweenAB));
	}

	private double calculatePerimeter(double convertedA, double convertedB) {
		return 2 * (convertedA + convertedB);
	}

}