package com.restapidemo.demorest;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Monitor {
	private double cpuUsage;
	private long memoryUsage;
	private long currentTimeMillis;
	public long getCurrentTimeMillis() {
		return currentTimeMillis;
	}
	public void setCurrentTimeMillis(long currentTimeMillis) {
		this.currentTimeMillis = currentTimeMillis;
	}
	public double getCpuUsage() {
		return cpuUsage;
	}
	public void setCpuUsage(double cpuUsage) {
		this.cpuUsage = cpuUsage;
	}
	public long getMemoryUsage() {
		return memoryUsage;
	}
	public void setMemoryUsage(long memoryUsage) {
		this.memoryUsage = memoryUsage;
	}
	@Override
	public String toString() {
		return "Monitor [cpuUsage=" + cpuUsage + ", memoryUsage=" + memoryUsage + ", currentTimeMillis="
				+ currentTimeMillis + "]";
	}
	
	
}
