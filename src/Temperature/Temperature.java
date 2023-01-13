package Temperature;

public abstract class Temperature {
	private double temperatureLevel;

	public Temperature(double temperatureLevel) {
		super();
		this.temperatureLevel = temperatureLevel;
	}

	abstract double getResult(String temperature);

	public double getTemperatureLevel() {
		return temperatureLevel;
	}

	public void setTemperatureLevel(double temperatureLevel) {
		this.temperatureLevel = temperatureLevel;
	}

}
