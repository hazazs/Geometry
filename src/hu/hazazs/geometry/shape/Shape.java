package hu.hazazs.geometry.shape;

import hu.hazazs.geometry.metric.MetricConverter;
import hu.hazazs.geometry.metric.MetricUnit;

public abstract class Shape implements ShapeRequirements {

	double convert(Side side, MetricUnit unit) {
		return side.getUnit() == unit ? side.getLength() : MetricConverter.getConverter().convert(side, unit);
	}

	void printAreaAndPerimeter(double area, double perimeter, String unit) {
		System.out.printf("A = %." + getNumberOfDecimalPlaces(area) + "f %s²%n", area, unit);
		System.out.printf("P = %." + getNumberOfDecimalPlaces(perimeter) + "f %s", perimeter, unit);
	}

	private int getNumberOfDecimalPlaces(double value) {
		if (value == (int) value) {
			return 0;
		} else {
			value -= (int) value;
			int numberOfDecimalPlaces = 1;
			while (value * Math.pow(10.0, numberOfDecimalPlaces) < 1) {
				numberOfDecimalPlaces++;
			}
			return String.format("%." + (numberOfDecimalPlaces + 1) + "f", value).endsWith("0") ? numberOfDecimalPlaces
					: numberOfDecimalPlaces + 1;
		}
	}

}