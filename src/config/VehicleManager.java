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
	
	private HashMap<String, Vehicle> vehicles = new HashMap<>();
	private String[] vehicleNames;
	
	private Vehicle currentVehicle = null;
	
	public VehicleManager() {
		populateVehicles();
	}
	
	private void populateVehicles() {
		
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
	
	
	
	public void initialiseVehicle(String vehicleName) {
		currentVehicle = vehicles.get(vehicleName);
	}
	
	public String printVehicleSpeed() {
		return currentVehicle.printSpeed();
	}
	
	public void setVehicleSpeed(int speed) {
		currentVehicle.setCurrentSpeed(speed);
	}
	
	public boolean isVehicleNull() {
		return currentVehicle == null;
	}

	public String[] getVehicleNames() {
		return vehicleNames;
	}

}
