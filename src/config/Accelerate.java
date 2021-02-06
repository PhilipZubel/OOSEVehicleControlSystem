package config;


import javax.swing.JButton;

public class Accelerate extends Config {
	
	public Accelerate(JButton button) {
		super(button);
	}
	
	private Config getThis() {
		return this;
	}
	
	@Override
	public void buttonClicked() {
		
		currentConfig = this;
		
		changeButtonColor(this.button);

		Thread thread = new Thread(){
			public void run(){
				try {
					while(currentConfig == getThis()) {
						Thread.sleep(2 * 1000);
						
						int curSpeed = SimulationPane.updateSpeed(1);
						setVehicleSpeed(curSpeed);
						speedlabel.setText(getVehiclePrintSpeed());
														    
					}
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				} 
			}
		};

		thread.start();
	
	}

}
