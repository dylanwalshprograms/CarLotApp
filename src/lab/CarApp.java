package lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarApp {
	
	public static Scanner scnr = new Scanner(System.in);
	public static List<Car> cars = new ArrayList<>();

	public static void main(String[] args) {
		
		System.out.println("Welcome to the GC Car teminal admin page!\n");
		int numCars = Validator.getInt(scnr, "How many cars are you entering:");
		for (int i = 0; i < numCars; i++) {
			addCar(i);
		}
		
		System.out.println("Current Inventory: ");
		System.out.printf("%-12s %-12s %-12s %-12s\n", "Make", "Model", "Year", "Price");
		System.out.println("===============================================");
		for (Car car : cars) {
			System.out.printf("%-12s %-12s %-12s $%.2f\n", car.getMake(), car.getModel(), car.getYear(), car.getPrice());
		}	
	}
		
	public static void addCar(int i) {
		Car car = new Car();
		
		System.out.print("Enter car #"+ (i + 1) + " make: ");
		car.setMake(scnr.nextLine());
		
		System.out.print("Enter car #"+ (i + 1) + " model: ");
		car.setModel(scnr.nextLine());
		
		System.out.print("Enter car #"+ (i + 1) + " year: ");
		car.setYear(scnr.nextInt());
		
		System.out.print("Enter car #"+ (i + 1) + " price: ");
		car.setPrice(scnr.nextDouble());
		
		scnr.nextLine();
		
		cars.add(car);
		
	}
	
	public static void listCars() {
		for (int i = 0; i < cars.size(); i++) {
			System.out.println("Car " + (i + 1) + ": " + cars.get(i));
		}
	}
}
