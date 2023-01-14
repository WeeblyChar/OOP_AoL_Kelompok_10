package Temperature;

// Temparature as the parent class which consist of variables and method that can be used in the child class.
// This class combining the usage of inheritance, polymorphism, and abstraction together, which those 3 elements are essential for the child class.
// This class can also be called as a super class
public abstract class Temperature {
	private double temperatureLevel;

	public Temperature(double temperatureLevel) {
		super();
		this.temperatureLevel = temperatureLevel;
	}

	abstract double getResult(String temperature);

	public double getTemperatureLevel() {
		return temperatureLevel;
	}

	public void setTemperatureLevel(double temperatureLevel) {
		this.temperatureLevel = temperatureLevel;
	}

}
