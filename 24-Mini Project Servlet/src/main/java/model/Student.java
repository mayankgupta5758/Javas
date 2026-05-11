package model;

public class Student {

	private int sId;
	private String sName;
	private String email;
	private String phone;
	private int age;
	private String city;

	public Student(String sName, String email, String phone, int age, String city) {
		this.sName = sName;
		this.email = email;
		this.phone = phone;
		this.age = age;
		this.city = city;
	}

	public Student(int sId, String sName, String email, String phone, int age, String city) {
		this.sId = sId;
		this.sName = sName;
		this.email = email;
		this.phone = phone;
		this.age = age;
		this.city = city;
	}

	public int getsId() {
		return sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}