package hu.hazazs.geometry.metric;

import hu.hazazs.geometry.shape.Side;

public final class MetricConverter {

	private static MetricConverter converter;

	private MetricConverter() {
	}

	public static MetricConverter getConverter() {
		if (converter == null) {
			converter = new MetricConverter();
		}
		return converter;
	}

	public double convert(Side side, MetricUnit unit) {
		return side.getLength() * side.getUnit().getConversionRate() / unit.getConversionRate();
	}

}