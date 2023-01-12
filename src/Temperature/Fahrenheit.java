package Temperature;

public class Fahrenheit extends Temperature {

	final private double factor = 1.8;

	public Fahrenheit(String temperature, double temperatureLevel) {
		super(temperature, temperatureLevel);
	}

	@Override
	double getResult(Celcius temperature) {
		double fah_to_cel = this.getTemperatureLevel();
		fah_to_cel = (fah_to_cel - 32) / factor;
		temperature.setTemperatureLevel(fah_to_cel);
		return temperature.getTemperatureLevel();
	}

	@Override
	double getResult(Fahrenheit temperature) {
		temperature.setTemperatureLevel(this.getTemperatureLevel());
		return temperature.getTemperatureLevel();
	}

	@Override
	double getResult(Kelvin temperature) {
		double fah_to_kel = this.getTemperatureLevel();
		fah_to_kel = (fah_to_kel + 459.67) / factor;
		temperature.setTemperatureLevel(fah_to_kel);
		return temperature.getTemperatureLevel();
	}

	@Override
	double getResult(Reaumur temperature) {
		double fah_to_rea = this.getTemperatureLevel();
		fah_to_rea = (fah_to_rea - 32) / (factor + 0.45);
		temperature.setTemperatureLevel(fah_to_rea);
		return temperature.getTemperatureLevel();
	}

}
