package myapp.controller;

import java.util.List;

import javax.ejb.EJB;

import myapp.model.Activity;
import myapp.services.ActivityManager;

public class ActivityController implements Controller<Activity> {

	@EJB
	ActivityManager manager;
	
	@Override
	public List<Activity> getAll() {
		return manager.findAll();
	}

	@Override
	public String updateWithFilter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String show(Integer n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String edit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String save() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String newInstance() {
		// TODO Auto-generated method stub
		return null;
	}

}
