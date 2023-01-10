package hu.hazazs.geometry;

import java.util.Scanner;
import hu.hazazs.geometry.shape.Shape;
import hu.hazazs.geometry.util.InputHandler;
import hu.hazazs.geometry.util.Printer;

final class Main {

	public static void main(String[] args) {
		new Main().run();
	}

	private void run() {
		try (Scanner scanner = new Scanner(System.in)) {
			InputHandler handler = InputHandler.getHandler(scanner);
			Printer printer = Printer.getPrinter();
			Shape shape;
			System.out.println("Hello!");
			outer: while (true) {
				printer.printInitialMenu();
				shape = handler.getShape();
				printer.printShape(shape);
				shape.getAndSetSidesAndAngles(handler);
				while (true) {
					printer.printUnits();
					shape.printAreaAndPerimeter(handler.getUnit());
					printer.printFinalMenu();
					int choice = handler.getChoice();
					if (choice == 1) {
						continue;
					} else if (choice == 2) {
						break;
					} else {
						break outer;
					}
				}
			}
			System.out.println("Good bye!");
		}
	}

}