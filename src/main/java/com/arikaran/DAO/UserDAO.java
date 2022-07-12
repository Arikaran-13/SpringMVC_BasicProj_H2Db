package com.arikaran.DAO;

import javax.persistence.Id;

import org.springframework.data.repository.CrudRepository;

import com.arikaran.module.User;

public interface UserDAO extends CrudRepository<User, Integer>{

}
