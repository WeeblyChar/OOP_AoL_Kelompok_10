package UI;

public class Length {

	// To Meter
	final private double INCH_TO_METER = 0.0254;
	final private double FOOT_TO_METER = 0.3048;
	final private double MILE_TO_METER = 1609.344;
	final private double YARD_TO_METER = 0.9144;
	final private double MM_TO_METER = 0.001;
	final private double CM_TO_METER = 0.01;
	final private double KM_TO_METER = 1000;

	private double factor = 1;
	private String measurement;

	public Length(String measurement) {
		super();
		this.measurement = measurement;
		this.factor = 1;
	}

	public String getMeasurement() {
		return measurement;
	}

	public void setMeasurement(String measurement) {
		this.measurement = measurement;
	}

	public double getFactor() {
		String measurement = this.measurement;
		if (measurement.equalsIgnoreCase("Inch")) {
			factor = INCH_TO_METER;
			return factor;
		} else if (measurement.equalsIgnoreCase("Foot")) {
			factor = FOOT_TO_METER;
			return factor;
		} else if (measurement.equalsIgnoreCase("Mile")) {
			factor = MILE_TO_METER;
			return factor;
		} else if (measurement.equalsIgnoreCase("Yard")) {
			factor = YARD_TO_METER;
			return factor;
		} else if (measurement.equalsIgnoreCase("Milimeter")) {
			factor = MM_TO_METER;
			return factor;
		} else if (measurement.equalsIgnoreCase("Centimeter")) {
			factor = CM_TO_METER;
			return factor;
		} else if (measurement.equalsIgnoreCase("Kilometer")) {
			factor = KM_TO_METER;
			return factor;
		}
		return factor;
	}

	public void setFactor(double factor) {
		this.factor = factor;
	}

	public double toMeter(double x) {
		return (x * factor);
	}

	public double fromMeter(double x) {
		return (x / factor);
	}

}
