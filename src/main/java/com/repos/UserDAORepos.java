package com.repos;

import com.domain.UserDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAORepos extends JpaRepository<UserDAO,Long> {
    UserDAO findByFirstName(String firstName);

    UserDAO findByPassport(String passport);
}
