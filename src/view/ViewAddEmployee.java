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
//Importing packages for format
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
//Importing componenets to be used
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.DateFormatter;
//Importing Datepicker class package to allow for calender widget to be used for date selection
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

//Creating Add Employee Form
public class ViewAddEmployee extends JPanel {
//Declaring Variables and Types
	private JTextField firstName;

	private JTextField lastName;

	private JFormattedTextField hours;

	private JFormattedTextField startWorkingTime;

	private JComboBox<DayOfWeek> dayOffs;

	private UtilDateModel startWorkingDate;

	public final static int TOTAL_WEEKLY_HOURS_DEFAULT = 48;

	public final static String START_WORKING_TIME_DEFAULT = "09:00";

	public final static DateFormat DF;

	public final static DateFormatter TIME_FORMAT = new DateFormatter (DF = new SimpleDateFormat("HH:mm"));
	//Creating/formating panel with parseexcepttion to deal with runtime errors
	public ViewAddEmployee() throws ParseException
	{
		super (new FlowLayout (FlowLayout.RIGHT, 10, 10));

		setPreferredSize (new Dimension (310, 280));

		TextSelection ts = new TextSelection();
		FontColorValidation fcv = new FontColorValidation();
		FieldValidation fv = new FieldValidation();

		add (new JLabel ("Enter first name:"));
		add (firstName = new JTextField (10));
		firstName.addMouseListener(ts);
		firstName.addKeyListener(fv);
		add (new JLabel ("Enter last name:"));
		add (lastName = new JTextField (10));
		lastName.addMouseListener(ts);
		lastName.addKeyListener(fv);
		add (new JLabel ("Enter total hours per week:"));
		add (hours = new JFormattedTextField(java.text.NumberFormat.getNumberInstance()));
		add (new JLabel ("Select day off:"));
		add (dayOffs = new JComboBox<>(DayOfWeek.values()));
		add (new JLabel ("Enter start working time:"));
		add (startWorkingTime = new JFormattedTextField(TIME_FORMAT));
		dayOffs.setPreferredSize(new Dimension (113, 20));
		hours.setColumns(10);
		hours.setValue(TOTAL_WEEKLY_HOURS_DEFAULT);
		hours.setForeground(Color.decode("#006400"));
		hours.addKeyListener(fv);
		hours.addFocusListener(fcv);
		hours.addMouseListener(ts);

		startWorkingTime.setColumns(10);
		startWorkingTime.setValue(DF.parse(START_WORKING_TIME_DEFAULT));
		startWorkingTime.setForeground(Color.decode("#006400"));
		startWorkingTime.addKeyListener(fv);
		startWorkingTime.addFocusListener(fcv);
		startWorkingTime.addMouseListener(ts);

		setupStartWorkingDate();

	}
	 //Creating date picker used when employee selects starting date will allow for only valid entrys
	private void setupStartWorkingDate ()
	{
		add (new JLabel ("Select start working date:"));

		startWorkingDate = new UtilDateModel(Date.from(Instant.now()));
		JDatePanelImpl datePanel = new JDatePanelImpl(startWorkingDate);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
		add (datePicker);
	}
 	//validating textfeilds and setting colours used to be uniform throughout
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
	//Setting colour used by feilds
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
	//Allow for selection of employee and subsequent variables will de used for deletion of employee
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
	//Returning user input from Firstname textfield to variable
	public JTextField getFirstName() {
		return firstName;
	}
	//Returning user input from Lastname textfield to variable
	public JTextField getLastName() {
		return lastName;
	}
	//Returning user input from hours formated textfield to variable
	public JFormattedTextField getHours() {
		return hours;
	}
	//Returning user selection from dayoff combobox to variable
	public JComboBox<DayOfWeek> getDayOffs() {
		return dayOffs;
	}
	 //Returning user selection from start date from date selection to variable
	public UtilDateModel getStartWorkingDate() {
		return startWorkingDate;
	}
	//Returning user input from formated textfield to variable
	public JFormattedTextField getStartWorkingTime() {
		return startWorkingTime;
	}
	//Method to clear feilds for quick reuse
	public void clearFields () throws ParseException
	{
		firstName.setText("");
		lastName.setText("");
		hours.setValue(TOTAL_WEEKLY_HOURS_DEFAULT);
		dayOffs.setSelectedIndex(0);
		startWorkingDate.setValue(Date.from(Instant.now()));
		startWorkingTime.setValue(DF.parse(START_WORKING_TIME_DEFAULT));
	}
}
