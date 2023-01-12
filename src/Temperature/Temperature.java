package Temperature;

public abstract class Temperature {
	private String temperature;
	private double temperatureLevel;

	public Temperature(String temperature, double temperatureLevel) {
		super();
		this.temperature = temperature;
		this.temperatureLevel = temperatureLevel;
	}

	abstract double getResult(Celcius temperature);
	abstract double getResult(Fahrenheit temperature);
	abstract double getResult(Kelvin temperature);
	abstract double getResult(Reaumur temperature);
	
	public double getTemperatureLevel() {
		return temperatureLevel;
	}

	public void setTemperatureLevel(double temperatureLevel) {
		this.temperatureLevel = temperatureLevel;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	
}
