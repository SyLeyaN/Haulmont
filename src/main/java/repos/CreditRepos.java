package repos;

import domain.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.events.Event;

public interface CreditRepos extends JpaRepository<Credit, Long> {
    Credit findByName(String name);
}
