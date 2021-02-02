package oose.vcs;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Simulator extends JPanel {

	private BufferedImage boat;
	private int xPos = 0;
	private int direction = 1;
	private File file; 
	private Timer timer;
	
	// fields added
	private int currentvelocity;
	private int maximumvelocity = 300;
	private String vehicleName;
	
	public Simulator(int currentVelocity, String vehicleName) {
		this.currentvelocity = currentVelocity;
		this.vehicleName = vehicleName.toLowerCase();
		
		setDisplayObject();
		try {	
			boat = ImageIO.read(file);
			timer = new Timer(maximumvelocity/currentvelocity, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					xPos += direction;
					if (xPos + boat.getWidth() > getWidth()) {
						xPos = 0;
						direction *= -1;

					} else if (xPos < 0) { 
						xPos = 0;
						direction *= -1;
					}
					repaint();
				}

			});
			timer.setRepeats(true);
			timer.setCoalesce(true);
			timer.start();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	// updates speed and returns the updated velocity
	public int updateSpeed(int changeOfVelocity) {
		if((currentvelocity<=maximumvelocity && changeOfVelocity>0) || (currentvelocity>1 && changeOfVelocity<0)) {
			currentvelocity = currentvelocity + changeOfVelocity;
			timer.setDelay(maximumvelocity/currentvelocity);
		}
		return currentvelocity;
	}
	
	public int getCurrentVelocity() {
		return this.currentvelocity;
	}
	
	public void setCurrentVelocity(int curVelocity) {
		currentvelocity = curVelocity;
		timer.setDelay(maximumvelocity/currentvelocity);
	}

	private void setDisplayObject() {
		file = new File(System.getProperty("user.dir")+"/img/"+vehicleName+".png");
	}

	@Override
	public Dimension getPreferredSize() {
		return boat == null ? super.getPreferredSize() : new Dimension(boat.getWidth() * 4, boat.getHeight());
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		int y = getHeight() - boat.getHeight();
		g.drawImage(boat, xPos, y, this);

	}

}