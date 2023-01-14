package Temperature;

// Celcius as the child class of Temperature as the implementation of inherintance
public class Celcius extends Temperature {

	final private double factor = 1.8;

	public Celcius(double temperatureLevel) {
		super(temperatureLevel);
	}

	@Override
	public double getResult(String temperature) {
		if(temperature.equals("Fahrenheit")) return (this.getTemperatureLevel() * factor) + 32; 
		else if(temperature.equals("Kelvin")) return this.getTemperatureLevel() + 273.15;
		else if(temperature.equals("Reaumur")) return this.getTemperatureLevel() * (factor - 1);
		else if(temperature.equals("Rankine")) return (this.getTemperatureLevel() * factor) + 32 + 459.67;
		return this.getTemperatureLevel();
	}
}
