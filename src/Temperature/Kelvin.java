package Temperature;

public class Kelvin extends Temperature {

	final private double factor = 1.8;

	public Kelvin(double temperatureLevel) {
		super(temperatureLevel);
	}

	@Override
	public double getResult(String temperature) {
		if (temperature.equals("Celcius")) return this.getTemperatureLevel() - 273.15;
		else if (temperature.equals("Fahrenheit")) return (this.getTemperatureLevel() * factor) - 459.67;
		else if (temperature.equals("Reaumur")) return (this.getTemperatureLevel() - 273.15) * (factor - 1);
		return this.getTemperatureLevel();
	}
}
