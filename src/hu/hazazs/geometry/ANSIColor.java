package hu.hazazs.geometry;

final class ANSIColor {

	private static ANSIColor color;
	private static final String RESET = "\033[0m";
	private static final String RED = "\033[1;31m";

	private ANSIColor() {
	}

	static ANSIColor getColor() {
		if (color == null) {
			color = new ANSIColor();
		}
		return color;
	}

	String black(Object object) {
		return RESET + object;
	}

	String red(Object object) {
		return RED + object + RESET;
	}

}