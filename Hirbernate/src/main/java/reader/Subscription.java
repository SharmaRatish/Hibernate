package reader;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "subscription",
uniqueConstraints = {@UniqueConstraint(columnNames = "subscriptionid")})
public class Subscription {
	@Id
	@Column
	private int subscriptionid;
	private String sname;
	@ManyToMany
	private Set<Reader> readers;
	public int getSubscriptionid() {
		
		return subscriptionid;
	}
	public void setSubcriptionid(int subscription, int subscriptionid) {
		
		this.subscriptionid=subscriptionid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Set<Reader> getReaders() {
		return readers;
	}
	public void setReaders(Set<Reader> readers) {
		this.readers = readers;
	}
	public void setSubscriptionid(int subscriptionid) {
		this.subscriptionid = subscriptionid;
	}
	
	
	

}
