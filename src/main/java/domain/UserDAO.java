package domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="UserDAO")
public class UserDAO{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String midName;

    private String lastName;

    private String telephone;

    private String email;

    private String passport;

    private Boolean active;

    @OneToMany
    private Set<Offer> offers;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_bank",
            joinColumns = { @JoinColumn(name ="user_id")},
            inverseJoinColumns = { @JoinColumn(name = "bank_id")}
    )
    private Set<Bank> banks = new HashSet<>();


    public UserDAO(){

    }

    public UserDAO(String firstName, String midName, String lastName, String telephone, String email, String passport) {
        this.firstName = firstName;
        this.midName = midName;
        this.lastName = lastName;
        this.telephone = telephone;
        this.email = email;
        this.passport = passport;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMidName() {
        return midName;
    }

    public void setMidName(String midName) {
        this.midName = midName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public Set<Offer> getOffers() {
        return offers;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }

    public Boolean isActive() {
        return active;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Set<Bank> getBanks() {
        return banks;
    }

    public void setBanks(Set<Bank> banks) {
        this.banks = banks;
    }
}
