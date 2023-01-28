package onetomany;

import java.util.Set;
import java.util.jar.Attributes.Name;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Company {
	
	@Id
	@GeneratedValue
	private int id;
	private String Companyname;
	
	@OneToMany(targetEntity = Customer.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "comp_id",referencedColumnName = "id")
	private Set customer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyname() {
		return Companyname;
	}

	public void setCompanyname(String companyname) {
		Companyname = companyname;
	}

	public Set getCustomer() {
		return customer;
	}

	public void setCustomer(Set customer) {
		this.customer = customer;
	}

}
