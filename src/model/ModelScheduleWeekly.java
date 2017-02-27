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
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class ModelScheduleWeekly extends ModelSchedule {
	
	private Map<DayOfWeek, Duration> weeklyHours;

	public ModelScheduleWeekly(int totalHours, LocalTime startWorking, LocalDate firstDay, DayOfWeek dayOff) {
		super(totalHours, startWorking, firstDay, dayOff);
		weeklyHours = new HashMap<>();
	}


	@Override
	public void scheduleAuto(LocalDateTime ldtFrom) {
		
		int hoursPerDay = totalHours / 6; // Schedule evenly (7 days - 1 day off).
		
		LocalDateTime ldtTo = ldtFrom.plusHours(hoursPerDay);
		
		for (DayOfWeek dof: DayOfWeek.values())
		{
			weeklyHours.put(dof, Duration.between(ldtFrom, ldtTo));
		}
		
	}
	
	public Duration getDurationByDayOfWeek (DayOfWeek dof)
	{
		return weeklyHours.get(dof);
	}
	
}

