package hu.hazazs.geometry.shape;

import hu.hazazs.geometry.metric.MetricConverter;
import hu.hazazs.geometry.metric.MetricUnit;

public abstract class Shape implements ShapeRequirements {

	double convert(Side side, MetricUnit unit) {
		return side.getUnit() == unit ? side.getLength() : MetricConverter.getConverter().convert(side, unit);
	}

	void printAreaAndPerimeter(double area, double perimeter, String unit) {
		System.out.printf("A = %." + getNumberOfDecimalPlaces(area) + "f %s²%n", area, unit);
		System.out.printf("P = %." + getNumberOfDecimalPlaces(perimeter) + "f %s%n", perimeter, unit);
	}

	private int getNumberOfDecimalPlaces(double value) {
		if (String.format("%f", value).matches("\\d+,0+")) {
			return 0;
		} else {
			value -= (int) value;
			int numberOfDecimalPlaces = 1;
			while (value * Math.pow(10.0, numberOfDecimalPlaces) < 1) {
				numberOfDecimalPlaces++;
			}
			return numberOfDecimalPlaces + 1;
		}
	}

}