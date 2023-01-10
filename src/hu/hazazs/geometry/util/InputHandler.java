package hu.hazazs.geometry.util;

import java.util.Scanner;
import hu.hazazs.geometry.metric.MetricUnit;
import hu.hazazs.geometry.shape.Shape;
import hu.hazazs.geometry.shape.ShapeEnum;
import hu.hazazs.geometry.shape.Side;

public final class InputHandler {

	private static InputHandler handler;
	private final Scanner scanner;

	private InputHandler(Scanner scanner) {
		this.scanner = scanner;
	}

	public static InputHandler getHandler(Scanner scanner) {
		if (handler == null) {
			handler = new InputHandler(scanner);
		}
		return handler;
	}

	public Shape getShape() {
		String input;
		int intInput;
		ShapeEnum[] shapes = ShapeEnum.values();
		while (true) {
			System.out.print(ANSIColor.getColor().black("Please choose from the menu: "));
			input = scanner.nextLine();
			intInput = input.matches("\\d+") ? Integer.parseInt(input) : 0;
			if (intInput == shapes.length + 1) {
				System.out.print("Good bye!");
				System.exit(0);
			}
			if (intInput == 0 || intInput > shapes.length) {
				System.out.println(ANSIColor.getColor().red("Invalid menu number."));
				continue;
			}
			return shapes[intInput - 1].getShape();
		}
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

	public MetricUnit getUnit() {
		String input;
		int intInput;
		MetricUnit[] units = MetricUnit.values();
		while (true) {
			System.out.print(ANSIColor.getColor()
					.black("Please choose the metric unit in which do you want to see the results: "));
			input = scanner.nextLine();
			intInput = input.matches("\\d+") ? Integer.parseInt(input) : 0;
			if (intInput == 0 || intInput > units.length) {
				System.out.println(ANSIColor.getColor().red("Invalid menu number."));
				continue;
			}
			return units[intInput - 1];
		}
	}

	public int getChoice() {
		String input;
		while (true) {
			System.out.print(ANSIColor.getColor().black("Please choose from the menu: "));
			input = scanner.nextLine();
			if (!"1".equals(input) && !"2".equals(input) && !"3".equals(input)) {
				System.out.println(ANSIColor.getColor().red("Invalid menu number."));
				continue;
			}
			return Integer.parseInt(input);
		}
	}

}