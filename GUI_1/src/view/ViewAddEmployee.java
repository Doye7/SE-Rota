/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author joel
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Instant;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.DateFormatter;




public class ViewAddEmployee extends JPanel {

	private JTextField firstName;

	private JTextField lastName;

	private JFormattedTextField hours;

	private JFormattedTextField startWorkingTime;

	private JComboBox<DayOfWeek> dayOffs;

	

	public final static int TOTAL_WEEKLY_HOURS_DEFAULT = 48;

	public final static String START_WORKING_TIME_DEFAULT = "09:00";

	public final static DateFormat DF;

	public final static DateFormatter TIME_FORMAT = new DateFormatter (DF = new SimpleDateFormat("HH:mm"));

	


	private class FieldValidation extends KeyAdapter {

		@Override
		public void keyTyped(KeyEvent evt) {
			Object obj = evt.getSource();
			if (obj == startWorkingTime) {
				String text = startWorkingTime.getText().trim();
				if (text.length() == 0) {
					return;
				}
				try {
					DF.parse(text);
					startWorkingTime.setForeground(Color.decode("#006400"));
				} catch (ParseException exc) {
					startWorkingTime.setForeground(Color.RED);
				}	
			} else if (obj == hours) {
				String text = hours.getText().trim();
				if (text.length() == 0) {
					return;
				}
				try {
					Integer.parseInt(text);
					hours.setForeground(Color.decode("#006400"));
				} catch (NumberFormatException exc) {
					hours.setForeground(Color.RED);
				}			
			} else if (obj == firstName) {
				firstName.setBorder(BorderFactory.createLineBorder(Color.decode("#006400")));
			} else if (obj == lastName) {
				lastName.setBorder(BorderFactory.createLineBorder(Color.decode("#006400")));
			}
		}
	}

	private class FontColorValidation extends FocusAdapter {

		@Override
		public void focusLost (FocusEvent e) {
			Object obj = e.getSource();
			if (obj == hours) {
				hours.setForeground(Color.decode("#006400"));
			} else if (obj == startWorkingTime) {
				startWorkingTime.setForeground(Color.decode("#006400"));
			}
		}
	}

	private class TextSelection extends MouseAdapter {

		@Override
		public void mousePressed (MouseEvent e)
		{
			Object obj = e.getSource();
			if (obj == hours) {
				SwingUtilities.invokeLater(() -> hours.selectAll());								
			} else if (obj == firstName) {
				firstName.selectAll();
			} else if (obj == lastName) {
				lastName.selectAll();
			} else if (obj == startWorkingTime) {
				SwingUtilities.invokeLater(() -> startWorkingTime.selectAll());
			}
		}
	}

	public JTextField getFirstName() {
		return firstName;
	}

	public JTextField getLastName() {
		return lastName;
	}

	public JFormattedTextField getHours() {
		return hours;
	}

	public JComboBox<DayOfWeek> getDayOffs() {
		return dayOffs;
	}

	

	public JFormattedTextField getStartWorkingTime() {
		return startWorkingTime;
	}

	
}
