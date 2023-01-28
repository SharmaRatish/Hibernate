package embded;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	private String house_no;
	
	private String city;
	private String state;

	private String contory;
	private int pincode;
	private String street;
	public String getHouse_no() {
		return house_no;
	}
	public void setHouse_no(String house_no) {
		this.house_no = house_no;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getContory() {
		return contory;
	}
	public void setContory(String contory) {
		this.contory = contory;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
	
	
}
