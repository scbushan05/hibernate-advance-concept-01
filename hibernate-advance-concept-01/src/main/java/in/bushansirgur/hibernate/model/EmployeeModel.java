package in.bushansirgur.hibernate.model;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
/**
 * 
 * This class represents the model class for employee object
 * */
@Entity
@Table(name="employee")
public class EmployeeModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int id;
	
	@Column(name="full_name")
	private String name;
	
	@Column(name="email_id")
	private String email;
	
	@ElementCollection
	@CollectionTable(name="emplooyee_phone_numbers", joinColumns=@JoinColumn(name="employee_id"))
	@Column(name="phone_number")
	private Set<String> phoneNumbers;

	public EmployeeModel(String name, String email, Set<String> phoneNumbers) {
		this.name = name;
		this.email = email;
		this.phoneNumbers = phoneNumbers;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(Set<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	@Override
	public String toString() {
		return "EmployeeModel [id=" + id + ", name=" + name + ", email=" + email + ", phoneNumbers=" + phoneNumbers
				+ "]";
	}
	
}
