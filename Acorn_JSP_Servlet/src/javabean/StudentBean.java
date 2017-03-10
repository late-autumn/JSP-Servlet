package javabean;

import java.util.Calendar;

public class StudentBean {

	private String id;
	
	private String password;

	private String name;
	
	private String snum;
	
	private int year;
	
	private String email;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSnum() {
		return snum;
	}

	public void setSnum(String snum) {
		this.snum = snum;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	//태어난 해를 이용하여 현재 나이를 구하는 메서드 구현
	
	public int getAge(){
		
		int curyear = Calendar.getInstance().get(Calendar.YEAR);
		System.out.println(curyear);
		
		return curyear-year+1;
		
	}
}
