package com.lcwr.spring_validation.repository;

import com.lcwr.spring_validation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositroy extends JpaRepository<User,Integer > {
}
