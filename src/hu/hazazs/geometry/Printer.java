package hu.hazazs.geometry;

import hu.hazazs.geometry.metric.MetricUnit;
import hu.hazazs.geometry.shape.Shape;
import hu.hazazs.geometry.shape.ShapeEnum;

final class Printer {

	private static Printer printer;

	private Printer() {
	}

	static Printer getPrinter() {
		if (printer == null) {
			printer = new Printer();
		}
		return printer;
	}

	void printInitialMenu() {
		for (ShapeEnum shape : ShapeEnum.values()) {
			System.out.printf("%d - %s%n", shape.ordinal() + 1, shape);
		}
		System.out.printf("%d - EXIT%n", ShapeEnum.values().length + 1);
	}

	void printShape(Shape shape) {
		String toString = shape.toString();
		System.out.println(
				"\n" + toString.substring(toString.lastIndexOf(".") + 1, toString.lastIndexOf("@")).toUpperCase());
	}

	void printUnits() {
		for (MetricUnit unit : MetricUnit.values()) {
			System.out.printf("%d - %s%n", unit.ordinal() + 1, unit);
		}
	}

	void printFinalMenu() {
		System.out.println();
		System.out.println("1 - This shape in another metric unit");
		System.out.println("2 - New Shape");
		System.out.println("3 - EXIT");
	}

}