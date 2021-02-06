package config;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JLabel;

import oose.vcs.Simulator;
import vehicle.types.Vehicle;


public abstract class Config {

	private static LinkedList<JButton> buttons = new LinkedList<JButton>();
	
	private static String[] vehicles = { "Boat", "Ship", "Truck", "Motorcycle", "Bus", "Car", "Bicycle", "Helicopter", "Airplane", "Tram", "Train"};
	
	protected static JLabel speedlabel;
	protected static VehicleManager vehicleManager = new VehicleManager();
	protected static Simulator SimulationPane = null;
	
	protected static Config currentConfig;
	
	protected JButton button;
	protected String actionName;
	
	public Config(JButton button) {
		button.setBackground(Color.lightGray);
		this.actionName = button.getText();
		this.button = button;
		buttons.add(button);
		
		this.button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				buttonClicked();
				
			}
	
		});
	}
	
	protected abstract void buttonClicked();
	
	protected static void changeButtonColor(JButton button) {

		for (JButton b : buttons) {
			if (b == button) {
				b.setBackground(Color.green);
			} else {
				b.setBackground(Color.lightGray);
			}
		}
		
	}

	public static void initialiseVehicle(String vehicleName) {
		vehicleManager.initialiseVehicle(vehicleName);
	}
	
	protected boolean isVehicleNull() {
		return vehicleManager.isVehicleNull();
	}
	
	protected String getVehiclePrintSpeed() {
		return vehicleManager.printVehicleSpeed(); 
	}
	
	protected void setVehicleSpeed(int speed) {
		vehicleManager.setVehicleSpeed(speed);
	}

	public static String[] getVehicleArray() {
		return vehicles;
	}
	
	protected void setSimulator(Simulator SimulationPane) {
		Config.SimulationPane = SimulationPane;
	}
	
	public static void setSpeedlabel(JLabel speedlabel) {
		Config.speedlabel = speedlabel;
	}
	
	
	
	

}
