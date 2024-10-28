package AtmSystem.Entity;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")  // Ensure the table name is correct
public class customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int cust_id;
	private String cust_name;
	private String cust_address;
	private int cust_contact;
    
    // Account relationship if exists
    @ManyToOne
    @JoinColumn(name = "account_id",referencedColumnName = "account_id")  // Ensure the account_id column exists and is correct
	private account account;
	
	//getters and setters
	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String getCust_address() {
		return cust_address;
	}
	public void setCust_address(String cust_address) {
		this.cust_address = cust_address;
	}
	public int getcust_contact() {
		return cust_contact;
	}
	public void setCust_contact(int cust_contact) {
		this.cust_contact = cust_contact;
	}
	public account getAccount() {
		return account;
	}
	public void setAccount(account account) {
		this.account = account;
	}
}
