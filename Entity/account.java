package AtmSystem.Entity;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
//import jakarta.persistence.TableGenerator;

@Entity
@Table(name="account")
public class account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "account_type", nullable = false)
	private String account_type;
	
	@Column(name = "account_numb", nullable = true)
    private Integer accountNumb;

	@Column(name = "cust_id", nullable = false)
	private int cust_id;
	
	@Column(name = "bank_id", nullable = false)
	private int bank_id;

	 
	 @Column(name = "account_id", nullable = false)
	private int account_id;
	 
	 @Column(name = "balance", nullable = false)
	private float balance;
	
	 // If there are any relationships, include them. For example, if a customer is linked to an account:
    @OneToMany(mappedBy = "account",cascade = CascadeType.ALL)
    private List<customer> customers;
	
	//getters and setters

	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	public int getBank_id() {
		return bank_id;
	}
	public void setBank_id(int bank_id) {
		this.bank_id = bank_id;
	}

	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public List<customer> getCustomers() {
		return customers;
	}
	public void setCustomers(List<customer> customers) {
		this.customers = customers;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public Object getBalance() {
		return balance;
	}
	public void setBalance1(float balance) {
		this.balance = balance;
	}
}
