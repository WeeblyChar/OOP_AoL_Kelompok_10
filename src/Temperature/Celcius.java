package Temperature;

public class Celcius extends Temperature {

	final private double factor = 1.8;

	public Celcius(String temperature, double temperatureLevel) {
		super(temperature, temperatureLevel);
	}

	@Override
	double getResult(Celcius temperature) {
		temperature.setTemperatureLevel(this.getTemperatureLevel());
		return this.getTemperatureLevel();
	}

	@Override
	double getResult(Fahrenheit temperature) {
		double cel_to_fah = this.getTemperatureLevel();
		cel_to_fah = (cel_to_fah * factor) + 32;
		temperature.setTemperatureLevel(cel_to_fah);
		return temperature.getTemperatureLevel();
	}

	@Override
	double getResult(Kelvin temperature) {
		temperature.setTemperatureLevel(this.getTemperatureLevel() + 273.15);
		return temperature.getTemperatureLevel();
	}

	@Override
	double getResult(Reaumur temperature) {
		double cel_to_rea = this.getTemperatureLevel() * (factor - 1);
		temperature.setTemperatureLevel(cel_to_rea);
		return temperature.getTemperatureLevel();
	}

}
