/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author joel
 */
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.SwingUtilities;

import controller.Controller;
import model.ModelEmployee;
import model.ModelEmployees;
import model.ModelScheduleWeekly;
import view.View;
import view.ViewAddEmployee;
import view.ViewContent;

public class Main {

	public static void main(String[] args) {

		try 
		{
			ModelEmployees model = new ModelEmployees();

			/*
			 * Add sample data.
			 */
			model.addEmployee(new ModelEmployee("Alan", "Smith", 
					new ModelScheduleWeekly(48, LocalTime.of(9, 00), LocalDate.of(2016, 2, 24), DayOfWeek.SUNDAY)));
			model.addEmployee(new ModelEmployee("Jessica", "Parker", 
					new ModelScheduleWeekly(48, LocalTime.of(8, 00), LocalDate.of(2016, 2, 24), DayOfWeek.SATURDAY)));

			ViewContent view = new ViewContent();
			ViewAddEmployee viewAddEmp = new ViewAddEmployee();
			Controller controller = new Controller (model, view,viewAddEmp);
			controller.initView();
			controller.initController();

			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Metal".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}

			SwingUtilities.invokeLater(() -> new View ("Rota System", view));
			
		} catch (Exception exc) 
		{
			System.err.println("Internal error: " + exc);
		}

	}

}
