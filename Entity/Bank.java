package AtmSystem.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity

public class Bank {
	@Id

	private int bank_id;
	private String bank_name;
	private String bank_address;
	private int bank_contact;
	
	//getters and setters
	
	public int getBank_id() {
		return bank_id;
	}
	public void setBank_id(int bank_id) {
		this.bank_id = bank_id;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public String getBank_address() {
		return bank_address;
	}
	public void setBank_address(String bank_address) {
		this.bank_address = bank_address;
	}
	public int getBank_contact() {
		return bank_contact;
	}
	public void setBank_contact(int bank_contact) {
		this.bank_contact = bank_contact;
	}
	

	
	}
	
	

