package hu.hazazs.geometry.metric;

public enum MetricUnit {

	MM("mm", 1.0 / 1000), CM("cm", 1.0 / 100), DM("dm", 1.0 / 10), M("m", 1.0), KM("km", 1000.0);

	private final String unit;
	private final double conversionRate;

	private MetricUnit(String unit, double conversionRate) {
		this.unit = unit;
		this.conversionRate = conversionRate;
	}

	public String getUnit() {
		return unit;
	}

	double getConversionRate() {
		return conversionRate;
	}

}