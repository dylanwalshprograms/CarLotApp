package lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarAppPartTwo {
	
	public static Scanner scnr = new Scanner(System.in);
	public static List<Car> cars = new ArrayList<>();
	static {
		cars.add(new Car("Subaru", "Impreza", 2018, 24000.00));
		cars.add(new Car("Ford", "Focus RS", 2019, 45000.00));
		cars.add(new Car("Mitsubishi", "Lancer", 2019, 20000.00));
		cars.add(new UsedCar("Toyota", "Rav4", 2009, 5000.00, 19000.00));
		cars.add(new UsedCar("Nissan", "Cube", 2000, 2.00, 300.00));
		cars.add(new UsedCar("Subaru", "Crossover", 1999, 6000.00, 13000.00));	
	}

	public static void main(String[] args) {
		buyCar();
	}
	
	public static void buyCar() {
		int userSelection = 0;
		try {
			listCars();
			userSelection = Validator.getInt(scnr, "Which car would you like?");
			System.out.printf("%-6s %-12s %-12s $%.2f\n", cars.get(userSelection - 1).getYear(), cars.get(userSelection - 1).getMake(),  cars.get(userSelection - 1).getModel(), cars.get(userSelection - 1).getPrice());
			System.out.println();
			boolean buyCar = getYesOrNo(scnr, "Would you like to buy this car (y/n)?");
			if (buyCar) {
				System.out.println();
				System.out.println("Excellent! Our finance department will be in touch with you shortly.");
				cars.remove(userSelection - 1);
				System.out.println();
			}
			buyCar();
		}
		catch (IndexOutOfBoundsException e){
			System.out.println("Have a great day!");
		}
	}
	
	public static void listCars() {
		int i;
		for (i = 0; i < cars.size(); i++) {
			if (cars.get(i) instanceof UsedCar) {
				UsedCar car = (UsedCar) cars.get(i);
				System.out.printf("%-1s %-6s %-12s %-12s $%-12.2f %-12s\n", (i + 1) + ".",  cars.get(i).getYear(), cars.get(i).getMake(),  cars.get(i).getModel(), cars.get(i).getPrice(), "(Used) " + car.getMileage() + " miles");
			}
			else {
				System.out.printf("%-1s %-6s %-12s %-12s $%.2f\n", (i + 1) + ".",  cars.get(i).getYear(), cars.get(i).getMake(),  cars.get(i).getModel(), cars.get(i).getPrice());
			}
		}
		System.out.println((i + 1) + ". Quit");
		
	}
	
	public static boolean getYesOrNo(Scanner scnr, String prompt) { //getYesOrNo from day 6 validation examples
		System.out.print(prompt);
		String input = scnr.nextLine().toLowerCase().trim(); //added a trim in case the user accidentally puts a space before their answer
		boolean isValid = input.equals("yes") || input.equals("y")|| input.equals("no")|| input.equals("n");
		while (!isValid) { // keep looping as long as they enter something invalid
			System.out.println();
			System.out.println("Oops. Please enter yes or no.");
			System.out.println();
			System.out.print(prompt);
			input = scnr.nextLine().toLowerCase();
			isValid = input.equals("yes") || input.equals("y")|| input.equals("no")|| input.equals("n");
		}
		return input.startsWith("y");
	}
	
	public static void showCarById(int id) {
		System.out.println(cars.get(id - 1));
		
	}
	
	public static void buyCar(int id) {
		cars.remove(id - 1);
	}

}
