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
//Importing componants for main form
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
//creating main form
public class View extends JFrame {

	public View (String title, JPanel content)
	{
		super (title);
		
		add (content);
		//allowing for termination on close
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		//setting relative location of form 
		setLocationRelativeTo(null);
		//setting form to be visible
		setVisible(true);
	}
	
}

