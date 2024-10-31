package AtmSystem.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "bank") // Optional: specify the table name if different from the class name
public class Bank {
    @Id
    @Column(name = "bank_id", nullable = false)
    private int bank_id;

    @Column(name = "bank_name", nullable = false)
    private String bank_name;

    @Column(name = "bank_address", nullable = true)
    private String bank_address;

    @Column(name = "bank_contact", nullable = true)
    private String bank_contact;

    // One Bank can have many Accounts
    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL)
    private List<Account> accounts;

    // Getters and Setters
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

    public String getBank_contact() {
        return bank_contact;
    }

    public void setBank_contact(String bank_contact) {
        this.bank_contact = bank_contact;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
