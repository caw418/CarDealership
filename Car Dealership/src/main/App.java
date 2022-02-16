/*
 * Name: Daiki Naruke
 * Date: 2/3/22
 * Description: The App class is the app that users use to view the inventory and buy cars. It is also the app that
 * the admin uses to add and remove cars from the lot as well as view the lot. Username and password for admin account
 * are as follows: username: admin password: password
 */
package main;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

	static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args) {
	
		int userInput = 0;
		Lot lot = new Lot();
		String make;
		String model;
		int year;
		String VIN;
		double price;
		Car car;
		ArrayList<Car> resultList = new ArrayList<Car>();
		String username = "admin";
		String password = "password";
		String usernameEntered;
		String passwordEntered;
		
		do
		{
			System.out.println("1 - View Cars");
			System.out.println("2 - Search Inventory");
			System.out.println("3 - Buy Cars");
			System.out.println("4 - Admin Login");
			userInput = console.nextInt();
			switch(userInput)
			{
			case 1:
				lot.viewLot();
				break;
			case 2:
				System.out.println("1 - Search by Make, Model and Year");
				System.out.println("2 - Search by Make");
				userInput = console.nextInt();
				switch(userInput)
				{
				case 1:
					System.out.println("Enter the Make: ");
					make = console.next();
					System.out.println("Enter the Model: ");
					model = console.next();
					System.out.println("Enter the Year: ");
					year = console.nextInt();
					car = lot.searchLot(make, model, year);
					System.out.println("Search Results: ");
					System.out.println(car);
					break;
				case 2:
					System.out.println("Enter the Make: ");
					make = console.next();
					resultList = lot.searchLot(make);
					for(Car c: resultList)
					{
						System.out.println(c);
					}
					break;
				default:
					System.out.println("Error: Please enter a valid option.");
					break;
				}
				break;
			case 3:
				System.out.println("Enter the VIN of the car you want to buy.");
				VIN = console.next();
				car = lot.searchLotByVIN(VIN);
				if(lot.removeCar(VIN))
				{
					System.out.println("You just bought a " + car.getYear() + " " + car.getMake() + 
							" " + car.getModel() + "!");
				}
				break;
			case 4:
				System.out.println("Admin Login");
				System.out.println("Enter your username: ");
				usernameEntered = console.next();
				System.out.println("Enter your password: ");
				passwordEntered = console.next();
				if(usernameEntered.equals(username) && passwordEntered.equals(password))
				{
					System.out.println("Login Successful");
					do
					{
						System.out.println("1 - Add Car");
						System.out.println("2 - Remove Car");
						System.out.println("3 - View Lot");
						userInput = console.nextInt();
						switch(userInput)
						{
						case 1:
							System.out.println("Enter the Make: ");
							make = console.next();
							System.out.println("Enter the Model: ");
							model = console.next();
							System.out.println("Enter the Year: ");
							year = console.nextInt();
							System.out.println("Enter the VIN: ");
							VIN = console.next();
							System.out.println("Enter the Price: ");
							price = console.nextDouble();
							car = new Car(make, model, year, VIN, price);
							lot.addCar(car);
							System.out.println("Car added.");
							break;
						case 2:
							System.out.println("Enter the VIN of the Car to remove: ");
							VIN = console.next();
							car = lot.searchLotByVIN(VIN);
							if(lot.removeCar(VIN))
							{
								System.out.println("Successfully removed " + car.getYear() + " " + car.getMake() + 
										" " + car.getModel() + ".");
							}
							else
							{
								System.out.println("Operation Failed.");
							}
							break;
						case 3:
							lot.viewLot();
							break;
						default:
							System.out.println("Error: Please enter a valid option.");
						}
						System.out.println("Enter 1 to select another admin option, 2 to logout and return to " +
						"customer view");
						userInput = console.nextInt();
					}
					while(userInput == 1);
				}
				else
				{
					System.out.println("Login Failed");
				}
			}
			System.out.println("Enter 1 to select another option, 2 to exit");
			userInput = console.nextInt();
		}
		while(userInput == 1);
	}
}