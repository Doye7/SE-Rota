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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ViewContent extends JPanel {
	
	private DefaultTableModel tableModel;
	
	private JTable table;
	
	private JButton jbAddEmployee;
	
	private JButton jbDelEmployee;
	
	public ViewContent ()
	{
		super (new BorderLayout(0, 10));
		setPreferredSize (new Dimension (700, 300));
		setBackground(Color.decode("#DEB887"));
		
		table = new JTable (tableModel = new DefaultTableModel());
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, dtcr);
		
		JPanel actionPanel = new JPanel(new FlowLayout (FlowLayout.CENTER, 10, 0));
		actionPanel.setBackground(Color.decode("#DEB887"));
		
		JPanel jpAddEmployee = new JPanel ();
		jpAddEmployee.setBackground(Color.decode("#DEB887"));
		jpAddEmployee.add(jbAddEmployee = new JButton ("ADD  EMPLOYEE"));
		
		JPanel jpDelEmployee = new JPanel ();
		jpDelEmployee.setBackground(Color.decode("#DEB887"));
		jpDelEmployee.add(jbDelEmployee = new JButton ("DELETE  EMPLOYEE"));
		
		actionPanel.add(jpAddEmployee);
		actionPanel.add(jpDelEmployee);
		
		add (new JScrollPane (table), BorderLayout.CENTER);
		add (actionPanel, BorderLayout.NORTH);
	}
	
	@Override
	public Insets getInsets ()
	{
		return new Insets (10, 10, 10, 10);
	}

	public DefaultTableModel getTableModel() {
		return tableModel;
	}

	public JTable getTable() {
		return table;
	}

	public JButton getJbAddEmployee() {
		return jbAddEmployee;
	}

	public JButton getJbDelEmployee() {
		return jbDelEmployee;
	}

}
