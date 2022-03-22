package com.repos;

import com.domain.Credit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditRepos extends JpaRepository<Credit, Long> {
    Credit findByName(String name);
}
