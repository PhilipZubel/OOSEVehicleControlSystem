package oose.vcs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.UIManager;

import config.Accelerate;
import config.Config;
import config.Cruise;
import config.Decelerate;
import config.Start;
import config.Stop;


public class Controller {
	
	public static void main(String args[]) {
		new Controller();
	}

	public Controller() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
				} catch (Exception e) {
					e.printStackTrace();
				}
				JFrame frame = new JFrame("Vehicle Control System");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLayout(new BorderLayout());

				String[] vehicles = Config.getVehicleArray();
				
				JComboBox<String> combobox = new JComboBox<String>(vehicles);
				combobox.setSelectedIndex(6);
				combobox.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						int selectedIndex = combobox.getSelectedIndex();
						String vehicleName = vehicles[selectedIndex];
						Config.initialiseVehicle(vehicleName);							
					}
				});

				JLabel speedlabel = new JLabel("          ");
				
				Config.setSpeedlabel(speedlabel);
				
				JButton buttonStart = new JButton("start");
				new Start(buttonStart, combobox, frame);
				
				JButton button2 = new JButton("accelerate");
				new Accelerate(button2);
				
				JButton button3 = new JButton("decelerate");
				new Decelerate(button3);
				
				JButton button4 = new JButton("cruise");
				new Cruise(button4);
				
				JButton button5 = new JButton("stop");
				new Stop(button5);
				
				JToolBar toolBar =new JToolBar();
				toolBar.setRollover(true);

				toolBar.add(combobox);
				toolBar.add(speedlabel);
				toolBar.add(buttonStart);
				toolBar.add(button2);
				toolBar.add(button3);
				toolBar.add(button4);
				toolBar.add(button5);

				frame.add(toolBar,BorderLayout.NORTH);
				frame.setPreferredSize(new Dimension(800,200));
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}

		});
	}
	


	

}
