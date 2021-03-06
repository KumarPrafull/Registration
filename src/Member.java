
public class Member {
	
	private String uname, phone, age, gender, address, password;

	
	
	
	public Member() {
		super();
	}

	public Member(String uname, String phone, String age, String gender, String address, String password) {
		super();
		this.uname = uname;
		this.phone = phone;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.password = password;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
