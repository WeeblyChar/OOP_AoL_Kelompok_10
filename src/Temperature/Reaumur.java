package Temperature;

public class Reaumur extends Temperature {

	final private double factor = 1.25;

	public Reaumur(String temperature, double temperatureLevel) {
		super(temperature, temperatureLevel);
	}

	@Override
	double getResult(Celcius temperature) {
		return 0;
	}

	@Override
	double getResult(Fahrenheit temperature) {
		return 0;
	}

	@Override
	double getResult(Kelvin temperature) {
		return 0;
	}

	@Override
	double getResult(Reaumur temperature) {
		return 0;
	}

}
