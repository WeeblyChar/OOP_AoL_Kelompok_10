package Temperature;

// Reaumur as the child class of Temperature as the implementation of inherintance
public class Reaumur extends Temperature {

	final private double factor = 1.25;

	public Reaumur(double temperatureLevel) {
		super(temperatureLevel);
	}

	@Override
	public double getResult(String temperature) {
		if (temperature.equals("Celcius")) return this.getTemperatureLevel() * factor;
		else if (temperature.equals("Fahrenheit")) return (this.getTemperatureLevel() * (factor + 1)) + 32;
		else if (temperature.equals("Kelvin")) return (this.getTemperatureLevel() * factor) + 273.15;
		else if(temperature.equals("Rankine")) return (this.getTemperatureLevel() * (factor + 1)) + 32 + 459.67;
		return this.getTemperatureLevel();
	}
}
