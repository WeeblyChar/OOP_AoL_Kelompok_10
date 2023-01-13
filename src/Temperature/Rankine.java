package Temperature;

public class Rankine extends Temperature {
	
	final private double factor = 1.8;
	
	public Rankine(double temperatureLevel) {
		super(temperatureLevel);
	}

	@Override
	public double getResult(String temperature) {
		if(temperature.equals("Celcius")) return (this.getTemperatureLevel() - 32 - 459.67) / factor; 
		else if(temperature.equals("Fahrenheit")) return this.getTemperatureLevel() - 459.67;
		else if(temperature.equals("Kelvin")) return this.getTemperatureLevel() / factor;
		else if(temperature.equals("Reaumur")) return (this.getTemperatureLevel() - 32 - 459.67) / (factor + 0.45);
		return this.getTemperatureLevel();
	}
	
}
