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
	
	protected static String[] vehicles = { "Boat", "Ship", "Truck", "Motorcycle", "Bus", "Car", "Bicycle", "Helicopter", "Airplane", "Tram", "Train"};
	protected static Vehicle vehicle = null;
	protected static JLabel speedlabel;
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
				// TODO Auto-generated method stub
				buttonClicked();
				
			}
	
		});
	}
	
	public static void setSpeedlabel(JLabel speedlabel) {
		Config.speedlabel = speedlabel;
	}
	
	public static String[] getVehicleArray() {
		return vehicles;
	}
	
	public static void initialiseVehicle(String vehicleName) {
		// move initializeVehicle to Vehicle class
		vehicle = Vehicle.initialiseVehicle(vehicleName);
	}
	
	protected void setSimulator(Simulator SimulationPane) {
		Config.SimulationPane = SimulationPane;
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

}
