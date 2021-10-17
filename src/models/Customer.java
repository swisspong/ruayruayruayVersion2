package models;

public class Customer {
	private int id;
	private String name;
	private String address;
	private String phone;
	private String email;
	private String username;
	private String password;
	
	
	public Customer(int id, String name, String address, String phone, String email, String username, String password) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.username = username;
		this.password = password;
	}
	public Customer(String name, String address, String phone, String email, String username, String password) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.username = username;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmial(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + ", emial="
				+ email + ", username=" + username + ", password=" + password + "]";
	}
	
	
}
