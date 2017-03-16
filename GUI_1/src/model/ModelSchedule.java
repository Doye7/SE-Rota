/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author joel
 */

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public abstract class ModelSchedule {
	
	int totalHours;
	
	LocalTime startWorking;
	
	LocalDate firstDay;
	
	DayOfWeek dayOff;

	public ModelSchedule(int totalHours, LocalTime startWorking, LocalDate firstDay, DayOfWeek dayOff) {
		this.totalHours = totalHours;
		this.startWorking = startWorking;
		this.firstDay = firstDay;
		this.dayOff = dayOff;
	}
	
	public abstract void scheduleAuto (LocalDateTime ldtFrom);

	public LocalTime getStartWorking() {
		return startWorking;
	}

	public LocalDate getFirstDay() {
		return firstDay;
	}

	public DayOfWeek getDayOff() {
		return dayOff;
	}

}
