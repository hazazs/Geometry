package hu.hazazs.geometry.shape;

import hu.hazazs.geometry.metric.MetricUnit;

public final class Side {

	private final double length;
	private final MetricUnit unit;

	public Side(double length, MetricUnit unit) {
		this.length = length;
		this.unit = unit;
	}

	public double getLength() {
		return length;
	}

	public MetricUnit getUnit() {
		return unit;
	}

}