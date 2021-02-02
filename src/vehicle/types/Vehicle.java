package vehicle.types;

public abstract class Vehicle {
	private String name;
	private Type type;
	private Direction direction;
	private boolean stopped;
	private double currentSpeed;
	
	public void drive(Direction direction, double speed) {}
	public void streer(double degree, double speed) {}
	
	public abstract String printSpeed();
	
	public static Vehicle initialiseVehicle(String vehicleName) {
		if(vehicleName.equals("Boat")) {
			return new Boat("Apollo ");
		}
		else if(vehicleName.equals("Ship")) {
			return new Ship("Cruizz");
		}
		else if(vehicleName.equals("Truck")) {
			return new Truck("Ford F-650");
		}
		else if(vehicleName.equals("Motorcycle")) {
			return new Motorcycle("Suzuki");
		}
		else if(vehicleName.equals("Bus")) {
			return new Bus("Aero");
		}
		else if(vehicleName.equals("Car")) {
			return new Car("BMW");
		}
		else if(vehicleName.equals("Bicycle")) {
			return new Bicycle("A-bike");
		}
		else if(vehicleName.equals("Helicopter")) {
			return new Helicopter("Eurocopter");
		}
		else if(vehicleName.equals("Airplane")) {
			return new Airplane("BA");
		}
		else if(vehicleName.equals("Tram")) {
			return new Tram("EdinburghTram");
		}
		else if(vehicleName.equals("Train")) {
			return new Train("Virgin",4);
		}	
		return null;
	}
	
	public void stop() {
		setCurrentSpeed(0);
		setDirection(Direction.STATIONARY);
		setStopped(true);		
	}
	
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public Direction getDirection() {
		return direction;
	}
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	public boolean isStopped() {
		return stopped;
	}
	public void setStopped(boolean stopped) {
		this.stopped = stopped;
	}
	public double getCurrentSpeed() {
		return currentSpeed;
	}
	public void setCurrentSpeed(double currentSpeed) {
		this.currentSpeed = currentSpeed;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

enum Type {
	WHEELED, TRACKED, RAILED, SKIED, FLOATED
}

enum Direction {
	FORWARD, BACKWARD, LEFT, RIGHT, STATIONARY
}
