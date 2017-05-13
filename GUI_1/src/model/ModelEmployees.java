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

import java.util.ArrayList;
import java.util.List;

public class ModelEmployees {
	
	private List<ModelEmployee> list;
	
	public ModelEmployees ()
	{
		list = new ArrayList<>();
	}
	
	public boolean addEmployee (ModelEmployee model)
	{
		return list.add(model);
	}
	
	public List<ModelEmployee> getEmployees ()
	{
		return new ArrayList<>(list);
	}
	
	public boolean deleteEmployee (int index)
	{
		return list.remove(index) != null;
	}

}
