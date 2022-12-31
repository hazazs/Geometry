package hu.hazazs.geometry;

enum MetricUnit {

	MM("mm"), CM("cm"), DM("dm"), M("m"), KM("km");

	private final String unit;

	private MetricUnit(String unit) {
		this.unit = unit;
	}

	String getUnit() {
		return unit;
	}

}