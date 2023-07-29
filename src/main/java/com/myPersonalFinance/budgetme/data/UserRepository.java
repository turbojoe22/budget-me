package com.myPersonalFinance.budgetme.data;

import com.myPersonalFinance.budgetme.models.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

};
