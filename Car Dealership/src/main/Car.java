/*
 * Name: Daiki Naruke
 * Date: 2/3/22
 * Description: The Car class is a class for modeling car objects to put into the lot. Each car has fields to store
 * the make, model, year, VIN and price. The VIN uniquely identifies a car.
 */

package main;

public class Car {

	private String make;
	private String model;
	private int year;
	private String VIN;
	private double price;

	public Car(String make, String model, int year, String VIN, double price)
	{
		this.make = make;
		this.model = model;
		this.year = year;
		this.VIN = VIN;
		this.price = price;
	}

	@Override
	public String toString() 
	{
		return "Car [make=" + make + ", model=" + model + ", year=" + year + ", VIN=" + VIN + ", price=" + price + "]";
	}
	
	public String getVIN() 
	{
		return VIN;
	}
	
	public String getMake()
	{
		return make;
	}
	
	public String getModel()
	{
		return model;
	}
	
	public int getYear()
	{
		return year;
	}
}