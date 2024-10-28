package AtmSystem.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class receipt {
	@Id
	private int receipt_id;
	private int trans_id;
	private int date_time;
	private double balance;
	//getters and setters
	public int getReceipt_id() {
		return receipt_id;
	}
	public void setReceipt_id(int receipt_id) {
		this.receipt_id = receipt_id;
	}
	public int getTrans_id() {
		return trans_id;
	}
	public void setTrans_id(int trans_id) {
		this.trans_id = trans_id;
	}
	public int getDate_time() {
		return date_time;
	}
	public void setDate_time(int date_time) {
		this.date_time = date_time;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	

	

}
