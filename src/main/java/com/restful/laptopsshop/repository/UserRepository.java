package com.restful.laptopsshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restful.laptopsshop.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
