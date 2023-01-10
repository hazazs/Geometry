package hu.hazazs.geometry.shape;

import hu.hazazs.geometry.metric.MetricUnit;
import hu.hazazs.geometry.util.InputHandler;

interface ShapeRequirements {

	void getAndSetSidesAndAngles(InputHandler handler);

	void printAreaAndPerimeter(MetricUnit unit);

}