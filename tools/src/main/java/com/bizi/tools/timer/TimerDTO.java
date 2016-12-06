package com.bizi.tools.timer;

import org.quartz.Job;

public class TimerDTO {

	private Job job;
	private String timerName;
	private String expression;

	
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public String getExpression() {
		return expression;
	}
	public void setExpression(String expression) {
		this.expression = expression;
	}
	public String getTimerName() {
		return timerName;
	}
	public void setTimerName(String timerName) {
		this.timerName = timerName;
	}
	
	
}
