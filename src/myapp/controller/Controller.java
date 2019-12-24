package myapp.controller;

import java.util.List;

public interface Controller<T> {
	
	public List<T> getAll();
	
	public String updateWithFilter();

	public String show(Integer n);
	
	public String edit();

	public String save();

	public String newInstance();

}
