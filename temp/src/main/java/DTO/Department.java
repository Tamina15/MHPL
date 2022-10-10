package DTO;

import java.sql.Date;

public class Department {
	private int DepartmentID;
	private String Name;
	private double Budget;
	private Date StartDate;
	private int AD;

	
	public Department(int De, String Name, double Budget, Date SDate, int AD) {
		this.DepartmentID=De;
		this.Name=Name;
		this.Budget=Budget;
		this.StartDate=SDate;
		this.AD=AD;
	}
	
	public int getDepartment() {
		return DepartmentID;
	}
	
	public void setDepartmentID(int departmentID) {
		DepartmentID = departmentID;
	}
	
	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		Name = name;
	}
	
	public double getBudget() {
		return Budget;
	}
	
	public void setBudget(double budget) {
		Budget = budget;
	}
	
	public Date getStartDate() {
		return StartDate;
	}
	
	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}
	
	public int getAD() {
		return AD;
	}
	
	public void setAD(int aD) {
		AD = aD;
	}
	
}
