package hu.hazazs.geometry;

import java.util.Scanner;
import hu.hazazs.geometry.metric.MetricUnit;
import hu.hazazs.geometry.shape.Side;

public final class InputHandler {

	private static InputHandler handler;
	private final Scanner scanner;

	private InputHandler(Scanner scanner) {
		this.scanner = scanner;
	}

	static InputHandler getHandler(Scanner scanner) {
		if (handler == null) {
			handler = new InputHandler(scanner);
		}
		return handler;
	}

	public Side getSide(String identifier) {
		String input;
		MetricUnit inputUnit;
		while (true) {
			System.out.print(
					ANSIColor.getColor().black(String.format("Please give the length of the Side %s: ", identifier)));
			input = scanner.nextLine();
			if ((inputUnit = getUnit(input)) == null) {
				System.out.println(ANSIColor.getColor().red(
						"The length must be a valid floating point number (with dot as a decimal point if needed) followed by a space and one of these metric units:"));
				for (MetricUnit unit : MetricUnit.values()) {
					System.out.println(unit.getUnit());
				}
				continue;
			}
			break;
		}
		return new Side(Double.parseDouble(input.split(" ")[0]), inputUnit);
	}

	private MetricUnit getUnit(String input) {
		if (input.matches("\\d+(\\.\\d+)? \\w+")) {
			String inputUnit = input.split(" ")[1];
			for (MetricUnit unit : MetricUnit.values()) {
				if (inputUnit.equals(unit.getUnit())) {
					return unit;
				}
			}
			return null;
		}
		return null;
	}

	public double getAngle(String sidesBetween) {
		String input;
		while (true) {
			System.out.printf("Please give the angle between the Sides %s: ", sidesBetween);
			input = scanner.nextLine();
			if (!input.matches("\\d+(\\.\\d+)?")) {
				System.out.println(ANSIColor.getColor().red(
						"The length must be a valid floating point number (with dot as a decimal point if needed)."));
				continue;
			}
			break;
		}
		return Double.parseDouble(input);
	}

}