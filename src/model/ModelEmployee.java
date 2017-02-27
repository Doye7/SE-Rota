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


public class ModelEmployee {
	
	public static int unique_id = 1;
	
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private ModelSchedule rota;

	public ModelEmployee(String firstName, String lastName, ModelSchedule rota) {
		this.id = unique_id ++;
		this.firstName = firstName;
		this.lastName = lastName;
		this.rota = rota;
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public ModelSchedule getRota() {
		return rota;
	}

	public void setRota(ModelSchedule rota) {
		this.rota = rota;
	}
	
	@Override
	public String toString ()
	{
		return firstName + " " + lastName;
	}

}
