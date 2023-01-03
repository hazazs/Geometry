package hu.hazazs.geometry.shape;

import hu.hazazs.geometry.InputHandler;
import hu.hazazs.geometry.metric.MetricUnit;

public final class Rectangular extends Shape {

	private Side A;
	private Side B;

	@Override
	public void getAndSetSidesAndAngles(InputHandler handler) {
		A = handler.getSide("A");
		B = handler.getSide("B");
	}

	@Override
	public void printAreaAndPerimeter(MetricUnit unit) {
		double convertedA = convert(A, unit);
		double convertedB = convert(B, unit);
		printAreaAndPerimeter(calculateArea(convertedA, convertedB), calculatePerimeter(convertedA, convertedB),
				unit.getUnit());
	}

	private double calculateArea(double convertedA, double convertedB) {
		return convertedA * convertedB;
	}

	private double calculatePerimeter(double convertedA, double convertedB) {
		return 2 * (convertedA + convertedB);
	}

}