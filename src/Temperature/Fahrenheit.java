package Temperature;

// Fahrenheit as the child class of Temperature as the implementation of inherintance
public class Fahrenheit extends Temperature {

	final private double factor = 1.8;

	public Fahrenheit(double temperatureLevel) {
		super(temperatureLevel);
	}

	@Override
	public double getResult(String temperature) {
		if (temperature.equals("Celcius")) return (this.getTemperatureLevel() - 32) / factor;
		else if (temperature.equals("Kelvin")) return (this.getTemperatureLevel() + 459.67) / factor;
		else if (temperature.equals("Reaumur")) return (this.getTemperatureLevel() - 32) / (factor + 0.45);
		else if(temperature.equals("Rankine")) return this.getTemperatureLevel() + 459.67;
		return this.getTemperatureLevel();
	}
}
