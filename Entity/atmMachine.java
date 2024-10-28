package AtmSystem.Entity;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;

@Entity
public class atmMachine {
	@Id
	private int manchine_id;
	private String machine_address;
	private int manuf_date;
	private String bank_name;
	private String manchine_name;
	//getters and setters
	public int getManchine_id() {
		return manchine_id;
	}
	public void setManchine_id(int manchine_id) {
		this.manchine_id = manchine_id;
	}
	public String getMachine_address() {
		return machine_address;
	}
	public void setMachine_address(String machine_address) {
		this.machine_address = machine_address;
	}
	public int getManuf_date() {
		return manuf_date;
	}
	public void setManuf_date(int manuf_date) {
		this.manuf_date = manuf_date;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public String getManchine_name() {
		return manchine_name;
	}
	public void setManchine_name(String manchine_name) {
		this.manchine_name = manchine_name;
	}
	
	
}
	