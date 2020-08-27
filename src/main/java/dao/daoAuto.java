package dao;

import java.util.List;

import model.Auto;


public interface daoAuto {
	
	public List<Auto> getAllAuto();
	public void addAuto(Auto auto);
	public void delAuto(Auto auto);
	public void updateAuto(Auto auto);
	public Auto getUserByName(String nameAuto);
	
		
	

}
