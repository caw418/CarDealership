/*
 * Name: Daiki Naruke
 * Date: 2/3/22
 * Description: The Lot class contains the cars. It has methods that allow you to add cars, remove cars, view cars
 * and search for cars
 */

package main;

import java.util.ArrayList;

public class Lot {

	//The list to store the cars in the lot
	ArrayList<Car> inventory = new ArrayList<>();
	
	public Lot()
	{
		//Create Cars to put into the lot and add them to our inventory
		Car Mustang = new Car("Ford", "Mustang", 2022, "31N543", 30134.00);
		Car Camaro = new Car("Chevrolet", "Camaro", 2022, "432NF3", 25000.00);
		Car Versa = new Car("Nissan", "Versa", 2011, "31N456", 5000.00);
		Car Highlander = new Car("Toyota", "Highlander", 2008, "5RTF65", 10000.00);
		Car Corvette = new Car("Chevrolet", "Corvette", 2022, "5F65T7", 65000.00);
		Car NSX = new Car("Acura", "NSX", 2022, "HT6570", 120000.00);
		Car P1 = new Car("McLaren", "P1", 2022, "FN5643", 1825000.00);
		inventory.add(Mustang);
		inventory.add(Camaro);
		inventory.add(Versa);
		inventory.add(Highlander);
		inventory.add(Corvette);
		inventory.add(NSX);
		inventory.add(P1);
	}
	
	//loops through each car in inventory and prints out each car
	public void viewLot()
	{
		for(Car c: inventory)
		{
			System.out.println(c);
		}
	}
	
	//Adds the Car object that you pass in as an argument to inventory
	public void addCar(Car car)
	{
		inventory.add(car);
	}
	
	//Removes the Car with the VIN passed in as a argument from inventory. Returns true if successful, false if not.
	public boolean removeCar(String VIN)
	{
		for(Car c: inventory)
		{
			if(c.getVIN().equals(VIN))
			{
				inventory.remove(c);
				return true;
			}
		}
		return false;
	}

	/*
	 * Loops through inventory looking for a Car with the make, model and year passed in as arguments. If found, that
	 * car is returned, if not then this method returns null
	 */
	
	public Car searchLot(String make, String model, int year)
	{
		for(Car c: inventory)
		{
			if(c.getMake().equals(make) && c.getModel().equals(model) && c.getYear() == year)
			{
				return c;
			}
		}
		return null;
	}
	
	/*
	 * Loops through inventory looking for all Cars in the inventory with the make passed in as an argument. If one is
	 * found, then it is added to an ArrayList called resultList. Once finished looping through inventory the resultList
	 * is returned regardless of rather any matches were found or not.
	 */
	public ArrayList<Car> searchLot(String make)
	{
		ArrayList<Car> resultList = new ArrayList<>();
		for(Car c: inventory)
		{
			if(c.getMake().equals(make))
			{
				resultList.add(c);
			}
		}
		return resultList;
	}
	
	
	//Loops through inventory looking for a car with that VIN. If found it returns that car. If not returns null
	public Car searchLotByVIN(String VIN)
	{
		for(Car c: inventory)
		{
			if(c.getVIN().equals(VIN))
			{
				return c;
			}
		}
		return null;
	}
}