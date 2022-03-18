package domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Bank")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="users")
    @OneToMany // Но это не точно
    private Set<UserDAO> users = new HashSet<>();

    @Column(name="credits")// Посмотреть сет из роллс в пользователях
    @OneToMany
    private Set<Credit> credits = new HashSet<>();

    public Bank(){

    }

    public Bank(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UserDAO> getUsers() {
        return users;
    }

    public void setUsers(Set<UserDAO> users) {
        this.users = users;
    }

    public Set<Credit> getCredits() {
        return credits;
    }

    public void setCredits(Set<Credit> credits) {
        this.credits = credits;
    }
}
