//scanner class
import java.util.Scanner;

//parent class
 class Car {
	
	//attributes set to protected so child class can access them directly
	protected String carID;
	protected String customerName;
	protected int rentalDays;
	
	//constructor with parameters
	public Car (String carID, String customerName, int rentalDays) {
		
		this.carID = carID;
		this.customerName = customerName;
		this.rentalDays = rentalDays;
		
	}
	
	//constructor without parameters(default values)
	public Car () {
		
		this.carID = "CSD123";
		this.customerName = "Driver";
		this.rentalDays = 0;
		
	}
	
	//method is used to display about rented car
	public void displayCarDetails() {
		
			System.out.println ("Car's ID : "+carID);
			System.out.println ("Customer name : "+customerName);
			System.out.println ("Rental days : "+rentalDays);
			
		
	}
	
	// calculate total base cost 
	public double calculateRentalCost() {
		
			return rentalDays * 50;
		
	}
	
	// calculate total base cost using coupon
	public double calculateRentalCost(double discountCoupon) {
			
			double baseCost = calculateRentalCost();
		
			return baseCost - (baseCost * discountCoupon / 100);
		
	}
	
 }
 
 //subclass of Car
 class StandardCar extends Car {
	 
	private boolean hasAirConditioning;
	
	//constructor with parameters
	public StandardCar (String carID, String customerName, int rentalDays, boolean hasAirConditioning) {
		
		super(carID , customerName , rentalDays);
		this.hasAirConditioning = hasAirConditioning;
		
	}
	
	//constructor without parameters (default values)
	public StandardCar () {
		
		super("C0", "unknown", 0);
		this.hasAirConditioning = false;
		
	}
	
	//overriden means we use the same method that has in parent class
	@Override
	public double calculateRentalCost() {
			
			return rentalDays * 40;
				
	}
	
	@Override
	public void displayCarDetails() {
		
		super.displayCarDetails();
		System.out.println();
		System.out.println("---Standard Car---");
		System.out.println("This car has airconditioning : "+(hasAirConditioning ? "Yes" : "No"));
		System.out.println("Total rental cost : "+calculateRentalCost());
	}
	
 }
 
 //subclass of Car
 class LuxuryCar extends Car {
	 
	private boolean hasGPS;
	private boolean hasChauffeurService;
	
	//constructor with parameters
	public LuxuryCar (String carID, String customerName, int rentalDays, boolean hasGPS, boolean hasChauffeurService) {
		
		super(carID , customerName , rentalDays);
		this.hasGPS = hasGPS;
		this.hasChauffeurService = hasChauffeurService;
		
	}
	
	//constructor without parameters (default values)
	public LuxuryCar () {
		
		super("C1", "unknown", 0);
		this.hasGPS = false;
		this.hasChauffeurService = false;
		
		
	}
	
	//overriden means we use the same method that has in parent class
	@Override
	public double calculateRentalCost() {
		
		double totalCost = rentalDays * 100;
		
		if (hasGPS && hasChauffeurService) {
			
			totalCost += 50;
			
		}
		
		return totalCost;
		
	}
	
	@Override
	public void displayCarDetails() {
		
		super.displayCarDetails();
		System.out.println();
		System.out.println("---Luxury Car---");
		System.out.println("This car has GPS: "+(hasGPS ? "Yes" : "No"));
		System.out.println("This car has Chauffeur service :"+(hasChauffeurService ? "Yes" : "No"));
		System.out.println("Total rental cost : "+calculateRentalCost());
		
	}
	
 }

//main method
public class CarRentalApp {
	
	public static void main (String...args) {
		
		Scanner sc = new Scanner(System.in);
	
		Car[] cars = new Car[2];
		
		// object1 created for standard car with default values
		cars[0] = new StandardCar();
		
		// handling user input for luxury car (object2)
		System.out.print ("Car's ID : ");
		String carID = sc.nextLine();
		
		System.out.print ("Customer's name : ");
		String customerName = sc.nextLine();
		
		System.out.print ("How long did you rent the car : ");
		int rentalDays = sc.nextInt();
		
		System.out.print ("Does the car provides GPS (true or false) : ");
		boolean hasGPS = sc.nextBoolean();
		
		System.out.print ("Does the car provides Chauffeur services (true or false) : ");
		boolean hasChauffeurService = sc.nextBoolean();
		System.out.println();
		
		//object2
		cars[1] = new LuxuryCar (carID, customerName , rentalDays , hasGPS , hasChauffeurService);
		
		//displaying car details using for each loop
		for (Car car : cars) {
			
			car.displayCarDetails();
			System.out.println();
			
		}
		
	}
	
}
		
	
	
	
	
	
	
	
	
	
	
	