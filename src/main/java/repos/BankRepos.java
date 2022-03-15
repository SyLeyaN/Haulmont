package repos;

import domain.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepos extends JpaRepository<Bank, Long> {
    Bank findByName(String name);
}
