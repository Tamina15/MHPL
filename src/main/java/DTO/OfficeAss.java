package DTO;

import java.sql.*;

public class OfficeAss {
	private int InstructorID;
	private String Localtion;
	private Date Timestamp;
	
	public OfficeAss() {
		
	}
	
	public OfficeAss(int Ins, String Local, Date Times) {
		this.InstructorID=Ins;
		this.Localtion=Local;
		this.Timestamp=Times;
	}
}
