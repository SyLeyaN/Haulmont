package repos;

import domain.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepos extends JpaRepository<Offer, Long> {
    Offer findByName(String name);
}
