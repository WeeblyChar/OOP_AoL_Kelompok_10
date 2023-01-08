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
	}

	public String getMeasurement() {
		return measurement;
	}

	public void setMeasurement(String measurement) {
		this.measurement = measurement;
	}

	public double getFactor() {
		return factor;
	}

	public double optionCheck() {
		String measurement = this.measurement;
		if (measurement.equalsIgnoreCase("inch")) {
			factor = INCH_TO_METER;
			return factor;
		} else if (measurement.equalsIgnoreCase("foot")) {
			factor = FOOT_TO_METER;
			return factor;
		} else if (measurement.equalsIgnoreCase("mile")) {
			factor = MILE_TO_METER;
			return factor;
		} else if (measurement.equalsIgnoreCase("yard")) {
			factor = YARD_TO_METER;
			return factor;
		} else if (measurement.equalsIgnoreCase("milimeter")) {
			factor = MM_TO_METER;
			return factor;
		} else if (measurement.equalsIgnoreCase("centimeter")) {
			factor = CM_TO_METER;
			return factor;
		} else if (measurement.equalsIgnoreCase("kilometer")) {
			factor = KM_TO_METER;
			return factor;
		}
		return factor;
	}

	public double toMeter(double x) {
		return (x * factor);
	}

	public double fromMeter(double x) {
		return (x / factor);
	}

}
