package com.DB.website.repository;

import com.DB.website.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AccountRepository extends JpaRepository<Account, Integer> {
//    List<Account> findByCustomerId(Integer customerId);
    List<Account> findByCustomerCustomerId(Integer customerId);
}
