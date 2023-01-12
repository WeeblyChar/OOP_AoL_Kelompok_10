package Temperature;

public class Reaumur extends Temperature {

	final private double factor = 1.25;

	public Reaumur(String temperature, double temperatureLevel) {
		super(temperature, temperatureLevel);
	}

	@Override
	double getResult(Celcius temperature) {
		double rea_to_cel = this.getTemperatureLevel();
		rea_to_cel = rea_to_cel * factor;
		temperature.setTemperatureLevel(rea_to_cel);
		return temperature.getTemperatureLevel();
	}

	@Override
	double getResult(Fahrenheit temperature) {
		double rea_to_fah = this.getTemperatureLevel();
		rea_to_fah = (rea_to_fah * (factor + 1)) + 32;
		temperature.setTemperatureLevel(rea_to_fah);
		return temperature.getTemperatureLevel();
	}

	@Override
	double getResult(Kelvin temperature) {
		double rea_to_kel = this.getTemperatureLevel();
		rea_to_kel = (rea_to_kel * factor) + 273.15;
		temperature.setTemperatureLevel(rea_to_kel);
		return temperature.getTemperatureLevel();
	}

	@Override
	double getResult(Reaumur temperature) {
		temperature.setTemperatureLevel(this.getTemperatureLevel());
		return temperature.getTemperatureLevel();
	}

}
