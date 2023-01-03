package hu.hazazs.geometry.shape;

import hu.hazazs.geometry.InputHandler;
import hu.hazazs.geometry.metric.MetricUnit;

interface ShapeRequirements {

	void getAndSetSidesAndAngles(InputHandler handler);

	void printAreaAndPerimeter(MetricUnit unit);

}