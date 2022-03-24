package com.repos;

import com.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepos extends JpaRepository<Payment,Long> {
    Payment findByMonth(int month);
}
