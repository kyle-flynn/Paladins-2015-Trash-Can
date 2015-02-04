package org.usfirst.frc.team3618.robot;

import edu.wpi.first.wpilibj.PowerDistributionPanel;

public class Electronics {

	private PowerDistributionPanel pdp;
	
	public Electronics(int port) {
		pdp = new PowerDistributionPanel();
	}
	
	public double getCurrent(int channel) {
		return pdp.getCurrent(channel);
	}
	
	public double getTotalVoltage() {
		return pdp.getVoltage();
	}
	
	public double getTemperature() {
		return pdp.getTemperature();
	}
	
}
