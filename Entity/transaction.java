package AtmSystem.Entity;

import jakarta.persistence.Entity;



import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "transaction")
public class transaction {
    @Id
	private int tr_id;
	private int date_time;
	//getters and setters
	public int getTr_id() {
		return tr_id;
	}
	public void setTr_id(int tr_id) {
		this.tr_id = tr_id;
	}
	public int getDate_time() {
		return date_time;
	}
	public void setDate_time(int date_time) {
		this.date_time = date_time;
	}
	public void setAmount(double nextDouble) {
		// TODO Auto-generated method stub
		
	}
	public void setaccount_id(int nextInt) {
		// TODO Auto-generated method stub
		
	}
}
