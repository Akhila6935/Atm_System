package AtmSystem.Entity;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="account")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id", nullable = false)
	private int account_id;
	 
	@Column(name = "account_type", nullable = false)
	private String account_type;
	
	@Column(name = "account_numb", nullable = true)
    private int accountNumb;

	@Column(name = "balance", nullable = false)
	private double balance;

	// Many accounts can be associated with one bank
	@ManyToOne
	@JoinColumn(name = "bank_id", nullable = false)
	private Bank bank;

	// Many customers can be associated with one account
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Customer> customers;

	// Getters and Setters

	public String getaccount_type() {
		return account_type;
	}
	public void setaccount_type(String account_type) {
		this.account_type = account_type;
	}

	public int getaccountNumb() {
		return accountNumb;
	}
	public void setaccountNumb(int accountNumb) {
		this.accountNumb = accountNumb;
	}

	public int getaccount_id() {
		return account_id;
	}
	public void setaccount_id(int account_id) {
		this.account_id = account_id;
	}

	public double getBalance() {
		return balance;
	}
	public void setBalance(double d) {
		this.balance = d;
	}

	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public List<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	public void setcust_id(int nextInt) {
		// TODO Auto-generated method stub
		
	}
	public void setBank_id(int nextInt) {
		// TODO Auto-generated method stub
		
	}
	public void setaccountNumb(String next) {
		// TODO Auto-generated method stub
		
	}
}
