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
	private static Vehicle vehicle = null;
	protected static Simulator SimulationPane = null;
	
	public static Config currentConfig;
	
	protected JButton button;
	protected String actionName;
	
	public Config(JButton button) {
		this.button = button;
		this.actionName = button.getText();
		buttons.add(button);
		this.button.setBackground(Color.lightGray);
		this.button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				buttonClicked();
				
			}
	
		});
	}
	
	protected abstract void buttonClicked();
	
	protected void changeButtonColor(JButton button) {

		for (JButton b : Config.buttons) {
			if (b == button) {
				b.setBackground(Color.green);
			} else {
				b.setBackground(Color.lightGray);
			}
		}
		
	}

	public static void initialiseVehicle(String vehicleName) {
		vehicle = VehicleManager.initialiseVehicle(vehicleName);
	}
	
	protected boolean isVehicleNull() {
		return vehicle == null;
	}
	
	protected String getVehiclePrintSpeed() {
		return vehicle.printSpeed(); 
	}
	
	protected void setVehicleSpeed(int speed) {
		vehicle.setCurrentSpeed(speed);
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
