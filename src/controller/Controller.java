/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;
import java.text.ParseException;
import java.time.LocalTime;
import java.time.ZoneId;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

import javax.swing.BorderFactory;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

import javafx.scene.input.MouseButton;
import model.ModelEmployee;
import model.ModelEmployees;
import model.ModelScheduleWeekly;
import view.ViewAddEmployee;
import view.ViewContent;

public class Controller {

	private ModelEmployees model;

	private ViewContent view;

	private ViewAddEmployee viewAddEmp;

	public Controller (ModelEmployees model, ViewContent view, ViewAddEmployee viewAddEmp) {
		this.model = model;
		this.view = view;
		this.viewAddEmp = viewAddEmp;
	}

	public void initView()
	{
		/*
		 * Fill out table headers.
		 */
		String[] column_headers = new String[9];
		column_headers[0] = "ID";
		column_headers[1] = "EMPLOYEE";
		for (int i = 2; i < column_headers.length; i ++)
		{
			column_headers[i] = DayOfWeek.values()[i - 2].name();
		}
		view.getTableModel().setColumnIdentifiers(column_headers);
		view.getTable().getColumnModel().getColumn(0).setPreferredWidth(25);
		view.getTable().getColumnModel().getColumn(1).setPreferredWidth(120);

		/*
		 * Fill out employees.
		 */
		updateTable();
	}

	private void updateTable()
	{
		view.getTableModel().setRowCount(0); // Clear table.
		for (ModelEmployee emp: model.getEmployees()) // Loop through the all employee.
		{
			LocalTime sw = emp.getRota().getStartWorking(); // Get start working time.
			DayOfWeek dof = emp.getRota().getDayOff(); // Get day off.
			
			assert (emp.getRota() instanceof ModelScheduleWeekly); // Make sure ModelScheduleWeekly object is used to 
			// initialize ModelEmployee.
			
			ModelScheduleWeekly msw = (ModelScheduleWeekly)emp.getRota();
			emp.getRota().scheduleAuto(LocalDateTime.of(emp.getRota().getFirstDay(), sw)); // Distribute hours evenly.
			
			/*
			 * Add the next row to the table. If the current day is day off just print "X".
			 */
			view.getTableModel().addRow(
					new String[]{
							emp.getId() + "", 
							emp.toString(), 
							(dof == DayOfWeek.MONDAY ? "X" : sw + " : " + sw.plusHours(msw.getDurationByDayOfWeek(DayOfWeek.MONDAY).toHours())),
							(dof == DayOfWeek.TUESDAY ? "X" : sw + " : " + sw.plusHours(msw.getDurationByDayOfWeek(DayOfWeek.TUESDAY).toHours())),
							(dof == DayOfWeek.WEDNESDAY ? "X" : sw + " : " + sw.plusHours(msw.getDurationByDayOfWeek(DayOfWeek.WEDNESDAY).toHours())),
							(dof == DayOfWeek.THURSDAY ? "X" : sw + " : " + sw.plusHours(msw.getDurationByDayOfWeek(DayOfWeek.THURSDAY).toHours())),
							(dof == DayOfWeek.FRIDAY ? "X" : sw + " : " + sw.plusHours(msw.getDurationByDayOfWeek(DayOfWeek.FRIDAY).toHours())),
							(dof == DayOfWeek.SATURDAY ? "X" : sw + " : " + sw.plusHours(msw.getDurationByDayOfWeek(DayOfWeek.SATURDAY).toHours())),
							(dof == DayOfWeek.SUNDAY ? "X" : sw + " : " + sw.plusHours(msw.getDurationByDayOfWeek(DayOfWeek.SUNDAY).toHours()))
					});
		}
	}

	public void initController()
	{
		view.getJbAddEmployee().addActionListener(e -> addEmployee());
		view.getJbDelEmployee().addActionListener(e -> deleteEmployee());
	}

	
	private void addEmployee()
	{
		int res = JOptionPane.showConfirmDialog(view, viewAddEmp, "Add new employee", JOptionPane.OK_CANCEL_OPTION);
		if (res == JOptionPane.OK_OPTION)
		{
			String firstName = viewAddEmp.getFirstName().getText().trim();
			if (firstName.length() == 0) // If firstname is empty.
			{
				viewAddEmp.getFirstName().setBorder(BorderFactory.createLineBorder(Color.RED));
				addEmployee(); // Call this method once more.
				return; // To avoid repeating employees.
			}
			String lastName = viewAddEmp.getLastName().getText().trim();
			if (lastName.length() == 0) // If lastname is empty.
			{
				viewAddEmp.getLastName().setBorder(BorderFactory.createLineBorder(Color.RED));
				addEmployee();
				return;
			}
			ModelScheduleWeekly msw = new ModelScheduleWeekly(
					Integer.parseInt(viewAddEmp.getHours().getText()), 
					LocalTime.parse(viewAddEmp.getStartWorkingTime().getText()), 
					viewAddEmp.getStartWorkingDate().getValue().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), 
					(DayOfWeek)viewAddEmp.getDayOffs().getSelectedItem());
			ModelEmployee emp = new ModelEmployee(firstName, lastName, msw);
			model.addEmployee(emp);
			updateTable();

			try {
				viewAddEmp.clearFields(); // Clear all fields after the new employee has been added successfully.
			} catch (ParseException e) {
				JOptionPane.showMessageDialog(viewAddEmp, e, "Error occured", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	private void deleteEmployee()
	{
		int rowIndex = view.getTable().getSelectedRow();
		if (rowIndex < 0) {
			JOptionPane.showMessageDialog(view, "Select row!", "Warning", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		model.deleteEmployee(rowIndex);
		updateTable();
	}

}
