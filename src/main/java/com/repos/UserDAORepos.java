package com.repos;

import com.domain.UserDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAORepos extends JpaRepository<UserDAO,Long> {
    UserDAO findByLastName(String LastName);

    UserDAO findByPassport(String passport);
}
