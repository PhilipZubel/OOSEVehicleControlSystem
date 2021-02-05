package config;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import oose.vcs.Simulator;

public class Start extends Config{
	private JComboBox<String> combobox;
	private JFrame frame;
	
	public Start(JButton button, JComboBox<String> combobox, JFrame frame) {
		super(button);
		this.combobox = combobox;
		this.frame = frame;
		VehicleManager.populateVehicles();
		
	}

	@Override
	public void buttonClicked() {

		currentConfig = this;
		
		String vehicleName = "Bicycle";
		int selectedIndex = combobox.getSelectedIndex();
		vehicleName = getVehicleArray()[selectedIndex];
		
		if(isVehicleNull()) {
			initialiseVehicle(vehicleName);
			speedlabel.setText(getVehiclePrintSpeed());
		}
		int curVelocity = 1;
		if(Config.SimulationPane !=null) {
			curVelocity = SimulationPane.getCurrentVelocity();
			frame.remove(SimulationPane);
		}
		
		
		changeButtonColor(this.button);
		
		SimulationPane = new Simulator(curVelocity, vehicleName);
		frame.add(SimulationPane,BorderLayout.CENTER);
		frame.revalidate();
		frame.repaint();
		
	}
	
}
