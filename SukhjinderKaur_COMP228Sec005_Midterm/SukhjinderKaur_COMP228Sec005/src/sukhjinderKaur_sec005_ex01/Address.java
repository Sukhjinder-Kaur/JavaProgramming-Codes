package sukhjinderKaur_sec005_ex01;

public class Address {
	
	// instance variables
	private int houseNumber;
	private String streetName;
	private String city;
	private String province;
	private String zipCode;

	// constructor
	public Address(int houseNumber, String streetName, String city, String province, String zipCode) {
		super();
		this.houseNumber = houseNumber;
		this.streetName = streetName;
		this.city = city;
		this.province = province;
		this.zipCode = zipCode;
	}

	// getter and setters
	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public int getHouseNumber() {
		return houseNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public String getCity() {
		return city;
	}

	public String getProvince() {
		return province;
	}

	public String getZipCode() {
		return zipCode;
	}

	// To string method
	@Override
	public String toString() {
		return houseNumber + "," + streetName + "," + city + "," + province + "," + zipCode;
	}

}
