package Temperature;

public class Kelvin extends Temperature {

	final private double factor = 1.8;

	public Kelvin(String temperature, double temperatureLevel) {
		super(temperature, temperatureLevel);
	}

	@Override
	double getResult(Celcius temperature) {
		double kel_to_cel = this.getTemperatureLevel();
		kel_to_cel = kel_to_cel - 273.15;
		temperature.setTemperatureLevel(kel_to_cel);
		return temperature.getTemperatureLevel();
	}

	@Override
	double getResult(Fahrenheit temperature) {
		double kel_to_fah = this.getTemperatureLevel();
		kel_to_fah = (kel_to_fah * factor) - 459.67;
		temperature.setTemperatureLevel(kel_to_fah);
		return temperature.getTemperatureLevel();
	}

	@Override
	double getResult(Kelvin temperature) {
		temperature.setTemperatureLevel(this.getTemperatureLevel());
		return temperature.getTemperatureLevel();
	}

	@Override
	double getResult(Reaumur temperature) {
		double kel_to_rea = this.getTemperatureLevel();
		kel_to_rea = (kel_to_rea - 273.15) * (factor - 1);
		temperature.setTemperatureLevel(kel_to_rea);
		return temperature.getTemperatureLevel();
	}

}
