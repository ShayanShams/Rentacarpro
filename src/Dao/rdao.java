package Dao;

import model.inscar;
import model.register;
import model.cars;

public interface rdao {
	public void addUser(register r);
	public void addcars(cars c);
	public void insertcars(inscar i);
}
