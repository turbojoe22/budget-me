package com.myPersonalFinance.budgetme.data;

import com.myPersonalFinance.budgetme.models.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Transactional
    User findByUsername(String username);
};
