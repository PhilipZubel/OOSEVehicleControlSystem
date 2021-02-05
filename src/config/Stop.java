package config;

import javax.swing.JButton;

public class Stop extends Config{

	public Stop(JButton button) {
		super(button);
	}

	@Override
	protected void buttonClicked() {
		
		currentConfig = this;
		
		changeButtonColor(this.button);
		
		int currentVelocity = 1;
		SimulationPane.setCurrentVelocity(currentVelocity);
		setVehicleSpeed(currentVelocity);
		speedlabel.setText(getVehiclePrintSpeed());
		
	}

}
