package com.rest.webservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.webservice.entity.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {

}
