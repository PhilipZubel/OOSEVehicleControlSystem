package config;

import javax.swing.JButton;

public class Cruise extends Config{

	public Cruise(JButton button) {
		super(button);

	}

	@Override
	protected void buttonClicked() {
		// TODO Auto-generated method stub
		currentConfig = this;
		changeButtonColor(this.button);

		
	}

}
