package hu.hazazs.geometry.shape;

import hu.hazazs.geometry.InputHandler;
import hu.hazazs.geometry.metric.MetricUnit;

public final class Square extends Shape {

	private Side A;

	@Override
	public void getAndSetSidesAndAngles(InputHandler handler) {
		A = handler.getSide("A");
	}

	@Override
	public void printAreaAndPerimeter(MetricUnit unit) {
		double convertedA = convert(A, unit);
		printAreaAndPerimeter(calculateArea(convertedA), calculatePerimeter(convertedA), unit.getUnit());
	}

	private double calculateArea(double convertedA) {
		return Math.pow(convertedA, 2);
	}

	private double calculatePerimeter(double convertedA) {
		return 4 * convertedA;
	}

}