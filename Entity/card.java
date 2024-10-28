package AtmSystem.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "card" )
public class card {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int card_id;  // Use card_id as the primary key
    private String card_name;
    private int card_numb;
    private int date_exp;
	public int getCard_id() {
		return card_id;
	}
	public void setCard_id(int card_id) {
		this.card_id = card_id;
	}
	public String getCard_name() {
		return card_name;
	}
	public void setCard_name(String card_name) {
		this.card_name = card_name;
	}
	public int getCard_numb() {
		return card_numb;
	}
	public void setCard_numb(int card_numb) {
		this.card_numb = card_numb;
	}
	public int getDate_exp() {
		return date_exp;
	}
	public void setDate_exp(int date_exp) {
		this.date_exp = date_exp;
	}
	
	//getters and setters
	
	
	
}