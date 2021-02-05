package config;

import java.util.HashMap;

import vehicle.types.Airplane;
import vehicle.types.Bicycle;
import vehicle.types.Boat;
import vehicle.types.Bus;
import vehicle.types.Car;
import vehicle.types.Helicopter;
import vehicle.types.Motorcycle;
import vehicle.types.Ship;
import vehicle.types.Train;
import vehicle.types.Tram;
import vehicle.types.Truck;
import vehicle.types.Vehicle;

public class VehicleManager {
	
	private static HashMap<String, Vehicle> vehicles = new HashMap<>();
	
	public static void populateVehicles() {
		vehicles.put("Boat", new Boat("Apollo"));
		vehicles.put("Ship", new Ship("Cruizz"));
		vehicles.put("Truck", new Truck("Ford F-650"));
		vehicles.put("Motorcycle", new Motorcycle("Suzuki"));
		vehicles.put("Bus", new Bus("Aero"));
		vehicles.put("Car", new Car("BMW"));
		vehicles.put("Bicycle", new Bicycle("A-bike"));
		vehicles.put("Helicopter", new Helicopter("Eurocopter"));
		vehicles.put("Airplane", new Airplane("BA"));
		vehicles.put("Tram", new Tram("EdinburghTram"));
		vehicles.put("Train", new Train("Virgin",4));
		
	}
	
	
	
	public static Vehicle initialiseVehicle(String vehicleName) {
		return vehicles.get(vehicleName);
	}

}
