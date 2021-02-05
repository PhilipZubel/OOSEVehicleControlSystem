package config;

import java.awt.Color;

import javax.swing.JButton;

public class Decelerate extends Config{

	public Decelerate(JButton button) {
		super(button);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void buttonClicked() {
		
		currentConfig = this;
		
		changeButtonColor(this.button);

		
		Thread thread = new Thread(){
			public void run(){
				try {
					while(currentConfig == getThis()) {
						Thread.sleep(2 * 1000);

						// updated curSpeed by moving the calculations to updateSpeed class
						int curSpeed = SimulationPane.updateSpeed(-1);
						vehicle.setCurrentSpeed(curSpeed);
						speedlabel.setText(vehicle.printSpeed());							    
					}
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				} 
			}
		};

		thread.start();
	}				    	
		
	
	
	private Config getThis() {
		return this;
	}
	
	

}
